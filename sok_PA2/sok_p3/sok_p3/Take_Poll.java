package sok_p3;
import java.util.Scanner;

public class Take_Poll {

	public static void main(String[] args) {
		/*
		 *Write a simple polling program that allows users to rate five topics from 1 (least important) to 10 (most important). 
		 *Pick five topics that are important to you (e.g., political issues, global environmental issues, food, video games). 
		 *Use a one-dimensional array topics (of type String) to store the five issues. 
		 *To summarize the survey responses, use a 5-row, 10-column two-dimensional array responses (of type int), 
		 *each row corresponding to an element in the topics array. When the program runs, it should ask the user to rate each issue. 
		 *Multiple people should be able to respond to the survey while the program is running. Once all responses have been logged, 
		 *have the program display a summary of the results, including:

		 *A tabular report with the five topics down the left side and the 10 ratings across the top, 
		 *listing in each column the number of ratings received for each topic.
		 *To the right of each row, show the average of the ratings for that issue.
		 *Which issue received the highest point total? Display both the issue and the point total.
		 *Which issue received the lowest point total? Display both the issue and the point total.
		 */
		
		Scanner scnr = new Scanner(System.in);
		
		String [] topics = {"Healthcare", "Gun Control", "Food Shortage", "Video Games", "Economy"};
		int[][] responses = new int[5][10];
		int[] average = new int[5];
		int userResponse, pollCounter = 0, holder = 0;
		int highPoint = 0, lowPoint = 0;
		String highTopic = null, lowTopic = null;
		boolean run = true;
		
		System.out.println("On a scale of 1(least important) to 10(most important), how would you rate these topics? ");
		
		while (run)
		{
			for (int i = 0; i < 5; i++)
			{
				System.out.printf("How would you rate %s: ", topics[i]);
				userResponse = scnr.nextInt();
				
				//increment responses in 2D array
				switch (userResponse)
				{
				case 1:
					responses[i][userResponse - 1]++;
					break;
				case 2:
					responses[i][userResponse - 1]++;
					break;
				case 3:
					responses[i][userResponse - 1]++;
					break;
				case 4:
					responses[i][userResponse - 1]++;
					break;
				case 5:
					responses[i][userResponse - 1]++;
					break;
				case 6:
					responses[i][userResponse - 1]++;
					break;
				case 7:
					responses[i][userResponse - 1]++;
					break;
				case 8:
					responses[i][userResponse - 1]++;
					break;
				case 9:
					responses[i][userResponse - 1]++;
					break;
				case 10:
					responses[i][userResponse - 1]++;
					break;
				default:
					System.out.println("Invalid rating.");
					i--;				//resets increment so user can input proper rating without skipping a topic
					break;
				}
			}
			
			System.out.println("Take poll again?(Enter -1 to quit): ");
			userResponse = scnr.nextInt();		//reusing variable
			
			if (userResponse == -1)
			{
				run = false;	//ends while loop
			}
		}
		//calculate avg for each topic
		for (int l = 0; l < 5; l++)
		{
			for (int m = 0; m < 10; m++)
			{
				//hold value from responses indexes to pass into avg array calculation
				holder = responses[l][m];
				pollCounter += holder;		//used as a total count for topic to help calculate avg
				average[l] += holder * (m + 1);
			}
			
			if (average[l] > highPoint)
			{
				highPoint = average[l];
				highTopic = topics[l];
			}
			
			if (lowPoint == 0 || lowPoint > average[l])
			{
				lowPoint = average[l];
				lowTopic = topics[l];
			}
			
			average[l] /= (double)pollCounter; //actual avg being set, cast double for accuracy
			pollCounter = 0;				//reset pollCounter for next average index
		}
		
		//print ratings on top
		System.out.printf("Rating:\t\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tAverage\n");
		
		//print topics
		for (int j = 0; j < 5; j++)
		{
			System.out.printf("%s:", topics[j]);
			for (int k = 0; k < 10; k++)
			{
				System.out.printf("\t%d", responses[j][k]);
			}
			System.out.printf("\t%d\n", average[j]);
		}
		System.out.printf("The topic with the highest point total of %d is %s.\n", highPoint, highTopic);
		System.out.printf("The topic with the lowest point total of %d is %s.\n", lowPoint, lowTopic);
		scnr.close();
	}

}
