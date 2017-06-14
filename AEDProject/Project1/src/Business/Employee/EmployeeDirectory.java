/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CUTIE
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(String name) {
        boolean isEmployeeNamePresent = true;
        if (employeeList.isEmpty()) {
            Employee employee = new Employee();

            employee.setName(name);

            employeeList.add(employee);
            return employee;
        } else {
            for (Employee e : getEmployeeList()) {
                if (e.getName().equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(null, "Employee already exists", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                    isEmployeeNamePresent = true;
                    break;
                } else {
                    isEmployeeNamePresent = false;
                }
            }
            if (isEmployeeNamePresent == false) {
                Employee employee = new Employee();
                employee.setName(name);
                employeeList.add(employee);
                return employee;

            }
        }

        return null;
    }

}
