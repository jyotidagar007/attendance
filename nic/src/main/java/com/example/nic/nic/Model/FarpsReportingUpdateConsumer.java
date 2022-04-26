package com.example.nic.nic.Model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "farps_reporting_update_consumer", schema = "public")
public class FarpsReportingUpdateConsumer {

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

    @CreatedDate
    @Column(nullable = true, updatable = true)
    private Date mainDB;

    public FarpsReportingUpdateConsumer() {
    }

    public FarpsReportingUpdateConsumer(String id, int empCode, int repCode, Date updatedAt, Date mainDB) {
        this.id = id;
        this.empCode = empCode;
        this.repCode = repCode;
        this.updatedAt = updatedAt;
        this.mainDB = mainDB;
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

    public Date getMainDB() {
        return mainDB;
    }

    public void setMainDB(Date mainDB) {
        this.mainDB = mainDB;
    }

    @Override
    public String toString() {
        return "FarpsReportingUpdate{" +
                "id='" + id + '\'' +
                ", empCode=" + empCode +
                ", repCode=" + repCode +
                ", updatedAt=" + updatedAt +
                ", mainDB=" + mainDB +
                '}';
    }
}

