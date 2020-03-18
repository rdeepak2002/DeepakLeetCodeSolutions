import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    // Runner
    public static void main(String[] args) {
        Main main = new Main();

        // Problem 1
        System.out.println("\n\n\nProblem 1:");
        int[] solution1 = main.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(solution1));

        // Problem 2
        System.out.println("\n\n\nProblem 2:");
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(main.addTwoNumbers(l1, l2));

    }

    // Problem 1
    /*
    * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    * You may assume that each input would have exactly one solution, and you may not use the same element twice.
    * */
    public int[] twoSum(int[] nums, int target) {
        // Better Solution, O(n):
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

        // My Solution, O(n^2):
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

    // Problem 2
    /*
    * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    * */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public String toString() {
            String result = "" + val + " -> ";
            ListNode temp = next;
            while(temp != null) {
                result += temp.val + " -> ";
                temp = temp.next;
            }
            result += "null";
            return  result;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Better Solution:
        ListNode ret = new ListNode(0);
        ListNode opr = ret;

        int sum = 0;

        while(l1 != null || l2 != null || sum != 0){
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            opr.next = new ListNode(sum%10);
            sum = sum/10;
            opr = opr.next;
        }

        return ret.next;

        // My Solution:
        /*
        int digit = 1;
        int remainder = 0;

        ListNode result = new ListNode(0);
        ListNode head = result;

        while(l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;

            if(l1 != null) {
                val1 = l1.val;
            }

            if(l2 != null) {
                val2 = l2.val;
            }

            int sum = (val1 + val2 + remainder)%10;

            remainder = (val1 + val2 + remainder)/10;

            if(digit == 1) {
                result = new ListNode(sum);
                head = result;
            }
            else {
                head.next = new ListNode(sum);
                head = head.next;
            }

            digit++;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(remainder != 0) {
            head.next = new ListNode(remainder);
        }

        return result;
        */
    }

}
