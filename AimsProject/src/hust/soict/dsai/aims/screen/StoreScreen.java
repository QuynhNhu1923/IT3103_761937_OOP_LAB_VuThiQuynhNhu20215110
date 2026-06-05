package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        
        setVisible(true);
        setTitle("AIMS Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        addBookMenu.addActionListener(e -> new AddBookToStoreScreen(store));
        smUpdateStore.add(addBookMenu);
        
        JMenuItem addCDMenu = new JMenuItem("Add CD");
        addCDMenu.addActionListener(e -> new AddCompactDiscToStoreScreen(store));
        smUpdateStore.add(addCDMenu);
        
        JMenuItem addDVDMenu = new JMenuItem("Add DVD");
        addDVDMenu.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));
        smUpdateStore.add(addDVDMenu);
        
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        
        JMenuItem viewCartMenu = new JMenuItem("View cart");
        viewCartMenu.addActionListener(e -> new CartScreen(cart));
        menu.add(viewCartMenu);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        
        JButton cartBtn = new JButton("View cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));
        
        cartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });
        
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }
        return center;
    }
}