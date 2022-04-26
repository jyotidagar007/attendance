package com.example.nic.nic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class FarpsReportingProducerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FarpsReportingConsumerService farpsReportingConsumerService;

    public List<Object[]> getDataLessThanUpdatedDate(String date) {

        String queryStr = "select * from farps_reporting_update_producer where updated_at >= '"+date+"'";
        Query query = entityManager.createNativeQuery(queryStr);
        List<Object[]> result =  (List<Object[]>)query.getResultList();
        return result;
    }
}
