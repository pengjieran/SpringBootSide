package com.pengjieran.config.filter;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.auth0.jwt.exceptions.JWTVerificationException;

import reactor.core.publisher.Mono;

@Component
public class JWTFilter implements GlobalFilter, Ordered {

	private static final String WWW_AUTH_HEADER = "WWW-Authenticate";
	private static final String X_JWT_SUB_HEADER = "X-jwt-sub";

	private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);
	
	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;
	
	@Override
	public int getOrder() {
		
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		try {
			
			String token = this.extractJWTToken(exchange.getRequest());
			//这里验证token的有效性与正确性
			redisTemplate.opsForValue().set(token, token, 30, TimeUnit.DAYS);//一个token30天有效期
			ServerHttpRequest request = exchange.getRequest().mutate().header(X_JWT_SUB_HEADER, token).build();
			
			return chain.filter(exchange.mutate().request(request).build());
		} catch (JWTVerificationException ex) {

			logger.error(ex.toString());
			return this.onError(exchange, ex.getMessage());
		}
	}

	private Mono<Void> onError(ServerWebExchange exchange, String err) {
		
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		response.getHeaders().add(WWW_AUTH_HEADER, this.formatErrorMsg(err));

		return response.setComplete();
	}

	private String extractJWTToken(ServerHttpRequest request) {
		
		if (!request.getHeaders().containsKey("Authorization")) {
			throw new JWTTokenExtractException("Authorization header is missing");
		}

		List<String> headers = request.getHeaders().get("Authorization");
		if (headers.isEmpty()) {
			throw new JWTTokenExtractException("Authorization header is empty");
		}

		String credential = headers.get(0).trim();
		String[] components = credential.split("\\s");

		if (components.length != 2) {
			throw new JWTTokenExtractException("Malformat Authorization content");
		}

		if (!components[0].equals("Bearer")) {
			throw new JWTTokenExtractException("Bearer is needed");
		}

		return components[1].trim();
	}

	private String formatErrorMsg(String msg) {
		return String.format("Bearer realm=\"mtoliv.com\", " + "error_description=\"%s\" ", msg);
	}
}