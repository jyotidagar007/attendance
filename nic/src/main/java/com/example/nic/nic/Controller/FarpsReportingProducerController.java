package com.example.nic.nic.Controller;

import com.example.nic.nic.Service.FarpsReportingConsumerService;
import com.example.nic.nic.Service.FarpsReportingProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FarpsReportingProducerController {

    @Autowired
    private FarpsReportingProducerService farpsReportingProducerService;
    @Autowired
    private FarpsReportingConsumerService farpsReportingConsumerService;

    @GetMapping("/")
    @ResponseBody
    public String display(){
        return "index";
    }

    @GetMapping("/updateDate")
    @ResponseBody
    public List<Object[]> updateDate(@RequestParam("date") String date){
        System.out.println("Date---"+date);
        List<Object[]> list = farpsReportingProducerService.getDataLessThanUpdatedDate(date);
        return list;
    }

    @GetMapping("/health")
    @ResponseBody
    public String health() {
        return "200 - OK";
    }
}
