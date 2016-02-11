package org.lukedowell.example.quartz.controller;

import org.lukedowell.example.quartz.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ldowell on 2/10/16.
 */
@RestController
@RequestMapping("/")
public class ScheduleController {

    SchedulingService schedulingService;

    @Autowired
    public ScheduleController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(@RequestParam("values") String[] values) {
        return schedulingService.scheduleNewJob(values);
    }
}
