package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField tfTitle, tfCategory, tfCost;
    protected JPanel centerPanel;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("Add New Media");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cp.add(headerLabel, BorderLayout.NORTH);

        centerPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        centerPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        cp.add(centerPanel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> {
            try {
                addItem();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        cp.add(btnAdd, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected abstract void addItem();
}