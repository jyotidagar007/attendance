package nic.oad.attendance.dto.transformation;

import nic.oad.attendance.Entity.User;
import nic.oad.attendance.dto.UserRegistrationDto;

public class UserTransformation {
    public static UserRegistrationDto fromEntity(User user) {

        UserRegistrationDto userDTO = new UserRegistrationDto();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }
}
