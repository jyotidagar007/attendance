package com.example.nic.nic.Model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "farps_reporting_update_producer", schema = "public")
public class FarpsReportingUpdateProducer {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    private int empCode;

    @NotNull
    private int repCode;

    @CreatedDate
    @Column(nullable = false, updatable = true)
    private Date updatedAt;

    public FarpsReportingUpdateProducer() {
    }

    public FarpsReportingUpdateProducer(String id, int empCode, int repCode, Date updatedAt) {
        this.id = id;
        this.empCode = empCode;
        this.repCode = repCode;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public int getRepCode() {
        return repCode;
    }

    public void setRepCode(int repCode) {
        this.repCode = repCode;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "FarpsReportingUpdate{" +
                "id='" + id + '\'' +
                ", empCode=" + empCode +
                ", repCode=" + repCode +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
