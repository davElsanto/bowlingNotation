package com.jobsity.utilities;

import java.util.ArrayList;
import java.util.Scanner;

import com.jobsity.interfaces.IPlayerInputReader;

public class PlayerInputReader implements IPlayerInputReader{

    public PlayerInputReader() {
    }

	@Override
	public ArrayList<String> processPlayerInput(){

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> userLines = new ArrayList<String>();
        String inputLine;

        while(scanner.hasNextLine()){

            inputLine = scanner.nextLine();
            if(inputLine.isEmpty()) break;

            userLines.add(inputLine);
        }

        scanner.close();

        return userLines;
    }
    

    
}
