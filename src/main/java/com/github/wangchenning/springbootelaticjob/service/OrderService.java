package com.github.wangchenning.springbootelaticjob.service;

import com.github.wangchenning.springbootelaticjob.dao.AllOrderMapper;
import com.github.wangchenning.springbootelaticjob.dao.JdOrderMapper;
import com.github.wangchenning.springbootelaticjob.dao.OrderMapper;

import com.github.wangchenning.springbootelaticjob.dao.TmailOrderMapper;
import com.github.wangchenning.springbootelaticjob.model.AllOrder;
import com.github.wangchenning.springbootelaticjob.model.JdOrder;
import com.github.wangchenning.springbootelaticjob.model.Order;
import com.github.wangchenning.springbootelaticjob.model.TmailOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private JdOrderMapper jdOrderMapper;
    @Autowired
    private TmailOrderMapper tmailOrderMapper;
    @Autowired
    private AllOrderMapper allOrderMapper;


    public int insertOrder() {
        Order order = new Order();
        order.setAmount(BigDecimal.TEN);
        order.setReceiveName("wcn");
        order.setReceiveAddress("wcn");
        order.setReceiveMobile("1");
        order.setStatus(1);
        order.setCreateTime(new Date());
        order.setCreateUser("wcn");
        order.setUpdateTime(new Date());
        order.setUpdateUser("wcn");
        return orderMapper.insertSelective(order);
    }

    public List<Order> getOrder(Calendar now, int shardingTotalCount, int shardingItem) {

        return orderMapper.getOrder(now.getTime(), shardingTotalCount, shardingItem);
    }

    public void cancelOrder(Integer orderId, Date updateTime, int status, String updateUser, Date updateNow) {
        orderMapper.cancelOrder(orderId, updateTime, status, updateUser, updateNow);
    }

    public void produceThirdOrder() {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(2);
            if (randomInt == 0) {
                log.info("插入京东订单");
                JdOrder jdOrder = new JdOrder();
                jdOrder.setStatus(0);
                jdOrder.setAmount(BigDecimal.TEN);
                jdOrder.setCreateUser("jdUser");
                jdOrder.setCreateTime(new Date());
                jdOrder.setUpdateUser("jdUser");
                jdOrder.setUpdateTime(new Date());
                jdOrderMapper.insertSelective(jdOrder);
            } else {
                log.info("插入天猫订单");
                TmailOrder tmailOrder = new TmailOrder();
                tmailOrder.setOrderStatus(0);
                tmailOrder.setMoney(new BigDecimal(100));
                tmailOrder.setCreateUser("tmailUser");
                tmailOrder.setCreateTime(new Date());
                tmailOrder.setUpdateUser("tmailUser");
                tmailOrder.setUpdateTime(new Date());
                tmailOrderMapper.insertSelective(tmailOrder);
            }
        }
    }

    @Transactional
    public void processJdOrder(AllOrder allOrder) {
        allOrderMapper.insertSelective(allOrder);
        JdOrder jdOrder = new JdOrder();
        jdOrder.setId(allOrder.getThirdOrderId());
        jdOrder.setStatus(1);
        jdOrder.setUpdateUser("wcn");
        jdOrder.setUpdateTime(new Date());
        jdOrderMapper.updateByPrimaryKeySelective(jdOrder);
    }
    @Transactional
    public void processTmailOrder(AllOrder allOrder) {
        allOrderMapper.insertSelective(allOrder);
        TmailOrder tmailOrder = new TmailOrder();
        tmailOrder.setId(allOrder.getThirdOrderId());
        tmailOrder.setOrderStatus(1);
        tmailOrder.setUpdateUser("wcn");
        tmailOrder.setUpdateTime(new Date());
        tmailOrderMapper.updateByPrimaryKeySelective(tmailOrder);
    }
}
