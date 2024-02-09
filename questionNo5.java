import java.util.Scanner;

public class questionNo5 {
    public static double hornersMethod(double[] arr, double answer, int i, double num) {
        if (i == arr.length)
            return answer;

        return hornersMethod(arr, answer * num + arr[i], i + 1, num);
    }

    public static void main(String[] args) {
        System.out.println();

        Scanner inp = new Scanner(System.in);

        System.out.print("Enter the highest degree of the polynomial : ");
        int size = inp.nextInt();
        System.out.println();

        double[] arr = new double[size + 1];

        System.out.println("Enter the coefficient's");
        for (int i = 0; i < size + 1; i++) {
            System.out.print(i + 1 + "th : ");
            arr[i] = inp.nextDouble();
        }
        System.out.println();

        System.out.print("Enter value of x : ");
        double x = inp.nextDouble();
        System.out.println();

        double answer = hornersMethod(arr, 0, 0, x);

        System.out.println("functional value at " + x + " is : " + answer);
    }
}
