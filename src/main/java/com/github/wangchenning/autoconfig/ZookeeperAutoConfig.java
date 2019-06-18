package com.github.wangchenning.autoconfig;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("elasticjob.zookeeper.server-list")
@EnableConfigurationProperties(ZookeeperProperties.class)
public class ZookeeperAutoConfig {
    @Autowired
    private ZookeeperProperties zookeeperProperties;

    @Bean(initMethod = "init")
    public CoordinatorRegistryCenter zkCenter() {
        String serverList = zookeeperProperties.getServerList();
        String namespace = zookeeperProperties.getNamespace();
        ZookeeperConfiguration zkc = new ZookeeperConfiguration(serverList, namespace);
        //ip:port,ip:port,ip:port
        CoordinatorRegistryCenter crc = new ZookeeperRegistryCenter(zkc);
//        crc.init();
        return crc;
    }

}
