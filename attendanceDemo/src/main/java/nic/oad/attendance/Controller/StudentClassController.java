package nic.oad.attendance.Controller;

import nic.oad.attendance.Entity.Student;
import nic.oad.attendance.Service.StudentClassService;
import nic.oad.attendance.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentClassController {

    @Autowired
    StudentClassService studentClassService;

    @GetMapping("/index")
    public String display(){
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping(value = "/attendance")
    public String attendance(@RequestParam int studentClass, @RequestParam String section, Model model){
        List<Student> students = studentClassService.getStudentList(studentClass);
        boolean flag = studentClassService.isAttendanceMarked(studentClass);
        model.addAttribute( "students", students);
        model.addAttribute( "isAttendanceMarked", flag);
        model.addAttribute("studentClass", studentClass);
        return "attendance";
    }

    @GetMapping(value = "/records")
    public String records(@RequestParam int studentClass, @RequestParam String section,
                          @RequestParam String fromDate, @RequestParam String toDate, Model model){
        List<Object[]> result = studentClassService.getRecords(studentClass, fromDate, toDate);
        model.addAttribute("results", result);
        return "records";
    }

    @PostMapping(value = "/saveAttendance")
    public String saveAttendance(@RequestParam("studentId") String studentId, @RequestParam("studentClass") int studentClass){
        studentClassService.saveAttendance(studentId, studentClass);
        return "redirect:index";
    }

    @PostMapping(value = "/saveStudent")
    public String saveStudent(StudentDto studentDto){
        studentClassService.createStudent(studentDto);
        return "redirect:welcome";
    }
}
