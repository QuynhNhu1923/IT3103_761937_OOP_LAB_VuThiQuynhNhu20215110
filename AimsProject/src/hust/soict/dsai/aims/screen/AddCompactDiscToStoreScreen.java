package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist, tfTracks;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");

        centerPanel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        centerPanel.add(tfArtist);

        centerPanel.add(new JLabel("Tracks (Title-Length, ...):"));
        tfTracks = new JTextField();
        centerPanel.add(tfTracks);
        
        revalidate();
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();
        String tracksStr = tfTracks.getText();

        CompactDisc cd = new CompactDisc();
        cd.setTitle(title);
        cd.setCategory(category);
        cd.setCost(cost);
        cd.setArtist(artist);
        
        String[] tracks = tracksStr.split(",");
        for (String trackInfo : tracks) {
            String[] parts = trackInfo.trim().split("-");
            if (parts.length == 2) {
                String trackTitle = parts[0].trim();
                int trackLength = Integer.parseInt(parts[1].trim());
                cd.addTrack(new Track(trackTitle, trackLength));
            }
        }

        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "Đã thêm CD thành công!");
        dispose();
    }
}