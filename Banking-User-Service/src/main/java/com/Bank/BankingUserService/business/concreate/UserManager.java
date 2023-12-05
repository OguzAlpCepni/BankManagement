package com.Bank.BankingUserService.business.concreate;

import com.Bank.BankingUserService.business.abstracts.UserService;
import com.Bank.BankingUserService.business.dto.requests.CreateUserRequest;
import com.Bank.BankingUserService.business.dto.requests.UpdateUserRequest;
import com.Bank.BankingUserService.business.dto.responses.GetAllUserResponse;
import com.Bank.BankingUserService.business.dto.responses.GetByIdUserResponse;
import com.Bank.BankingUserService.core.mapper.ModelMapperService;
import com.Bank.BankingUserService.dataAccess.UserRepository;
import com.Bank.BankingUserService.model.Entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

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
    public void add(CreateUserRequest createUserRequest) {
        UserEntity userEntity = this.modelMapperService.forRequest().map(createUserRequest,UserEntity.class);
        this.userRepository.save(userEntity);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        UserEntity userEntity = this.modelMapperService.forRequest().map(updateUserRequest,UserEntity.class);
        this.userRepository.save(userEntity);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
