package com.github.wangchenning.springbootelaticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Musk
 */
@Slf4j
public class MyNormalListener implements ElasticJobListener {
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
      log.info("我是:"+shardingContexts.getJobName()+"作业，在方法前!");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        log.info("我是:"+shardingContexts.getJobName()+"作业，在方法后!");
    }
}
