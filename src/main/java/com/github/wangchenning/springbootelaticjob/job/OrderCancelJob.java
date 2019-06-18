package com.github.wangchenning.springbootelaticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.github.wangchenning.autoconfig.ElasticSimpleJob;
import com.github.wangchenning.springbootelaticjob.config.WcnThreadFactory;
import com.github.wangchenning.springbootelaticjob.model.Order;
import com.github.wangchenning.springbootelaticjob.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

//@ElasticSimpleJob(jobName = "orderCancelJob", corn = "0/15 * * * * ?", shardingTotalCount = 2, overwrite = true)
public class OrderCancelJob implements SimpleJob {
    @Autowired
    private OrderService orderService;
    private WcnThreadFactory defaultThreadFactory = WcnThreadFactory.defaultThreadFactory();

    @Override
    public void execute(ShardingContext shardingContext) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.SECOND, -30);
        List<Order> orders = orderService.getOrder(now, shardingContext.getShardingTotalCount(), shardingContext.getShardingItem());
        if (orders != null && orders.size() > 0) {
            ExecutorService es = new ThreadPoolExecutor(4, 4,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(), defaultThreadFactory);

            for (Order o : orders) {
                es.execute(() -> {
                    Integer orderId = o.getId();
                    Date updateTime = o.getUpdateTime();

                    int status = 3;
                    String updateUser = "System";
                    Date updateNow = new Date();

                    orderService.cancelOrder(orderId, updateTime, status, updateUser, updateNow);
                });

            }
            es.shutdown();
        }
    }
}
