package swing;

import model.Book_Model;

public class Favorite_Item extends javax.swing.JPanel {
    public Favorite_Item(Book_Model data) {
        initComponents();
        
        img.setIcon(data.toIcon(img, data));
        title.setText("<html>" + data.getTitle() + "</html>");
        author.setText(data.getAuthor());
        published.setText(Integer.toString(data.getYear_published()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        published = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 100));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(275, 100));

        img.setBackground(new java.awt.Color(204, 204, 255));
        img.setPreferredSize(new java.awt.Dimension(64, 70));

        title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        title.setForeground(new java.awt.Color(27, 76, 140));
        title.setText("Title Here");

        author.setText("Author here");

        published.setText("2020");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(author)
                    .addComponent(published))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(author)
                        .addGap(3, 3, 3)
                        .addComponent(published))
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel author;
    private javax.swing.JLabel img;
    private javax.swing.JLabel published;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
