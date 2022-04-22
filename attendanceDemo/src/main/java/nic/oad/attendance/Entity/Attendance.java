package nic.oad.attendance.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attendance", schema = "students")
public class Attendance extends Auditable<String> {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne(targetEntity = Student.class)
    private Student student;

    private boolean isPresent;

    private Date date;

    public Attendance() {
    }

    public Attendance(String id, Student student, boolean isPresent, Date date) {
        this.id = id;
        this.student = student;
        this.isPresent = isPresent;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
