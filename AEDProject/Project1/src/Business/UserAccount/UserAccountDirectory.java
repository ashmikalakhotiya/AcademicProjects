/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Network.Network;
import Business.Patient.Patient;
import Business.Role.Role;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CUTIE
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, String mobileNumber, Network net, Employee employee, Role role){
        
            Boolean isEmployeeUsernameExist = true;
            Boolean isUsernamePresent = true;
            
            
          
            if(userAccountList.isEmpty()){
            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(username);
            userAccount.setPassword(password);
            userAccount.setMobileNumber(mobileNumber);
            userAccount.setEmployee(employee);
            userAccount.setNetwork(net);
            userAccount.setRole(role);
            userAccountList.add(userAccount);
            return userAccount; 
            }else{
             
                  for(UserAccount ua : getUserAccountList()){
                        if(ua.getUsername().equalsIgnoreCase(username)){
                            JOptionPane.showMessageDialog(null,"User Name Exists","Error",JOptionPane.INFORMATION_MESSAGE);
                            isUsernamePresent = true;
                            break;
                        }else{
                            isUsernamePresent = false;
                        }
                  }
                    if(isUsernamePresent == false){
                         UserAccount userAccount = new UserAccount();
                        userAccount.setUsername(username);
                        userAccount.setPassword(password);
                         userAccount.setNetwork(net);
                        userAccount.setMobileNumber(mobileNumber);
                        userAccount.setEmployee(employee);
                        userAccount.setRole(role);
                        userAccountList.add(userAccount);
                        return userAccount;
                    } 
            }
        
       
           
       return null;
        
    }
    
     public UserAccount createPatientUserAccount(String username, String password,String mobileNumber, Network net ,Patient patient, Role role){
        
         Boolean isUsernamePresent = true;
            if(userAccountList.isEmpty()){
         
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setMobileNumber(mobileNumber);
        userAccount.setPatient(patient);
         userAccount.setNetwork(net);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
            else{
                  for(UserAccount ua : getUserAccountList()){
                        if(ua.getUsername().equalsIgnoreCase(username)){
                            JOptionPane.showMessageDialog(null,"User Name Exists","Error",JOptionPane.INFORMATION_MESSAGE);
                            isUsernamePresent = true;
                            break;
                        }else{
                            isUsernamePresent = false;
                        }
                  }
                    if(isUsernamePresent == false){
                        UserAccount userAccount = new UserAccount();
                        userAccount.setUsername(username);
                        userAccount.setPassword(password);
                         userAccount.setNetwork(net);
                        userAccount.setMobileNumber(mobileNumber);
                        userAccount.setPatient(patient);
                        userAccount.setRole(role);
                        userAccountList.add(userAccount); 
                        return userAccount;
                    }
            }
            return null;
     }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
