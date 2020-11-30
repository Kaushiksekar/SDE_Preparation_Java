package problem_solving.dynamic_programming;

public class DecodeWays {

    public int numDecodings(String s) {
        int result = 0;
        for (int i=0; i<s.length(); i++){
            try{
                int first = Integer.parseInt(s.substring(0, i));
                System.out.println("First " + first);
                if (first < 27)
                    result += 1;
            }
            catch (Exception e){

            }
            try{
                int second = Integer.parseInt(s.substring(i+1));
                System.out.println("Second " + second);
                if (second < 27)
                    result += 1;
            }
            catch (Exception e){

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("226"));
    }
}
