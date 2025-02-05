package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import model.Nav_Model;

public class NavItem extends javax.swing.JPanel {

    private boolean selected;
    private Nav_Model data;
    public NavItem(Nav_Model data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        
        if(data.getType() == Nav_Model.MenuType.MENU) {
            icon.setIcon(data.toIcon());
            name.setText(data.getName());
        } else if(data.getType() == Nav_Model.MenuType.TITLE) {
            icon.setText(data.getName());
            icon.setFont(new Font("sansserif", 1, 12));
            name.setVisible(false);
        } else {
            name.setText(" ");
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(selected) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(118, 75, 162, 95));
            g2.fillRoundRect(20, 0, getWidth() - 40, getHeight(), 5, 5);
            if(data.getType() == Nav_Model.MenuType.MENU) {
                name.setForeground(Color.WHITE);
            }
        }
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        name = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        icon.setBackground(new java.awt.Color(255, 102, 255));
        icon.setForeground(new java.awt.Color(255, 255, 102));
        icon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        name.setText("Menu Name");
        name.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(icon)
                .addGap(20, 20, 20)
                .addComponent(name)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
