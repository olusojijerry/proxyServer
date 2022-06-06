package com.zenithbank.integration.endpoint;

import com.zenithbank.integration.auth.annotation.Auth;
import com.zenithbank.integration.config.pojo.RestResponsePojo;
import com.zenithbank.integration.dto.users.CreateUserDto;
import com.zenithbank.integration.entity.flight.CoreUser;
import com.zenithbank.integration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@Slf4j
public class Users {

    @Autowired
    UserService userService;

    @PostMapping("")
    public RestResponsePojo<CoreUser> createUser(@Auth CoreUser user,
                                                 @RequestBody CreateUserDto userDto){
        RestResponsePojo<CoreUser> restResponsePojo = new RestResponsePojo<>();

        CoreUser coreUser = userService.createUser(userDto, user);

        coreUser.setPassword("");

        restResponsePojo.setMessage("Successful");
        restResponsePojo.setData(coreUser);

        return restResponsePojo;
    }
}
