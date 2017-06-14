/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.PatientWorkArea.PatientMainWorkAreaJPanel;

/**
 *
 * @author CUTIE
 */
public class PatientRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new PatientMainWorkAreaJPanel(userProcessContainer, account,(PatientOrganization)organization, enterprise, business);
    }
    
}
