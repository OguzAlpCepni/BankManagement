package com.Bank.BankingBankService.WebApi.Controller;

import com.Bank.BankingBankService.Business.abstracts.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/user")
public class UserConstoller {
    private final UserService userService;
    private final MessageSource messageSource;
    @GetMapping(value = "/{identification}")
    public ResponseEntity readUser(@PathVariable("identification") String identification) {
        return ResponseEntity.ok(userService.readUser(identification));
    }
    @GetMapping
    public ResponseEntity readUsers() {
        return ResponseEntity.ok(userService.readUsers());
    }

}
