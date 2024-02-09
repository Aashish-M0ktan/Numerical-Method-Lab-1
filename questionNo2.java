import java.util.Scanner;

public class questionNo2 extends Iterator {

    public static double getFunctionValue(double x) {
        // update the equation here
        return (Math.sin(x) - 2 * x + 1);
    }

    public static double getDerivativeValue(double x) {
        // update the derivative of the above equation here
        return (Math.cos(x) - 2);
    }

    public static double getNewValue(double x) {
        return (x - (getFunctionValue(x) / getDerivativeValue(x)));
    }

    public static double getError(double xNew, double xOld) {
        return Math.abs((xNew - xOld) / xNew);
    }

    public static double newtonRapsonMethod(double x, double error) {
        if (error <= 0.05) {
            updateIteration();
            return x;
        }

        double xNew = getNewValue(x);
        updateIteration();
        return newtonRapsonMethod(xNew, getError(xNew, x));
    }

    public static void main(String[] args) {
        System.out.println();

        Scanner inp = new Scanner(System.in);

        System.out.print("Enter a point : ");
        double x = inp.nextDouble();
        System.out.println();

        double root = newtonRapsonMethod(x, getError(getNewValue(x), x));

        System.out.println("Root of the equation is : " + root);
        System.out.println("Function value at " + root + " is : " + getFunctionValue(root));
        System.out.println("Number of Iteration is : " + getIteration());
    }
}
