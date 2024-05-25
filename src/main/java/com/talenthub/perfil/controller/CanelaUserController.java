package com.talenthub.perfil.controller;


import com.talenthub.perfil.model.CanelaUser;
import com.talenthub.perfil.service.CanelaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canelauser")
public class CanelaUserController {

    @Autowired
    private CanelaUserService canelaUserService;

    @GetMapping
    public ResponseEntity<List<CanelaUser>> getAllUsers() {
        return ResponseEntity.ok(canelaUserService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CanelaUser> getPlanById(@PathVariable Long id) {
        CanelaUser canelaUser = canelaUserService.findPlanById(id);
        if (canelaUser != null) {
            return ResponseEntity.ok(canelaUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{username}")
    public CanelaUser getUserByUsername(@PathVariable String username) {
        return canelaUserService.findUserByUsername(username);
    }


    @PostMapping
    public ResponseEntity<CanelaUser> createUser(@RequestBody CanelaUser user) {
        return ResponseEntity.status(201).body(canelaUserService.saveUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CanelaUser> getUser(@PathVariable Long id) {
        return canelaUserService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CanelaUser> updateUser(@PathVariable Long id, @RequestBody CanelaUser userDetails) {
        return ResponseEntity.ok(canelaUserService.updateUser(id, userDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        canelaUserService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
