package com.Bank.BankingUserService.webApiController;

import com.Bank.BankingUserService.business.abstracts.UserService;
import com.Bank.BankingUserService.business.dto.requests.CreateUserRequest;
import com.Bank.BankingUserService.business.dto.requests.UpdateUserRequest;
import com.Bank.BankingUserService.business.dto.responses.GetAllUserResponse;
import com.Bank.BankingUserService.business.dto.responses.GetByIdUserResponse;
import com.Bank.BankingUserService.model.Entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping()
    public List<GetAllUserResponse> getAll(){
        return this.userService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdUserResponse getById(@PathVariable long id){
        return this.userService.getById(id);
    }
    @PutMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateUserRequest createUserRequest){
        this.userService.add(createUserRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdateUserRequest updateUserRequest){
        this.userService.update(updateUserRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        this.userService.delete(id);
    }

}
