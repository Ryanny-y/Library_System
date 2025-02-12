
package swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Stats_Card extends javax.swing.JPanel {

    public Stats_Card() {
        initComponents();
        setOpaque(false);
    }
    
    public void setData(String n, String i, String d) {
        lblname.setText(n);
        lblIcon.setIcon(toIcon(i));
        lblDescription.setText(d);
    }
        
    
    public Icon toIcon(String icon) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/" + icon + ".png"));
        Image image = imageIcon.getImage();

        Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        
        return new ImageIcon(resizedImage);
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint paint = new GradientPaint(0, 0, Color.decode("#1B4C8C"), 0, getHeight(), Color.decode("#E7F1FF"));
        g2.setPaint(paint);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblname = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(200, 135));

        lblname.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblname.setText("123");

        lblIcon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        lblDescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDescription.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblname;
    // End of variables declaration//GEN-END:variables
}
