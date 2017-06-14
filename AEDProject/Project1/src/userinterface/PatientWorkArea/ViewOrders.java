/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.PatientOrganization;
import Business.Patient.MasterOrderCatalog;
import Business.Patient.Order;
import Business.Patient.OrderItem;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CUTIE
 */
public class ViewOrders extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PatientOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Patient patient;
    private EcoSystem business;
    private MasterOrderCatalog masterOrderCatalog;

    /**
     * Creates new form ViewOrders
     */
    public ViewOrders(JPanel userProcessContainer, UserAccount account, PatientOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        this.masterOrderCatalog = organization.getMasterOrderCatalog();
        populateOrders();
    }

    private void populateOrders() {
        DefaultTableModel dtm = (DefaultTableModel) ordersJTable.getModel();
        dtm.setRowCount(0);

        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        SimpleDateFormat ft1 = new SimpleDateFormat("MM/dd/yyyy");
        for (Order o : masterOrderCatalog.getOrderCatalog()) {
            if (o.getPatient() == userAccount.getPatient()) {
                Object row[] = new Object[4];
                row[0] = o;
                row[1] = ft.format(o.getOrderDate());
                row[2] = o.getOrderTotal();
                if (o.getEstimatedDelivery() != null) {
                    row[3] = ft1.format(o.getEstimatedDelivery());
                } else {
                    row[3] = "";
                }
                dtm.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        ordersJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderDetailsJTable = new javax.swing.JTable();
        btnBACK = new javax.swing.JButton();
        btnViewOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        ordersJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order", "Date", "Total", "Estimated Delivery Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ordersJTable);
        if (ordersJTable.getColumnModel().getColumnCount() > 0) {
            ordersJTable.getColumnModel().getColumn(0).setResizable(false);
            ordersJTable.getColumnModel().getColumn(1).setResizable(false);
            ordersJTable.getColumnModel().getColumn(2).setResizable(false);
            ordersJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        orderDetailsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", " Price", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderDetailsJTable);

        btnBACK.setBackground(new java.awt.Color(102, 102, 255));
        btnBACK.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBACK.setForeground(new java.awt.Color(255, 255, 255));
        btnBACK.setText("<< Back");
        btnBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBACKActionPerformed(evt);
            }
        });

        btnViewOrder.setBackground(new java.awt.Color(102, 102, 255));
        btnViewOrder.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnViewOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnViewOrder.setText("View Order Detail");
        btnViewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("VIEW ORDERS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(btnBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnViewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnViewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBACKActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBACKActionPerformed

    private void btnViewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderActionPerformed
        int selectedRowCount = ordersJTable.getSelectedRowCount();
        if (selectedRowCount <= 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        int selectedRow = ordersJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an item from cart", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Order o = (Order) ordersJTable.getValueAt(selectedRow, 0);

        DefaultTableModel dtm = (DefaultTableModel) orderDetailsJTable.getModel();
        dtm.setRowCount(0);
        for (OrderItem oi : o.getOrderItemList()) {
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getPrice() * oi.getQuantity();

            dtm.addRow(row);
        }
    }//GEN-LAST:event_btnViewOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBACK;
    private javax.swing.JButton btnViewOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderDetailsJTable;
    private javax.swing.JTable ordersJTable;
    // End of variables declaration//GEN-END:variables
}
