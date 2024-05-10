package com.example.datacenter.Controllers;

import com.example.datacenter.Entity.Datacenter;
import com.example.datacenter.Entity.Utilisateur;
import com.example.datacenter.Entity.VirtualMachine;
import com.example.datacenter.Service.IExamenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ExamenController {
    private final IExamenService iExamenService ;
    @PostMapping("/addUer")
    public void ajouterUser(@RequestBody Utilisateur u){
        iExamenService.ajouterUser(u);
    }
    @PostMapping("/addDC")
    public void ajouterDc(@RequestBody Datacenter datacenter){
        iExamenService.ajouterDc(datacenter);
    }

    @PostMapping("/addVm")
    public int ajouterVm(@RequestBody VirtualMachine vm){
        return iExamenService.ajouterVm(vm);
    }

    @PostMapping("/affecter/{idvm}/{iduser}")
    public void affecterVmuser(@PathVariable ("idvm") int idvm,@PathVariable ("iduser") int iduser){
        iExamenService.affecterVmuser(idvm,iduser);
    }

    @PostMapping("/affecter/{idvm}")
    public void affecterVm(@PathVariable ("idvm") int idvm){
        iExamenService.affecterVm(idvm);
    }

    @PostMapping("/demmarer/{idvm}")
    public void demarrerInstanceUser(@PathVariable ("idvm") int idvm){
        iExamenService.demarrerInstanceUser(idvm);
    }

    @PostMapping("/arreter/{idvm}")
    public void arreterInstanceUser(@PathVariable ("idvm") int idvm){
        iExamenService.arreterInstanceUser(idvm);
    }

//    @GetMapping("/getallDatacenter")
//    public List<Datacenter> listerDatacenter(){
//        return iExamenService.listerDatacenter();
//    }
}
