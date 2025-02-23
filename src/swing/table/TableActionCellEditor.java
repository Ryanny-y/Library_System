
package swing.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import swing.PanelAction;


public class TableActionCellEditor extends DefaultCellEditor {
    
    
    public TableActionCellEditor() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        String status = table.getValueAt(row, 3).toString();
        int book_id = Integer.parseInt(table.getValueAt(row, 0).toString());
        
        JFrame currentFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(table);
        PanelAction action = new PanelAction(status, book_id, currentFrame);
        
        action.setBackground(new Color(0,0,0,0));
        return action;
    }
    
}
