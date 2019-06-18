package com.github.wangchenning.autoconfig;

import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;

@Configuration
@ConditionalOnBean(CoordinatorRegistryCenter.class)
@AutoConfigureAfter(ZookeeperAutoConfig.class)
public class DataflowJobAutoConfig {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private CoordinatorRegistryCenter zkCenter;

    @PostConstruct
    public void initDataflowJob() {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(ElasticDataflowJob.class);
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object instance = entry.getValue();
            Class<?>[] interfaces = instance.getClass().getInterfaces();
            for (Class<?> superInterface : interfaces) {
                if (superInterface == DataflowJob.class) {
                    ElasticDataflowJob annotation = instance.getClass().getAnnotation(ElasticDataflowJob.class);
                    String jobName = annotation.jobName();
                    String corn = annotation.corn();
                    int shardingTotalCount = annotation.shardingTotalCount();
                    boolean overwrite = annotation.overwrite();
                    boolean streamingProcess = annotation.streamingProcess();
                    //job核心配置
                    JobCoreConfiguration jcc = JobCoreConfiguration.newBuilder(jobName, corn, shardingTotalCount).build();
                    //job类型配置
                    JobTypeConfiguration jtc = new DataflowJobConfiguration(jcc, instance.getClass().getCanonicalName(),streamingProcess);
                    //job根的配置(LiteJobConfiguration)
                    LiteJobConfiguration ljc = LiteJobConfiguration.newBuilder(jtc)
                            .overwrite(overwrite).build();
//                    new JobScheduler(zkCenter, ljc).init();
                    new SpringJobScheduler((ElasticJob) instance, zkCenter, ljc).init();
                }
            }


        }
    }
}
