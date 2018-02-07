package com.example.searchjpa.service;

import com.example.searchjpa.DAO.UserDao;
import com.example.searchjpa.DTO.RootObject;
import com.example.searchjpa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public interface UsersService  {
    public void createUser();
    Page<Users> findAll(Map<String,String> attributes, Pageable pageable);
    Page<Users> findAllEqIds(List<String> attributes, Pageable pageable);
    Page<Users> findAllFilterPost(RootObject rootObject, Pageable pageable);
}
