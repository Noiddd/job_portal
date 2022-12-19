package com.ncs.jobportal.service;

import com.ncs.jobportal.model.Admin;
import com.ncs.jobportal.model.Employer;
import com.ncs.jobportal.model.JobSeeker;
import com.ncs.jobportal.model.User;
import com.ncs.jobportal.repo.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    public User getUserByEmail(String email) {
//        return userRepo.findBy(Example.of(), String email);
//    }

    public List<User> getAllUsers(){


        return this.userRepo.findAll();
    }

    public List<Employer> getAllEmployers(){
        return this.userRepo.findAll(Example.of(new Employer()));
    }

    public User addUser(User user) {
        return this.userRepo.save(user);
    }

    public User addEmployer(Employer employer) {
        return this.userRepo.save(employer);
    }

    public User addJobSeeker(JobSeeker jobSeeker) {
        return this.userRepo.save(jobSeeker);
    }

    public User addAdmin(Admin admin) {
        return this.userRepo.save(admin);
    }

    public User getEmployerByEmail(String email) {
        return (User) em.createQuery("select u from User u where u.email=:email")
                .setParameter("email", email)
                .getSingleResult();
    }

    public Long getEmployerIdByEmail(String email) {
        return (Long) em.createQuery("select u.id from User u where u.email=:email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Transactional
    public Boolean updateUserEmail(String email, Long id){
        return em.createQuery("update User u set u.email=:email where u.id=:id")
                .setParameter("id", id)
                .setParameter("email", email)
                .executeUpdate() == 1;
    }
}
