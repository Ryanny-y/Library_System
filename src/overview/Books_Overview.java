package overview;

import config.ConnDB;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import pages.Add_Book_Frame;
import pages.Admin.Admin_Books;
import swing.table.TableActionCellEditor;
import swing.table.TableActionCellRender;

public class Books_Overview extends javax.swing.JPanel {

    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    
    public Books_Overview() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        addRows();
        
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor());
    }
    
    
    private void addRows() {
        if (c == null) {
            System.err.println("Database connection is NULL!");
            return;
        }
        
        String query = "SELECT * FROM books AS b LEFT JOIN borrowed_books as bb ON b.book_id = bb.book_id";
         try {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String status = rs.getString("status");
                String borrowed_by = rs.getString("borrowed_by");
                String due_date = rs.getString("due_date");
                if(borrowed_by == null) {
                    borrowed_by = "";
                }
                if(due_date == null) {
                    due_date = "";
                }
                LocalDateTime added_at = rs.getObject("created_at", LocalDateTime.class);
                
                table.addRow(new Object[]{book_id, title, author, status, borrowed_by, due_date, added_at});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        add_book_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new swing.table.BookListTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 76, 140));
        jLabel1.setText("Book List");

        add_book_btn.setBackground(new java.awt.Color(27, 76, 140));
        add_book_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add_book_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_book_btn.setText("Add Book");
        add_book_btn.setBorder(null);
        add_book_btn.setBorderPainted(false);
        add_book_btn.setFocusPainted(false);
        add_book_btn.setFocusable(false);
        add_book_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_book_btnActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        table.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Author", "Status", "Borrower", "Due Date", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
                        .addComponent(add_book_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_book_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void add_book_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_book_btnActionPerformed
        System.out.println("Clicked");
        Admin_Books topFrame = (Admin_Books) javax.swing.SwingUtilities.getWindowAncestor(this);
        if(topFrame != null) {
            new Add_Book_Frame(topFrame);
        }
        
    }//GEN-LAST:event_add_book_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_book_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.PanelBorder panelBorder2;
    private swing.table.BookListTable table;
    // End of variables declaration//GEN-END:variables
}
