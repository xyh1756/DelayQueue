package com.messagequeue.delayqueue.core;

import com.messagequeue.delayqueue.utils.RedissonUtils;
import org.redisson.api.RMap;

/**
 * 延迟任务池
 */
public class DelayQueueJobPool {

    private static final String DELAY_QUEUE_JOB_POOL = "delayQueueJobPool";

    /**
     * 查询 DelayQueueJod
     * @param delayQueueJodId
     * @return
     */
    public static DelayQueueJob getDelayQueueJod(long delayQueueJodId) {
        RMap<Long, DelayQueueJob> rMap = RedissonUtils.getMap(DELAY_QUEUE_JOB_POOL);
        return rMap.get(delayQueueJodId);
    }

    /**
     * 添加 DelayQueueJod
     * @param delayQueueJob
     */
    public static void addDelayQueueJod(DelayQueueJob delayQueueJob) {
        RMap<Long, DelayQueueJob> rMap = RedissonUtils.getMap(DELAY_QUEUE_JOB_POOL);
        rMap.put(delayQueueJob.getId(), delayQueueJob);
    }

    /**
     * 删除 DelayQueueJod
     * @param delayQueueJodId
     */
    public static void deleteDelayQueueJod(long delayQueueJodId) {
        RMap<Long, DelayQueueJob> rMap = RedissonUtils.getMap(DELAY_QUEUE_JOB_POOL);
        rMap.remove(delayQueueJodId);
    }
}
