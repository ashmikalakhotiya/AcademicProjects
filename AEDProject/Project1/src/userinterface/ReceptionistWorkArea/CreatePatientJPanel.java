/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReceptionistWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Utils.MyStringVerifier;
import Business.UserAccount.UserAccount;
import Business.Utils.AddressVerifier;
import Business.Utils.MyAgeVerifier;
import Business.Utils.MyDoubleVerifier;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CUTIE
 */
public class CreatePatientJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount ua;
    private Organization o;
    private Enterprise e;
    private PatientOrganization patientOrg;

    /**
     * Creates new form CreatePatientJPanel
     */
    public CreatePatientJPanel(JPanel userProcessContainer, UserAccount ua, Organization o, Enterprise e) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ua = ua;
        this.o = o;
        this.e = e;
        populateDoctorList();
        populateBloodGroup();
        addVerifiers();
    }

    private void addVerifiers() {
        InputVerifier stringVerifier = new MyStringVerifier();
        InputVerifier doubleVerifier = new MyDoubleVerifier();
        InputVerifier ageVerifier = new MyAgeVerifier();
        InputVerifier addVerifier = new AddressVerifier();

        textaddress.setInputVerifier(addVerifier);
        textpname.setInputVerifier(stringVerifier);
        textage.setInputVerifier(ageVerifier);
        textWeight.setInputVerifier(doubleVerifier);

    }

    private void populateBloodGroup() {
        comboBlood.removeAllItems();
        comboBlood.addItem("O+");
        comboBlood.addItem("O-");
        comboBlood.addItem("A+");
        comboBlood.addItem("A-");
        comboBlood.addItem("B+");
        comboBlood.addItem("B-");
        comboBlood.addItem("AB+");
        comboBlood.addItem("AB-");
    }

    private void populateDoctorList() {
        comboDoctor.removeAllItems();
        for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
            if (org.getName().equals("Doctor Organization")) {
                for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                    comboDoctor.addItem(ua);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textpname = new javax.swing.JTextField();
        textage = new javax.swing.JTextField();
        textaddress = new javax.swing.JTextField();
        comboDoctor = new javax.swing.JComboBox();
        btnPatient = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textWeight = new javax.swing.JTextField();
        comboBlood = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Create Patient");

        jLabel2.setText("Patient Name");

        jLabel3.setText("Age");

        jLabel4.setText("Address");

        jLabel5.setText("Blood Group");

        jLabel6.setText("Assigned Doctor");

        comboDoctor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDoctorActionPerformed(evt);
            }
        });

        btnPatient.setBackground(new java.awt.Color(102, 102, 255));
        btnPatient.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPatient.setForeground(new java.awt.Color(255, 255, 255));
        btnPatient.setText("Add Patient");
        btnPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("<< Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Weight");

        comboBlood.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textage, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textpname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBlood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientActionPerformed

        for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
            if (org.getName().equals("Patient Organization")) {
                patientOrg = (PatientOrganization) org;
                break;
            }
        }
        if (patientOrg != null) {
            if (comboDoctor.getSelectedItem() != null) {
                if (checkBlankInput()) {
                    String patientName = textpname.getText();
                    int age = ((Integer.parseInt(textage.getText())));
                    String address = textaddress.getText();
                    Double weight = Double.parseDouble(textWeight.getText());
                    String bloodGroup = (String) (comboBlood.getSelectedItem());

                    UserAccount assignedDoc = (UserAccount) comboDoctor.getSelectedItem();
                    if (weight > (double) 3 && weight <= (double) 300) {

                        patientOrg.getPatientDirectory().createPatient(patientName, age, weight, bloodGroup, address, assignedDoc);
                        JOptionPane.showMessageDialog(null, "Patient added Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Weight should be between 3 - 300  ", "ERROR", JOptionPane.ERROR_MESSAGE);

                        textWeight.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter all fields ", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Doctors not present  ", "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Patient Organization not created. ", "INFO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPatientActionPerformed
    private void clearFields() {
        textpname.setText("");
        textage.setText("");
        textaddress.setText("");
        textWeight.setText("");
    }

    private Boolean checkBlankInput() {
        if (textpname.getText().length() == 0
                || textWeight.getText().length() == 0
                || textage.getText().length() == 0
                || textaddress.getText().length() == 0) {
            return false;
        } else {
            return true;
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManagePatient mpjp1 = (ManagePatient) component;
        mpjp1.populatePatientTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPatient;
    private javax.swing.JComboBox comboBlood;
    private javax.swing.JComboBox comboDoctor;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField textWeight;
    private javax.swing.JTextField textaddress;
    private javax.swing.JTextField textage;
    private javax.swing.JTextField textpname;
    // End of variables declaration//GEN-END:variables
}
