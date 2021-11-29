package com.messagequeue.delayqueue.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 延迟任务
 */
public class DelayQueueJob {

    /**
     * 延迟任务的唯一标识，用于检索任务
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;

    /**
     * 任务类型（具体业务类型）
     */
    private String topic;

    /**
     * 任务的执行时间
     */
    private long delayTime;

    /**
     * 任务的执行超时时间
     */
    private long ttrTime;

    /**
     * 任务具体的消息内容，用于处理具体业务逻辑用
     */
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public long getTtrTime() {
        return ttrTime;
    }

    public void setTtrTime(long ttrTime) {
        this.ttrTime = ttrTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DelayQueueJob{id=" + id +
                ", topic='" + topic + '\'' +
                ", delayTime=" + delayTime +
                ", ttrTime=" + ttrTime +
                ", message='" + message + '\'' +
                '}';
    }
}
