/**
 * Created by Krishna Nikhil Vedurumudi on 21/06/16.
 */

import java.util.ArrayList;

public class MatrixPrettyPrint {
    
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();

        int minValue = a - 1;

        //for firstRow add complete row
        ArrayList<Integer> row = new ArrayList<Integer>();

        for(int i = 0; i < 2 * a - 1; i++) {
            row.add(a);
        }

        output.add(row);
        for(int i = 1; i < 2 * a - 2; i++) {

            row = new ArrayList<Integer>();
            //add max value at zeroth position
            int j = 0;
            int temp = a;
            for(; j < a; j++) {
                if(temp == minValue) {
                    row.add(temp);
                } else {
                    row.add(temp);
                    temp -= 1;
                }
            }

            for(; j < a + minValue - 1; j++) {
                row.add(minValue);
            }

            for(; j < 2 * a - 1; j++) {
                temp += 1;
                row.add(temp);
            }

            output.add(row);

            if(i < a - 1) {
                minValue -= 1;
            } else {
                minValue += 1;
            }
        }

        row = new ArrayList<Integer>();
        if(a > 1) {
            for(int i = 0; i < 2 * a - 1; i++) {
                row.add(a);
            }
            output.add(row);
        }


        return output;
    }
}
