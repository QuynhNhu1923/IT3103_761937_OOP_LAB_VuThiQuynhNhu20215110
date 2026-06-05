package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");

        centerPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("Length (mins):"));
        tfLength = new JTextField();
        centerPanel.add(tfLength);
        revalidate();
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        
        JOptionPane.showMessageDialog(this, "Đã thêm DVD thành công!");
        dispose();
    }
}