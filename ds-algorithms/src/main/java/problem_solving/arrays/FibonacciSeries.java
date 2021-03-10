package problem_solving.arrays;

// 509

public class FibonacciSeries {

    int sum;

    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        sum = fib(n-1) + fib(n-2);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciSeries().fib(2));
        System.out.println(new FibonacciSeries().fib(3));
        System.out.println(new FibonacciSeries().fib(5));
        System.out.println(new FibonacciSeries().fib(6));
    }
}
