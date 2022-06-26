package com.jobsity.utilities;


import com.jobsity.entities.Score;
import com.jobsity.interfaces.IValidations;

import java.util.ArrayList;

public class Validations implements IValidations {
	@Override
    public Boolean isNumeric(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
	@Override
    public Boolean isValueInRange(Integer value){
        return value >= 0 && value <= 10;
    }
	@Override
    public Boolean isFoul(String value){
        return value.equals("f") || value.equals("F");
    }
	@Override
    public Boolean hasEnoughEntries(ArrayList<Score> userScores){
        return userScores.size() > 10 && userScores.size() < 13;
    }
	@Override
    public Boolean validateInput(String userScore){
        if(this.isNumeric(userScore)){
            int value = Integer.parseInt(userScore);
            if(!this.isValueInRange(value)) return false;
            return true;
        }

        if(!this.isFoul(userScore)) return false;
        return true;
    }

}
