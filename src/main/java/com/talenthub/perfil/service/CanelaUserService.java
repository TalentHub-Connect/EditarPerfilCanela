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
    private CanelaUserRepository caneiaUserRepository;

    public List<CanelaUser> findAllUsers() {
        return caneiaUserRepository.findAll();
    }

    public CanelaUser saveUser(CanelaUser user) {
        return caneiaUserRepository.save(user);
    }

    public Optional<CanelaUser> findUserById(Long id) {
        return caneiaUserRepository.findById(id);
    }

    public CanelaUser updateUser(Long id, CanelaUser userDetails) {
        return caneiaUserRepository.findById(id)
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
                return caneiaUserRepository.save(user);
            })
            .orElseGet(() -> {
                userDetails.setId(id);
                return caneiaUserRepository.save(userDetails);
            });
    }

    public void deleteUser(Long id) {
        caneiaUserRepository.deleteById(id);
    }
}
