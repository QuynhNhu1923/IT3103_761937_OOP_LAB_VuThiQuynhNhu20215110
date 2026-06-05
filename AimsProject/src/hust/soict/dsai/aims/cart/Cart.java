package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Số lượng tối đa có thể đặt
    
    //private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
 // 1. Phương thức thêm Media vào giỏ hàng 
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media \"" + media.getTitle() + "\" has been added.");
            } else {
                System.out.println("The media is already in the cart.");
            }
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    // 2. Nạp chồng: Thêm số lượng tham số tùy ý (Varargs) 
    public void addMedia(Media... medias) {
        for (Media media : medias) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                if (!itemsOrdered.contains(media)) {
                    itemsOrdered.add(media);
                    System.out.println("The media \"" + media.getTitle() + "\" has been added.");
                } else {
                    System.out.println("The media \"" + media.getTitle() + "\" is already in the cart.");
                }
            } else {
                System.out.println("The cart is almost full. Cannot add: " + media.getTitle());
                break;
            }
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }
    // Phương thức tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost(); 
        }
        return total;
    }
    // Bổ sung thêm phương thức hiển thị nội dung giỏ hàng để thể hiện rõ hơn khi test remove
    public void displayCart() {
        System.out.println("Cart contents:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }
 // Tìm theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found match: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No media found with ID: " + id);
    }

    // Tìm theo Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found match: " + media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No media found with title: " + title);
    }
    
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    
    public void emptyCart() {
        itemsOrdered.clear();
    }
    
}
