package com.spring.consumerRibbon.controller;

import com.spring.consumerRibbon.entity.User;
import com.spring.consumerRibbon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author zhaild
 * @date 2020/8/15:50 PM
 * @Description: 用户控制层
 */
@RestController
public class UserControler {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {

        return userService.hiService(name);

    }

    @RequestMapping(value = "/userList")
    public List userList() {

        return userService.userList();

    }

    @RequestMapping(value = "/addUser")
    public String addUser(@RequestParam String id, String username) {

        User user = new User();

        user.setId(id);

        user.setUsername(username);

        return userService.addUser(user);

    }

    @GetMapping(value = "/updateUser")
    public String updateUser(@RequestParam String id, String username) {

        User user = new User();

        user.setId(id);

        user.setUsername(username);

        return userService.updateUser(user);

    }

    @GetMapping(value = "/delUser")
    public String delUser(@RequestParam String id) {
        return userService.delUser(id);
    }

}
