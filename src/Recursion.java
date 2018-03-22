import java.util.ArrayList;
import java.util.List;

/**
 * This project have the 2 methods
 * 1.unique method use to make a list that contain string to be unique.
 * 2.fibonacci method use to calculate the fibonacci value.
 * @author Thanakrit Daowrueang.
 */
public class Recursion {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        System.out.println("Size of list: " + list.size());
        System.out.println("Unique of list: " + unique(list));

        System.out.println("Slow fibonacci: " + fibonacci(5));
        System.out.println("Fast fibonacci: " + fastFibonacci(5, 0, 0, 0));
        System.out.println("Binet fibonacci: " + binetFibonacci(5));
    }

    /**
     * This use to make a list not contain the duplicate string.
     *
     * @param list of string use to make it unique.
     * @return the list of unique of each string.
     */
    public static List unique(List<String> list) {
        if (list.size() <= 1) return list;
        if (list.get(0).equals(list.get(1))) {
            list.remove(0);
            unique(list);
        } else unique(list.subList(1, list.size()));
        return list;
    }

    /**
     * This use to calculate fibonacci value.
     *
     * @param n the sequence of fibonacci value.
     * @return the value of fibonacci.
     */
    public static long fibonacci(int n) {
        // the base case
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // the recursive step
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * This use to calculate fibonacci value in the fast way.
     *
     * @param n         the squence of fibonacci.
     * @param result    the value of first plus second number.
     * @param firstNum  the first number to start.
     * @param secondNum the number of fibonacci next from the first number.
     * @return the value of fibonacci.
     */
    public static long fastFibonacci(int n, long result, long firstNum, long secondNum) {
        if (n == 0) return result;
        if (firstNum == 0 && secondNum == 0) result = 1;
        else {
            result = firstNum + secondNum;
        }
        secondNum = firstNum;
        firstNum = result;
        return fastFibonacci(n - 1, result, firstNum, secondNum);
    }


    /**
     * This use to calculate fibonacci value with the formula.
     * @param n the squence of fibonacci.
     * @return the value of fibonacci.
     */
    public static long binetFibonacci(int n) {
        double Phi = (Math.sqrt(5) + 1);
        double fiveSqrt = Math.sqrt(5);
        return (long) ((Math.pow(Phi / 2, n) - Math.pow(-((Phi - 2) / 2), n)) / fiveSqrt);
    }


}
