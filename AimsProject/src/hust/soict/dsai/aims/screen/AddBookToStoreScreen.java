package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");

        centerPanel.add(new JLabel("Authors (comma separated):"));
        tfAuthors = new JTextField();
        centerPanel.add(tfAuthors);
        revalidate();
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String authorsStr = tfAuthors.getText();

        Book book = new Book();
        book.setTitle(title);
        book.setCategory(category);
        book.setCost(cost);
        
        String[] authors = authorsStr.split(",");
        for (String author : authors) {
            book.addAuthor(author.trim());
        }

        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Đã thêm Book thành công!");
        dispose();
    }
}