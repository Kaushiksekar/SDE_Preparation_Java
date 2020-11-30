package problem_solving.main;

import java.util.*;

public class Example {

    public static void main(String[] args) {

//        List<Integer> a = new Example().getOne();
//        a.stream().forEach(integer -> System.out.println(integer));
//
//        Map<Integer, Integer> b = new HashMap<>();
//        for (Map.Entry<Integer, Integer> bEn: b.entrySet()){
//
//        }

        System.out.println(new Example().getAnagramString("tea"));

        new ArrayList<ArrayList<String>>();

        List<Integer> a =new ArrayList<>();
        a.add(1);
        System.out.println("******");
        System.out.println(a.indexOf(2));


    }

    public String getAnagramString(String item){
        char[] characterArray = item.toCharArray();
        Arrays.sort(characterArray);
        return new String(characterArray);
    }

    public List<Integer> getOne(){
        List<Integer> b = new ArrayList<>();
        getTwo(b);
        return b;
    }

    public void getTwo(List<Integer> a){
        a.add(1);
    }

}
