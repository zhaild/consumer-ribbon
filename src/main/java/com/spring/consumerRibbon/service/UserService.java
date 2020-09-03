package com.spring.consumerRibbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.consumerRibbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhaild
 * @date 2020/8/15:46 PM
 * @Description: 用户业务层
 */
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {

        return restTemplate.postForObject("http://PROVIDER-USER/user/hi?name=" + name, null, String.class);

    }

    @HystrixCommand(fallbackMethod = "userListError")
    public List userList() {

        return restTemplate.postForObject("http://PROVIDER-USER/user/userList", "", List.class);

    }

    @HystrixCommand(fallbackMethod = "addUserError")
    public String addUser(User user) {

        return restTemplate.postForEntity("http://PROVIDER-USER/user/add", user, String.class).getBody();

    }

    @HystrixCommand(fallbackMethod = "updateUserError")
    public String updateUser(User user) {

        return restTemplate.postForEntity("http://PROVIDER-USER/user/updateUser", user, String.class).getBody();

    }

    @HystrixCommand(fallbackMethod = "delUserError")
    public String delUser(String id) {

        return restTemplate.postForObject("http://PROVIDER-USER/user/delUser?id=" + id, null, String.class);

    }

    public String hiError(String name) {

        return "服务器开了小差，请休息一会再试！";

    }

    public List userListError() {

        return null;

    }

    public String addUserError(User user) {
        return "服务器开了小差，请休息一会再试！";
    }

    public String updateUserError(User user) {
        return "服务器开了小差，请休息一会再试！";
    }

    public String delUserError(String id) {
        return "服务器开了小差，请休息一会再试！";
    }

}


