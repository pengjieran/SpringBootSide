package com.ambow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 流通道关联
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@TableName("t_stream_room")
public class StreamRoom extends Model<StreamRoom> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 关联本地资源id
     */
    private String resourceId;
    private String name;
    private String code;
    private String templatetype;
    private String publisherpass;
    private String assistantpass;
    private String playpass;
    private String streamUrl;


    public String getId() {
        return id;
    }

    public StreamRoom setId(String id) {
        this.id = id;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    public StreamRoom setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public String getName() {
        return name;
    }

    public StreamRoom setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public StreamRoom setCode(String code) {
        this.code = code;
        return this;
    }

    public String getTemplatetype() {
        return templatetype;
    }

    public StreamRoom setTemplatetype(String templatetype) {
        this.templatetype = templatetype;
        return this;
    }

    public String getPublisherpass() {
        return publisherpass;
    }

    public StreamRoom setPublisherpass(String publisherpass) {
        this.publisherpass = publisherpass;
        return this;
    }

    public String getAssistantpass() {
        return assistantpass;
    }

    public StreamRoom setAssistantpass(String assistantpass) {
        this.assistantpass = assistantpass;
        return this;
    }

    public String getPlaypass() {
        return playpass;
    }

    public StreamRoom setPlaypass(String playpass) {
        this.playpass = playpass;
        return this;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public StreamRoom setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StreamRoom{" +
        ", id=" + id +
        ", resourceId=" + resourceId +
        ", name=" + name +
        ", code=" + code +
        ", templatetype=" + templatetype +
        ", publisherpass=" + publisherpass +
        ", assistantpass=" + assistantpass +
        ", playpass=" + playpass +
        ", streamUrl=" + streamUrl +
        "}";
    }
}
