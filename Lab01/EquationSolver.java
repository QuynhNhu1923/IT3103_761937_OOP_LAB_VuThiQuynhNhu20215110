import javax.swing.JOptionPane;

public class EquationSolver {
	public static void main(String[] args) {
	    while (true) { // Vòng lặp vô tận để cho phép chọn lại
	        String menu = "--- CHƯƠNG TRÌNH GIẢI PHƯƠNG TRÌNH ---\n" +
	                      "1. Phương trình bậc nhất (ax + b = 0)\n" +
	                      "2. Hệ phương trình bậc nhất (2 ẩn)\n" +
	                      "3. Phương trình bậc hai (ax^2 + bx + c = 0)\n" +
	                      "0. Thoát chương trình\n" +
	                      "Vui lòng chọn một tùy chọn:";
	                      
	        String choice = JOptionPane.showInputDialog(null, menu, "Menu lựa chọn", JOptionPane.QUESTION_MESSAGE);

	        // Trường hợp người dùng nhấn Cancel hoặc dấu X của cửa sổ
	        if (choice == null || choice.equals("0")) {
	            System.exit(0);
	        }

	        switch (choice) {
	            case "1": 
	                solveLinear(); 
	                break;
	            case "2": 
	                solveSystem(); 
	                break;
	            case "3": 
	                solveQuadratic(); 
	                break;
	            default: 
	                // Nếu chọn sai, hiện thông báo và vòng lặp while sẽ tự quay lại menu
	                JOptionPane.showMessageDialog(null, "Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 3.");
	                break;
	        }
	    }
	}

    private static void solveLinear() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số b:"));
        
        if (a == 0) {
            JOptionPane.showMessageDialog(null, b == 0 ? "Phương trình có vô số nghiệm" : "Phương trình vô nghiệm");
        } else {
            JOptionPane.showMessageDialog(null, "Nghiệm của phương trình x = " + (-b / a));
        }
    }

    private static void solveSystem() {
        // Nhập các hệ số cho hệ phương trình 2 ẩn
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            JOptionPane.showMessageDialog(null, "Hệ có nghiệm duy nhất: x1 = " + (D1/D) + ", x2 = " + (D2/D));
        } else {
            JOptionPane.showMessageDialog(null, (D1 == 0 && D2 == 0) ? "Hệ có vô số nghiệm" : "Hệ vô nghiệm");
        }
    }

    private static void solveQuadratic() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số c:"));

        if (a == 0) { // Trở về phương trình bậc nhất nếu a = 0
            if (b == 0) {
                JOptionPane.showMessageDialog(null, c == 0 ? "Phương trình có vô số nghiệm" : "Phương trình vô nghiệm");
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình bậc nhất có nghiệm: x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                JOptionPane.showMessageDialog(null, "Phương trình có 2 nghiệm phân biệt:\nx1 = " + ((-b + Math.sqrt(delta)) / (2 * a)) + 
                                                   "\nx2 = " + ((-b - Math.sqrt(delta)) / (2 * a)));
            } else if (delta == 0) {
                JOptionPane.showMessageDialog(null, "Phương trình có nghiệm kép: x = " + (-b / (2 * a)));
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm thực");
            }
        }
    }
}