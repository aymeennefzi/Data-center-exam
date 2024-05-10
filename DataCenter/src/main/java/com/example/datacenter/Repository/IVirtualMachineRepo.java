package com.example.datacenter.Repository;

import com.example.datacenter.Entity.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IVirtualMachineRepo extends JpaRepository<VirtualMachine , Integer> {
    @Query("SELECT u FROM Utilisateur u JOIN u.virtualMachines v WHERE v.idVm = :idVm")
    VirtualMachine findUtilisateurByIdVm(@Param("idVm") int idVm);


}
