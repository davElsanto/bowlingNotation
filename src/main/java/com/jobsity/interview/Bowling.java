package com.jobsity.interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.jobsity.entities.Player;
import com.jobsity.utilities.PlayerInputReader;
import com.jobsity.utilities.ProcessPlayer;
import com.jobsity.utilities.ProcessScore;

public class Bowling {

	public static void main(String[] args) {
		
		PlayerInputReader playerInput = new PlayerInputReader();
		ProcessPlayer processPlayer = new ProcessPlayer();
		ProcessScore processScore = new ProcessScore();
		
		System.out.println("Please, insert your bowling score:");
		
		ArrayList<String> playersData = playerInput.processPlayerInput();
		LinkedHashMap<String, ArrayList<String>> valuesByPlayer = processPlayer.generatePlayerAndScores(playersData);
		
		ArrayList<Player> players = new ArrayList<>();
		valuesByPlayer.forEach( (key, values) -> {
            Player player = new Player();
            player.setPlayerName(key);
            player.setPlayerScore(processScore.generateScore(values));
            players.add(player);
        });
		
		for(Player player: players){
			processScore.setTotalByPlayer(player.getPlayerScore());
			processPlayer.gerenateNotation(player.getPlayerName(), player.getPlayerScore());
        }

		System.out.println("Bowling Notation. David Santos");
	}

}
