package nic.oad.attendance.Repository;

import nic.oad.attendance.Entity.Attendance;
import nic.oad.attendance.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, String> {
    @Query("select atd from Attendance atd where atd.date = :date1")
    Attendance findAttendanceByDate(Date date1);
}
