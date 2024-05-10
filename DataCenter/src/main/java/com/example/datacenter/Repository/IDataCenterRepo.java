package com.example.datacenter.Repository;

import com.example.datacenter.DataCenterApplication;
import com.example.datacenter.Entity.Datacenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IDataCenterRepo extends JpaRepository<Datacenter, Integer> {
//    @Query("select d.region from Datacenter d where d.dateFabrication > '01-11-2019'")
//    List<Datacenter> getAllDataCenter();
    Datacenter findFirstByOrderByEspaceLibreDisqueAsc();
    @Query("select d from Datacenter d join d.virtualMachines v where d.espaceLibreDisque > v.tailleDisque order by d.espaceLibreDisque asc ")
    Datacenter retriveDatacenter ();
}
