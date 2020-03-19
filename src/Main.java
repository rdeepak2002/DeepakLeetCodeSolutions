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

        // Problem 5
        System.out.println("\n\n\nProblem 5:");
        System.out.println(main.longestPalindrome("baad"));

        // Problem 6
        System.out.println("\n\n\nProblem 6:");
        System.out.println(main.convert("PAYPALISHIRING", 4));

        // Problem 7
        System.out.println("\n\n\nProblem 7:");
        System.out.println(main.reverse(-1234));

        // Problem 8
        System.out.println("\n\n\nProblem 8:");
        System.out.println(main.myAtoi("3.14159"));

        // Problem 9
        System.out.println("\n\n\nProblem 9:");
        System.out.println(main.isPalindrome(121));

        // Problem 10
        System.out.println("\n\n\nProblem 10:");
        System.out.println(main.isMatch("aa", "a*"));
    }

    // Problem 1 (Easy)
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

    // Problem 2 (Medium)
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

    // Problem 3 (Medium)
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

    // Problem 4 (Hard)
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
                // Now get max of left elements and min of right elements to get the median in case of even
                // length combined array size or get max of left for odd length combined array size.
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

    // Problem 5 (Medium)
    /* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     */
    // Good solution:
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        if(s.length() < 1) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            int len1 = maxPalindrome(s, i, i);
            int len2 = maxPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end+1);
    }

    public int maxPalindrome(String s, int L, int R) {
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    // Problem 6 (Medium)
    /* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * string convert(string s, int numRows);
     */
    // My solution:
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        String result = "";

        String[] rows = new String[numRows];

        boolean goingDown = false;
        int curRow = 0;

        for(int i = 0; i < s.length(); i++) {
            if(rows[curRow] == null) {
                rows[curRow] = "";
            }
            rows[curRow] += s.charAt(i);
            if(curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            if(goingDown) {
                curRow++;
            }
            else {
                curRow--;
            }
        }

        for (String row : rows) {
            if(row != null)
                result += row;
        }

        return result;
    }

    // Problem 7 (Easy)
    /* Given a 32-bit signed integer, reverse digits of an integer.
     */
    // My attempt:
    /*
    public int reverse(int x) {
        String result = "";
        String num = Integer.toString(Math.abs(x));

        for(int i = num.length()-1; i >= 0; i--) {
            result+=num.charAt(i);
        }

        if(x < 0) {
            return -1*Integer.parseInt(result);
        }

        return Integer.parseInt(result);
    }
     */
    // My later optimal solution:
    public int reverse(int x) {
        long rev = 0;

        while(x!=0) {
            rev = rev*10 + x%10;

            x /= 10;
        }

        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)rev;
    }

    // Problem 8 (Medium)
    /* Implement atoi which converts a string to an integer.
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character
     * is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many
     * numerical digits as possible, and interprets them as a numerical value.
     * The string can contain additional characters after those that form the integral number, which are ignored and
     * have no effect on the behavior of this function.
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
     * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     * If no valid conversion could be performed, a zero value is returned.
     *
     * Note:
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
     * [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or
     * INT_MIN (−231) is returned.
     */
    // My solution:
    public int myAtoi(String str) {
        char c[] = str.toCharArray();
        int i = 0;
        int n = c.length;
        //Remove whitespace
        while (i < n && c[i] == ' ') {
            i++;
        }
        //Handle sign
        int sign = 1;
        if(i < n && (c[i] == '+' || c[i] == '-')) {
            sign = c[i] == '+' ? 1: -1;
            i++;
        }

        //Get the number
        long num = 0;
        int d;
        while(i<n) {
            d = c[i] - '0';
            if(d < 0 || d > 9)
                break;
            num = num * 10 + d;
            if(num*sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if(num*sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            i++;

        }
        return (int)num*sign;
    }

    // Problem 9 (Easy)
    /* Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     */
    // My solution:
    public boolean isPalindrome(int x) {
        int orig = x;
        int rev = 0;

        while(x != 0) {
            rev = rev*10+x%10;
            x /= 10;
        }

        return rev == Math.abs(orig);
    }

    // Problem 10 (Hard)
    /* Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * Note:
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like . or *.
     */
    // Best solution (https://youtu.be/l3hda49XcDE):
    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] T = new boolean[text.length+1][pattern.length+1];

        T[0][0] = true;

        // Deals with weird patterns like a*b* or a*b*c* wherein anything can pass
        for(int i = 1; i < T[0].length; i++) {
            if(pattern[i-1] == '*') {
                T[0][i] = T[0][i-2];
            }
        }

        for(int i = 1; i < T.length; i++) {
            for(int j = 1; j < T[i].length; j++) {
                if(pattern[j-1] == '.' || pattern[j-1] == text[i-1]) {
                    T[i][j] = T[i-1][j-1];
                }
                else if(pattern[j-1] == '*') {
                    T[i][j] = T[i][j-2];
                    if(pattern[j-2] == '.' || pattern[j-2] == text[i-1]) {
                        T[i][j] = T[i][j] || T[i-1][j];
                    }
                }
                else {
                    T[i][j] = false;
                }
            }
        }

        return T[text.length][pattern.length];
    }
}
