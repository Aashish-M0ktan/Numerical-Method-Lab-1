import java.util.Scanner;

public class questionNo4 extends Iterator {
    public static double getFunctionValue(double x) {
        // update the equation for the g(x);
        return (Math.pow(x, 2) + x - 0.75);
    }

    public static double getError(double xNew, double xOld) {
        return Math.abs((xNew - xOld) / xNew);
    }

    public static double fixedPointIterationMethod(double xn, double xn1, double error) {
        if (error <= 0.05)
            return xn1;

        double xNew = getFunctionValue(xn);
        updateIteration();
        return fixedPointIterationMethod(xn1, xNew, getError(xNew, xn));
    }

    public static void main(String[] args) {
        System.out.println();

        Scanner inp = new Scanner(System.in);

        System.out.print("Enter the initial guess : ");
        double xn = inp.nextDouble();
        System.out.println();

        double xn1 = getFunctionValue(xn);
        double ans = fixedPointIterationMethod(xn, xn1, getError(xn1, xn));

        System.out.println("The root of the equation is : " + ans);
        System.out.println("The functional value at " + ans + " is : " + getFunctionValue(ans));
        System.out.println("Number of Iteration is : " + getIteration());
    }
}
