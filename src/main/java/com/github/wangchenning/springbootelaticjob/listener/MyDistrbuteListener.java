package com.github.wangchenning.springbootelaticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyDistrbuteListener extends AbstractDistributeOnceElasticJobListener {
    public MyDistrbuteListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        log.info("我是:"+shardingContexts.getJobName()+"作业，在方法前!");
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        log.info("我是:"+shardingContexts.getJobName()+"作业，在方法后!");
    }
}
