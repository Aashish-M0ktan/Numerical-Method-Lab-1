import java.util.Scanner;

public class questionNo3 extends Iterator {
    public static double getFunctionValue(double x) {
        // update the equation here
        return (Math.sin(x) - 2 * x + 1);
    }

    public static double getNewXSecant(double x1, double x0) {
        return (x1 - (getFunctionValue(x1) * (x1 - x0)) / (getFunctionValue(x1) - getFunctionValue(x0)));
    }

    public static double getError(double xNew, double xOld) {
        return Math.abs((xNew - xOld) / xNew);
    }
    public static double secantMethod(double x0, double x1, double error) {
        if (error <= 0.05)
            return x1;

        double xNew = getNewXSecant(x1, x0);
        error = getError(xNew, x1);
        updateIteration();
        return secantMethod(x1, xNew, error);
    }

    public static void main(String[] args) {
        System.out.println();

        Scanner inp = new Scanner(System.in);

        double x0, x1;

        System.out.print("Enter a number that gives negative function value : ");
        x0 = inp.nextDouble();
        while (getFunctionValue(x0) > 0) {
            System.out.print("Enter again : ");
            x0 = inp.nextDouble();
        }

        System.out.print("Enter a number that gives positive function value : ");
        x1 = inp.nextDouble();
        while (getFunctionValue(x1) < 0) {
            System.out.print("Enter again : ");

            x1 = inp.nextDouble();
        }

        double root = secantMethod(x1, x0, 1);

        System.out.println();
        System.out.println("Root of the equation is : " + root);
        System.out.println("Function value at " + root + " is : " + getFunctionValue(root));
        System.out.println("Number of Iteration is : " + getIteration());
    }
}
