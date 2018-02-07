package com.example.searchjpa.repository;

import com.example.searchjpa.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>{
//    @Query("select u from Users u where u.firstname like  ?1% OR u.lastname like  ?1% OR u.address like  ?1% OR u.city like  ?1% OR u.email like  ?1% OR u.state like  ?1%")
//    List<Users> find(String text);
//    Page<Users> findAll(Pageable pageRequest);
   // List<Users> findAll(Specifications<Users> specifications);
     Page<Users> findAll(Specification<Users> spec,Pageable pageRequest);
}

