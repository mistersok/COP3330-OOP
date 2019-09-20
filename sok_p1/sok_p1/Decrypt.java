package sok_p1;

import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String codeString;
		int code, holder, codePlace = 1000;
		int[] userCode = new int[4];
		
		//Read user input as string to accept the case where code starts with 0 
		codeString = scnr.next();
		
		//Validate user input
		if (codeString.length() == 4)
		{
			code = Integer.parseInt(codeString);
			//place code into array
			for(int i = 0; i < 4; i++)
			{
				userCode[i] = (code / codePlace) % 10;
				codePlace /= 10;
			}
			
			//Swaps digits inside array
			holder = userCode[0];
			userCode[0] = userCode[2];
			userCode[2] = holder;
			holder = userCode[1];
			userCode[1] = userCode[3];
			userCode[3] = holder;
			
			//Decrypts code in an array
			for(int i = 0; i < 4; i++)
			{
				userCode[i] = (userCode[i] + 3) % 10;
				
			}

			
			for(int j = 0; j < 4; j++)
			{
				System.out.print(userCode[j]);
			}
			
		}
		else
		{
			System.out.println("You must enter 4 digits.");
		}

		
		scnr.close();

	}

}
