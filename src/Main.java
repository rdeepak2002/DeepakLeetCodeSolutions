import java.util.*;

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

        // Problem 11
        System.out.println("\n\n\nProblem 11:");
        System.out.println(main.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

        // Problem 12
        System.out.println("\n\n\nProblem 12:");
        System.out.println(main.intToRoman(1994));

        // Problem 13
        System.out.println("\n\n\nProblem 13:");
        System.out.println(main.romanToInt("MCMXCIV"));

        // Problem 14
        System.out.println("\n\n\nProblem 14:");
        System.out.println(main.longestCommonPrefix(new String[]{"flower","flow","flight"}));

        // Problem 15
        System.out.println("\n\n\nProblem 15:");
        System.out.println(main.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));

        // Problem 16
        System.out.println("\n\n\nProblem 16:");
        System.out.println(main.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));

        // Problem 17
        System.out.println("\n\n\nProblem 17:");
        System.out.println(main.letterCombinations("23"));

        // Problem 18
        System.out.println("\n\n\nProblem 18:");
        System.out.println(main.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

        // Problem 19
        System.out.println("\n\n\nProblem 19:");
        ListNode l19 = new ListNode(1);
        l19.next = new ListNode(2);
        //l19.next.next = new ListNode(3);
        //l19.next.next.next = new ListNode(4);
        //l19.next.next.next.next = new ListNode(5);
        System.out.println(main.removeNthFromEnd(l19, 1));
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

        // Deals with weird patterns like a*b* or a*b*c* wherein anything can pass∂
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

    // Problem 11 (Medium)
    /* Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
     * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
     * with x-axis forms a container, such that the container contains the most water.
     * Note: You may not slant the container and n is at least 2.
     */
    /*
    // My solution:
    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int maxArea = 0;

        for(int i = 0; i < height.length; i++) {
            for(int j = 0; j < height.length; j++) {
                int tempHeight = Math.min(height[i], height[j]);
                int width = j-i;
                maxArea = Math.max(maxArea, tempHeight*width);
            }
        }

        return maxArea;
    }
    */
    // Best solution:
    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int maxArea = 0;

        int l = 0;
        int r = height.length-1;

        while(l!=r) {
            int area = Math.min(height[l],height[r])*(r-l);
            maxArea = Math.max(area, maxArea);
            if(height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return maxArea;
    }

    // Problem 12 (Medium)
    /* Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     */
    // My solution:
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String roman = "";

        for(int i = 0; i < values.length; i++) {
            while(num >= values[i]) {
                roman += romanLiterals[i];
                num -= values[i];
            }
        }

        return roman;
    }

    // Problem 13 (Easy)
    /* Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     */
    // My solution:
    public int romanToInt(String s) {
        int[] values = {900,1000,400,500,90,100,40,50,9,10,4,5,1};
        String[] romanLiterals = {"CM", "M","CD","D","XC","C","XL","L","IX","X","IV","V","I"};

        int result = 0;

        while (s.length() > 0) {
            boolean found = false;
            int i = 0;
            while(!found) {
                if(s.indexOf(romanLiterals[i]) == 0) {
                    s = s.substring(romanLiterals[i].length());
                    result += values[i];
                    found = true;
                }
                i++;
            }
        }

        return result;
    }

    // Problem 14 (Easy)
    /* Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     */
    // My solution:
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // Problem 15 (Medium)
    /* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
     * triplets in the array which gives the sum of zero.
     * Note:
     * The solution set must not contain duplicate triplets.
     */
    // My solution (but time limit exceeded):
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for(int num : nums) {
            numList.add(num);
        }

        for(int i = 0; i < numList.size(); i++) {
            for(int j = i+1; j < numList.size() && j!=i; j++) {
                int sum = numList.get(i) + numList.get(j);
                int k = numList.lastIndexOf(0-sum);

                if(k > j && numList.get(k)+sum == 0) {
                    ArrayList<Integer> tempSol = new ArrayList<>();
                    tempSol.add(numList.get(i));
                    tempSol.add(numList.get(j));
                    tempSol.add(numList.get(k));

                    if(!set.contains(tempSol)) {
                        ans.add(tempSol);
                        set.add(tempSol);
                    }
                }
            }
        }

        return ans;
    }
    */
    // Better solution:
    public List<List<Integer>> threeSum(int[] nums) {

        /*
        Approach: Sort the array. Have a set of list of integers (threeSumSet), to store three sum cobos.
                  Go through each item (i). For each item, have two pointers: one pointing to the next item (j), and another
                  one pointing to the end of the array (k). Now, do a 2-way-sweep. While j and k doesn't meet, at each step
                  calculate sum = (nums[i]+nums[j]+nums[k]).
                  [Starting sweep from next item to prevent duplicate combos because of indexes like ( [i,j,k], [j,i,k]).]
                  If sum == 0, we found a three-sum combo! Add it to the threeSumSet. If there is any
                  duplicate combo because of different indexes but same items like
                  ([i1, j1, k1], [i2, j2, k2], but i1==i2, j1==j2, k1==k2). This will automatically be taken care of by the
                  set, as it analyzes the added Lists and makes sure there is no duplicate.
                  If sum > 0, we should try decreasing the sum value. So we'll decrement k, as this should potentially
                  result nums[k] being smaller than previous value, as the array is sorted.
                  If sum < 0, because of the same reason, we'll increment j.
                  Finally, we'll convert the threeSumSet to ArrayList and return.

        Complexity analysis: Time: O(n^2), Space: O(n)
        */

        Set<List<Integer>> threeSumSet  = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2;i++){                         //Doing length-2, because we want two elems j and k after i.
            int j =i+1;

            int k = nums.length-1;

            while(j<k){

                int sum = nums[i]+nums[j]+nums[k];

                if(sum==0){
                    threeSumSet.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                }
                else if (sum > 0){
                    k--;
                }
                else if (sum < 0){
                    j++;
                }
            }

        }

        return new ArrayList<>(threeSumSet);
    }

    // Problem 16 (Medium)
    /* Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
     * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     */
    // My solution:
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long minSum = Integer.MAX_VALUE;

        for(int i=0; i<nums.length-2;i++){                         //Doing length-2, because we want two elems j and k after i.
            int j =i+1;

            int k = nums.length-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(Math.abs(target-sum) < Math.abs(target-minSum)) {
                    minSum = sum;
                }

                if(sum==target){
                    j++;
                    k--;
                    return sum;
                }
                else if (sum > target){
                    k--;
                }
                else if (sum < target){
                    j++;
                }
            }
        }

        return (int)minSum;
    }

    // Problem 17 (Medium)
    /* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
     * could represent. A mapping of digit to letters (just like on the telephone buttons) is given below. Note that
     * 1 does not map to any letters.
     */
    // Better solution:
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        if(digits.length() != 0) {
            branchOut(answer, phone, digits, "");
        }

        return answer;
    }

    public void branchOut(List<String> answer, Map<String, String> phone, String digits, String combination) {
        if(digits.length() == 0) {
            answer.add(combination);
        }
        else {
            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);
            digits = digits.substring(1);

            for(int i = 0; i < letters.length(); i++) {
                branchOut(answer, phone, digits, combination + letters.charAt(i));
            }
        }
    }

    // Problem 18 (Medium)
    /* Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
     * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     * Note:
     * The solution set must not contain duplicate quadruplets.
     */
    // My solution (time limit exceeds):
    /*
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for(int num : nums) {
            numList.add(num);
        }

        for(int i = 0; i < numList.size(); i++) {
            for(int j = i+1; j < numList.size() && j!=i; j++) {
                for(int l = j+1; l < numList.size() && l!=j && l!=i; l++) {
                    int sum = numList.get(i) + numList.get(j) + numList.get(l);
                    int k = numList.lastIndexOf(target-sum);

                    if(k > l) {
                        ArrayList<Integer> tempSol = new ArrayList<>();
                        tempSol.add(numList.get(i));
                        tempSol.add(numList.get(j));
                        tempSol.add(numList.get(l));
                        tempSol.add(numList.get(k));

                        if(!set.contains(tempSol)) {
                            ans.add(tempSol);
                            set.add(tempSol);
                        }
                    }
                }
            }
        }

        return ans;
    }
    */
    // Better solution:
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        find(0, target, new ArrayList<>(), nums, result);
        return result;
    }

    private void find(int fromIndx, int balance, List<Integer> currentNums, int[] nums, List<List<Integer>> result)
    {
        for(int i=fromIndx; i<nums.length; i++)
        {
            if(currentNums.size() == 3)
            {
                // Just need the last one, so find remaining balance from the rest of numbers
                if(nums[i] == balance) {
                    List<Integer> newCurrentNums = new ArrayList<>(currentNums);
                    newCurrentNums.add(nums[i]);
                    Collections.sort(newCurrentNums);
                    if(!result.contains(newCurrentNums))
                        result.add(newCurrentNums);
                    return;
                }
            }
            else {
                List<Integer> newCurrentNums = new ArrayList<>(currentNums);
                newCurrentNums.add(nums[i]);
                find(i+1, balance-nums[i], newCurrentNums, nums, result);
            }
        }
    }

    // Problem 19 (Medium)
    /* Given a linked list, remove the n-th node from the end of list and return its head.
     */
    // My solution:
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            return null;
        }
        else if(n<=0) {
            return head;
        }
        else {
            ListNode cur = head.next;

            ListNode start = head;
            ListNode end = cur.next;

            while(isNthLast(cur, n) == 0) {
                start = start.next;
                cur = cur.next;
                end = end.next;
            }

            if(isNthLast(cur, n) == 2) {
                return head.next;
            }

            //System.out.println(cur);

            start.next = end;
        }

        return head;
    }

    public int isNthLast(ListNode cur, int n) {
        for(int i = 0; i < n; i++) {
            if(cur.next == null && i!=n-1) {
                return 2;
            }
            cur = cur.next;
        }
        return (cur==null) ? 1 : 0;
    }

    // Problem 20 (Easy)
    /* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
     * valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     */
    // My solution:
    
}

