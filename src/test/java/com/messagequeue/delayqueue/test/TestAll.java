package com.messagequeue.delayqueue.test;

import com.messagequeue.delayqueue.utils.RedissonUtils;
import com.messagequeue.delayqueue.core.DelayBucket;
import com.messagequeue.delayqueue.core.ScoredSortedItem;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestAll {


    @Test
    public void scoredSet(){
        //RScoredSortedSet<ScoredSortedItem> testScore = RedissonUtils.getScoredSorteSet("testScore");
        /*testScore.add(1,new ScoredSortedItem(111,1));
        testScore.add(2,new ScoredSortedItem(222,2));
        testScore.add(3,new ScoredSortedItem(333,3));*/
        //testScore.remove(new ScoredSortedItem(22,2));
        //testScore.remove(1);
        /*System.out.println(testScore.size());
        System.out.println(testScore.readAll());*/
        ScoredSortedItem delayBucket = DelayBucket.getFromBucket("delayBucket11");

    }

    @Test
    public void map() {
        /*DelayQueueJob job = new DelayQueueJob();
        job.setId(1);
        job.setDelayTime(100);
        job.setMessage("work1");
        job.setTopic("test");
        DelayQueueJobPool.addDelayQueueJod(job);*/
        //DelayQueueJobPool.deleteDelayQueueJod(1);
        //System.out.println("test:"+DelayQueueJobPool.getDelayQueueJod(1));
        System.out.println(System.currentTimeMillis());
    }

    @After
    public void destroy() {
        RedissonUtils.close();
    }
}
