package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CUTIE
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork(String name) {
        Boolean isNetworkPresent = true;
        if (name.length() > 0) {
            if (networkList.isEmpty()) {
                Network network = new Network();
                network.setName(name);
                networkList.add(network);
                JOptionPane.showMessageDialog(null,"Network Added Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                return network;
            } else {
                for (Network n : getNetworkList()) {
                    if (n.getName().equalsIgnoreCase(name)) {
                        JOptionPane.showMessageDialog(null, "Network already exists", "Error", JOptionPane.ERROR_MESSAGE);
                        isNetworkPresent = true;
                        break;
                    } else {
                        isNetworkPresent = false;
                    }
                }
                if (isNetworkPresent == false) {
                    Network network = new Network();
                    network.setName(name);
                    networkList.add(network);
                    JOptionPane.showMessageDialog(null, "Network Added Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return network;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Network", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return null;

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        for (Network network : networkList) {
        }
        return true;
    }
}
