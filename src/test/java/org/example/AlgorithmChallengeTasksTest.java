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
}