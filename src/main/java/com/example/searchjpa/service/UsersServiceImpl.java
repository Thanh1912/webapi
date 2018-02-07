package com.example.searchjpa.service;

import com.example.searchjpa.DAO.UserDao;
import com.example.searchjpa.DTO.RootObject;
import com.example.searchjpa.model.Users;
import com.example.searchjpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    UserDao userDao;
    @Autowired
    UsersRepository userRepository;

    @Override
    public void createUser() {
        userDao.createUser();
    }

    @Override
    public Page<Users> findAll(Map<String,String> attributes, Pageable pageRequest) {
        Specification specification=Specifications.where(UsersSpecification.containsTextInAttributes2(attributes));
        return userRepository.findAll(specification,pageRequest);
    }
    @Override
    public Page<Users> findAllEqIds(List<String> attributes, Pageable pageable) {
        Specification specification=Specifications.where(UsersSpecification.containsTextInAttributeseq(attributes));
        return userRepository.findAll(specification,pageable);
    }

    @Override
    public Page<Users> findAllFilterPost(RootObject rootObject, Pageable pageable) {
        Specification specification=Specifications.where(
                UsersSpecification.containsTextInAttributeseqUsePostOject(rootObject));
        return userRepository.findAll(specification,pageable);
    }


}
