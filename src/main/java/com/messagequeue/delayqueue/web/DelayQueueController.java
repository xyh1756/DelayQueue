package com.messagequeue.delayqueue.web;

import com.messagequeue.delayqueue.core.DelayQueue;
import com.messagequeue.delayqueue.core.DelayQueueJob;
import com.messagequeue.delayqueue.dto.Result;
import com.messagequeue.delayqueue.utils.SnowflakeIdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api("延迟队列相关接口")
@RestController
public class DelayQueueController {

    private static SnowflakeIdUtil idUtil = new SnowflakeIdUtil(1,1);

    @ApiOperation("添加延迟任务")
    @RequestMapping(value = "/push",method = RequestMethod.POST)
    public Result push(@ApiParam(name = "topic", value = "任务类型", required = true) @RequestParam("topic") String topic,
                       @ApiParam(name = "delayTime", value = "延迟任务执行时间（13位时间时间戳）", required = true) @RequestParam("delayTime") Long delayTime,
                       @ApiParam(name = "ttrTime", value = "延迟任务执行超时时间（单位：秒）", required = true) @RequestParam("ttrTime") Long ttrTime,
                       @ApiParam(name = "message", value = "消息内容", required = true) @RequestParam("message") String message) {
        DelayQueueJob delayQueueJob = new DelayQueueJob();
        delayQueueJob.setTopic(topic);
        delayQueueJob.setDelayTime(delayTime);
        delayQueueJob.setMessage(message);
        delayQueueJob.setTtrTime(ttrTime);
        delayQueueJob.setId(idUtil.nextId());
        DelayQueue.push(delayQueueJob);
        return Result.sucess();
    }

    @ApiOperation("轮询队列获取任务")
    @RequestMapping(value = "/pop/{topic}",method = RequestMethod.GET)
    public Result pop(@PathVariable("topic") String topic) {
        DelayQueueJob delayQueueJob = DelayQueue.pop(topic);
        return Result.sucess().put("data",delayQueueJob);
    }

    @ApiOperation("完成任务")
    @RequestMapping(value = "/finish",method = RequestMethod.POST)
    public Result finish(@ApiParam(name = "id", value = "任务id", required = true) @RequestParam("id") Long id) {
        DelayQueue.finish(id);
        return Result.sucess();
    }
}
