package sok_p1;
import java.util.Scanner;

public class Encrypt {

	public static void main(String[] args) {
		/*
		 * A company that wants to send data over the Internet has asked you to write a program that will encrypt it 
		 * so that it may be transmitted more securely. All the data is transmitted as four-digit integers. 
		 * Your application should read a four-digit integer entered by the user and encrypt it as follows: 
		 * Replace each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10. 
		 * Then swap the first digit with the third, and swap the second digit with the fourth. 
		 * Then print the encrypted integer. 
		 * Write a separate application that inputs an encrypted four-digit integer and decrypts it 
		 * (by reversing the encryption scheme) to form the original number.
		 */
		
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
			//Encrypts code in an array
			for(int i = 0; i < 4; i++)
			{
				userCode[i] = (code / codePlace) % 10;
				userCode[i] = (userCode[i] + 7) % 10;
				codePlace /= 10;
			}
			//Swaps digits inside array
			holder = userCode[0];
			userCode[0] = userCode[2];
			userCode[2] = holder;
			holder = userCode[1];
			userCode[1] = userCode[3];
			userCode[3] = holder;
			
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
