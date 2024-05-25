package com.talenthub.perfil.service;


import com.talenthub.perfil.model.CanelaUser;
import com.talenthub.perfil.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanelaUserService {

    @Autowired
    private CanelaUserRepository canelaUserRepository;

    public List<CanelaUser> findAllUsers() {
        return canelaUserRepository.findAll();
    }

//    public CanelaUser findPlanById(Long id) {
//        return canelaUserRepository.findById(id).orElse(null);
//    }

//    public CanelaUser findUserByUsername(String username) {
//        return canelaUserRepository.findByUsername(username);
//    }
    
    public CanelaUser saveUser(CanelaUser user) {
        return canelaUserRepository.save(user);
    }

    public Optional<CanelaUser> findUserById(Long id) {
        return canelaUserRepository.findById(id);
    }

    public CanelaUser updateUser(Long id, CanelaUser userDetails) {
        return canelaUserRepository.findById(id)
            .map(user -> {
                user.setIdentification(userDetails.getIdentification());
                user.setEmail(userDetails.getEmail());
                user.setPassword(userDetails.getPassword());
                user.setName(userDetails.getName());
                user.setSurname(userDetails.getSurname());
                user.setNumberPhone(userDetails.getNumberPhone());
                user.setAddress(userDetails.getAddress());
                user.setEmergencyContactName(userDetails.getEmergencyContactName());
                user.setEmergencyContact(userDetails.getEmergencyContact());
                user.setPositionId(userDetails.getPositionId());
                user.setUser_id(userDetails.getUser_id());
                return canelaUserRepository.save(user);
            })
            .orElseGet(() -> {
                userDetails.setId(id);
                return canelaUserRepository.save(userDetails);
            });
    }

    public void deleteUser(Long id) {
        canelaUserRepository.deleteById(id);
    }
}
