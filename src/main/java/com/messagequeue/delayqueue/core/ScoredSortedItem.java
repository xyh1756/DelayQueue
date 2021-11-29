package com.messagequeue.delayqueue.core;

public class ScoredSortedItem {

    /**
     * 任务的执行时间
     */
    private long delayTime;

    /**
     * 延迟任务的唯一标识
     */
    private long delayQueueJodId;

    public ScoredSortedItem(long delayQueueJodId, long delayTime) {
        this.delayQueueJodId = delayQueueJodId;
        this.delayTime = delayTime;
    }

    public ScoredSortedItem() {

    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public long getDelayQueueJodId() {
        return delayQueueJodId;
    }

    public void setDelayQueueJodId(long delayQueueJodId) {
        this.delayQueueJodId = delayQueueJodId;
    }

    @Override
    public String toString() {
        return "ScoredSortedItem{delayTime=" + delayTime +
                ", delayQueueJodId=" + delayQueueJodId +
                '}';
    }
}
