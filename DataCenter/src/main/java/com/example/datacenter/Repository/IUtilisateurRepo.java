package com.example.datacenter.Repository;

import com.example.datacenter.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUtilisateurRepo extends JpaRepository <Utilisateur, Integer> {

}
