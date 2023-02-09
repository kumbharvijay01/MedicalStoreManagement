/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master;



import DB.Dbconn;
import java.sql.*;
import master.*;
import medicalstoremanagement.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author user
 */
public class CategoryMaster extends javax.swing.JInternalFrame {

    /**
     * Creates new form attendance
     */
     DefaultTableModel modelItem;
    String categoryid,categoryname,categorydesc,status;
    String error="";
    int valid=0;
    JFrame frame = new JFrame();
    Dbconn conn;
    Connection con;
    int selectedRow;
    ResultSet rs_Category;
    String a;
    public CategoryMaster(JFrame parent, boolean modal) {
        initComponents();
        modelItem=(DefaultTableModel)jcategorytable.getModel();
        refreshTable();
        jLabel5.setVisible(false);
    }

    
      public void refreshTable()
    {
        conn=new Dbconn();
       modelItem.setRowCount(0);
        try
        {
            rs_Category=conn.execute_query("select * from category_master where status=?", new String[]{"ACTIVE"});
            
            while (rs_Category.next()) 
            {
                categoryid=rs_Category.getString("Category_id");
                categoryname=rs_Category.getString("Category_name");
                categorydesc=rs_Category.getString("Category_Description");
                
                modelItem.addRow(new String[]{categoryid,categoryname,categorydesc});
            }
           }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void refreshForm(Object cellvalue)
            
    {
        Dbconn conn=new Dbconn();
        con=conn.getConnection();
        ResultSet rs;
        try
        {
            Statement st=con.createStatement();
            rs=st.executeQuery("select * from category_master where Category_id="+cellvalue);
            while(rs.next())
            {
               
                jLabel5.setText(rs.getString("Category_id"));
//                jcategoryid.setText(rs.getString("Category_id"));
                jcategoryname.setText(rs.getString("Category_name"));
                jcategorydesc.setText(rs.getString("Category_Description"));

             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    
     public void clear()
    {
//        jcategoryid.setText("");
        jcategoryname.setText("");
        jcategorydesc.setText("");
    
    }
     
     
       public void validate()
    {
        error="";
        valid=0;
//        if(jcategoryid.getText().equals(""))
//        {
//            error+="\n"+"Please Enter the Category Id";
//            valid=1;
//        }   
        if(jcategoryname.getText().equals(""))
        {
            error+="\n"+"Please Enter the Category Name";
            valid=1;
        }
        if(jcategorydesc.getText().equals(""))
        {
            error+="\n"+"Please Enter the Category Description";
            valid=1;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcategoryname = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jcategorydesc = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jcategorytable = new javax.swing.JTable();

        setClosable(true);
        setTitle("Purchase Order");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Category Master");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Desctiption");

        jcategoryname.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jcategorydesc.setColumns(20);
        jcategorydesc.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jcategorydesc.setRows(5);
        jScrollPane3.setViewportView(jcategorydesc);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jcategoryname, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcategoryname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home icon.png"))); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addGap(61, 61, 61)
                .addComponent(jButton3)
                .addGap(49, 49, 49)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jcategorytable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jcategorytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Category Name", "Category Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jcategorytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcategorytableMouseClicked(evt);
            }
        });
        jcategorytable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcategorytableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcategorytableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jcategorytable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validate();
        conn=new Dbconn();
        if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, error, "Error!!", JOptionPane.ERROR_MESSAGE);

        }
        else
        {
            int k=conn.insert_data("insert into category_master (Category_name,Category_Description,status)values(?,?,?)", new String[]{jcategoryname.getText(),jcategorydesc.getText(),"ACTIVE"});
            
            if(k>0)
            {
            
            JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully!", "Data Inserted Sucessfully.!!", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
                clear();
            }   
            else
            {
            JOptionPane.showMessageDialog(rootPane, "Data Not Saved !!", "Error!!", JOptionPane.ERROR_MESSAGE);
      
            }
            
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        clear();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jcategorytableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcategorytableKeyPressed
 JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==evt.VK_UP)||(evt.getKeyCode()==evt.VK_DOWN))
        {
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }
        

    }//GEN-LAST:event_jcategorytableKeyPressed

    private void jcategorytableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcategorytableKeyReleased
        // TODO add your handling code here:
        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==evt.VK_UP)||(evt.getKeyCode()==evt.VK_DOWN))
        {
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }
    }//GEN-LAST:event_jcategorytableKeyReleased

    private void jcategorytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcategorytableMouseClicked
if(evt.getClickCount()==1)
{
    JTable target = (JTable)evt.getSource();  
       
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
      
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jcategorytableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        validate();
        if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
 
             int a=JOptionPane.showConfirmDialog(rootPane, "Do Your Want to Delete This Category !", "Confirm", JOptionPane.YES_NO_OPTION);
             if(a==0)
             {
             try
        {
                conn=new Dbconn();
             int i = conn.update_data("update category_master SET Status =? where Category_id=?" , new String[]{"DEACTIVE",jLabel5.getText()});
             if(i>0)
             {
                JOptionPane.showMessageDialog(rootPane, "Category Deleted Sucessfully", "Error! ", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
                clear();
             }
             else
             {
                  JOptionPane.showMessageDialog(rootPane, "Problem In Delete!!", "Error! ", JOptionPane.ERROR_MESSAGE);

             }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, "Contact To Service Provider", "Error! ", JOptionPane.ERROR_MESSAGE);
        }
             }
        }
        
       
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jcategorydesc;
    private javax.swing.JTextField jcategoryname;
    private javax.swing.JTable jcategorytable;
    // End of variables declaration//GEN-END:variables
}
