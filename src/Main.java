import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

        // Problem 3
        System.out.println("\n\n\nProblem 3:");
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));

        // Problem 4
        System.out.println("\n\n\nProblem 4:");
        System.out.println(main.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    // Problem 1
    /*
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */
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
     */
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

    // Problem 3
    /*
     * Given a string, find the length of the longest substring without repeating characters.
     */

    // Better solution:
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int length = s.length();
        int answer = 0;

        int i = 0;
        int j = 0;

        while(i < length && j < length) {
            if(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            else {
                answer = Math.max(answer, j-i+1);
                set.add(s.charAt(j));
                j++;
            }
        }

        return answer;
    }

    // My Solution:
    /*
    public boolean hasNoRepeats(int start, int end, String s) {
        Set<Character> set = new HashSet<>();

        for(int x = start; x < end; x++) {
            if(set.contains(s.charAt(x))) {
                return false;
            }

            set.add(s.charAt(x));
        }

        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLength = 0;

        for(int i = 0; i < length; i++) {
            for(int j = i+1; j <= length; j++) {

                if(hasNoRepeats(i, j, s)) {
                    maxLength = Math.max(maxLength, j-i);
                }
            }
        }

        return maxLength;
    }
    */

    // Problem 4
    /* There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * You may assume nums1 and nums2 cannot be both empty.
     */
    // Best solution:
    public double findMedianSortedArrays(int nums1[], int nums2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }
}
