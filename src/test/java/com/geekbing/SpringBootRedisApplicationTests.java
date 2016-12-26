package com.geekbing;

import com.geekbing.entity.Department;
import com.geekbing.entity.Role;
import com.geekbing.entity.User;
import com.geekbing.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    private static Logger logger = LoggerFactory.getLogger(SpringBootRedisApplicationTests.class);

    @Autowired
    UserRepository userRepository;

    @Before
    public void setup() {
        Department deparment = new Department();
        deparment.setName("开发部");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("user");

        user.setCreatedate(new Date());
        user.setDepartment(deparment);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        userRepository.delete(this.getClass().getName() + ":userByname:" + user.getName());
        userRepository.add(this.getClass().getName() + ":userByname:" + user.getName(), 10L, user);
    }

    @Test
    public void contextLoads() {
        User user = userRepository.get(this.getClass().getName() + ":userByname:user");
        Assert.notNull(user);
        logger.info("======user====== name:{}, deparment:{}, role:{}", user.getName(), user.getDepartment().getName(), user.getRoles().get(0).getName());
    }
}
