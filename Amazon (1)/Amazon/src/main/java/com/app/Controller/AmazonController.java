package com.app.Controller;

import com.app.DTO.UserDetailsDTO;
import com.app.Request.UserDetails;
import com.app.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AmazonController {
    @Autowired
    UserServiceImpl service;

    @GetMapping("/login")
    public String login(){
        return "Hello Varun, You're loggedIn" ;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addUser")
    public UserDetailsDTO addUserToDb(@RequestBody UserDetails userDetails){
    return service.saveUser(userDetails);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addUsers")
    public List<UserDetailsDTO> addAllUserToDb(@RequestBody List<UserDetails> userDetails){
        return service.saveAllUserDetails(userDetails);
    }


    @RequestMapping(method = RequestMethod.GET,value ="/getUser/{Id}")
        public UserDetailsDTO getUserDetails(@PathVariable Long Id){
            return service.getUser(Id);
        }

    @RequestMapping(method = RequestMethod.DELETE,value ="/deleteUser/{Id}")
    public String deleteUserDetail(@PathVariable Long Id){
        service.deleteUserDetails(Id);
        return "User Deleted";
    }
    @RequestMapping(method = RequestMethod.GET,value ="/getUsers")
    public List<UserDetailsDTO> getAllUserDetails(){
        return service.getAllUsers();
    }
    @RequestMapping(method = RequestMethod.DELETE,value ="/deleteUsers")
    public String deleteAllUserDetail(){
        service.deleteAllUserDetails();
        return "All User Data Deleted";
    }
    }
