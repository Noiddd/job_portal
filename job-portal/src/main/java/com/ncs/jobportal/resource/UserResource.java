package com.ncs.jobportal.resource;

import com.ncs.jobportal.model.Admin;
import com.ncs.jobportal.model.Employer;
import com.ncs.jobportal.model.JobSeeker;
import com.ncs.jobportal.model.User;
import com.ncs.jobportal.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {


    private final UserService userService;

    public UserResource(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/findAllEmployers")
    public List<Employer> getAllEmployers(){
        return userService.getAllEmployers();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/addEmployer")
    public User addEmployer(@RequestBody Employer employer){
        return userService.addEmployer(employer);
    }

    @PostMapping("/addJobSeeker")
    public User addJobSeeker(@RequestBody JobSeeker jobSeeker){
        return userService.addJobSeeker(jobSeeker);
    }

    @PostMapping("/addAdmin")
    public User addAdmin(@RequestBody Admin admin){
        return userService.addAdmin(admin);
    }

    @GetMapping("/findEmployerByEmail/{email}")
    public User findEmployerByEmail (@PathVariable("email") String email){
        return userService.getEmployerByEmail(email);
    }

    @GetMapping("/findEmployerIdByEmail/{email}")
    public Long findEmployerIdByEmail (@PathVariable("email") String email){
        return userService.getEmployerIdByEmail(email);
    }

    @PutMapping("/updateUserEmail/{email}/{id}")
    public Boolean updateUserEmail (@PathVariable("email") String email, @PathVariable("id") Long id){
        return userService.updateUserEmail(email, id);
    }
}
