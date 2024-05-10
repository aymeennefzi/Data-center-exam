package com.example.datacenter.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VirtualMachine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVm ;
    int tailleDisque ;
    @Enumerated(value = EnumType.STRING)
    Etat etat ;
    @JsonIgnore
    @ManyToOne
    Datacenter datacenter ;
}
