/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Patient.MasterOrderCatalog;
import Business.Role.PatientRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author CUTIE
 */
public class PatientOrganization extends Organization{
    private MasterOrderCatalog masterOrderCatalog;
    
    public PatientOrganization() {
        super(Organization.Type.Patient.getValue());
        masterOrderCatalog = new MasterOrderCatalog();
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PatientRole());
        return roles;
    }
     
  
    
    
}
