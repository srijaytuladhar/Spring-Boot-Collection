package com.spring.scheduling.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {


    // the statement will be executed every 1 minute from 3:00 pm to 3:59 pm
    //  fixedRate and fixedDelay can be used instead of cron expression
    @Scheduled(cron = "0 * 15 * * ?")
    public void fixedScheduler() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        String dateToString = simpleDateFormat.format(date);

        System.out.println("Cron Scheduler: " + dateToString);
    }
}
