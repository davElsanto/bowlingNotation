package com.jobsity.interfaces;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.jobsity.entities.Score;

public interface IProcessPlayer {
	/**Generate players and their's scores
	 * @param userData
	 * @return LinkedHashMap<String PlayerName, ArrayList PlayerScores>
	 */
	LinkedHashMap<String, ArrayList<String>> generatePlayerAndScores(ArrayList<String> userData);	
	/**Generate bowling notation
	 * @param playerScore
	 * @param playerName
	 */
	void gerenateNotation(String playerName, ArrayList<Score> playerScore);
}
