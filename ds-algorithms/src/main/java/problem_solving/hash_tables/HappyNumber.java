package problem_solving.hash_tables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            System.out.println(set);
            set.add(n);
            int sum = 0;
            while(n > 0){
                int denominator = n % 10;
                n = n / 10;
                sum += denominator * denominator;
            }
            n = sum;
        }
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}
