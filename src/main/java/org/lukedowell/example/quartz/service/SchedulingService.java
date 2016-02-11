package org.lukedowell.example.quartz.service;

import org.lukedowell.example.quartz.jobs.ExampleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldowell on 2/11/16.
 */
@Service
public class SchedulingService {

    @Autowired
    Scheduler scheduler;

    public String scheduleNewJob(String[] values) {

        JobDataMap map = new JobDataMap();
        map.put("values", values);


        // Build a simple schedule
        ScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever();

        // Build a job detail
        JobDetail jobDetail = JobBuilder
                .newJob(ExampleJob.class)
                .setJobData(map)
                .storeDurably()
                .build();

        // Build a trigger
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .forJob(jobDetail)
                .startNow()
                .withSchedule(scheduleBuilder)
                .build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
            return "SUCCESS";
        } catch (SchedulerException e) {
            e.printStackTrace();
            return "FAILED";
        }

    }
}
