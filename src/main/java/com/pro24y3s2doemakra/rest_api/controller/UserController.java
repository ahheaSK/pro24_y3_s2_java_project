package com.pro24y3s2doemakra.rest_api.controller;
import com.pro24y3s2doemakra.rest_api.entity.User;
import com.pro24y3s2doemakra.rest_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

//    UserService userService1 = new UserServiceImpl();

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
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
    @PutMapping("{id}")
    public ResponseEntity<?> userPUT(@PathVariable Long id, @RequestBody User user) {
        User user1 = userService.updateById(id, user);
        return ResponseEntity.ok(user1);
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
