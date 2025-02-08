package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Nav_Item extends javax.swing.JPanel {
     
    private boolean selected, isCurrent;
    private Class<? extends JFrame> path;
    private String icon;
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public Nav_Item(String name, String icon, Class<? extends JFrame> path) {
        initComponents();
        setOpaque(false);
        
        lblname.setText(name);
        this.path = path;
        this.icon = icon;
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(!isCurrent) {
                    setBackground(new Color(102, 126, 234, 80));
                    setSelected(true);
                    repaint();
                    lblicon.setIcon(toIcon(icon + "-Current"));
                    lblname.setForeground(Color.decode("#ffffff"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!isCurrent) {
                    setBackground(new Color(0,0,0,0));
                    setSelected(false);
                    repaint();
                    lblicon.setIcon(toIcon(icon));
                    lblname.setForeground(Color.decode("#000000"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    path.getDeclaredConstructor().newInstance();
                    closePage();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    public Icon toIcon(String icon) {
        return new ImageIcon(getClass().getResource("/images/" + icon + ".png"));
    }
    
    private void closePage() {
        JFrame topFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.dispose(); // Close the frame 
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); //
    }
    
     @Override
    public void addNotify() {
        super.addNotify();
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (parentFrame != null) {
           if (parentFrame.getClass().equals(path)) {
                lblicon.setIcon(toIcon(icon + "-Current"));
                lblname.setForeground(Color.decode("#ffffff"));
                isCurrent = true;
                setBackground(new Color(102, 126, 234, 80));
                repaint();
            } else {
                lblicon.setIcon(toIcon(icon));
                setBackground(new Color(0, 0, 0, 0));
                repaint();
            }
        } else {
            System.out.println("Parent JFrame not found");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblicon = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(32767, 50));
        setOpaque(false);

        lblname.setText("Menu Title");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblicon)
                .addGap(20, 20, 20)
                .addComponent(lblname)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblicon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblname, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblicon;
    private javax.swing.JLabel lblname;
    // End of variables declaration//GEN-END:variables
}
