package org.lukedowell.example.quartz;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootQuartzApplication{
	public static void main(String[] args) {
		SpringApplication.run(BootQuartzApplication.class, args);
	}
}
