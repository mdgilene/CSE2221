import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newton3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error e%.
     *
     * @param x
     *            number to compute the square root of, x > -1
     * @param e
     *            the error to which the result should be of the actual
     * @return estimate of square root
     */
    private static double sqrt(double x, double e) {
        if (x == 0) {
            return 0;
        }
        double guess = x / 2;
        double error = 100 * Math.abs((Math.pow(guess, 2) - x)) / x;
        while (error > e) {
            guess = (guess + x / guess) / 2;
            error = 100 * Math.abs((Math.pow(guess, 2) - x)) / x;
        }
        return guess;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        String answer = "n";
        out.println("Enter the desired error % threshold:");
        double error = in.nextDouble();
        do {
            //ask the user for a positive number to calculate the root of.
            out.println("Enter the number you wish to calculate the root of...");
            double number = in.nextDouble();
            out.println("Root: " + sqrt(number, error));
            out.println("Actual: " + Math.sqrt(number));
            //ask if user would like to run the program again.
            out.println("Would you like to calculate another root? (y=yes,n=no)");
            answer = in.nextLine();
        } while (answer.equals("y"));

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
