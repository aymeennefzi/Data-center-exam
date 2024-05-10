package com.example.datacenter.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Datacenter implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int idDs ;
    String region ;
    @Temporal(TemporalType.DATE)
    LocalDate dateFabrication;
    int capaicteDisque ;
    int espaceLibreDisque ;
    @JsonIgnore
    @OneToMany(mappedBy = "datacenter")
    List<VirtualMachine> virtualMachines ;
}
