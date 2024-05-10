package com.example.datacenter.Service;

import com.example.datacenter.Entity.Datacenter;
import com.example.datacenter.Entity.Utilisateur;
import com.example.datacenter.Entity.VirtualMachine;

import java.util.List;

public interface IExamenService {
    public void ajouterUser(Utilisateur u);
    public void ajouterDc(Datacenter datacenter);
    public int ajouterVm(VirtualMachine vm);
    public void affecterVmuser(int idvm, int iduser);
    public void affecterVm(int idvm);
    public void demarrerInstanceUser(int idvm);
    public void arreterInstanceUser(int idvm);
//    public List<Datacenter> listerDatacenter();
}
