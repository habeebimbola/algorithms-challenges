package org.example;

import java.util.*;

/**
 * @Author Habeeb Animashaun
 * email: habeebimbola@yahoo.com
 * Data Structure And Algorithm Exercises
 *
 * */
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
        int[] ints = {3, 8, 9, 7, 6}, nums ={3,4,4,6,1,4,4};
//        practiseTest.cyclicRotate(ints, 3);
//        practiseTest.maxCounter(5,nums );
//        practiseTest.permMissingElement(nums);
        String sentence = "There are two black birds sitting on a wall One " +
                          "named Peter One named Paul Fly Away Peter Fly Away Paul";
        practiseTest.fixedWidth(sentence, 3);
    }

    public void fixedWidth(String words, int width){

        String[] wordTokens = words.split("\\s+");
        int wordLength = wordTokens.length, line = 1;

        while ( line <= wordLength){

            System.out.print(wordTokens[line - 1] +" ");
            if ( line % width == 0 ){
                System.out.println();
            }

            line++;
        }




    }

    public int[] cyclicRotate(int[] nums, int i) {
        int[] result = new int[nums.length];
        int size = nums.length, temp = 0, swap = 0;

        while ( i > 0) {
            for (int index = 0; index < size; index++) {

                if (index == 0) {
                    temp = nums[index];
                    nums[index] = nums[size - 1];
                }

                if (index > 0 ) {
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


        for (int index = 0;index < nums.length; index++)
        {
            if (numSet.contains( nums[index])){
                numSet.remove(nums[index]);
            }else
            {
                numSet.add(nums[index]);
            }
        }

        if (!numSet.isEmpty()){
            result = numSet.stream().findFirst().get();
        }



        return  result;
    }

    public boolean matchedBrackets(String input) {
        boolean isValid = false;

        Stack<Character> characterStack = new Stack<>();

        for (int index = 0; index < input.length(); index++){
            char ch = input.charAt(index);

            if (ch == '{' || ch == '[' || ch == '('){
                characterStack.push(ch);
            }else if ( characterStack.isEmpty()){
                return isValid;
            }else{

                char top = characterStack.peek();

                if( ch == '}' && top == '{' ) {
                    characterStack.pop();
                }
                if( ch == ']' && top == '['){
                    characterStack.pop();
                }
                if ( ch == ')' && top == '('){
                    characterStack.pop();
                }

            }
        }

        if( characterStack.isEmpty()){
            isValid = true;
        }


        return isValid;
    }

    public int permMissingElement(int[] nums) {
        int missing = 1, size = nums.length;

        Arrays.sort(nums);
        for (int index = 0; index < size; index++){
            if(missing == nums[index]){
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

        for (int index = 1; index < size; index++){
            sum1 += A[index];
        }
        minimum = Math.abs(sum1 - sum2);

        for (int index = 0; index < size - 1; index++){
            sum2 += A[index];
            sum1 -= A[index];

             minimum = Math.min( Math.abs(sum1 - sum2), minimum);

        }

        return minimum;
    }


    public int[] maxCounter(int input, int[] operations) {
        int[] result = new int[input];
        int max = 0;

        for (int index = 0; index < operations.length; index++){
            if (operations[index] <= input && operations[index] >= 1){
                result[operations[index] - 1 ] += 1;

                if (result[operations[index] - 1] > max){
                    max = result[operations[index] - 1];
                }
            };

            if(operations[index] == (input + 1)){
               Arrays.fill(result,max);
            }
        }

        return result;
    }

    public int missingInteger(int[] nums) {
        int missing = 1, size = nums.length;

        if (size == 1 && nums[size - 1] > 1){
            return missing;
        }

        Arrays.sort(nums);

        if (nums[size - 1] < 1){
            return missing;
        }

        for (int index = 0; index < size; index++){

            if(missing == nums[index]){
                missing++;
            }
        }

        return missing;
    }

    public int distinctCount(int[] nums) {
        int count = 0;

        Set<Integer> integerSet = new HashSet<>();

        for (int index = 0; index < nums.length; index++){
            integerSet.add(nums[index]);
        }
        count = integerSet.size();

        return  count;

    }

    public int longestSubstringSize(String input) {
        int longest = 0, counter = 0;

        Map<Character, Integer> charsMap = new HashMap<>();

        for (int index = 0; index < input.length(); index++){
            char ch = input.charAt(index);

            if(charsMap.containsKey(ch)) // Character already exists, so increase it's frequency
            {
                counter = charsMap.get(ch)  + 1;
                charsMap.put(ch, counter);
            }else { // Beginning To Track New Character
                charsMap.put(ch, 1);
            }
        }
        for (Character ch : charsMap.keySet()){
            if (longest < charsMap.get(ch)){
                longest = charsMap.get(ch);
            }
        }

        return longest;
    }
}
