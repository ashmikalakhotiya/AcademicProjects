package Business.Pharmacy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;


/**
 *
 * @author CUTIE
 */
public class MedicalStoreDirectory {
    private ArrayList<MedicalStore> medicalStoreList;
   
    public MedicalStoreDirectory() {
        medicalStoreList = new ArrayList<MedicalStore>();
    }

    public ArrayList<MedicalStore> getMedicalStoreList() {
        return medicalStoreList;
    }
    
    public MedicalStore addMedicalStore(String name){
        MedicalStore ms = new MedicalStore();
        ms.setMedicalStoreName(name);
        medicalStoreList.add(ms);
        return ms;   
    }
    
    public void removeSupplier(MedicalStore ms){
        medicalStoreList.remove(ms);
    }   
}
