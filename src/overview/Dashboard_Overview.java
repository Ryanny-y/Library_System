package overview;

import java.awt.Color;
import javax.swing.JPanel;

public class Dashboard_Overview extends javax.swing.JPanel {

    public Dashboard_Overview() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        card1.setData("1234", "UserBig", "Total Users");
        card2.setData("123", "UserBig", "Total Books");
        card3.setData("123", "UserBig", "Borrowed Books");
        card4.setData("123", "UserBig", "Overdue Books");
        
        JPanel p = new JPanel();
        
        addRow();
    }
    
    private void addRow() {
        table.addRow(new Object[]{101, "Alice Johnson", "alice.johnson@example.com", "2023-01-15"});
        table.addRow(new Object[]{102, "Bob Smith", "bob.smith@example.com", "2023-02-10"});
        table.addRow(new Object[]{103, "Charlie Brown", "charlie.brown@example.com", "2023-03-05"});
        table.addRow(new Object[]{104, "David Wilson", "david.wilson@example.com", "2023-04-12"});
        table.addRow(new Object[]{105, "Emma Davis", "emma.davis@example.com", "2023-05-20"});
        table.addRow(new Object[]{106, "Frank Harris", "frank.harris@example.com", "2023-06-25"});
        table.addRow(new Object[]{107, "Grace Martinez", "grace.martinez@example.com", "2023-07-30"});
        table.addRow(new Object[]{108, "Henry White", "henry.white@example.com", "2023-08-15"});
        table.addRow(new Object[]{109, "Isabella Anderson", "isabella.anderson@example.com", "2023-09-22"});
        table.addRow(new Object[]{110, "Jack Thomas", "jack.thomas@example.com", "2023-10-18"});
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        card1 = new swing.Stats_Card();
        card2 = new swing.Stats_Card();
        card3 = new swing.Stats_Card();
        card4 = new swing.Stats_Card();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.Table();

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jLayeredPane1.add(card1);
        jLayeredPane1.add(card2);
        jLayeredPane1.add(card3);
        jLayeredPane1.add(card4);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 76, 140));
        jLabel1.setText("Members List");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Email", "Joined", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Stats_Card card1;
    private swing.Stats_Card card2;
    private swing.Stats_Card card3;
    private swing.Stats_Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables
}
