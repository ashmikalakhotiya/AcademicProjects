



package Business.Pharmacy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author CUTIE
 */
public class MedicalStore {
    private String medicalStoreName;
    private MedicineCatalog medicineList;

    public MedicalStore() {
    medicineList = new MedicineCatalog();
    }

    public String getMedicalStoreName() {
        return medicalStoreName;
    }

    public void setMedicalStoreName(String medicalStoreName) {
        this.medicalStoreName = medicalStoreName;
    }

    public MedicineCatalog getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(MedicineCatalog medicineList) {
        this.medicineList = medicineList;
    }

   
    @Override
    public String toString() {
        return medicalStoreName; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
