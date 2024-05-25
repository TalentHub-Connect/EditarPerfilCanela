package com.talenthub.perfil.repository;


import com.talenthub.perfil.model.CanelaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanelaUserRepository extends JpaRepository<CanelaUser, Long> {

//    CanelaUser findByUsername(String username);

}
