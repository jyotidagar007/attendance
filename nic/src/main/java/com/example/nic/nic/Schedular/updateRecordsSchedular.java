package com.example.nic.nic.Schedular;

import com.example.nic.nic.Service.FarpsReportingConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class updateRecordsSchedular {

    @Autowired
    private FarpsReportingConsumerService farpsReportingConsumerService;

    @Scheduled(initialDelay = 3000, fixedDelay = 15 * 1000)
    public void checkRecords(){
        String result  = farpsReportingConsumerService.updateRecordsLessThanUpdatedDate();
    }
}
