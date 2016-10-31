/**
 * Created by Krishna Nikhil Vedurumudi on 18/06/16.
 */
public class PowerSet {
    public static void main(String args[]) {
        String s = "abcd";

        int index = 1;
        printPowerSet(s);
    }

    /*
    Prints the possible combinations of the String  (the power set) using iteration...
     */
    private static void printPowerSet(String s) {
        int length = s.length();

        int totalCombinations = (int)Math.pow(2, length);
        System.out.println("{}");
        for(int i = 1; i < totalCombinations; i++) {

            int x = 1;
            for(int j= 0; j < length; j++) {
                if((i & x) != 0) {
                    System.out.print(s.charAt(j)+" ");
                }
                x = x << 1;
            }
            System.out.print("\n");
        }
    }

}
