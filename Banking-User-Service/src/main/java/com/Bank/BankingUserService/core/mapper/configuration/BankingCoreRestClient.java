package com.Bank.BankingUserService.core.mapper.configuration;

import com.Bank.BankingUserService.business.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="Banking-Bank-Service",path = "/api/user")
@Service
public interface BankingCoreRestClient {

    @RequestMapping(method = RequestMethod.GET,value="/api/user/{identification}")
    UserResponse readUser(@PathVariable("identification") String identification);

}
