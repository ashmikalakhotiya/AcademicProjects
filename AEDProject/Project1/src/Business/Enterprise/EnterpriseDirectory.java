/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CUTIE
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        boolean isEnterprisePresent = true;
        if (enterpriseList.isEmpty()) {
            if (type == Enterprise.EnterpriseType.Hospital) {
                enterprise = new HospitalEnterprise(name);
                enterpriseList.add(enterprise);
            } else if ((type == Enterprise.EnterpriseType.Pharmaceutical)) {
                enterprise = new PharmaceuticalEnterprise(name);
                enterpriseList.add(enterprise);
            }
            return enterprise;
        } else {
            for (Enterprise e : getEnterpriseList()) {
                if (e.getName().equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(null, "Enterprise Already Present", "Error", JOptionPane.INFORMATION_MESSAGE);
                    isEnterprisePresent = true;
                    break;
                } else {
                    isEnterprisePresent = false;
                }
            }
            if (isEnterprisePresent == false) {
                if (type == Enterprise.EnterpriseType.Hospital) {
                    enterprise = new HospitalEnterprise(name);
                    enterpriseList.add(enterprise);
                } else if ((type == Enterprise.EnterpriseType.Pharmaceutical)) {
                    enterprise = new PharmaceuticalEnterprise(name);
                    enterpriseList.add(enterprise);
                }
                return enterprise;

            }

        }
        return null;

    }

}
