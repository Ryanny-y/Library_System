package components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.Book_Model;
import model.Current_User;
import model.User_Model;
import pages.User.Home;

public class UserFrameHeader extends javax.swing.JPanel implements ActionListener {

    Book_Model bookModel = new Book_Model();
    JFrame frame;
    
    String userName = "";
    
    public UserFrameHeader() {
        initComponents();
        setOpaque(false);
        User_Model user = Current_User.getCurrentUser();

        if (user != null && user.getFirst_name() != null && !user.getFirst_name().isEmpty()) {
            userName = user.getFirst_name().substring(0, 1).toUpperCase() + user.getFirst_name().substring(1);
        }
        
        lblName.setText(userName);
        search_btn.setBackground(new Color(0,0,0,0));
        search_btn.addActionListener(this);

    }
    
    public UserFrameHeader(JFrame frame) {
        this.frame = frame;
        initComponents();
        setOpaque(false);
        User_Model user = Current_User.getCurrentUser();

        if (user != null && user.getFirst_name() != null && !user.getFirst_name().isEmpty()) {
            userName = user.getFirst_name().substring(0, 1).toUpperCase() + user.getFirst_name().substring(1);
        }
        
        lblName.setText(userName);
        search_btn.setBackground(new Color(0,0,0,0));
        search_btn.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        search_btn = new javax.swing.JButton();
        search_field = new components.Search_Field();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 76, 140));
        jLabel1.setText("Welcome Back To IT242 Library, ");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(27, 76, 140));

        search_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        search_btn.setBorder(null);
        search_btn.setBorderPainted(false);
        search_btn.setContentAreaFilled(false);
        search_btn.setFocusPainted(false);
        search_btn.setFocusable(false);

        search_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        search_field.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        search_field.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblName)
                        .addGap(0, 179, Short.MAX_VALUE))
                    .addComponent(search_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_btn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(search_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search_btn) {
            bookModel.filterList(search_field.getText().trim()); // Trim spaces to avoid errors
            if (frame instanceof Home) {
                Home homeFrame = (Home) frame;
                homeFrame.updateBookList(); // Now it can access updateBookList()
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JButton search_btn;
    private components.Search_Field search_field;
    // End of variables declaration//GEN-END:variables
}
