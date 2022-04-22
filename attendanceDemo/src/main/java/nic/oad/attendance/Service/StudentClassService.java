package nic.oad.attendance.Service;

import nic.oad.attendance.Entity.Attendance;
import nic.oad.attendance.Entity.Student;
import nic.oad.attendance.Repository.AttendanceRepository;
import nic.oad.attendance.Repository.StudentRepository;
import nic.oad.attendance.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class StudentClassService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> getStudentList(Integer studentClass) {
        return studentRepository.findAllByStudentClass(studentClass);
    }

    public void saveAttendance(String studentId, int studentClass) {
        Date date = new Date();
        List<String> studentIds = Arrays.asList(studentId.split(","));
        List<Student> students = studentRepository.findAllByStudentClass(studentClass);

        for (Student student:students) {
            Attendance attendance = new Attendance();
            attendance.setPresent(studentIds.contains(student.getId()));
            attendance.setStudent(student);
            attendance.setDate(date);
            attendanceRepository.save(attendance);
        }
    }

    public List<Object[]> getRecords(int studentClass, String fromDate, String toDate) {

        String queryStr = "select student_id, first_name, last_name, count(student_id) from students.attendance " +
                "JOIN students.students ON students.id = student_id " +
                "where date between '" + fromDate + "' and '" + toDate + "' and is_present = true " +
                "and student_id in (select id from students.students where student_class=" + studentClass + ") " +
                "group by student_id, first_name, last_name ";

        Query query = entityManager.createNativeQuery(queryStr);

        List<Object[]> result =  (List<Object[]>) query.getResultList();

         return result;
    }

    public void createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setRollNo(studentDto.getRollNo());
        student.setStudentClass(studentDto.getStudentClass());

        studentRepository.save(student);
    }

    public boolean isAttendanceMarked(int studentClass) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = df.format(date);

        String queryStr = "select * " +
                "from students.attendance " +
                "where date >= '"+date1+" 00:00:00.000000' and student_id in (select id from students.students where student_class = "+studentClass+")";

        Query query = entityManager.createNativeQuery(queryStr);

        List<Object[]> result =  (List<Object[]>) query.getResultList();

        System.out.println(!result.isEmpty());

        return !result.isEmpty();
    }
}
