package problem_solving.memoization;

public class FibonacciSeries {

    public static void main(String[] args) {

        System.out.println(new FibonacciSeries().fib(4));
        System.out.println(new FibonacciSeries().fib(5));
        System.out.println(new FibonacciSeries().fib(6));
        System.out.println(new FibonacciSeries().fib(7));
        System.out.println(new FibonacciSeries().fib(8));

    }

    public int fib(int n) {
        return fib(n, new int[n+1]);
    }

    private int fib(int n, int[] cache){
        if (n==0 || n==1) return n;
        if (cache[n]!=0) return cache[n];

        int result = fib(n-1, cache) + fib(n-2, cache);
        cache[n] = result;
        return result;
    }
}
