package com.jobsity.interfaces;

import java.util.ArrayList;

import com.jobsity.entities.Score;

public interface IValidations {
	/**Verify if value can be parsed as Integer
	 * @param value
	 * @return
	 */
	Boolean isNumeric(String value);
	/**A value from 0 to 10
	 * @param value
	 * @return
	 */
	Boolean isValueInRange(Integer value);
	/**A foul is defined by "f" or "F"
	 * @param value
	 * @return
	 */
	Boolean isFoul(String value);
	/**A player's scores must be between 11 or 12
	 * @param userScores
	 * @return
	 */
	Boolean hasEnoughEntries(ArrayList<Score> userScores);
	/**Validate if it is an allowed value.
	 * Allowed values are: 
	 * Numbers from 1 to 10.
	 * String 'f' or 'F' for foul.
	 * @param userScore
	 * @return
	 */
	Boolean validateInput(String userScore);
}
