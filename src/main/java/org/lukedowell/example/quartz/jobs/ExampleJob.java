package org.lukedowell.example.quartz.jobs;

import org.lukedowell.example.quartz.service.SomeService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by ldowell on 2/10/16.
 */
public class ExampleJob implements Job {

    @Autowired
    SomeService someService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap map = context.getJobDetail().getJobDataMap();
        String[] values = (String[]) map.get("values");
        someService.printSomething(values[0]);
    }
}
