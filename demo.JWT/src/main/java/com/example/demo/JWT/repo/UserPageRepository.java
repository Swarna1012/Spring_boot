package com.example.demo.JWT.repo;

import com.example.demo.JWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPageRepository extends PagingAndSortingRepository<User, Long> {


    Object findAll();
}
