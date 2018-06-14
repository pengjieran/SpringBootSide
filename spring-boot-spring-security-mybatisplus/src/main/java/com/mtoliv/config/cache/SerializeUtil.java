package com.mtoliv.config.cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.ibatis.cache.CacheException;

public final class SerializeUtil {
	
	private SerializeUtil() {}

	public static byte[] serialize(Object object) {
		
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			return baos.toByteArray();
		} catch (Exception e) {
			
			throw new CacheException(e);
		}
	}

	public static Object unserialize(byte[] bytes) {
		
		if (bytes == null) {
			
			return null;
		}
		ByteArrayInputStream bais = null;
		try {
			
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}
}