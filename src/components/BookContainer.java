package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Book_Model;
import swing.Book_Card;

public class BookContainer extends javax.swing.JPanel {

    private ArrayList<Book_Model> bookList;
    
    public BookContainer(ArrayList bookList) {
        initComponents();
        this.bookList = bookList;
        addComponents();
        setBackground(new Color(0,0,0,0));
    }
    
     private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        
        for (int i = 0; i < bookList.size(); i++) {  
            gbc.gridx = i % 5; 
            gbc.gridy = i / 5; 
            
            Book_Model model = bookList.get(i);
            Book_Card card = new Book_Card(model);
            add(card, gbc);
        }
        
        gbc.weighty = 1;
        add(new JPanel(), gbc); // Invisible filler
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
