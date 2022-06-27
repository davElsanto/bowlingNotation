package com.jobsity.utilities;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.jobsity.entities.Score;
import com.jobsity.enums.Bowling;
import com.jobsity.interfaces.IProcessPlayer;

public class ProcessPlayer implements IProcessPlayer{
	
	public ProcessPlayer() {}
	Validations validations = new Validations();
	
	@Override
	public LinkedHashMap<String, ArrayList<String>> generatePlayerAndScores(ArrayList<String> userData) {
		
		LinkedHashMap<String, ArrayList<String>> data = new LinkedHashMap<>();

        String[] lineText;
        String userName;
        String userScore;

        for (String line : userData) {

            lineText = line
                    .replaceAll("\\s+", " ")
                    .split(" ");

            userName = lineText[0];
            userScore = validations.validateInput(lineText[1]) ?
                    lineText[1] :
                    String.valueOf(Bowling.ERROR_SCORE);

            ArrayList<String> values = new ArrayList<String>();

            if (!data.containsKey(userName)) {
                values.add(userScore);
                data.put(userName, values);
            } else {
                values = data.get(userName);
                values.add(userScore);

                data.replace(userName, values);
            }
        }

        return data;
		
	}

	@Override
	public void gerenateNotation(String playerName, ArrayList<Score> playerScore) {
		
		StringBuilder sb = new StringBuilder();

        sb.append("Frame\t\t");

        for (int i = 1; i < 11; i++)
            sb.append(i + "\t\t");

        sb.append("\n" + playerName + "\nPinfalls" + "\t");

        for (int i = 0; i < playerScore.size(); i++) {

            int pinsValue1 = playerScore.get(i).getPinsValue1();
            int pinsValue2 = playerScore.get(i).getPinsValue2();

            if (playerScore.get(i).isStrike()) sb.append(" \tX\t");
            else if (playerScore.get(i).isSpare()) sb.append(pinsValue1 + "\t/\t");
            else if (playerScore.get(i).isOpen()) {

                if (pinsValue1 == 0) sb.append("-\t" + pinsValue2 + "\t");
                else if (pinsValue2 == 0) sb.append(pinsValue1 + "\t-\t");
                else sb.append(pinsValue1 + "\t" + pinsValue2 + "\t");

            } else {

                if (pinsValue1 == 0) sb.append("F\t" + pinsValue2 + "\t");
                else sb.append(pinsValue1 + "\tF\t");

            }

        }

        sb.append("\n").append("Score" + "\t\t");

        for (int i = 0; i < 10; i++) {
            sb.append(playerScore.get(i).getTotal() + "\t\t");
        }

        sb.append("\n");

        System.out.println(sb.toString());
		
	}

}
