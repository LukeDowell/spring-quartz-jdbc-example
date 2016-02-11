package org.lukedowell.example.quartz.jobs;

import org.lukedowell.example.quartz.service.SomeService;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by ldowell on 2/10/16.
 */
public class ExampleJob extends QuartzJobBean {

    @Autowired
    SomeService someService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap map = context.getJobDetail().getJobDataMap();
        String[] values = (String[]) map.get("values");
        someService.printSomething(values[0]);
    }
}
