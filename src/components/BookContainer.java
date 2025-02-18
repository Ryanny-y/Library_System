package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Book_Model;
import swing.Book_Card;

public class BookContainer extends javax.swing.JPanel {

    private ArrayList<Book_Model> bookList = new ArrayList<>();
    
    public BookContainer(ArrayList<Book_Model> bookList) {
        initComponents();
        this.bookList = (bookList != null) ? bookList : new ArrayList<>();
        addComponents();
        setBackground(new Color(0,0,0,0));
    }
    
    public BookContainer() {
        initComponents();
        setBackground(new Color(0,0,0,0));
    }
    
    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 0; // Prevent components from expanding horizontally
        gbc.weighty = 0; // Prevent components from expanding vertically
        gbc.anchor = GridBagConstraints.NORTHWEST; // Align to the top-left

        int row = 0; // Start with the first row
        int column = 0; // Start with the first column

        for (int i = 0; i < bookList.size(); i++) {
            if (column == 4) {
                column = 0;
                row++;
            }

            gbc.gridx = column;
            gbc.gridy = row;

            // Create and add the book card component
            Book_Model model = bookList.get(i);
            Book_Card card = new Book_Card(model);
            card.setPreferredSize(new Dimension(180, 210)); // Set fixed size for cards
            add(card, gbc);

            // Increment the column index after placing an item
            column++;
        }

            // Ensure to add an empty panel to take up remaining space if there are fewer than 4 items in the last row
        if (column > 0) {
            gbc.gridx = column; // Place at the next empty position
            gbc.gridy = row; // Stay in the same row as the last element
            gbc.weightx = 1; // Take up all remaining space
            gbc.weighty = 1; // Ensure that remaining space is distributed
            add(new JPanel(), gbc);
        }
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
