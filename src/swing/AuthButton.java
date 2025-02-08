

package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class AuthButton extends JButton{
    
    String path;
    public AuthButton(String text, String path) {
        super(text);   
        this.path = path;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#1B4C8C"));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        
        // Draw the button text
        g2.setColor(Color.WHITE);
        g2.setFont(getFont());
        int stringWidth = g2.getFontMetrics().stringWidth(getText());
        int stringHeight = g2.getFontMetrics().getAscent();
        g2.drawString(getText(), (getWidth() - stringWidth) / 2, (getHeight() + stringHeight) / 2 - 3);
        
        super.paintChildren(g); 
    }
    
    
    
}
