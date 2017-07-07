package com.example.web;

import com.example.dao.UserRepository;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aiyabeetle on 2017/5/24.
 */
@RestController
@RequestMapping(value = "/project")
public class HelloWorldController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String index(){
        return "hi this is a simple springboot project! 哈哈哈哈";
    }
    @RequestMapping(value = {"/say"},method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id:"+id;
    }

    @GetMapping(value = "/getAll")
    public List<User> getUserList(){
        System.out.println("test github");
        return userRepository.findAll();
    }
}
