package com.jobsity.utilities;

import java.util.ArrayList;

import com.jobsity.entities.Score;
import com.jobsity.enums.Bowling;
import com.jobsity.interfaces.IProcessScore;

public class ProcessScore implements IProcessScore{
	
	Validations validations = new Validations();
	@Override
	public ArrayList<Score> generateScore(ArrayList<String> scores) {
		
		ArrayList<Score> userScores = new ArrayList<Score>();

        for (int index = 0; index < scores.size(); index++) {

            if (scores.get(index).equals("10")) {
                //strike
                this.addScoreToPlayer(0, 10, "strike", userScores);
            } else {
                if (index < scores.size()) {

                    boolean isNumberValue = validations.isNumeric(scores.get(index));
                    boolean isNumberValueNext = index + 1 >= scores.size() ?
                            false :
                            validations.isNumeric(scores.get(index + 1));

                    int auxUserScore = isNumberValue ?
                            Integer.parseInt(scores.get(index)) : 0;
                    int auxUserScoreNext = isNumberValueNext ?
                            Integer.parseInt(scores.get(index + 1)) : 0;

                    String flag;

                    if (isNumberValue && isNumberValueNext)
                        if (auxUserScore + auxUserScoreNext == 10) flag = "spare";
                        else flag = "open";
                    else flag = !isNumberValueNext ? "open" : "foul";

                    this.addScoreToPlayer(auxUserScore, auxUserScoreNext, flag, userScores);

                    index++;

                }
            }
        }

        return userScores;
		
	}

	@Override
	public void addScoreToPlayer(int pinsValue1, int pinsValue2, String flag, ArrayList<Score> playerScore) {
		
		Score score = new Score(0, 0, false, false, false, false, 0);
        switch (flag) {
            case "strike":
                score.setPinsValue2(10);
                score.setStrike(true);
                break;
            case "spare":
                score.setPinsValue1(pinsValue1);
                score.setPinsValue2(pinsValue2);
                score.setSpare(true);
                break;
            case "foul":
                score.setPinsValue1(pinsValue1);
                score.setPinsValue2(pinsValue2);
                score.setFoul(true);
                break;
            case "open":
                score.setPinsValue1(pinsValue1);
                score.setPinsValue2(pinsValue2);
                score.setOpen(true);
                break;
        }

        playerScore.add(score);
		
	}

	@Override
	public void setTotalByPlayer(ArrayList<Score> playerScore) {
	
		int index = 0;

        if (!validations.hasEnoughEntries(playerScore))
            this.addScoresEmptyEntries(playerScore);

        for (Score score : playerScore) {

            Score auxNext, auxNextNext, auxTemp;
            int total;
            int totalPrev = index > 0 ? playerScore.get(index - 1).getTotal() : 0;
            if (index < 9) {
                //strike #1
                auxTemp = playerScore.get(index);
                auxNext = this.getNext(index + 1, playerScore);
                auxNextNext = this.getNext(index + 2, playerScore);

                if (score.isStrike()) {

                    //strike #2
                    if (auxNext.isStrike()) {
                        //strike #3
                        if (auxNextNext.isStrike()) total = Bowling.STRIKE_3 + totalPrev;
                        else total = Bowling.STRIKE_2 + auxNextNext.getPinsValue1() + totalPrev;

                    } else total = Bowling.STRIKE_1 + auxNext.getPinsValue1() + auxNext.getPinsValue2() + totalPrev;

                } else if (score.isSpare()) {
                    total = Bowling.STRIKE_1 + auxNext.getPinsValue1() + totalPrev;
                } else {
                    total = auxTemp.getPinsValue1() + auxTemp.getPinsValue2() + totalPrev;
                }

                auxTemp.setTotal(total);
                playerScore.set(index, auxTemp);
                index++;

            } else {
                //get last values, manually
                auxTemp = playerScore.get(index);
                auxNext = this.getNext(index + 1, playerScore);
                auxNextNext = new Score(0, 0, false, false, false, false, 0);

                if (playerScore.size() == 12)
                    auxNextNext = this.getNext(index + 2, playerScore);

                auxTemp.setTotal(
                        auxTemp.getPinsValue1() + auxTemp.getPinsValue2() +
                        auxNext.getPinsValue1() + auxNext.getPinsValue2() +
                        auxNextNext.getPinsValue1() + auxNextNext.getPinsValue2() +
                        totalPrev);

                playerScore.set(index, auxTemp);

                break;


            }

        }

		
	}

	@Override
	public void addScoresEmptyEntries(ArrayList<Score> playerScore) {
		//add new score like "open"
		Score score = new Score(0, 0, false, false, false, true, 0);
        while (playerScore.size() < 11) 
        	playerScore.add(score);
		
	}

	@Override
	public Score getNext(int index, ArrayList<Score> playerScore) {
		return playerScore.get(index);
	}

}
