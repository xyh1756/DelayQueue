package com.messagequeue.delayqueue.core;

import com.messagequeue.delayqueue.utils.RedissonUtils;
import org.redisson.api.RBlockingQueue;

/**
 * 存放可以消费的jod
 */
public class ReadyQueue {

    /**
     * 添加jodid到准备队列
     * @param topic
     * @param delayQueueJodId
     */
    public static void pushToReadyQueue(String topic,long delayQueueJodId) {
        RBlockingQueue<Long> rBlockingQueue = RedissonUtils.getBlockingQueue(topic);
        rBlockingQueue.offer(delayQueueJodId);
    }

    /**
     * 从准备队列中获取jodid
     * @param topic
     * @return
     */
    public static Long pollFormReadyQueue(String topic) {
        RBlockingQueue<Long> rBlockingQueue = RedissonUtils.getBlockingQueue(topic);
        return rBlockingQueue.poll();
    }
}
