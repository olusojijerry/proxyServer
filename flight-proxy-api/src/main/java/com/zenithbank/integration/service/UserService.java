package com.zenithbank.integration.service;

import com.zenithbank.integration.dto.users.CreateUserDto;
import com.zenithbank.integration.entity.flight.CoreUser;
import com.zenithbank.integration.services.CoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    CoreUserService coreUserService;

    public CoreUser createUser (CreateUserDto userDto, CoreUser user){
        CoreUser coreUser = new CoreUser();

        coreUser.setCreatedBy(user.getUserName());
        coreUser.setCreatedDt(new Date());
        coreUser.setPassword(userDto.getPassword());
        coreUser.setUserName(userDto.getUsername());

        coreUserService.saveOrUpdate(coreUser);

        return coreUser;
    }
}
