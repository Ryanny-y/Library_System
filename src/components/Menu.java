
package components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    public Menu() {
        initComponents();
        setOpaque(false);
    }
    
    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Enable anti-aliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int shadowSize = 1; 

        GradientPaint shadowPaint = new GradientPaint(
            width - shadowSize, 0, new Color(0, 0, 0, 100), 
            width, 0, new Color(0, 0, 0, 0) 
        );

        g2.setPaint(shadowPaint);
        g2.fillRect(width - shadowSize, 0, shadowSize, height);

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, width - shadowSize, height, 15, 15); // Exclude shadow area

        g2.dispose();

        super.paintChildren(g); // Call superclass method to ensure child components render
    }

    
    private int x, y;
  
    public void initMoving(JFrame frame) {
       MenuHeader.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               x = e.getX();
               y = e.getY();
           }
       });
       
       MenuHeader.addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
           }
           
       });  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        navParentPanel1 = new swing.NavParentPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(200, 363));

        MenuHeader.setOpaque(false);
        MenuHeader.setPreferredSize(new java.awt.Dimension(215, 65));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 76, 140));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.png"))); // NOI18N
        jLabel1.setText("IT242 Library ");
        jLabel1.setIconTextGap(7);

        javax.swing.GroupLayout MenuHeaderLayout = new javax.swing.GroupLayout(MenuHeader);
        MenuHeader.setLayout(MenuHeaderLayout);
        MenuHeaderLayout.setHorizontalGroup(
            MenuHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuHeaderLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        MenuHeaderLayout.setVerticalGroup(
            MenuHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(319, 319, 319))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MenuHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navParentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(MenuHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navParentPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuHeader;
    private javax.swing.JLabel jLabel1;
    private swing.NavParentPanel navParentPanel1;
    // End of variables declaration//GEN-END:variables
}
