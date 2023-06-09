package org.example.Servise;

import org.example.Container.ComponentContainer;
import org.example.Dto.ProfileDto;
import org.example.Enum.ProfileRole;
import org.example.Enum.ProfileStatus;
import org.example.util.PhoneValidationUtil;

import java.time.LocalDateTime;

public class ProfileService {

    public void register(ProfileDto profileDto) {
        String phone = profileDto.getPhone();
        // validate phone
        if (!PhoneValidationUtil.isValidPhone(phone)) {
            System.out.println("This phone is already registered");
            return;
        }
        // check phone unique
        ProfileDto existProfile = ComponentContainer.profileRepo.getProfileByPhone(profileDto.getPhone());
        if (existProfile != null) {
            System.out.println("This phone is already registered");
            return;
        }
        // set detail
        profileDto.setCreated_date(LocalDateTime.now());
        profileDto.setRole(ProfileRole.USER);
        profileDto.setStatus(ProfileStatus.ACTIVE);
        //sms
        // ComponentContainer.smsService.send(profileDto.getPhone(), "1234");
        // save
        boolean result = ComponentContainer.profileRepo.addProfile(profileDto);
        if (result) {
            System.out.println("you have successfully registered");
            System.out.println("Login to your account!");
        } else {
            System.out.println("Something went wrong");
        }
    }


    public void login(String login, String password) {
        ProfileDto profileDto = ComponentContainer.profileRepo.login(login, password);
        if (profileDto == null) {
            System.out.println("login or password is incorrect!");
            return;

        } else if (profileDto.getStatus().equals(ProfileStatus.BLOCKED)) {
            System.out.println("your account is blocked!");
            return;
        }

        System.out.println("you have logged in successfully!");
        ComponentContainer.profileDto = profileDto;
        if (profileDto.getRole().equals(ProfileRole.USER)) {
            ComponentContainer.userController.start();
            System.out.println("Welcome user");
        } else {
            ComponentContainer.adminController.start();
            System.out.println("Welcome admin");
        }

    }
}

