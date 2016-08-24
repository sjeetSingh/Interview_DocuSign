package interviewproblem;

import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	// Initial Conditions when you are in the house wearing only pajamas.
	
	public static void main(String args[])throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		int tempInput;
		
		System.out.println("Please enter Temperature Type (only integers 1 or 2): ");
		System.out.println("1. HOT. \n2. COLD.");
		tempInput = scanner.nextInt();
		
		while(tempInput>2 || tempInput<1)
		{
			System.out.println("Please enter a valid choice.");
			tempInput = scanner.nextInt();		
		}
		handleTemp(tempInput);
	}

	private static void handleTemp(int tempInput) throws IOException 
	{
		ClothingLogic clothingLogicObj = new ClothingLogic();
		try
		{
			if (tempInput == 1)
			{
				clothingLogicObj.tempSetter(tempInput);
			}
			else if (tempInput == 2 )
			{
				clothingLogicObj.tempSetter(tempInput);
			}
			else
			{
				System.out.println("Incorrect choice. Please enter the correct choice from the menu");
			}
			
		}
		catch(Exception e)
		{	System.out.println(e.getMessage());	}
	}
	
}
