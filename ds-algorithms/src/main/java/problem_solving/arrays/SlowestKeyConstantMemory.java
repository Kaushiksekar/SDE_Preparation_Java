package problem_solving.arrays;

// 1629  - without using any hashmap, with just two variables

public class SlowestKeyConstantMemory {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = -1;
        char biggestChar = '0';
        for (int i=0; i<releaseTimes.length; i++){
            if (i==0){
                maxDuration = releaseTimes[i];
                biggestChar = keysPressed.charAt(i);
            }
            else{
                if (releaseTimes[i] - releaseTimes[i-1] >= maxDuration){
                    if (releaseTimes[i] - releaseTimes[i-1] == maxDuration){
                        if (biggestChar < keysPressed.charAt(i)){
                            biggestChar = keysPressed.charAt(i);
                        }
                    }
                    else{
                        biggestChar = keysPressed.charAt(i);
                    }
                    maxDuration = releaseTimes[i] - releaseTimes[i-1];
                }
            }
        }
        return biggestChar;
    }

    public static void main(String[] args) {
        System.out.println(new SlowestKeyConstantMemory().slowestKey(new int[] {12,23,36,46,62}, "spuda"));
    }

}
