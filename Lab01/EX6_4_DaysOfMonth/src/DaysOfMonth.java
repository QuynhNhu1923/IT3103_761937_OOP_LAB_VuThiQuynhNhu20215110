//Ex 6.4
import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = -1, year = -1;

        while (true) {
            System.out.println("--- Date Input ---");
            System.out.print("Enter month (Full Name/Abbr./3 letters/Number): ");
            String mStr = sc.nextLine().trim();

            System.out.print("Enter year (non-negative number): ");
            String yStr = sc.nextLine().trim();

            // 1. Validate year (must be a non-negative integer)
            try {
                year = Integer.parseInt(yStr);
                if (year < 0) {
                    System.out.println("Error: Year cannot be negative.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid year format. Please enter digits only.");
                continue;
            }

            // 2. Validate month
            month = getMonth(mStr);
            if (month != -1) {
                break;
            } else {
                System.out.println("Error: Invalid month. (Examples: January, Jan., Jan, or 1)");
            }
        }

        // 3. Calculate days
        int days = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else if (month == 2) {
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            days = isLeap ? 29 : 28;
        }

        System.out.println("Result: Month " + month + " in " + year + " has " + days + " days.");
        sc.close();
    }

    private static int getMonth(String m) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] abbr = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
        String[] three = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        for (int i = 0; i < 12; i++) {
            if (m.equalsIgnoreCase(months[i]) || 
                m.equalsIgnoreCase(abbr[i]) || 
                m.equalsIgnoreCase(three[i]) || 
                m.equals(String.valueOf(i + 1))) {
                return i + 1;
            }
        }
        return -1;
    }
}