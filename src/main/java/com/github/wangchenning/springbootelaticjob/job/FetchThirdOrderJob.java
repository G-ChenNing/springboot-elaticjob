package com.github.wangchenning.springbootelaticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.github.wangchenning.autoconfig.ElasticDataflowJob;
import com.github.wangchenning.springbootelaticjob.dao.JdOrderMapper;
import com.github.wangchenning.springbootelaticjob.dao.TmailOrderMapper;
import com.github.wangchenning.springbootelaticjob.model.AllOrder;
import com.github.wangchenning.springbootelaticjob.model.JdOrder;
import com.github.wangchenning.springbootelaticjob.model.TmailOrder;
import com.github.wangchenning.springbootelaticjob.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ElasticDataflowJob(jobName = "fetchThirdOrderJob", corn = "0/15 * * * * ?", shardingTotalCount = 2, overwrite = true, streamingProcess = true)
public class FetchThirdOrderJob implements DataflowJob<Object> {
    @Autowired
    private JdOrderMapper jdOrderMapper;
    @Autowired
    private TmailOrderMapper tmailOrderMapper;
    @Autowired
    private OrderService orderService;

    @Override
    public List<Object> fetchData(ShardingContext shardingContext) {
        if (shardingContext.getShardingItem() == 0) {
            List<JdOrder> jdOrders = jdOrderMapper.getNotFetchOrder(5);
            if (jdOrders != null && jdOrders.size() > 0) {
                List<Object> collect = jdOrders.stream().map(jdOrder -> (Object) jdOrder).collect(Collectors.toList());
                return collect;
            }
        } else {
            List<TmailOrder> tmailOrders = tmailOrderMapper.getNotFetchOrder(5);
            if (tmailOrders != null && tmailOrders.size() > 0) {
                List<Object> collect = tmailOrders.stream().map(tmailOrder -> (Object) tmailOrder).collect(Collectors.toList());
                return collect;
            }
        }
        return null;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<Object> data) {
        if (data == null && data.size() == 0) {
             return;
        }
        if (shardingContext.getShardingItem() == 0) {
            List<JdOrder> collect = data.stream().map(d -> (JdOrder) d).collect(Collectors.toList());
            for (JdOrder jdOrder : collect) {
                AllOrder allOrder = new AllOrder();
                allOrder.setThirdOrderId(jdOrder.getId());
                allOrder.setType(0);
                allOrder.setTotalAmount(jdOrder.getAmount());
                allOrder.setCreateUser("wcn");
                allOrder.setCreateTime(new Date());
                allOrder.setUpdateUser("wcn");
                allOrder.setUpdateTime(new Date());
                orderService.processJdOrder(allOrder);
            }
        } else {
            List<TmailOrder> collect = data.stream().map(d -> (TmailOrder) d).collect(Collectors.toList());
            for (TmailOrder tmailOrder : collect) {
                AllOrder allOrder = new AllOrder();
                allOrder.setThirdOrderId(tmailOrder.getId());
                allOrder.setType(1);
                allOrder.setTotalAmount(tmailOrder.getMoney());
                allOrder.setCreateUser("wcn");
                allOrder.setCreateTime(new Date());
                allOrder.setUpdateUser("wcn");
                allOrder.setUpdateTime(new Date());
                orderService.processTmailOrder(allOrder);
            }
        }

    }
}
