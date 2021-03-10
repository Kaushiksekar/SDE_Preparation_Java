package problem_solving.dynamic_programming;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(new FibonacciSeries().fib(4));
        System.out.println(new FibonacciSeries().fib(5));
        System.out.println(new FibonacciSeries().fib(6));
        System.out.println(new FibonacciSeries().fib(7));
        System.out.println(new FibonacciSeries().fib(8));
    }

    public int fib(int n) {
        if (n == 0 || n==1) return n;
        int[] cache = new int[n];
        cache[0] = 0; cache[1] = 1;
        for (int i=2; i<n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n-2] + cache[n-1];
    }
}
