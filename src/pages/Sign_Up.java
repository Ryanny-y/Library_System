package pages;

import java.awt.Color;

public class Sign_Up extends javax.swing.JFrame {

    public Sign_Up() {
        initComponents();
        setBackground(new Color(0,0,0,0));

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        authBorder1 = new swing.AuthBorder();
        signupForm1 = new components.SignupForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        javax.swing.GroupLayout authBorder1Layout = new javax.swing.GroupLayout(authBorder1);
        authBorder1.setLayout(authBorder1Layout);
        authBorder1Layout.setHorizontalGroup(
            authBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authBorder1Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(signupForm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        authBorder1Layout.setVerticalGroup(
            authBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authBorder1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(signupForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(authBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(authBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.AuthBorder authBorder1;
    private components.SignupForm signupForm1;
    // End of variables declaration//GEN-END:variables
}
