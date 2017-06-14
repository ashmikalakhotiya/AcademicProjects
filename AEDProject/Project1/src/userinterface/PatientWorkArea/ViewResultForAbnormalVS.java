/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.Patient.VitalSignSensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue2.WorkRequest2;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author CUTIE
 */
public class ViewResultForAbnormalVS extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PatientOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Patient patient;
    private EcoSystem business;
    private VitalSignSensor vs;
    private WorkRequest2 req1;

    /**
     * Creates new form ViewResultForAbnormalVS
     */
    public ViewResultForAbnormalVS(JPanel userProcessContainer, UserAccount userAccount, PatientOrganization organization, Enterprise enterprise, EcoSystem business, VitalSignSensor vs, WorkRequest2 req1) {

        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
        this.vs = vs;
        this.req1 = req1;
        showVSDetails();
    }

    public void showVSDetails() {

        Patient pat = userAccount.getPatient();
        int patientAge = pat.getAge();
        int randomRR = vs.getRespiratoryRate();
        int randomHR = vs.getHeartRate();
        int randomBP = vs.getBloodPressure();

        if (patientAge >= 1 && patientAge <= 3) {
            textRR.setText(String.valueOf(randomRR));
            textBP.setText(String.valueOf(randomBP));
            textHR.setText(String.valueOf(randomHR));

            if (randomRR < 20 || randomRR > 30) {
                lblRR.setText("Abnormal");
            } else {
                lblRR.setText("Normal");
            }

            if (randomHR < 80 || randomHR > 130) {
                lblHR.setText("Abnormal");
            } else {
                lblHR.setText("Normal");
            }

            if (randomBP < 80 || randomBP > 110) {
                lblBP.setText("Abnormal");
            } else {
                lblBP.setText("Normal");
            }
        } else if (patientAge >= 4 && patientAge <= 5) {
            textRR.setText(String.valueOf(randomRR));
            textBP.setText(String.valueOf(randomBP));
            textHR.setText(String.valueOf(randomHR));

            if (randomRR < 20 || randomRR > 30) {
                lblRR.setText("Abnormal");
            } else {
                lblRR.setText("Normal");
            }

            if (randomHR < 80 || randomHR > 120) {
                lblHR.setText("Abnormal");
            } else {
                lblHR.setText("Normal");
            }

            if (randomBP < 80 || randomBP > 110) {
                lblBP.setText("Abnormal");
            } else {
                lblBP.setText("Normal");
            }

        } else if (patientAge >= 6 && patientAge <= 12) {
            textRR.setText(String.valueOf(randomRR));
            textBP.setText(String.valueOf(randomBP));
            textHR.setText(String.valueOf(randomHR));

            if (randomRR < 20 || randomRR > 30) {
                lblRR.setText("Abnormal");
            } else {
                lblRR.setText("Normal");
            }

            if (randomHR < 70 || randomHR > 110) {
                lblHR.setText("Abnormal");
            } else {
                lblHR.setText("Normal");
            }

            if (randomBP < 110 || randomBP > 120) {
                lblBP.setText("Abnormal");
            } else {
                lblBP.setText("Normal");
            }

        } else {
            textRR.setText(String.valueOf(randomRR));
            textBP.setText(String.valueOf(randomBP));
            textHR.setText(String.valueOf(randomHR));

            if (randomRR < 12 || randomRR > 20) {
                lblRR.setText("Abnormal");
            } else {
                lblRR.setText("Normal");
            }

            if (randomHR < 55 || randomHR > 105) {
                lblHR.setText("Abnormal");
            } else {
                lblHR.setText("Normal");
            }

            if (randomBP < 110 || randomBP > 120) {
                lblBP.setText("Abnormal");
            } else {
                lblBP.setText("Normal");
            }

        }
        textTimeStamp.setText(String.valueOf(vs.getTimestamp()));
        textWeight.setText(String.valueOf(pat.getWeight()));

        textResult.setText(req1.getMessage());

        if (textResult.getText().isEmpty()) {
            lblResult.setText("RESULT AWAITED");
        } else {
            lblResult.setText("");
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

        textTimeStamp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblRR = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblHR = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblBP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textRR = new javax.swing.JTextField();
        textHR = new javax.swing.JTextField();
        textBP = new javax.swing.JTextField();
        textWeight = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textResult = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        textTimeStamp.setEditable(false);

        jLabel2.setText("Respiratory Rate");

        lblRR.setText("<RR>");

        jLabel3.setText("Heart Rate");

        lblHR.setText("<HR>");

        jLabel4.setText("Blood Pressure");

        lblBP.setText("<BP>");

        jLabel5.setText("Weight");

        textRR.setEditable(false);

        textHR.setEditable(false);

        textBP.setEditable(false);

        textWeight.setEditable(false);

        jLabel6.setText("TimeStamp");

        jLabel1.setText("Test Result");

        textResult.setEditable(false);

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("<<  Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblResult.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblResult.setText("<result>");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("VIEW LAB TEST RESULT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textBP, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(textHR, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(textRR, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(textTimeStamp)
                                            .addComponent(textResult))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRR)
                                            .addComponent(lblHR)
                                            .addComponent(lblBP)
                                            .addComponent(lblResult))))))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textRR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblRR))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblHR))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBP))
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textTimeStamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResult))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblBP;
    private javax.swing.JLabel lblHR;
    private javax.swing.JLabel lblRR;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTextField textBP;
    private javax.swing.JTextField textHR;
    private javax.swing.JTextField textRR;
    private javax.swing.JTextField textResult;
    private javax.swing.JTextField textTimeStamp;
    private javax.swing.JTextField textWeight;
    // End of variables declaration//GEN-END:variables
}
