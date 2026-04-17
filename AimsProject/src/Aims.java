public class Aims {

	public static void main(String[] args) {
		//Create a new cart
		Cart anOrder = new Cart();
		
//		// --- TEST MỤC 2.1: Nạp chồng với mảng (Array) ---
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//        
//        // Tạo một mảng các DVD
//        DigitalVideoDisc[] dvdList = {dvd1, dvd2};
//        
//        // Gọi hàm nạp chồng truyền vào mảng
//        anOrder.addDigitalVideoDisc(dvdList);

//        // --- TEST MỤC 2.2: Nạp chồng với 2 tham số ---
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Cinderella", "Animation", 20.00f);
//        
//        // Gọi hàm nạp chồng truyền trực tiếp 2 DVD
//        anOrder.addDigitalVideoDisc(dvd3, dvd4);

        // --- TEST VARARGS ---
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("DVD 5");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("DVD 6");
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("DVD 7");
        anOrder.addDigitalVideoDisc(dvd5, dvd6, dvd7); 

        // Hiển thị giỏ hàng sau khi thêm bằng các phương thức nạp chồng
        System.out.println("\nCurrent Cart Content:");
        anOrder.displayCart();
        System.out.println("Total Cost: " + anOrder.totalCost());
		
//		//Create new dvd objects and add them to the cart
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","RogerAllers",87,19.95f);
//		anOrder.addDigitalVideoDisc(dvd1);
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
//		anOrder.addDigitalVideoDisc(dvd2);
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
//		anOrder.addDigitalVideoDisc(dvd3);
//		
//		//print total cosr of the items in the cart
//		System.out.println("Total Cost is:");
//		System.out.println(anOrder.totalCost());
//		// Test removeDigitalVideoDisc
//		// Cart trước khi xóa
//        System.out.println("Cart before removal:");
//        anOrder.displayCart();
//        System.out.println("Total cost before removal: " + anOrder.totalCost());
//
//        // Thử xóa Stars Wars
//        System.out.println("\nRemoving 'Star Wars' from the cart...");
//        anOrder.removeDigitalVideoDisc(dvd2);
//
//        // Cart sau khi xóa
//        System.out.println("Cart after removal:");
//        anOrder.displayCart();
//        System.out.println("Total cost after removal: " + anOrder.totalCost());
//
//        // Xóa DVD không tồn tại
//        System.out.println("\nRemoving 'Nonexistent DVD' from the cart...");
//        // Ở đây mới chỉ khai báo 1 DVD mới là noxexistentDVD tuy nhiên chưa thực hiện thêm vào Cart
//        // nên  trong giỏ hàng chưa có sản phẩm này nên kết quả in ra sẽ là disc này không tồn tại
//        DigitalVideoDisc nonexistentDVD = new DigitalVideoDisc("Nonexistent DVD");
//        //anOrder.addDigitalVideoDisc(nonexistentDVD); Nếu thêm câu lệnh này thì kết quả in ra sẽ là xóa thành công
//        anOrder.removeDigitalVideoDisc(nonexistentDVD);
//        anOrder.removeDigitalVideoDisc(dvd2); // do ở dòng 26 đã thực hiện remove dcd2 nên trong giỏ hàng 
//        									  // không còn dvd2 nên kết quả trả ra sẽ là disc không tồn tại
    }

}
