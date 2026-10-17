package com.pro24y3s2doemakra.rest_api.controller;
import com.pro24y3s2doemakra.rest_api.entity.User;
import com.pro24y3s2doemakra.rest_api.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

//    UserService userService1 = new UserServiceImpl();

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getTest(){
        return "Test Controller";
    }

    // HTTP Method POST, PUT, PATCH, DELETE

    // POST
    @PostMapping
    public void userPOST(@RequestBody User user) {
        System.out.println("User Create");
        System.out.println(user);
        userService.create(user);
    }

    //PUT
    @PutMapping
    public void userPUT() {
        System.out.println("User update full data");
    }

    //Patch
    @PatchMapping
    public void userPATCH() {
        System.out.println("User update specific data");
    }

    @DeleteMapping
    public void userDELETE() {
        System.out.println("User Delete Data");
    }

}
