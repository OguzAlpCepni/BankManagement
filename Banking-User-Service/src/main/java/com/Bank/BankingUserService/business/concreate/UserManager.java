package com.Bank.BankingUserService.business.concreate;

import com.Bank.BankingUserService.business.Rules.UserBusinessRules;
import com.Bank.BankingUserService.business.abstracts.UserService;
import com.Bank.BankingUserService.business.dto.User;
import com.Bank.BankingUserService.business.dto.UserResponse;
import com.Bank.BankingUserService.business.dto.requests.CreateUserRequest;
import com.Bank.BankingUserService.business.dto.requests.UpdateUserRequest;
import com.Bank.BankingUserService.business.dto.responses.GetAllUserResponse;
import com.Bank.BankingUserService.business.dto.responses.GetByIdUserResponse;
import com.Bank.BankingUserService.core.mapper.ModelMapperService;
import com.Bank.BankingUserService.core.mapper.configuration.BankingCoreRestClient;
import com.Bank.BankingUserService.dataAccess.UserRepository;
import com.Bank.BankingUserService.model.Entity.UserEntity;
import com.Bank.BankingUserService.model.Enum.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private BankingCoreRestClient bankingCoreRestClient;
    private UserBusinessRules userBusinessRules;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<GetAllUserResponse> getAllUserResponses = userEntities.stream()
                .map(userEntity -> this.modelMapperService.forResponse()
                        .map(userEntity, GetAllUserResponse.class))
                .collect(Collectors.toList());
        return getAllUserResponses;
    }

    @Override
    public GetByIdUserResponse getById(long id) {
        UserEntity userEntity = this.userRepository.findById(id).orElseThrow();
        GetByIdUserResponse getByIdUserResponse = this.modelMapperService.forResponse().map(userEntity,GetByIdUserResponse.class);
        return getByIdUserResponse;
    }

    @Override
    public CreateUserRequest add(CreateUserRequest createUserRequest) {
        userBusinessRules.checkIfUserMailExists(createUserRequest.getEmail());
        User user = bankingCoreRestClient.readUser(createUserRequest.getIdentification());
        userBusinessRules.emailValidation(user,createUserRequest);
        UserEntity userEntity = this.modelMapperService.forRequest().map(createUserRequest,UserEntity.class);
        userEntity.setStatus(Status.PENDING);
        this.userRepository.save(userEntity);
        CreateUserRequest createUserRequest1 = this.modelMapperService.forResponse().map(userEntity,CreateUserRequest.class);
        return createUserRequest1;
    }



    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
