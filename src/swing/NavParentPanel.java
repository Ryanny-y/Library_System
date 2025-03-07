package swing;
import pages.User.Profile;
import pages.Admin.Admin_Books;
import pages.Admin.Admin_Users;
import pages.Admin.Admin_Dashboard;
import pages.User.My_Books;
import pages.User.Home;
import pages.User.Favorites;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Box;
import model.*;
import pages.*;
import pages.Admin.Admin_Profile;

public class NavParentPanel extends javax.swing.JPanel {

    private User_Model user = Current_User.getCurrentUser();
    
    public NavParentPanel() {
        initComponents();
        init();
        setOpaque(false);
        
    }
    
    private void init() {
        if(user != null) {
            if(user.getRole() == User_Role.USER) {
                userNav();
            } else if (user.getRole() == User_Role.ADMIN) {
                adminNav();
            }
        } else {
            System.out.println("User is null, cannot retrieve role.");
        }
    }
    
    private void userNav() {
        Nav_Item item1 = new Nav_Item("Home", "Home", Home.class);
        Nav_Item item2 = new Nav_Item("My books", "MyBooks", My_Books.class);
        Nav_Item item3 = new Nav_Item("Favorites", "Favorites", Favorites.class);
        Nav_Item item4 = new Nav_Item("Profile", "Profile", Profile.class);
        
        addNavItemWithGap(item1, 5);
        addNavItemWithGap(item2, 5);
        addNavItemWithGap(item3, 5);
        addNavItemWithGap(item4, 5);
    }
    
    private void adminNav() {
        Nav_Item item1 = new Nav_Item("Dashboard", "Home", Admin_Dashboard.class);
        Nav_Item item2 = new Nav_Item("Users", "Users", Admin_Users.class);
        Nav_Item item3 = new Nav_Item("Books", "MyBooks", Admin_Books.class);
        Nav_Item item4 = new Nav_Item("Profile", "Profile", Admin_Profile.class);
        
        addNavItemWithGap(item1, 5);
        addNavItemWithGap(item2, 5);
        addNavItemWithGap(item3, 5);
        addNavItemWithGap(item4, 5);
    }
    
    private void addNavItemWithGap(Nav_Item item, int gap) {
        this.add(item);
        this.add(Box.createVerticalStrut(gap));  // Add gap between items
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
            width - shadowSize, 0, new Color(0, 0, 0, 50), 
            width, 0, new Color(0, 0, 0, 0) 
        );

        g2.setPaint(shadowPaint);
        g2.fillRect(width - shadowSize, 0, shadowSize, height);

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, width - shadowSize, height, 15, 15); // Exclude shadow area

        g2.dispose();

        super.paintChildren(g); // Call superclass method to ensure child components render
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
