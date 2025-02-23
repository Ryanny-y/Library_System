package overview;

import config.ConnDB;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import swing.table.TableHeader;

public class User_Overview extends javax.swing.JPanel {
    
    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    
    public User_Overview() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        addUsers();
    }
    
    private void addUsers() {
        if (c == null) {
           System.err.println("Database connection is NULL!");
           return;
        }
         
        String query = "SELECT * FROM users WHERE role = ? ORDER BY last_name";
        
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, "USER");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                String student_no = rs.getString("student_id");
                String last_name =  rs.getString("last_name").substring(0, 1).toUpperCase() + rs.getString("last_name").substring(1);
                String first_name =  rs.getString("first_name").substring(0, 1).toUpperCase() + rs.getString("first_name").substring(1);
                String fullName = last_name + ' ' + first_name;
                String email = rs.getString("email");
                String password = rs.getString("password");
                Double penalty = rs.getDouble("penalty");
                LocalDateTime joined_at = rs.getObject("joined_at", LocalDateTime.class);
                table.addRow(new Object[]{student_no, fullName, email, password, penalty, joined_at});
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.table.UserListTable();

        setBackground(new java.awt.Color(255, 204, 204));
        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 76, 140));
        jLabel1.setText("Users List");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student No#", "Full Name", "Email", "Password", "Penalty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 443, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.table.UserListTable table;
    // End of variables declaration//GEN-END:variables
}
