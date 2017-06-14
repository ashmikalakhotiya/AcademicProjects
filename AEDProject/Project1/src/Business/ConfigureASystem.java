package Business;

import Business.DB4OUtil.DB4OUtil;
import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author CUTIE
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        Employee employee = system.getEmployeeDirectory().createEmployee("Ashmika");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin","617-697-5224",null, employee, new SystemAdminRole());
        ArrayList<String> UsernameList = DB4OUtil.retrieveUserNameList();
        UsernameList.add("sysadmin");
        DB4OUtil.storeUserNameList(UsernameList);
        return system;
    }
    
}
