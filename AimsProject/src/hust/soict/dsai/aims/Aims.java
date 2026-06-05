package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import java.util.Collections;
import java.util.Scanner;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
public class Aims {
	
	public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
        store.addMedia(new DigitalVideoDisc("Lỗi Length DVD", "Animation", "Test Lỗi", 0, 10.0f));
        
        Book book1 = new Book();
        book1.setTitle("Harry Potter");
        book1.setCategory("Fantasy");
        book1.setCost(20.5f);
        store.addMedia(book1);

        new StoreScreen(store, cart);
    }
}
