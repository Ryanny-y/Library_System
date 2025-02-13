package components;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Book_Model;

public class SearchBar extends javax.swing.JPanel {

    
    public SearchBar() {
        initComponents();
        
        search_btn.setIcon(toIcon(search_btn, "magnifying"));
    }
    
    public Icon toIcon(JButton lbl, String icon) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/" + icon + ".png"));
        Image image = imageIcon.getImage();
        
        // Get JLabel dimensions
        int labelWidth = lbl.getPreferredSize().width;
        int labelHeight = lbl.getPreferredSize().height;

        // Get original image dimensions
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        // Calculate new width and height while keeping aspect ratio
        double widthRatio = (double) labelWidth / imageWidth;
        double heightRatio = (double) labelHeight / imageHeight;
        double ratio = Math.min(widthRatio, heightRatio); // Maintain aspect ratio

        int newWidth = (int) (imageWidth * ratio);
        int newHeight = (int) (imageHeight * ratio);

        // Resize image
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

         return new ImageIcon(resizedImage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search_field = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();

        search_field.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        search_field.setText("Search");
        search_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_fieldActionPerformed(evt);
            }
        });

        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(search_field))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(search_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_fieldActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_field;
    // End of variables declaration//GEN-END:variables
}
