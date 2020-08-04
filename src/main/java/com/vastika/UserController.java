package com.vastika;

import com.vastika.model.User;
import com.vastika.service.UserService;
import com.vastika.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class UserController {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        String decision = "";
        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("What operation do you want?");
            String choice = reader.next();

            switch (choice) {
                case "save":
                    User saveUser = getUserData(choice, reader);

                    int saved = userService.saveUserInfo(saveUser);
                    if (saved >= 1) {
                        System.out.println("user info saved successfully");
                    } else {
                        System.out.println("error in db");
                    }
                    break;

                case "update":
                    User updateUser = getUserData(choice, reader);

                    int updated = userService.updateUserInfo(updateUser);
                    if (updated >= 1) {
                        System.out.println("user info updated successfully");
                    } else {
                        System.out.println("error in db");
                    }
                    break;

                case "delete":
                    System.out.println("Enter id: ");
                    int deleteId = reader.nextInt();
                    userService.deleteUserInfo(deleteId);
                    System.out.println("user info is deleted");
                    break;

                case "get":
                    System.out.println("Enter id: ");
                    int getId = reader.nextInt();
                    User user = userService.getUserById(getId);
                    System.out.println("user id : " + user.getId());
                    System.out.println("username : " + user.getUsername());
                    System.out.println("password : " + user.getPassword());
                    System.out.println("mobile number : " + user.getMobileNo());
                    System.out.println("address : " + user.getAddress());
                    break;

                case "list":
                    List<User> userList = userService.getAllUserInfo();
                    for (User u : userList) {
                        System.out.println("user id : " + u.getId());
                        System.out.println("username : " + u.getUsername());
                        System.out.println("password : " + u.getPassword());
                        System.out.println("mobile number : " + u.getMobileNo());
                        System.out.println("address : " + u.getAddress());
                        System.out.println("==========================");
                    }
                    break;
                default:
                    System.out.println("wrong choice!!");
            }
            System.out.println("Do you want to perform next operation? ");
            decision = reader.next();
        } while (decision.equalsIgnoreCase("y"));
    }

    public static User getUserData(String type, Scanner reader) {
        User user = new User();
        if (type.equals("update")) {
            System.out.println("Enter id: ");
            int id = reader.nextInt();
            user.setId(id);
        }
        System.out.println("Enter username: ");
        String userName = reader.next();
        System.out.println("Enter password: ");
        String password = reader.next();
        System.out.println("Enter Mobile Number: ");
        long mobileNo = reader.nextLong();
        System.out.println("Address: ");
        String address = reader.next();

        user.setUsername(userName);
        user.setPassword(password);
        user.setAddress(address);
        user.setMobileNo(mobileNo);
        return user;
    }
}