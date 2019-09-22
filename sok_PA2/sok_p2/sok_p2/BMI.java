package sok_p2;
import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		/*
		 * The formulas for calculating BMI are
		 * BMI = (703 * weightInPounds) / (heightInInches^2)
		 * BMI = weightInKilograms / heightInMeters^2
		 * 
		 * Create a BMI calculator that reads the user's weight and height (providing an option
		 * for the user to select which formula to use), and then calculates and displays
		 * the user's body mass index. Also, display the BMI categories and their values
		 * from the National Heart Lung and Blood Institute:...
		 * so the user can evaluate his/her BMI.
		 */
		
		Scanner scnr = new Scanner(System.in);
		int choice;
		double BMI = 0, height, weight;
		
		System.out.println("Press 1 to calculate BMI from standard units(lbs/in) or press 2 to calculate from metric units(kg/cm): ");
		choice = scnr.nextInt();
		
		if (choice == 1)
		{
			System.out.println("Enter your weight(lbs): ");
			weight = scnr.nextDouble();
			System.out.println("Enter your height(inches): ");
			height = scnr.nextDouble();
			
			BMI = (703 * weight) / Math.pow(height, 2);
		}
		else if (choice == 2)
		{
			System.out.println("Enter your weight(kg): ");
			weight = scnr.nextDouble();
			System.out.println("Enter your height(cm): ");
			height = scnr.nextDouble();
			height /= 100; 					//calculate cm to meters
			
			BMI = weight / Math.pow(height, 2);
		}
		else
		{
			System.out.println("Invalid input.");
		}
		
		System.out.printf("Your BMI is %.1f\n\n", BMI);		//.1 to simulate accuracy from NHLBI BMI calculator
		System.out.println("BMI Categories:\nUnderweight = <18.5\nNormal weight = 18.5–24.9\nOverweight = 25–29.9\nObesity = BMI of 30 or greater");
	
		scnr.close();
	}
	

}
