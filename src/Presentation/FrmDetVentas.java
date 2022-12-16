/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DSales;
import Logic.LSales;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author FeedzOne
 */
public class FrmDetVentas extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmDetVentas
     */
    public FrmDetVentas() {
        initComponents();
        showSearch();
    }
    
    public void showSearch(){
        DefaultTableModel myModel;
        LSales fn = new LSales();
        myModel = fn.showSales();
        tblSalesDetails.setModel(myModel);
    }
    
    public void searchSales(int id){
        DefaultTableModel myModel;
        LSales fn = new LSales();
        DSales dts = new DSales();
        dts.setId(id);
        myModel = fn.searchReceipts(dts);
        tblSalesDetails.setModel(myModel);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalesDetails = new javax.swing.JTable();
        SearchBTN = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        GenerateBTN1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(24, 24, 27));
        setClosable(true);
        setIconifiable(true);
        setTitle("SALES DETAILS");
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setBackground(new java.awt.Color(31, 31, 35));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sales List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(238, 238, 238))); // NOI18N

        tblSalesDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SUPPLIER", "LINE", "ENTRY DATE"
            }
        ));
        tblSalesDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSalesDetailsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblSalesDetails);

        SearchBTN.setText("Search");
        SearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTNActionPerformed(evt);
            }
        });

        GenerateBTN1.setBackground(new java.awt.Color(24, 24, 27));
        GenerateBTN1.setForeground(new java.awt.Color(238, 238, 238));
        GenerateBTN1.setText("Generate Report");
        GenerateBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBTN1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GenerateBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBTN)
                    .addComponent(GenerateBTN1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
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

    private void tblSalesDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalesDetailsMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            String idfact = tblSalesDetails.getValueAt(tblSalesDetails.getSelectedRow(), 0).toString();
            String supplier = tblSalesDetails.getValueAt(tblSalesDetails.getSelectedRow(), 1).toString();
            String line = tblSalesDetails.getValueAt(tblSalesDetails.getSelectedRow(), 2).toString();
            String regdate = tblSalesDetails.getValueAt(tblSalesDetails.getSelectedRow(), 3).toString();
            
            
            FrmDetalleVentas mi = new FrmDetalleVentas(new JFrame(), true);
            mi.setBill(idfact, supplier, line, regdate);
            mi.setLocationRelativeTo(null);
            mi.setVisible(true);
        }
    }//GEN-LAST:event_tblSalesDetailsMousePressed

    private void SearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTNActionPerformed
        // TODO add your handling code here:
        String dt = SearchField.getText();
        if(dt.equals("")){
            showSearch();
        }else{
            searchSales(Integer.parseInt(dt));
        }
    }//GEN-LAST:event_SearchBTNActionPerformed

    private void GenerateBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBTN1ActionPerformed
        // TODO add your handling code here:
        JFileChooser selection = new JFileChooser();
        int op = selection.showSaveDialog(null);
        if (op == JFileChooser.APPROVE_OPTION) {
            String route = selection.getSelectedFile().getAbsolutePath();
            String name = route + ".xlsx";
            String reportname = "Sales";
            XSSFWorkbook inventorybook = new XSSFWorkbook();
            XSSFSheet inventoryleaf = inventorybook.createSheet(reportname);

            String[] titles = new String[]{"ID", "SUPPLIER", "LINE", "ENTRY DATE"};

            Font titlesfont = inventorybook.createFont();
            titlesfont.setBold(true);

            XSSFRow title = inventoryleaf.createRow(0);
            for (int i = 0; i < titles.length; i++) {
                XSSFCell cell = title.createCell(i);
                cell.setCellValue(titles[i]);
            }
            int inventoryRow = 1;
            for (int i = 0; i < tblSalesDetails.getRowCount(); i++) {
                XSSFRow content = inventoryleaf.createRow(inventoryRow);
                inventoryRow++;
                for(int j = 0; j < tblSalesDetails.getColumnCount(); j++){
                    XSSFCell cell = content.createCell(j);
                    cell.setCellValue(tblSalesDetails.getValueAt(i, j).toString());
                }
            }
            inventoryleaf.autoSizeColumn(0);
            inventoryleaf.autoSizeColumn(1);
            inventoryleaf.autoSizeColumn(2);
            inventoryleaf.autoSizeColumn(3);

            try(OutputStream archivo = new FileOutputStream(name)){
                inventorybook.write(archivo);
                JOptionPane.showMessageDialog(rootPane, "Success", "Info", JOptionPane.INFORMATION_MESSAGE);
            }catch(IOException ex){
                JOptionPane.showMessageDialog(rootPane, "Uh oh, something went wrong", "Info", JOptionPane.INFORMATION_MESSAGE);
                ex.getStackTrace();
            }
        }
    }//GEN-LAST:event_GenerateBTN1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerateBTN1;
    private javax.swing.JButton SearchBTN;
    private javax.swing.JTextField SearchField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSalesDetails;
    // End of variables declaration//GEN-END:variables
}
