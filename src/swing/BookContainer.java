package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Book_Model;

public class BookContainer extends javax.swing.JPanel {

    private ArrayList<Book_Model> bookList;
    
    public BookContainer(ArrayList bookList) {
        initComponents();
        this.bookList = bookList;
        addComponents();
        setOpaque(false);
    }
    
     private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,0,0); 
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        
        for (int i = 0; i < bookList.size(); i++) {  
            gbc.gridx = i % 5; 
            gbc.gridy = i / 5; 
            
            Book_Model model = bookList.get(i);
            Book_Card card = new Book_Card(model);
            add(card, gbc);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 153, 153));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
