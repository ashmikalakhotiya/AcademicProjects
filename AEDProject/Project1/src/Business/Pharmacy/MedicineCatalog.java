/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pharmacy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CUTIE
 */
public class MedicineCatalog {

    private List<Medicine> medicineList;

    public MedicineCatalog() {
        medicineList = new ArrayList<Medicine>();
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public Medicine addMedicine() {
        Medicine m = new Medicine();
        medicineList.add(m);
        return m;
    }

    public void removeMedicine(Medicine m) {
        medicineList.remove(m);
    }
}
