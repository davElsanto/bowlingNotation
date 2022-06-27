package com.jobsity.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.Test;

import com.jobsity.entities.Score;
import com.jobsity.utilities.ProcessPlayer;

public class ProcessPlayerTest {
	
	@Test
    public void testGeneratePlayerAndScores(){
		ProcessPlayer pui = new ProcessPlayer();
        ArrayList<String> userData = new ArrayList<>();
        userData.add("user1  1");
        userData.add("user1  9");
        
        userData.add("user2  10");

        LinkedHashMap<String, ArrayList<String>> expected = new LinkedHashMap<>();
        ArrayList<String> dataUser1 = new ArrayList<>();
        ArrayList<String> dataUser2 = new ArrayList<>();
        dataUser1.add("1");
        dataUser1.add("9");
        expected.put("user1", dataUser1);
        dataUser2.add("10");
        expected.put("user2", dataUser2);
        
        System.out.println(expected);

        Assert.assertEquals(expected, pui.generatePlayerAndScores(userData));
    }
	
	@Test
    public void testGerenateNotation(){
		ProcessPlayer pui = new ProcessPlayer();
        ArrayList<Score> playerScore = new ArrayList<Score>();
        Score score1 = new Score(0, 10, true, false, false, false, 30);
        Score score2 = new Score(0, 10, true, false, false, false, 60);
        Score score3 = new Score(0, 10, true, false, false, false, 90);
        Score score4 = new Score(0, 10, true, false, false, false, 120);
        Score score5 = new Score(0, 10, true, false, false, false, 150);
        Score score6 = new Score(0, 10, true, false, false, false, 180);
        Score score7 = new Score(0, 10, true, false, false, false, 210);
        Score score8 = new Score(0, 10, true, false, false, false, 240);
        Score score9 = new Score(0, 10, true, false, false, false, 270);
        Score score10 = new Score(0, 10, true, false, false, false, 300);
        Score score11 = new Score(0, 10, true, false, false, false, 300);
        Score score12 = new Score(0, 10, true, false, false, false, 300);
        
        playerScore.add(score1);
        playerScore.add(score2);
        playerScore.add(score3);
        playerScore.add(score4);
        playerScore.add(score5);
        playerScore.add(score6);
        playerScore.add(score7);
        playerScore.add(score8);
        playerScore.add(score9);
        playerScore.add(score10);
        playerScore.add(score11);
        playerScore.add(score12);
        
        
        pui.gerenateNotation("David Santos", playerScore);
        
	}

}
