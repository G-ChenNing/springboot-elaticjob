package com.github.wangchenning.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "elasticjob.zookeeper")
@Data
public class ZookeeperProperties  {
    private String serverList;
    private String namespace;
}
