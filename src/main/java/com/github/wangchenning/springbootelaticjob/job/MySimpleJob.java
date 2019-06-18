package com.github.wangchenning.springbootelaticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.github.wangchenning.autoconfig.ElasticSimpleJob;
import com.github.wangchenning.springbootelaticjob.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
//@ElasticSimpleJob(jobName = "mySimpleJob-ly",
//        corn = "0/5 * * * * ?", shardingTotalCount = 1, overwrite = true)
public class MySimpleJob implements SimpleJob {
    @Autowired
    private OrderService orderService;

    @Override
    public void execute(ShardingContext shardingContext) {
//        log.info("我是分片项：" + shardingContext.getShardingItem() + ",总分片项：" + shardingContext.getShardingTotalCount());
        for (int i = 0; i < 10; i++) {
            orderService.insertOrder();
        }

    }
}
