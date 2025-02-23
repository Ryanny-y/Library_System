package swing.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import swing.PanelAction;

public class TableActionCellRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        String status = table.getValueAt(row, 3).toString();
        
        PanelAction action = new PanelAction(status);
        action.setBackground(new Color(0,0,0,0));
        return action;
    }
    
}
