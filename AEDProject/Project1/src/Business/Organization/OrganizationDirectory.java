/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CUTIE
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
     Organization organization = null;
     boolean isOrganizationPresent = false;
        for (Organization o : organizationList){
             if(o.getName().equalsIgnoreCase(type.getValue())){
                 isOrganizationPresent = true;
                 break;
             }
        }
        if(!isOrganizationPresent){
             if (type.getValue().equals(Type.Doctor.getValue())){
                organization = new DoctorOrganization();
                 organizationList.add(organization);
            }
            else if (type.getValue().equals(Type.Receptionist.getValue())){
                organization = new ReceptionistOrganization();
                organizationList.add(organization);
            }
            else if (type.getValue().equals(Type.Patient.getValue())){
                organization = new PatientOrganization();
                organizationList.add(organization);
            
            }
             else if (type.getValue().equals(Type.Lab.getValue())){
                organization = new LabOrganization();
                organizationList.add(organization);
            
            }
            else if (type.getValue().equals(Type.Store.getValue())){
                organization = new StoreOrganization();
                organizationList.add(organization);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Organization already exists","Error",JOptionPane.ERROR_MESSAGE);
        }
                return organization;
    }
  
}