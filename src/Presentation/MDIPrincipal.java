package Presentation;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author FeedzOne
 */
public class MDIPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MDIPrincipal
     */
    public MDIPrincipal() {
        initComponents();

        //REVISAR INVENTARIO
        ImageIcon ImgInventory = new ImageIcon(getClass().getResource("/Images/INVENTORY.png"));
        Icon InvIcon = new ImageIcon(ImgInventory.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        CheckInventoryButton.setIcon(InvIcon);

        //REGISTER A SALE
        ImageIcon ImgUpdate = new ImageIcon(getClass().getResource("/Images/NOTE.png"));
        Icon UpdateIcon = new ImageIcon(ImgUpdate.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        UpdateButton.setIcon(UpdateIcon);

        //RECEIPTS BUTTON
        ImageIcon ImgReceipts = new ImageIcon(getClass().getResource("/Images/RECEIPT.png"));
        Icon ReceiptIcon = new ImageIcon(ImgReceipts.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ReceiptsButton.setIcon(ReceiptIcon);

        //OPTIONS
        ImageIcon ImgOptions = new ImageIcon(getClass().getResource("/Images/SETTINGS.png"));
        Icon OptionsIcon = new ImageIcon(ImgOptions.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ToolsMenu.setIcon(OptionsIcon);

        //USER MENU
        ImageIcon ToolUser = new ImageIcon(getClass().getResource("/Images/USER.png"));
        Icon UserIcon = new ImageIcon(ToolUser.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        UserMenu.setIcon(UserIcon);

        //INFO MENU
        ImageIcon ToolInfo = new ImageIcon(getClass().getResource("/Images/INFO.png"));
        Icon InfoIcon = new ImageIcon(ToolInfo.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        InfoMenu.setIcon(InfoIcon);
        InfoMenu.setEnabled(false);
        InfoMenu.setVisible(false);

        //SECTOR MENU
        ImageIcon SectorInfo = new ImageIcon(getClass().getResource("/Images/SECTOR.png"));
        Icon SectorIcon = new ImageIcon(SectorInfo.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        SectorMenu.setIcon(SectorIcon);

        //SUPPLIER MENU
        ImageIcon SupplierInfo = new ImageIcon(getClass().getResource("/Images/SUPPLIER.png"));
        Icon SupplierIcon = new ImageIcon(SupplierInfo.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        SuppliersMenu.setIcon(SupplierIcon);

        //Inquiries
        ImageIcon INMenu = new ImageIcon(getClass().getResource("/Images/SEARCH.png"));
        Icon INIcon = new ImageIcon(INMenu.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        InquiriesMenu.setIcon(INIcon);

        //REPORTS MENU
        ImageIcon ReportsInfo = new ImageIcon(getClass().getResource("/Images/REPORTS.png"));
        Icon ReportsIcon = new ImageIcon(ReportsInfo.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ReportsMenu.setIcon(ReportsIcon);
        ReportsMenu.setEnabled(false);
        ReportsMenu.setVisible(false);

        //BILLS DETAILS MENU
        ImageIcon BillsDetailsInfo = new ImageIcon(getClass().getResource("/Images/BILLSDETAILS.png"));
        Icon BillsDetailsIcon = new ImageIcon(BillsDetailsInfo.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        BillsDetailsMenu.setIcon(BillsDetailsIcon);

        //RECEIPT DETAILS MENU
        ImageIcon ReceiptDetailsInfo = new ImageIcon(getClass().getResource("/Images/RECEIPTDETAILS.png"));
        Icon ReceiptDetailsIcon = new ImageIcon(ReceiptDetailsInfo.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ReceiptsMenu.setIcon(ReceiptDetailsIcon);

        timer.start();
    }

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Calendar cal = new GregorianCalendar();
            int hh, mm, ss, day, month, year;
            hh = cal.get(Calendar.HOUR);
            ss = cal.get(Calendar.SECOND);
            mm = cal.get(Calendar.MINUTE);

            day = cal.get(Calendar.DAY_OF_MONTH);
            month = cal.get(Calendar.MONTH);
            year = cal.get(Calendar.YEAR);

            TimeLabel.setText(hh + ":" + mm + ":" + ss);
            DateLabel.setText(day + "/" + month + "/" + year);

        }
    });

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UpdateButton = new javax.swing.JButton();
        CheckInventoryButton = new javax.swing.JButton();
        LBUsuario = new javax.swing.JLabel();
        LBHora = new javax.swing.JLabel();
        LBFecha = new javax.swing.JLabel();
        UserField = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        ReceiptsButton = new javax.swing.JButton();
        LBUsuario1 = new javax.swing.JLabel();
        ProfileField = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        InquiriesMenu = new javax.swing.JMenu();
        ReportsMenu = new javax.swing.JMenuItem();
        BillsDetailsMenu = new javax.swing.JMenuItem();
        ReceiptsMenu = new javax.swing.JMenuItem();
        ToolsMenu = new javax.swing.JMenu();
        UserMenu = new javax.swing.JMenuItem();
        InfoMenu = new javax.swing.JMenuItem();
        SectorMenu = new javax.swing.JMenuItem();
        SuppliersMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asociados del Desierto Intentory System");
        setBackground(new java.awt.Color(24, 24, 27));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(31, 31, 35));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(238, 238, 238))); // NOI18N

        UpdateButton.setBackground(new java.awt.Color(24, 24, 27));
        UpdateButton.setForeground(new java.awt.Color(238, 238, 238));
        UpdateButton.setText("Ingresar Factura");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        CheckInventoryButton.setBackground(new java.awt.Color(24, 24, 27));
        CheckInventoryButton.setForeground(new java.awt.Color(238, 238, 238));
        CheckInventoryButton.setText("Revisar Inventario");
        CheckInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInventoryButtonActionPerformed(evt);
            }
        });

        LBUsuario.setForeground(new java.awt.Color(238, 238, 238));
        LBUsuario.setText("Usuario:");

        LBHora.setForeground(new java.awt.Color(238, 238, 238));
        LBHora.setText("Hora:");

        LBFecha.setForeground(new java.awt.Color(238, 238, 238));
        LBFecha.setText("Fecha:");

        UserField.setForeground(new java.awt.Color(238, 238, 238));
        UserField.setText("----------");

        TimeLabel.setForeground(new java.awt.Color(238, 238, 238));
        TimeLabel.setText("jLabel4");

        DateLabel.setForeground(new java.awt.Color(238, 238, 238));
        DateLabel.setText("jLabel5");

        ReceiptsButton.setBackground(new java.awt.Color(24, 24, 27));
        ReceiptsButton.setForeground(new java.awt.Color(238, 238, 238));
        ReceiptsButton.setText("Registrar Venta");
        ReceiptsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptsButtonActionPerformed(evt);
            }
        });

        LBUsuario1.setForeground(new java.awt.Color(238, 238, 238));
        LBUsuario1.setText("Profile:");

        ProfileField.setForeground(new java.awt.Color(238, 238, 238));
        ProfileField.setText("----------");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBUsuario)
                            .addComponent(LBHora)
                            .addComponent(LBFecha)
                            .addComponent(LBUsuario1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProfileField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UserField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CheckInventoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(ReceiptsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReceiptsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CheckInventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBUsuario1)
                    .addComponent(ProfileField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBUsuario)
                    .addComponent(UserField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBHora)
                    .addComponent(TimeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBFecha)
                    .addComponent(DateLabel))
                .addGap(26, 26, 26))
        );

        Desktop.setBackground(new java.awt.Color(31, 31, 35));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuBar1.setForeground(new java.awt.Color(24, 24, 27));

        InquiriesMenu.setText("Inquiries");

        ReportsMenu.setText("Reports");
        ReportsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsMenuActionPerformed(evt);
            }
        });
        InquiriesMenu.add(ReportsMenu);

        BillsDetailsMenu.setText("Bills Details");
        BillsDetailsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillsDetailsMenuActionPerformed(evt);
            }
        });
        InquiriesMenu.add(BillsDetailsMenu);

        ReceiptsMenu.setText("Receipt Details");
        ReceiptsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptsMenuActionPerformed(evt);
            }
        });
        InquiriesMenu.add(ReceiptsMenu);

        jMenuBar1.add(InquiriesMenu);

        ToolsMenu.setForeground(new java.awt.Color(24, 24, 27));
        ToolsMenu.setText("Tools");

        UserMenu.setText("Users");
        UserMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(UserMenu);

        InfoMenu.setText("Info");
        InfoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(InfoMenu);

        SectorMenu.setText("Sectors");
        SectorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SectorMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(SectorMenu);

        SuppliersMenu.setText("Suppliers");
        SuppliersMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(SuppliersMenu);

        jMenuBar1.add(ToolsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Desktop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Desktop)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserMenuActionPerformed
        // TODO add your handling code here:
        FrmUsuarios myUsers = new FrmUsuarios();
        Desktop.add(myUsers);
        myUsers.show();
    }//GEN-LAST:event_UserMenuActionPerformed

    private void SectorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SectorMenuActionPerformed
        // TODO add your handling code here:
        FrmLineas myLines = new FrmLineas();
        Desktop.add(myLines);
        myLines.show();

    }//GEN-LAST:event_SectorMenuActionPerformed

    private void SuppliersMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersMenuActionPerformed
        // TODO add your handling code here:
        FrmProveedores mySuppliers = new FrmProveedores();
        Desktop.add(mySuppliers);
        mySuppliers.show();
    }//GEN-LAST:event_SuppliersMenuActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        FrmVentas mySales = new FrmVentas();
        Desktop.add(mySales);
        mySales.show();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void InfoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoMenuActionPerformed
        // TODO add your handling code here:
        /*FrmVentas mySales = new FrmVentas();
        Desktop.add(mySales);
        mySales.show();*/
    }//GEN-LAST:event_InfoMenuActionPerformed

    private void BillsDetailsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillsDetailsMenuActionPerformed
        // TODO add your handling code here:
        FrmDetVentas mySales = new FrmDetVentas();
        Desktop.add(mySales);
        mySales.show();
    }//GEN-LAST:event_BillsDetailsMenuActionPerformed

    private void CheckInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInventoryButtonActionPerformed
        // TODO add your handling code here:
        FrmInventario myInventory = new FrmInventario();
        Desktop.add(myInventory);
        myInventory.show();
    }//GEN-LAST:event_CheckInventoryButtonActionPerformed

    private void ReceiptsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptsButtonActionPerformed
        // TODO add your handling code here:
        FrmRecibos myReceipts = new FrmRecibos();
        Desktop.add(myReceipts);
        myReceipts.setUser(UserField.getText());
        myReceipts.show();
    }//GEN-LAST:event_ReceiptsButtonActionPerformed

    private void ReceiptsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptsMenuActionPerformed
        // TODO add your handling code here:
        FrmDetRecibos myReceipts = new FrmDetRecibos();
        Desktop.add(myReceipts);
        myReceipts.show();
    }//GEN-LAST:event_ReceiptsMenuActionPerformed

    private void ReportsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReportsMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIPrincipal().setVisible(true);
            }
        });
    }

    void setData(String user, String profile) {

        UserField.setText(user);
        if (profile.equals("Employee")) {
            UserMenu.setVisible(false);
            UserMenu.setEnabled(false);
        } else {
            UserMenu.setVisible(true);
            UserMenu.setEnabled(true);
        }
        ProfileField.setText(profile);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BillsDetailsMenu;
    private javax.swing.JButton CheckInventoryButton;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem InfoMenu;
    private javax.swing.JMenu InquiriesMenu;
    private javax.swing.JLabel LBFecha;
    private javax.swing.JLabel LBHora;
    private javax.swing.JLabel LBUsuario;
    private javax.swing.JLabel LBUsuario1;
    private javax.swing.JLabel ProfileField;
    private javax.swing.JButton ReceiptsButton;
    private javax.swing.JMenuItem ReceiptsMenu;
    private javax.swing.JMenuItem ReportsMenu;
    private javax.swing.JMenuItem SectorMenu;
    private javax.swing.JMenuItem SuppliersMenu;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JMenu ToolsMenu;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel UserField;
    private javax.swing.JMenuItem UserMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
