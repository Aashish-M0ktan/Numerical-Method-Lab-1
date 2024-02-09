import java.util.Scanner;

public class questionNo1 extends Iterator {
    static boolean flag;

    public static double getFunctionValue(double x) {
        // update the equation here
        return (Math.sin(x) - 2 * x + 1);
    }

    public static double getMid(double x1, double x2) {
        return ((x1 + x2) / 2);
    }

    public static double getError(double xNew, double xOld) {
        return Math.abs((xNew - xOld) / xNew);
    }

    public static double bisectionMethod(double x0, double x1, double error) {
        if (error < 0.05) {
            if (flag)
                return x0;
            return x1;
        }

        double xNew = getMid(x0, x1);
        updateIteration();
        if (getFunctionValue(xNew) < 0) {
            error = getError(xNew, x0);
            flag = true;
            return bisectionMethod(xNew, x1, error);
        } else {
            error = getError(xNew, x1);
            flag = false;
            return bisectionMethod(x0, xNew, error);
        }
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

        double root = bisectionMethod(x0, x1, 1);

        System.out.println();
        System.out.println("Root of the equation is : " + root);
        System.out.println("Functional value at " + root + " is : " + getFunctionValue(root));
        System.out.println("No of Iteration is : " + getIteration());
    }
}
