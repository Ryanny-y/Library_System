package overview;

import config.ConnDB;
import java.awt.Color;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Dashboard_Overview extends javax.swing.JPanel {

    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    
    public Dashboard_Overview() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        initCard();
        
        addRow();
    }
    
    private void initCard() {
        String query = "SELECT (SELECT COUNT(*) FROM users), " + 
               "(SELECT COUNT(*) FROM books), " + 
               "(SELECT COUNT(*) FROM borrowed_books)";
        int totalUsers = 0;
        int totalBooks = 0;
        int totalBorrowedBooks = 0;
        
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                totalUsers = rs.getInt(1);           
                totalBooks = rs.getInt(2);          
                totalBorrowedBooks = rs.getInt(3);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        card1.setData(String.valueOf(totalUsers) , "UserBig", "Total Users");
        card2.setData(String.valueOf(totalBooks), "UserBig", "Total Books");
        card3.setData(String.valueOf(totalBorrowedBooks), "UserBig", "Borrowed Books");
        card4.setData("123", "UserBig", "Overdue Books");
    }
    
    private void addRow() {
        if (c == null) {
            System.err.println("Database connection is NULL!");
            return;
        }
        String query = "SELECT * FROM users";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String student_id = rs.getString("student_id");
                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                String email = rs.getString("email");
                LocalDateTime joined_at = rs.getObject("joined_at", LocalDateTime.class);
                table.addRow(new Object[]{student_id, fullName, email, joined_at});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        card1 = new swing.Stats_Card();
        card2 = new swing.Stats_Card();
        card3 = new swing.Stats_Card();
        card4 = new swing.Stats_Card();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.table.Table();

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jLayeredPane1.add(card1);
        jLayeredPane1.add(card2);
        jLayeredPane1.add(card3);
        jLayeredPane1.add(card4);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 76, 140));
        jLabel1.setText("Members List");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number", "Name", "Email", "Created at"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Stats_Card card1;
    private swing.Stats_Card card2;
    private swing.Stats_Card card3;
    private swing.Stats_Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private swing.table.Table table;
    // End of variables declaration//GEN-END:variables
}
