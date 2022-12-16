/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DReceipts;
import Data.DReceiptsDetails;
import Data.DStorage;
import Logic.LReceipts;
import Logic.LReceiptsDetails;
import Logic.LStorage;
import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FeedzOne
 */
public class FrmRecibos extends javax.swing.JInternalFrame {

    DefaultTableModel myModel;

    /**
     * Creates new form FrmRecibos
     */
    public FrmRecibos() {
        initComponents();
        enablebtn(true);
        
        DpersonField.setEditable(false);
        DpersonField.setEnabled(false);

        TotalField.setEditable(false);

        myModel = (DefaultTableModel) tblReceipts.getModel();

        tblReceipts.getColumn("CODE").setWidth(15);
        tblReceipts.getColumn("CODE").setPreferredWidth(15);

        tblReceipts.getColumn("DESCRIPTION").setWidth(200);
        tblReceipts.getColumn("DESCRIPTION").setPreferredWidth(200);

        tblReceipts.getColumn("QUANTITY").setWidth(20);
        tblReceipts.getColumn("QUANTITY").setPreferredWidth(20);

        tblReceipts.getColumn("PRICE").setWidth(20);
        tblReceipts.getColumn("PRICE").setPreferredWidth(20);

        tblReceipts.getColumn("METRIC UNIT").setWidth(20);
        tblReceipts.getColumn("METRIC UNIT").setPreferredWidth(20);

        tblReceipts.getColumn("LINE").setWidth(20);
        tblReceipts.getColumn("LINE").setPreferredWidth(20);

        tblReceipts.getColumn("TOTAL").setWidth(20);
        tblReceipts.getColumn("TOTAL").setPreferredWidth(20);

        //NUEVO
        ImageIcon ImgNew = new ImageIcon(getClass().getResource("/Images/NEW.png"));
        Icon NewIcon = new ImageIcon(ImgNew.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        NewBTN.setIcon(NewIcon);

        //GUARDAR
        ImageIcon ImgSave = new ImageIcon(getClass().getResource("/Images/SAVE.png"));
        Icon SaveIcon = new ImageIcon(ImgSave.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        SaveBTN.setIcon(SaveIcon);

        //CANCELAR
        ImageIcon ImgCancel = new ImageIcon(getClass().getResource("/Images/CANCEL.png"));
        Icon CancelIcon = new ImageIcon(ImgCancel.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        CancelBTN.setIcon(CancelIcon);
    }

    public void cleanfield() {
        //LinesID = 0;
        DateField.setDate(null);
        TotalField.setText("");
        GetFIeld.setText("");
        SearchField.setText("");

        try {
            DefaultTableModel model = (DefaultTableModel) tblReceipts.getModel();
            int filas = tblReceipts.getRowCount();
            for (int i = 0; filas > i; i++) {
                model.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cleaning table...");
        }
    }

    public void enablebtn(boolean b) {
        SearchField.setEnabled(!b);
        DateField.setEnabled(!b);
        CancelBTN.setEnabled(!b);
        SaveBTN.setEnabled(!b);
        NewBTN.setEnabled(b);
        GetFIeld.setEnabled(!b);
    }

    public void addTotal() {
        DecimalFormat ft = new DecimalFormat("####.00");
        double totalp = 0, total = 0;
        for (int i = 0; i < tblReceipts.getRowCount(); i++) {
            totalp = Double.parseDouble(tblReceipts.getValueAt(i, 6).toString());
            total += totalp;
            TotalField.setText(ft.format(total));
        }
    }

    public void showProducts(String product) {
        //System.out.println("Dio Enter "+ product);
        LStorage fn = new LStorage();
        DStorage dts = new DStorage();
        DefaultTableModel tblData = (DefaultTableModel) tblReceipts.getModel();
        dts.setStorageID(product);
        String reg[] = fn.searchshowProductsRec(dts);
        if (reg[0] != null) {
            tblData.insertRow(0, reg);
            tblReceipts.setModel(tblData);
        } else {
            JOptionPane.showMessageDialog(rootPane, "The product does not exist in the inventory, please validate it");
        }
    }

    public boolean isintable(String text) {
        boolean res = false;
        DecimalFormat ft = new DecimalFormat("####.00");
        for (int i = 0; i < tblReceipts.getRowCount(); i++) {
            String code = tblReceipts.getValueAt(i, 0).toString();
            if (code.equals(text)) {
                int quantity = Integer.parseInt(tblReceipts.getValueAt(i, 2).toString());
                double unitprice = Double.parseDouble(tblReceipts.getValueAt(i, 3).toString());
                int totalqty = quantity + 1;
                tblReceipts.setValueAt(totalqty, i, 2);

                double totalpar = unitprice * totalqty;
                tblReceipts.setValueAt(ft.format(totalpar), i, 5);
                res = true;
            }
        }
        addTotal();
        return res;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NewBTN = new javax.swing.JButton();
        SaveBTN = new javax.swing.JButton();
        CancelBTN = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReceipts = new javax.swing.JTable();
        DateField = new com.toedter.calendar.JDateChooser();
        GetFIeld = new javax.swing.JTextField();
        TotalField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DpersonField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(24, 24, 27));
        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(31, 31, 35));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECEIPTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(238, 238, 238))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(238, 238, 238));
        jLabel1.setText("Date:");

        jLabel2.setForeground(new java.awt.Color(238, 238, 238));
        jLabel2.setText("Person Receiving:");

        NewBTN.setText("New");
        NewBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBTNActionPerformed(evt);
            }
        });

        SaveBTN.setText("Save");
        SaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBTNActionPerformed(evt);
            }
        });

        CancelBTN.setText("Cancel");
        CancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBTNActionPerformed(evt);
            }
        });

        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchFieldKeyPressed(evt);
            }
        });

        tblReceipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "DESCRIPTION", "QUANTITY", "PRICE", "METRIC UNIT", "LINE", "TOTAL", "LINEID"
            }
        ));
        tblReceipts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblReceiptsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblReceipts);
        if (tblReceipts.getColumnModel().getColumnCount() > 0) {
            tblReceipts.getColumnModel().getColumn(7).setMinWidth(0);
            tblReceipts.getColumnModel().getColumn(7).setPreferredWidth(0);
            tblReceipts.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jLabel3.setForeground(new java.awt.Color(238, 238, 238));
        jLabel3.setText("TOTAL:");

        DpersonField.setBackground(new java.awt.Color(80, 80, 80));
        DpersonField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(238, 238, 238));
        jLabel4.setText("USER:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateField, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(GetFIeld)))
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(NewBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(SaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(CancelBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(DpersonField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(GetFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DpersonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewBTN)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveBTN)
                            .addComponent(CancelBTN)
                            .addComponent(TotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBTNActionPerformed
        // TODO add your handling code here:
        enablebtn(false);
    }//GEN-LAST:event_NewBTNActionPerformed

    private void SaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBTNActionPerformed
        // TODO add your handling code here:
        String msgfinal = "";
        if (GetFIeld.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Person Receiving is required", "Validation", JOptionPane.WARNING_MESSAGE);
            GetFIeld.requestFocusInWindow();
            return;
        }

        if (DateField.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Date is required", "Validation", JOptionPane.WARNING_MESSAGE);
            DateField.requestFocusInWindow();
            return;
        }

        LReceipts fn = new LReceipts();
        DReceipts dts = new DReceipts();

        Calendar cal;
        cal = DateField.getCalendar();
        int aa, mm, dd;
        aa = cal.get(Calendar.YEAR) - 1900;
        mm = cal.get(Calendar.MONTH);
        dd = cal.get(Calendar.DAY_OF_MONTH);

        dts.setReceiptDate(new Date(aa, mm, dd));
        dts.setDeliveryPerson(DpersonField.getText());
        dts.setReceivingPerson(GetFIeld.getText());
        int idrec = fn.insertReceipt(dts);

        if (idrec > 0) {
            JOptionPane.showMessageDialog(rootPane, "Successfully Registered");
            int filas = tblReceipts.getRowCount();
            for (int i = 0; i < filas; i++) {

                String idprod = tblReceipts.getValueAt(i, 0).toString();
                int lineid = Integer.parseInt(tblReceipts.getValueAt(i, 7).toString());
                int qty = Integer.parseInt(tblReceipts.getValueAt(i, 2).toString());
                double total = Double.parseDouble(tblReceipts.getValueAt(i, 6).toString());
                LReceiptsDetails fundf = new LReceiptsDetails();
                DReceiptsDetails dtsf = new DReceiptsDetails();

                dtsf.setTotal(total);
                dtsf.setQuantity(qty);
                dtsf.setLinesID(lineid);
                dtsf.setProductID(idprod);
                dtsf.setReceiptID(idrec);

                String msg2 = fundf.RegisterDetailsReceipts(dtsf);
                if (msg2.equals("si")) {
                    LStorage funal = new LStorage();
                    DStorage dtsp = new DStorage();

                    dtsp.setStorageID(idprod);
                    dtsp.setStock(qty);

                    msgfinal = funal.decreaseStock(dtsp);
                }
            }
            JOptionPane.showMessageDialog(rootPane, msgfinal, "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Uh oh, an error has occurred", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        enablebtn(true);
        cleanfield();
    }//GEN-LAST:event_SaveBTNActionPerformed

    private void CancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBTNActionPerformed
        // TODO add your handling code here:
        enablebtn(true);
        cleanfield();
    }//GEN-LAST:event_CancelBTNActionPerformed

    private void SearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean b = isintable(SearchField.getText());
            if (b == false) {
                showProducts(SearchField.getText());
            }
            addTotal();
            SearchField.setText("");
        }
    }//GEN-LAST:event_SearchFieldKeyPressed

    private void tblReceiptsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblReceiptsKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        DecimalFormat ft = new DecimalFormat("####.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            for (int i = 0; i < tblReceipts.getRowCount(); i++) {
                int quantity = Integer.parseInt(tblReceipts.getValueAt(i, 2).toString());
                double unitprice = Double.parseDouble(tblReceipts.getValueAt(i, 3).toString());

                double totalpar = quantity * unitprice;
                tblReceipts.setValueAt(ft.format(totalpar), i, 6);
            }
            addTotal();
        }
    }//GEN-LAST:event_tblReceiptsKeyPressed

    public void setUser(String dperson) {
           DpersonField.setText(dperson);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBTN;
    private com.toedter.calendar.JDateChooser DateField;
    private javax.swing.JTextField DpersonField;
    private javax.swing.JTextField GetFIeld;
    private javax.swing.JButton NewBTN;
    private javax.swing.JButton SaveBTN;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField TotalField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReceipts;
    // End of variables declaration//GEN-END:variables

}
