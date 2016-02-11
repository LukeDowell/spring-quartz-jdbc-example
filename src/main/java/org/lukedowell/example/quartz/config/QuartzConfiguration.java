package org.lukedowell.example.quartz.config;

import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ldowell on 2/10/16.
 */
@Configuration
public class QuartzConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(QuartzConfiguration.class);

    /**
     * This pulls in the AutowiringSpringBeanJobFactory so that our
     * Quartz jobs can Autowire different components
     * @param applicationContext
     *      I don't really know what this is
     * @return
     *      A job factory
     */
    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    /**
     * Loads the properties found in resources/quarts.properties
     * @return
     *      A properties object
     * @throws IOException
     *      If shit breaks
     */
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    /**
     *
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory factory, DataSource dataSource) throws IOException {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();

        schedulerFactory.setJobFactory(factory);
        schedulerFactory.setDataSource(dataSource);
        schedulerFactory.setQuartzProperties(quartzProperties());

        return schedulerFactory;

    }
}
