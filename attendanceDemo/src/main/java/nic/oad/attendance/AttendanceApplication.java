package nic.oad.attendance;

import nic.oad.attendance.Entity.Role;
import nic.oad.attendance.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run( AttendanceApplication.class, args );
    }

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.findAll().isEmpty()) {

            Role role = new Role();
            role.setName("ROLE_ADMIN");
            roleRepository.save(role);

            Role role1 = new Role();
            role1.setName("ROLE_CREATOR");
            roleRepository.save(role1);

            Role role2 = new Role();
            role2.setName("ROLE_USER");
            roleRepository.save(role2);

            Role role3 = new Role();
            role3.setName("ROLE_EDITOR");
            roleRepository.save(role3);

            Role role4 = new Role();
            role4.setName("ROLE_TEACHER");
            roleRepository.save(role4);
        }
    }
}
