package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import java.util.Collections;
import java.util.Scanner;

public class Aims {
	
	private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
		store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: seeCurrentCart(); break;
                case 0: System.out.println("Tạm biệt!"); break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // --- Các logic tương tác ---
    private static void viewStore() {
        int choice;
        do {
            System.out.println("=== CỬA HÀNG ===");
            for (Media m : store.getItemsInStore()) {
                System.out.println(m.toString());
            }
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Xem chi tiết
                    System.out.print("Nhập tiêu đề Media: ");
                    Media m1 = store.fetchMedia(scanner.nextLine());
                    if (m1 != null) {
                        System.out.println(m1.toString());
                        mediaDetailsMenu();
                        int subChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (subChoice == 1) {
                            cart.addMedia(m1);
                        } else if (subChoice == 2 && m1 instanceof Playable) {
                            ((Playable) m1).play();
                        } else if (subChoice == 2) {
                            System.out.println("Media này không hỗ trợ Play!");
                        }
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;
                case 2: // Thêm vào giỏ hàng
                    System.out.print("Nhập tiêu đề Media cần thêm: ");
                    Media m2 = store.fetchMedia(scanner.nextLine());
                    if (m2 != null) cart.addMedia(m2);
                    else System.out.println("Không tìm thấy!");
                    break;
                case 3: // Play media
                    System.out.print("Nhập tiêu đề Media cần phát: ");
                    Media m3 = store.fetchMedia(scanner.nextLine());
                    if (m3 != null && m3 instanceof Playable) ((Playable) m3).play();
                    else System.out.println("Không tìm thấy hoặc không hỗ trợ Play!");
                    break;
                case 4: // Xem giỏ hàng
                    seeCurrentCart();
                    break;
            }
        } while (choice != 0);	
    }
    
    private static void updateStore() {
        System.out.println("Chức năng thêm/xóa khỏi cửa hàng (Store) - Sinh viên tự mở rộng dùng store.addMedia / store.removeMedia");
    }

    private static void seeCurrentCart() {
        int choice;
        do {
            System.out.println("=== GIỎ HÀNG ===");
            for (Media m : cart.getItemsOrdered()) {
                System.out.println(m.toString());
            }
            System.out.println("Tổng chi phí: " + cart.totalCost() + "$");
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Tính năng lọc giỏ hàng đang được xây dựng.");
                    break;
                case 2:
                    System.out.println("1. Xếp theo Title->Cost | 2. Xếp theo Cost->Title");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                    else if (sortChoice == 2) Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                    System.out.println("Đã sắp xếp!");
                    break;
                case 3:
                    System.out.print("Nhập tiêu đề Media cần xóa: ");
                    Media mRemove = store.fetchMedia(scanner.nextLine()); // Tái sử dụng logic tìm theo tên
                    if (mRemove != null) cart.removeMedia(mRemove);
                    break;
                case 4:
                    System.out.print("Nhập tiêu đề Media cần phát: ");
                    Media mPlay = store.fetchMedia(scanner.nextLine());
                    if (mPlay != null && mPlay instanceof Playable) ((Playable) mPlay).play();
                    break;
                case 5: // Đặt hàng theo yêu cầu rút gọn [cite: 336-337]
                    System.out.println("Đơn hàng đã được tạo. Giỏ hàng đã được làm trống!");
                    cart.emptyCart();
                    break;
            }
        } while (choice != 0);
    }
}
