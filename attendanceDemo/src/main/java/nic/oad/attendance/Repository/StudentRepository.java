package nic.oad.attendance.Repository;

import nic.oad.attendance.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAllByStudentClass(Integer studentClass);
}
