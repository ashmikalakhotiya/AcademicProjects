/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue2;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue2 {
    
    private ArrayList<WorkRequest2> workRequestList;

    public WorkQueue2() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest2> getWorkRequestList() {
        return workRequestList;
    }
}