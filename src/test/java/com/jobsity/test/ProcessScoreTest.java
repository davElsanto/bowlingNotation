package com.jobsity.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.jobsity.entities.Score;
import com.jobsity.utilities.ProcessScore;

public class ProcessScoreTest {

	@Test
	public void testAddScoreToPlayer(){
		
		ProcessScore ps = new ProcessScore();
		
		ArrayList<Score> playerScore = new ArrayList<>();
		
		Score scoreStrike = new Score(0, 10, true, false, false, false, 0);
		Score scoreSpare = new Score(2, 8, false, true, false, false, 0);
		Score scoreFoul = new Score(2, 0, false, false, true, false, 0);
		Score scoreOpen = new Score(3, 5, false, false, false, true, 0);
		
		ps.addScoreToPlayer(0, 10, "strike", playerScore);
		ps.addScoreToPlayer(2, 8, "spare", playerScore);
		ps.addScoreToPlayer(2, 0, "foul", playerScore);
		ps.addScoreToPlayer(3, 5, "open", playerScore);
		
        Assert.assertEquals(scoreStrike.isStrike(), playerScore.get(0).isStrike());
        Assert.assertEquals(scoreSpare.isSpare(), playerScore.get(1).isSpare());
        Assert.assertEquals(scoreFoul.isFoul(), playerScore.get(2).isFoul());
        Assert.assertEquals(scoreOpen.isOpen(), playerScore.get(3).isOpen());
    }
	
	@Test
	public void testSetTotalByPlayer(){
		
		ProcessScore ps = new ProcessScore();
		
		ArrayList<Score> playerScore = new ArrayList<>();
		
		Score scoreStrike = new Score(0, 10, true, false, false, false, 0);
		Score scoreSpare = new Score(2, 8, false, true, false, false, 0);
		Score scoreFoul = new Score(2, 0, false, false, true, false, 0);
		Score scoreOpen = new Score(3, 5, false, false, false, true, 0);
		
		playerScore.add(scoreStrike);
		playerScore.add(scoreSpare);
		playerScore.add(scoreFoul);
		playerScore.add(scoreOpen);
		
		ps.addScoresEmptyEntries(playerScore);
		
		Assert.assertEquals(11, playerScore.size());
		
    }
	
	@Test
	public void testGenerateScore() {
		ProcessScore ps = new ProcessScore();
		
		ArrayList<String> scores = new ArrayList<>();	
		ArrayList<Score> scoresExpected = new ArrayList<>();
		
		//strike
		scores.add("10");
		//spare
		scores.add("2");
		scores.add("8");
		//open
		scores.add("2");
		scores.add("0");
		//spare
		scores.add("3");
		scores.add("7");
		//foul
		scores.add("f");
		scores.add("2");
		scores.add("f");
		scores.add("F");
		scores.add("4");
		scores.add("f");
		scores.add("3");
		scores.add("5");
		scores.add("3");
		scores.add("5");
		scores.add("3");
		scores.add("5");
		scores.add("3");
		scores.add("5");
		scores.add("3");
		scores.add("5");
		
		scoresExpected = ps.generateScore(scores);
		
		Assert.assertEquals(true, scoresExpected.get(0).isStrike());
		Assert.assertEquals(true, scoresExpected.get(1).isSpare());
		Assert.assertEquals(true, scoresExpected.get(2).isOpen());
		Assert.assertEquals(true, scoresExpected.get(3).isSpare());
		Assert.assertEquals(true, scoresExpected.get(4).isFoul());
		Assert.assertEquals(true, scoresExpected.get(5).isOpen());
		Assert.assertEquals(true, scoresExpected.get(6).isOpen());
		Assert.assertEquals(true, scoresExpected.get(7).isOpen());
				
		
	}
	
	@Test
	public void testSetTotalByPlayerValues() {
		ProcessScore ps = new ProcessScore();
		ArrayList<String> scores = new ArrayList<>();
		ArrayList<Score> scoresExpected = new ArrayList<>();
		//perfect game
		scores.add("10");
		scores.add("10");
		scores.add("10");
		scores.add("10");
		scores.add("10");
		scores.add("10");
		scores.add("10");
		scores.add("10");
		scores.add("10");
		scores.add("10");
		scoresExpected = ps.generateScore(scores);
		ps.setTotalByPlayer(scoresExpected);
		System.out.println(scoresExpected.size() + " -> perfect game");
	}
}
