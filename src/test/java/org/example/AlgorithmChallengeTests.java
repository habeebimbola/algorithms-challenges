package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AlgorithmChallengeTasks Class
 */
public class AlgorithmChallengeTests
{

    private AlgorithmChallengeTasks test = new AlgorithmChallengeTasks();


    @Test
    public void testLongestBits()
    {
        int number = 1041;
       assertEquals( 5, test.longestBit(number));
    }

    @Test
    public void testMethod()
    {
        int[] nums = {2,3};
        assertEquals( 1,test.smallestInt(nums));
    }

    @Test
    public void testCyclicRotation(){
        int[] nums = { 1,2,3,4}, result = {1,2,3,4};
        assertArrayEquals(result, test.cyclicRotate(nums,4));
    }

    @Test
    public void testOddArrayOccurrence()
    {
        int[] nums ={9,3,9,3, 9, 7, 9};
        assertEquals(7, test.oddArrayOccurrence(nums));
    }

    @Test
    public void matchingBracketSpec()
    {
        String input = "(((((((((())))))))))";
        assertTrue( test.matchedBrackets(input));
    }

    @Test
    public void  notMatchedBracket()
    {
        String input = ")(";
        assertFalse(test.matchedBrackets(input));
    }

    @Test
    public void perm_missing_elementSpec(){
        int[] nums = {2,3,1,5};
        assertEquals(4, test.permMissingElement(nums));
    }

    @Test
    public void tape_equi_test_spec(){
        int[] input = {3, 1, 2, 4, 3};

        assertEquals(1, test.tapeEquilibriumTest(input));
    }

    @Test
    public void max_Counter_test_spec(){
        int[] result ={3,2,2,4,2}, operations = {3,4,4,6,1,4,4};
        int input = 5;
        assertArrayEquals(result, test.maxCounter(input,operations));
    }

    @Test
    public void missing_Integer_Test_Spec(){
        int nums[] = {-1,-3}, result = 1;

        assertEquals(result, test.missingInteger(nums));
    }

    @Test
    public void distinct_test_spec(){
        int[] nums = {2, 1, 1, 2, 3, 1};
        int result = 3;
        assertEquals(result, test.distinctCount(nums));
    }

    @Test
    public void longestSubstringTestSpec(){
        String input = "aabbbcccc";
        int result = 1;
        assertEquals(4, test.longestSubstringSize(input));
    }

    @Test
    public void closestToZeroSpec(){
       double[] items = {7,-10, 13, 8, 4, -7.2, -12,-3.7,3.5,-9.6, 6.5,-1.7, -6.2,7}; int[] nums = {-15 ,-7 ,-9 ,-14 ,-12};

       assertEquals( -7, test.closestToZero(nums));
    }

    @Test @Deprecated
    public void closestSpec(){
        int[] nums = {7 ,5 ,9 ,1 ,4}, ints = {-10,-10};
        assertEquals(1, test.closestTozero(nums));
    }

    @Test
    public void lengthOfLongestSubstringTest(){
        assertEquals(4,test.lengthOfLongestSubstring("abcabcdbb"));
    }

    @Test
    public void longestStringTest(){
//        assertEquals(4, test.longestString("abcabcdbb"));
        assertEquals(3,test.lengthOfLongestSubstring("dvdf"));

    }

    @Test
    public void twoSumTestSpec(){
        int[] result = {0,1}, nums = {2,7,11,15};
        assertArrayEquals(result ,test.twoSumMap(nums,9));
    }

    @Test
    public void intersectionTestSpec(){
        int[] result = {9,4}, input1 = {4,9,5}, input2 = {9,4,9,8,4};
        assertArrayEquals(result, test.intersection(input1,input2));
    }

    @Test
    public void threeSumValueSpec(){
        int[] input = {3, 7, 1, 2, 8, 4,5}, input2 = {3,7,1,2,8,4,5}, input3 = {-1, 2, 1, -4, 5, -3};
        assertTrue( test.threeSumValue(input3,-8));
    }

    @Test
    public void notThreeSumValueSpe(){
        int[] input = {3, 7, 1, 2,8, 4, 5 }, input2 = {-1, 2, 1, -4, 5, -3}, input3 = {-1, 2,1, -4,5 -3 };
        assertTrue(test.threeSumValue(input3, 0));
    }



}
