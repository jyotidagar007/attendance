package com.example.nic.nic.Repository;

import com.example.nic.nic.Model.FarpsReportingUpdateProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarpsReportingProducerRepository extends JpaRepository<FarpsReportingUpdateProducer, String> {
}
