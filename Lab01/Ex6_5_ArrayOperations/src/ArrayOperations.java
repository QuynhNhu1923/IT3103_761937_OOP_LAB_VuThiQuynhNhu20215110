import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        double[] my_array = new double[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            my_array[i] = sc.nextDouble();
        }

        // 1. Sort the array
        //Arrays.sort(my_array); - có thể dùng nhanh hàm này
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (my_array[i] > my_array[j]) {                    
                    double temp = my_array[i];
                    my_array[i] = my_array[j];
                    my_array[j] = temp;
                }
            }
        }

        // 2. Calculate sum and average
        double sum = 0;
        for (double num : my_array) {
            sum += num;
        }
        double average = sum / n;

        // 3. Display results
        //System.out.println("Sorted Array: " + Arrays.toString(my_array));
        System.out.print("Sorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(my_array[i] + (i == n - 1 ? "" : ", "));
        }
        System.out.print("\n");
        System.out.println("Sum: " + sum);
        System.out.println("Average value: " + average);
        
        sc.close();
    }
}