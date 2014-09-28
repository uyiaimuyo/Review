import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        
        HashMap<Integer,Integer> num_to_index = new HashMap<Integer,Integer>();
        for (int i=0; i<numbers.length; i++) {
            num_to_index.put(numbers[i],i);    
        }
        int[] r = new int[2];
        for (int i=0; i<numbers.length; i++) {
            if (num_to_index.containsKey(target - numbers[i])) {
                r[0] = i+1;
                r[1] = num_to_index.get(target - numbers[i]) + 1;
                if (num_to_index.get(target - numbers[i]) != i)
                    break;
            }
        }
        return r;
    }
}
