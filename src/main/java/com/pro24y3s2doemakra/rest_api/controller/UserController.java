package com.pro24y3s2doemakra.rest_api.controller;
import com.pro24y3s2doemakra.rest_api.service.impl.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

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
    public void userPOST() {
        System.out.println("User Create");
        userService.create();
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
