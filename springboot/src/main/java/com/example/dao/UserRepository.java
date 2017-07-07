package com.example.dao;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aiyabeetle on 2017/6/6.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
