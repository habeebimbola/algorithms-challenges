package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmChallengeTasksTest {

    AlgorithmChallengeTasks algorithmChallengeTasks;
    @BeforeEach
    void setUp(){
        algorithmChallengeTasks = new AlgorithmChallengeTasks();
    }
    @Test
    void closestTozero() {
        int[] nums = {-15 ,-7 ,-9 ,-14 ,-12};
        assertEquals(-7, algorithmChallengeTasks.closestTozero(nums));
    }

    @Test
    public void validWordTest(){
        assertEquals(6, algorithmChallengeTasks.validWord("Aminat This is a valid word a123 thw are"));
    }

    @Test
    public void threeSumTest(){
        int[] input = {3, 7, 1, 2, 8, 4, 5};
        int[] input2 = {2,5,3,7,1,6,9};
        int[] input3 = {1,4,45,6,10,8};
        assertTrue( algorithmChallengeTasks.threeSum(input3, 22));
    }

    @Test
    public void shouldTestEquality(){
        String firstName = "Habeeb";
        String lastName = "Habeeb";
        String className = firstName;
        String otherName = new String("Habeeb");
        String middleName = new String("Habeeb");

        assertTrue(firstName == lastName );

    }



}