package org.example;

import java.util.*;

import static java.util.Arrays.parallelSetAll;

/**
 * @Author Habeeb Animashaun
 * email: habeebimbola@yahoo.com
 * Data Structure And Algorithm Exercises
 */
public class AlgorithmChallengeTasks {
    public int smallestInt(int[] nums) {
        int smallest = 1, size = nums.length;

        if (size == 0) {
            return smallest;
        }

        Arrays.sort(nums);

        if (nums[size - 1] < 1) {
            return smallest;
        }


        for (int index = 0; index < size; index++) {
//            if(nums[index] <= (index + 1)) {
//                smallest = index + 1;
//            }
            if (smallest == nums[index]) {
                smallest++;
            } else if (nums[index] > smallest) {
                return smallest;
            }
        }
//        if (smallest == size) {
//            smallest++;
//        }

        return smallest;
    }

    public int longestBit(int number) {
        int longest = 0, zerosCount = 0;
        boolean startedCount = false;
        String numStr = Integer.toBinaryString(number);

        for (int index = 0; index < numStr.length(); index++) {
            char currentChar = numStr.charAt(index);

            if (currentChar == '1' && !startedCount) {
                startedCount = true;
            }

            if ((currentChar == '0') && (startedCount)) {
                zerosCount++;
            }

            if (startedCount && currentChar == '1') {
                if (longest < zerosCount) {
                    longest = zerosCount;
                }
                zerosCount = 0;
            }
        }

        return longest;
    }

    public static void main(String... args) {
        AlgorithmChallengeTasks practiseTest = new AlgorithmChallengeTasks();
        int[] ints = {-15 ,-7 ,-9 ,-14 ,-12}, nums = {3, 4, 4, 6, 1, 4, 4};
//        practiseTest.cyclicRotate(ints, 3);
//        practiseTest.maxCounter(5,nums );
//        practiseTest.permMissingElement(nums);
        practiseTest.closestTozero(ints);
        String sentence = "There are two black birds sitting on a wall One " +
                "named Peter One named Paul Fly Away Peter Fly Away Paul";
        practiseTest.fixedWidth(sentence, 3);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);integerList.add(5);

        for (int index: integerList){
//            integerList.add(6);
        }

//        Iterator iterator= integerList.iterator();
//
//        while (iterator.hasNext())
//        {
//            iterator.next();
//        }
        NodeList nodeList = new NodeList();

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        nodeList.addNode(first);
        nodeList.addNode(second);
        nodeList.addNode(third);
        nodeList.addNode(fourth);
        nodeList.addNode(fifth);

        Node parent = nodeList.getFirstNode();
        int count = 0;
        while (parent != null){
            System.out.println(parent.value);
            parent = parent.nextNode;
            count++;
        }
        System.out.println("Total Nodes "+count);

        nodeList.removeNth(0);

    }


    public void fixedWidth(String words, int width) {

        String[] wordTokens = words.split("\\s+");
        int wordLength = wordTokens.length, line = 1;

        while (line <= wordLength) {

            System.out.print(wordTokens[line - 1] + " ");
            if (line % width == 0) {
                System.out.println();
            }

            line++;
        }


    }

    public int[] cyclicRotate(int[] nums, int i) {
        int[] result = new int[nums.length];
        int size = nums.length, temp = 0, swap = 0;

        while (i > 0) {
            for (int index = 0; index < size; index++) {

                if (index == 0) {
                    temp = nums[index];
                    nums[index] = nums[size - 1];
                }

                if (index > 0) {
                    swap = nums[index];
                    nums[index] = temp;
                    temp = swap;
                }

            }
            i--;
        }
        for (int k : nums) {
            System.out.printf(" %d ", k);
        }
        return nums;
    }


    public int oddArrayOccurrence(int[] nums) {
        int result = 0;
        Set<Integer> numSet = new HashSet<>();


        for (int index = 0; index < nums.length; index++) {
            if (numSet.contains(nums[index])) {
                numSet.remove(nums[index]);
            } else {
                numSet.add(nums[index]);
            }
        }

        if (!numSet.isEmpty()) {
            result = numSet.stream().findFirst().get();
        }

        return result;
    }

    public boolean matchedBrackets(String input) {
        boolean isValid = false;

        Stack<Character> characterStack = new Stack<>();

        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);

            if (ch == '{' || ch == '[' || ch == '(') {
                characterStack.push(ch);
            } else if (characterStack.isEmpty()) {
                return isValid;
            } else {

                char top = characterStack.peek();

                if (ch == '}' && top == '{') {
                    characterStack.pop();
                }
                if (ch == ']' && top == '[') {
                    characterStack.pop();
                }
                if (ch == ')' && top == '(') {
                    characterStack.pop();
                }

            }
        }

        if (characterStack.isEmpty()) {
            isValid = true;
        }


        return isValid;
    }

    public int permMissingElement(int[] nums) {
        int missing = 1, size = nums.length;

        Arrays.sort(nums);
        for (int index = 0; index < size; index++) {
            if (missing == nums[index]) {
                missing = nums[index] + 1;
            }
        }

        return missing;

//Todo: Investigate solving the problem with a Map...
//        int missing = 1;
//        Map<Integer, Integer> numberMap = new HashMap<>();
//
//        for (int index = 0; index < nums.length; index++){
//            numberMap.put(nums[index], index + 1);
//        }
//
//        for (int index = 1; index <= nums.length; index++){
//            if (!numberMap.containsKey(index)){
//                return index;
//            }
//        }
//
//        return  missing;

    }


    public int tapeEquilibriumTest(int[] A) {
        int size = A.length, sum1 = 0, sum2 = A[0], minimum = 0;

        for (int index = 1; index < size; index++) {
            sum1 += A[index];
        }
        minimum = Math.abs(sum1 - sum2);

        for (int index = 0; index < size - 1; index++) {
            sum2 += A[index];
            sum1 -= A[index];

            minimum = Math.min(Math.abs(sum1 - sum2), minimum);

        }

        return minimum;
    }


    public int[] maxCounter(int input, int[] operations) {
        int[] result = new int[input];
        int max = 0;

        for (int index = 0; index < operations.length; index++) {
            if (operations[index] <= input && operations[index] >= 1) {
                result[operations[index] - 1] += 1;

                if (result[operations[index] - 1] > max) {
                    max = result[operations[index] - 1];
                }
            }
            ;

            if (operations[index] == (input + 1)) {
                Arrays.fill(result, max);
            }
        }

        return result;
    }

    public int missingInteger(int[] nums) {
        int missing = 1, size = nums.length;

        if (size == 1 && nums[size - 1] > 1) {
            return missing;
        }

        Arrays.sort(nums);

        if (nums[size - 1] < 1) {
            return missing;
        }

        for (int index = 0; index < size; index++) {

            if (missing == nums[index]) {
                missing++;
            }
        }

        return missing;
    }

    public int distinctCount(int[] nums) {
        int count = 0;

        Set<Integer> integerSet = new HashSet<>();

        for (int index = 0; index < nums.length; index++) {
            integerSet.add(nums[index]);
        }
        count = integerSet.size();

        return count;

    }

    public int longestSubstringSize(String input) {
        int longest = 0, counter = 0;

        Map<Character, Integer> charsMap = new HashMap<>();

        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);

            if (charsMap.containsKey(ch)) // Character already exists, so increase it's frequency
            {
                counter = charsMap.get(ch) + 1;
                charsMap.put(ch, counter);
            } else { // Beginning To Track New Character
                charsMap.put(ch, 1);
            }
        }
        for (Character ch : charsMap.keySet()) {
            if (longest < charsMap.get(ch)) {
                longest = charsMap.get(ch);
            }
        }

        return longest;
    }

    public double closestToZero(int[] items) {
        int size = items.length;

        if (size == 0) return 0;

        var closest = items[0];

        for (int index = 0; index < size; index++) {

            var number = items[index];
            var absNumber = Math.abs(number);
            var absClosest = Math.abs(closest);

            if (absNumber < absClosest) {
                closest = number;
            } else if (absNumber == absClosest && closest < 0) {
                closest = number;
            }

        }

        return closest;
    }

    public double closestTozero(int[] nums) {
        int size = nums.length;

        if (size == 0) {
            return 0;
        }

        Arrays.sort(nums);

        if (nums[0] < 0 && nums[size - 1] < 0) {
            return nums[size - 1];
        }

        int closest = nums[0];

        for (int index = 1; index < size; index++) {
            if (closest < 0 && nums[index] > 0) {
                closest = nums[index];
            } else if (closest > nums[index]) {
                closest = nums[index];
                return closest;
            }
        }

        return closest;
    }

    /*
     * abcabcbb
     * */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (!set.add(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
//            max = Math.max(max, right - left + 1);
            max = Math.max(max, set.size());
        }
        return max;
    }


    /*
     * pwwkew
     *
     * abcabcdbb
     *
     * dvdf
     * */
    public int longestString(String string) {

        int ans = 1;
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < string.length()) {
            if (set.contains(string.charAt(right))) {
                set.remove(string.charAt(left));
                left++;
            } else {
                set.add(string.charAt(right));
                right++;
                int sz = set.size();
                ans = Math.max(ans, sz);
            }
        }

        return ans;
    }

    //        int max = 0, left = 0, size = string.length();
//
//        Set<Character> characterSet = new HashSet<>();
//
//        for(int index = 0; index < size; index++){
//
////            while (!characterSet.add(string.charAt(index))){
////                characterSet.remove(string.charAt(left++));
////            }
//
//            if(characterSet.contains(string.charAt(index))){
//                characterSet.clear();
//                characterSet.add(string.charAt(index));
//            }else {
//                characterSet.add(string.charAt(index));
//            }
//
//            max = Math.max(max, characterSet.size());
//
//        }
//
//        return max;
//    }

    /**
     * aaabb
     */
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;

        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }

        return max;
    }

    public int longestSubstring2(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }
        int[] countMap = new int[26];
        int n = s.length();
        int result = 0;
        for (int start = 0; start < n; start++) {
            // reset the count map
            Arrays.fill(countMap, 0);
            for (int end = start; end < n; end++) {
                countMap[s.charAt(end) - 'a']++;
                if (isValid(s, start, end, k, countMap)) {
                    result = Math.max(result, end - start + 1);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s, int start, int end, int k, int[] countMap) {
        int countLetters = 0, countAtLeastK = 0;
        for (int freq : countMap) {
            if (freq > 0) countLetters++;
            if (freq >= k) countAtLeastK++;
        }
        return countAtLeastK == countLetters;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;

        for (int row = 0; row < size; row++) {
            for (int col = row + 1; col < size; col++) {
                if (col <= (size - 1) && (nums[row] + nums[col]) == target) {
                    result[row] = row;
                    result[col] = col;
                    return result;
                }
            }
        }

        return result;
    }

    public int[] twoSumMap(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int index = 0; index < nums.length; index++){

            int diff = target - nums[index];

            if(numMap.containsKey(diff)){
                result[0] = numMap.get(diff); result[1] = index;
                return result;
            }

            numMap.put(nums[index], index);
        }
        List<Integer> list = List.of(1,3,4,5);
        return result;
    }

    public int[] intersection(int[] nums1, int[] nums2){
        int counter = 0;
        Set<Integer> numsSet1 = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();

        for (int index = 0; index < nums1.length; index++){
             numsSet1.add(nums1[index]);
        }
        for (int index = 0; index < nums2.length; index++){
            if(numsSet1.contains(nums2[index])){
                resultList.add(nums2[index]);
                numsSet1.remove(nums2[index]);
            }
        }
        return resultList.stream().mapToInt(x -> x).toArray();

    }


    public boolean threeSumValue(int[] input, int target) {
        int size = input.length, low = 0, high = size - 1, sum = 0;

        Arrays.sort(input);

        for(int currentIndex = 0; currentIndex < size; currentIndex++) {

            low = currentIndex + 1;
            high = size - 1;

            while (low < high) {
                sum = input[currentIndex] + input[low] + input[high];

                if (sum == target) {
                    return true;
                }

                if (sum > target) {
                    high--;
                }
                if (sum < target) {
                    low++;
                }
            }
        }

        return  false;
    }

   static class Node{
        Integer value;
        Node nextNode;

       public Node(Integer value) {
           this.value = value;
       }
   }
  static  class NodeList{
        private Node firstNode;

      public boolean isEmpty(){
          return (firstNode == null);
      }
      public void addNode(Node node){

          if(isEmpty())
          {
             firstNode = new Node(node.value);
             return;
          }

          Node currentNode = firstNode;

          while (currentNode != null){
              currentNode = currentNode.nextNode;
          }
          currentNode = node;
//          currentNode.nextNode = firstNode;
//          firstNode = currentNode;


          currentNode = firstNode;
          firstNode = node;
          firstNode.nextNode = currentNode;

        }

      public Node getFirstNode() {
          return firstNode;
      }

      public void removeNth(int position){

          Node pointer = firstNode;

          while (position >= 1){
              pointer = pointer.nextNode;
              position--;
          }
          
      }
  }





}

