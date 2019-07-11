package com.github.wangchenning.springbootelaticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.github.wangchenning.autoconfig.ElasticSimpleJob;
import com.github.wangchenning.springbootelaticjob.sharding.MyShardingStratey;
import lombok.extern.slf4j.Slf4j;
import com.github.wangchenning.springbootelaticjob.listener.MyNormalListener;

@Slf4j
@ElasticSimpleJob(jobName = "MyShardingJob", corn = "0/5 * * * * ?", shardingTotalCount = 10, overwrite = true
        , jobStrategy = MyShardingStratey.class, jobEvent = false,jobListener = {MyNormalListener.class,MyNormalListener.class})
public class MyShardingJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("我是分片项：" + shardingContext.getShardingItem() + ",总分片项：" + shardingContext.getShardingTotalCount());
    }
}
