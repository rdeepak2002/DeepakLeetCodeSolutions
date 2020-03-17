import java.util.Arrays;
import java.util.HashMap;

public class Main {
    // Runner
    public static void main(String[] args) {
        Main main = new Main();

        // Problem 1
        int[] solution1 = main.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(solution1));


    }

    // Problem 1
    public int[] twoSum(int[] nums, int target) {
        // O(n):
        if(nums == null || nums.length < 2) {
            return new int[]{0, 0};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            else {
                map.put(target-nums[i], i);
            }
        }

        return new int[]{0, 0};

        //O(n^2):
        /*
        for(int i = 0; i < nums.length; i++) {
            for(int k = 0; k < nums.length; k++) {
                if(i!=k && nums[i]+nums[k] == target) {
                    return new int[]{i, k};
                }
            }
        }

        return new int[]{-1, -1};
        */
    }


}
