package com.example.datacenter.Service;

import com.example.datacenter.Entity.Datacenter;
import com.example.datacenter.Entity.Etat;
import com.example.datacenter.Entity.Utilisateur;
import com.example.datacenter.Entity.VirtualMachine;
import com.example.datacenter.Repository.IDataCenterRepo;
import com.example.datacenter.Repository.IUtilisateurRepo;
import com.example.datacenter.Repository.IVirtualMachineRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExamenServiceImplements implements IExamenService {
    private final IDataCenterRepo iDataCenterRepo;
    private final IVirtualMachineRepo iVirtualMachineRepo ;
    private final IUtilisateurRepo iUtilisateurRepo ;
    @Override
    public void ajouterUser(Utilisateur u) {
        iUtilisateurRepo.save(u);
    }
    @Override
    public void ajouterDc(Datacenter datacenter) {
        iDataCenterRepo.save(datacenter);
    }

    @Override
    public int ajouterVm(VirtualMachine vm) {
         iVirtualMachineRepo.save(vm);
         return 1 ;
    }

    @Transactional
    @Override
    public void affecterVmuser(int idvm, int iduser) {
        VirtualMachine virtualMachine = iVirtualMachineRepo.findById(idvm).orElse(null);
        Utilisateur utilisateur = iUtilisateurRepo.findById(iduser).orElse(null);
        if (utilisateur.getVirtualMachines() == null) {
            Set<VirtualMachine> virtualMachines = new HashSet();
            virtualMachines.add(virtualMachine);
            utilisateur.setVirtualMachines(virtualMachines);
        } else {
            utilisateur.getVirtualMachines().add(virtualMachine);
            iUtilisateurRepo.save(utilisateur);
        }
    }

//    @Transactional
//    @Override
//    public void affecterVm(int idvm) {
//        List<VirtualMachine> machinesVirtuelles = iVirtualMachineRepo.findAll();
//
//        for (VirtualMachine virtualMachine : machinesVirtuelles) {
//            if (virtualMachine.getDatacenter() == null) {
//                Datacenter datacenter = iDataCenterRepo.findFirstByOrderByEspaceLibreDisqueAsc();
//
//                if (datacenter != null && datacenter.getEspaceLibreDisque() >= virtualMachine.getTailleDisque()) {
//                    // Affectation de la machine virtuelle au Datacenter
//                    virtualMachine.setDatacenter(datacenter);
//
//                    // Mise à jour de l'espace libre du Datacenter
//                    datacenter.setEspaceLibreDisque(datacenter.getEspaceLibreDisque() - virtualMachine.getTailleDisque());
//
//                    // Sauvegarde des changements dans la base de données
//                    iDataCenterRepo.save(datacenter);
//                    iVirtualMachineRepo.save(virtualMachine);
//                }
//            }
//        }
//    }
@Transactional
@Override
public void affecterVm(int idvm) {
    VirtualMachine virtualMachine = iVirtualMachineRepo.findById(idvm).orElse(null);

    if (virtualMachine != null && virtualMachine.getDatacenter() == null) {
        Datacenter datacenter = iDataCenterRepo.retriveDatacenter();

        if (datacenter != null && datacenter.getEspaceLibreDisque() >= virtualMachine.getTailleDisque()) {
            // Affectation de la machine virtuelle au Datacenter
            virtualMachine.setDatacenter(datacenter);

            // Mise à jour de l'espace libre du Datacenter
            datacenter.setEspaceLibreDisque(datacenter.getEspaceLibreDisque() - virtualMachine.getTailleDisque());

            // Sauvegarde des changements dans la base de données
            iDataCenterRepo.save(datacenter);
            iVirtualMachineRepo.save(virtualMachine);
        }
    }
}


    @Override
    public void demarrerInstanceUser(int idvm) {
    VirtualMachine virtualMachine =iVirtualMachineRepo.findUtilisateurByIdVm(idvm);
    if (virtualMachine.getEtat()==Etat.STOPPED){
        virtualMachine.setEtat(Etat.RUNNING);
    }
    }

    @Override
    public void arreterInstanceUser(int idvm) {
        VirtualMachine virtualMachine =iVirtualMachineRepo.findUtilisateurByIdVm(idvm);
        if (virtualMachine.getEtat()==Etat.RUNNING){
            virtualMachine.setEtat(Etat.STOPPED);
        }
    }
//    @Scheduled(cron = "* * * * * * ")
//    @Override
//    public List<Datacenter> listerDatacenter() {
////        return iDataCenterRepo.getAllDataCenter();
//    }
}

