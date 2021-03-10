package java_io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ScannerDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
//        for (int i=0; i<number; i++){
//            System.out.println(scanner.nextInt());
//        }
        System.out.println(number);
        scanner.nextLine();
        String line = scanner.nextLine();
        System.out.println(line);
        List<Integer> list = Arrays.stream(line.split("\\s")).map(String::trim)
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(list);


    }
}
