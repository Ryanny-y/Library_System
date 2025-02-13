package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Search_Field extends JTextField{
    
    public Search_Field (String text) {
        super(text);
        init();
        
        
    }
    
    public Search_Field() {
        super();
        init();
    }
    
    private void init() {
        setOpaque(false);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(getText().equals("Search")) {
                    setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(getText().isBlank()) {
                    setText("Search");
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(new Color(240,240,240));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(200,200,200));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        
        
        super.paintComponent(g);
    }
    
    
}
