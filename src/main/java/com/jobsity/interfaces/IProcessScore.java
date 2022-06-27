package com.jobsity.interfaces;

import java.util.ArrayList;

import com.jobsity.entities.Score;

public interface IProcessScore {
	/**Generate an score to player
	 * @param scores
	 * @return
	 */
	ArrayList<Score> generateScore(ArrayList<String> scores);
	/**Generate an score and set its values for strike, spare, foul or open.
	 * @param pinsValue1
	 * @param pinsValue2
	 * @param flag
	 * @param playerScore
	 */
	void addScoreToPlayer(int pinsValue1, int pinsValue2, String flag, ArrayList<Score> playerScore);
	/**Calculate total value for each score
	 * @param playerScore
	 */
	void setTotalByPlayer(ArrayList<Score> playerScore);
	/**Add empty entries for each score its needed
	 * @param playerScore
	 */
	void addScoresEmptyEntries(ArrayList<Score> playerScore);
	/**Return next score in player score list
	 * @param index
	 * @param playerScore
	 * @return
	 */
	Score getNext(int index, ArrayList<Score> playerScore);
}
