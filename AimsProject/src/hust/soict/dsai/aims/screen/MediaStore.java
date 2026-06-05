package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null, "Đã thêm " + media.getTitle() + " vào giỏ hàng!");
            }
        });
        container.add(btnAddToCart);
        
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) media).play();
                        JOptionPane.showMessageDialog(null, "Đang phát: " + media.getTitle(), "Media Player", JOptionPane.INFORMATION_MESSAGE);
                    } catch (PlayerException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi Phát Media", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(btnPlay);
        }
        
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}