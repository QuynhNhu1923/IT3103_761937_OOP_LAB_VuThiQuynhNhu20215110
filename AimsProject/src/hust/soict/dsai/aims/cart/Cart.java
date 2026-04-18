public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Số lượng tối đa có thể đặt
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; // Mảng để lưu trữ các DVD
    private int qtyOrdered = 0; // Số lượng DVD hiện có trong giỏ hàng
    // Phương thức thêm DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    // 2.1: Nạp chồng: Thêm một mảng DVD (DigitalVideoDisc [])
//    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//        for (DigitalVideoDisc disc : dvdList) {
//            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//                itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
//            } else {
//                System.out.println("The cart is almost full. Cannot add: " + disc.getTitle());
//                break; 
//            }
//        }
//    }
    // 2.1: Nạp chồng: Thêm số lượng tham số tùy ý (Varargs) 
    	//cho phép gọi: cart.addDigitalVideoDisc(d1, d2, d3...);
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            } else {
                System.out.println("The cart is almost full.");
                break;
            }
        }
    }
    //2.2: Nạp chồng: Thêm chính xác 2 DVD
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 1 < MAX_NUMBERS_ORDERED) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        } else {
            System.out.println("The cart is almost full, cannot add both discs.");
        }
    }
    // Phương thức xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) { // So sánh DVD
                found = true;
                // Dời các DVD còn lại để lấp đầy khoảng trống
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Xóa DVD cuối cùng
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart.");
        }
    }
    // Phương thức tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost(); // Cộng dồn chi phí của các DVD
        }
        return total;
    }
    // Bổ sung thêm phương thức hiển thị nội dung giỏ hàng để thể hiện rõ hơn khi test remove
    public void displayCart() {
        System.out.println("Cart contents:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].toString());
        }
    }
 // Tìm theo ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found match: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No DVD found with ID: " + id);
    }

    // Tìm theo Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found match: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) System.out.println("No DVD found with title: " + title);
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}
