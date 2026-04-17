import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
    public static void main(String[] args) {
        // Nhập số thứ nhất
        String strNum1 = JOptionPane.showInputDialog(null, 
        		"Vui lòng nhập số thứ nhất: ", 
        		"Nhập số thứ nhất", 
        		JOptionPane.INFORMATION_MESSAGE);
        
        // Nhập số thứ hai
        String strNum2 = JOptionPane.showInputDialog(null, 
        		"Vui lòng nhập số thứ hai: ", 
        		"Nhập số thứ hai", 
        		JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        
        // Chuẩn bị chuỗi kết quả
        String result = "Tổng: " + sum + "\nHiệu: " + 
        				difference + "\nTích: " + product + "\n";
        
        if (num2 != 0) {
            result += "Thương: " + (num1 / num2);
        } else {
            result += "Thương: Không thể chia cho số 0!";
        }

        // Hiển thị kết quả
        JOptionPane.showMessageDialog(null, result, 
        			"Kết quả: ", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}