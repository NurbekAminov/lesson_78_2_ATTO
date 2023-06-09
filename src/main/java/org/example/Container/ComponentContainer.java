package org.example.Container;

import org.example.Controller.AdminController;
import org.example.Controller.UserController;
import org.example.Dto.ProfileDto;
import org.example.Repository.AdminRepo;
import org.example.Repository.ProfileRepo;
import org.example.Repository.UserRepo;
import org.example.Servise.AdminService;
import org.example.Servise.ProfileService;
import org.example.Servise.UserService;
import org.example.Servise.sms.EskizSmsService;
import org.example.Servise.sms.SmsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class ComponentContainer {
    public static Scanner stringScanner = new Scanner(System.in);
    public static Scanner intScanner = new Scanner(System.in);

    static ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Config.xml");
    public static ProfileService profileService = (ProfileService) context.getBean("profileService");
    public static ProfileRepo profileRepo = (ProfileRepo) context.getBean("profileRepo");
    public static UserController userController = (UserController) context.getBean("userController");
    public static UserService userService = (UserService) context.getBean("userService");
    public static UserRepo userRepo = (UserRepo) context.getBean("userRepo");
    public static ProfileDto profileDto = null;
    public static AdminController adminController = (AdminController) context.getBean("adminController");
    public static AdminService adminService = (AdminService) context.getBean("adminService");
    public static AdminRepo adminRepo = (AdminRepo) context.getBean("adminRepo");
    //    public static SmsService smsService = new SmsService();
    //    public static EskizSmsService eskizSmsService = new EskizSmsService();
//    public static SmsService smsService = new EskizSmsService();
    //    public static SmsService smsService = new SmsServiceImp();
}
