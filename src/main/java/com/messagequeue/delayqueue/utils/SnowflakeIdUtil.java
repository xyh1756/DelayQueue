package com.messagequeue.delayqueue.utils;

public class SnowflakeIdUtil {

    private static SnowflakeIdWorker snowflakeIdWorker;

    public SnowflakeIdUtil(long workerId, long dataCenterId){
        snowflakeIdWorker = new SnowflakeIdWorker(workerId,dataCenterId);
    }

    public long nextId(){
        return snowflakeIdWorker.nextId();
    }
}
