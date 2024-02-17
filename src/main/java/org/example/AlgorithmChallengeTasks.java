package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
        practiseTest.longestBit(1041);
        int[] ints = {3, 8, 9, 7, 6}, nums ={1, 2,3,4};
        practiseTest.cyclicRotate(nums, 4);
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
        return result;
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
}
