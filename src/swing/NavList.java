package swing;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import model.Nav_Model;

public class NavList<E extends Object> extends JList<E> {
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    
    public NavList() {
        model = new DefaultListModel<>();
        setModel(model);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    int index = locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    
                    if(o instanceof Nav_Model) {
                        Nav_Model nav = (Nav_Model) o;
                        if(nav.getType() == Nav_Model.MenuType.MENU) {
                            selectedIndex = index;
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
            
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Nav_Model data;

                if(value instanceof Nav_Model) {
                    data = (Nav_Model) value;
                } else {
                    data = new Nav_Model("", value+"", Nav_Model.MenuType.EMPTY);
                }
                
                NavItem item = new NavItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }
            
        };
    }
    
    public void addItem(Nav_Model data) {
        model.addElement(data);
    }
}
