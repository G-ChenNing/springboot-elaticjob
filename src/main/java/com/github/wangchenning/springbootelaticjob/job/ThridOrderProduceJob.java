package com.github.wangchenning.springbootelaticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.github.wangchenning.autoconfig.ElasticSimpleJob;
import com.github.wangchenning.springbootelaticjob.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

//@ElasticSimpleJob(jobName = "thridOrderProduceJob", corn = "0/5 * * * * ?", shardingTotalCount = 1, overwrite = true)
public class ThridOrderProduceJob implements SimpleJob {
    @Autowired
    private OrderService orderService;
    @Override
    public void execute(ShardingContext shardingContext) {
        orderService.produceThirdOrder();
    }
}
