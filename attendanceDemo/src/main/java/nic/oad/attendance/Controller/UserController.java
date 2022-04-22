package nic.oad.attendance.Controller;

import nic.oad.attendance.Service.UserService;
import nic.oad.attendance.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String signin() {
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/userRegister")
    public String userRegister(UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/signin";
    }

//    @GetMapping("/user/profile")
//    public String profile(){
//        return "user/profile.html";
//    }
//
//
//    @DeleteMapping("user/delete")
//    public String deleteUser()
//    {
//        userService.deleteTask();
//        return "user/login.html";
//    }

//    @GetMapping("/user")
//    public List<User> getAllUsers()
//    {
//        return userService.getAllUsers();
//    }

    //    @GetMapping("/{username}")
//    public User getUser(@PathVariable("username") String username)
//    {
//        return this.userService.getUser(username);
//    }


}