package problem_solving.hash_tables;

// 811 - https://leetcode.com/problems/subdomain-visit-count/

import java.util.*;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String domainCount: cpdomains){
            String[] domainCountArray = domainCount.split(" ");
            int count = Integer.parseInt(domainCountArray[0]);
            String domain = domainCountArray[1];
            int counter = 0;
            for (int i=0; i<domain.length(); i++)
                if (domain.charAt(i) == '.')
                    counter++;
            while (counter >= 0){
                String input[] = domain.split("\\.", counter);
                System.out.println(Arrays.toString(input));
                String item = input[input.length-1];
                System.out.println(item);
                if (!map.containsKey(item)){
                    map.put(item, count);
                }
                else{
                    map.put(item, map.get(item)+count);
                }
                counter--;
            }
        }
        for (String input: map.keySet()){
            result.add(map.get(input) + " " + input);
        }
        return result;
    }

    public static void main(String[] args) {

//        System.out.println(new SubdomainVisitCount().subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
        System.out.println(new SubdomainVisitCount().subdomainVisits(new String[] {"900 google.mail.com",
                "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));

    }
}
