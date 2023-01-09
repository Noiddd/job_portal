package com.ncs.jobportal.repo;

import com.ncs.jobportal.model.User;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository<User, Long> {

}
