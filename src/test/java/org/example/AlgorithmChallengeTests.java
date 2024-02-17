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
        int[] nums = { 1,2,3,4};
        assertEquals(nums, test.cyclicRotate(nums, 4 ));
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


}
