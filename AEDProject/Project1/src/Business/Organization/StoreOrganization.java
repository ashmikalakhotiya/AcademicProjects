/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;



import Business.Role.Role;
import Business.Role.StoreRole;
import java.util.ArrayList;

/**
 *
 * @author CUTIE
 */
public class StoreOrganization extends Organization{
   
   
    public StoreOrganization() {
        super(Organization.Type.Store.getValue());
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new StoreRole());
        return roles;
    }
     
  
    
    
}
