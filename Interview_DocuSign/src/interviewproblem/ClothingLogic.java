package interviewproblem;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


/*This class, as the name suggest defines the main 
logic on how to dress during a particular temperature
type. 
*/
public class ClothingLogic 
{ 
	
	public void tempSetter(int tempInput)throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> commandsEntered = new HashSet<Integer>();
		Alerts a1 = new Alerts();
		boolean allClothesWorn = false, 
				footwearOn = false,
				headwearOn = false,
				socksOn = false,
				shirtOn = false,
				jacketOn = false,
				pantsOn=false, 
				houseLeave = false, 
				pajamasON = true;		
		int commandNo;
		
		if(tempInput==1)
		{
			TempIsHot hotObj = new TempIsHot();
			System.out.println("It is "+TempEnum.Temperature.HOT.toString()+" outside!");
			System.out.println("Please input the commands: "); 

			while(!allClothesWorn)
			{
				//System.out.println("Inside while!");
				commandNo = sc.nextInt();
				
				// Status: PAJAMAS ON
				if(pajamasON)
				{
					if(commandNo==8)
					{
						pajamasON=false;
						commandsEntered.add(commandNo);
						System.out.println(hotObj.pajamasON());
					}
				}
				else if(!pajamasON && !commandsEntered.contains(commandNo))
				{
					// Wearing pants after removing Pajamas.
					// PAJAMAS OFF, PANTS ON
					if(commandNo==6 && !pantsOn)
					{
						pantsOn=true;
						commandsEntered.add(commandNo);
						System.out.println(hotObj.getPants());
					}
					else if(!shirtOn && commandNo!=6 && !pantsOn || commandsEntered.contains(commandNo))
					{	
						System.out.println(a1.throwError());
						System.exit(0);
					}
					else if(pantsOn)
					{						
						if(commandNo==3)
						{
							// PANTS ON, NO SOCKS due to HOT
							//commandsEntered.add(commandNo); 3 won't be added as we are not wearing in the summer
							System.out.println(hotObj.getSocks());
							System.exit(0);						
						}
						else
						{
							// Wearing shirt after wearing pants
							if (commandNo==4 && !shirtOn)
							{
								// PANTS ON, SHIRT ON
								shirtOn=true;
								commandsEntered.add(commandNo);
								System.out.println(hotObj.getShirt());
							}
							else if(commandNo!=4 && !shirtOn)
							{	
								System.out.println(a1.throwError());
								System.exit(0);
							}
							else if (commandNo==4 && shirtOn)
							{	
								System.out.println(a1.throwError());
								System.exit(0);
							}
							else if(shirtOn)
							{
								if(commandNo==2 && !headwearOn)
								{
									// PANTS ON, SHIRT ON, HEADWEAR ON
									headwearOn=true;
									commandsEntered.add(commandNo);
									System.out.println(hotObj.getHeadwear());
								}
								else if(commandNo!=2 && !headwearOn)
								{	
									System.out.println(a1.throwError());
									System.exit(0);
								}
								else if(headwearOn)
								{
									if(commandNo==5)
									{
										// NO JACKET IN HOT TEMPERATURE
										//commandsEntered.add(commandNo);
										System.out.println(hotObj.getJacket());
									}
									else
									{
										if(commandNo==1)
										{
											// FOOTWEAR ON
											footwearOn=true;
											commandsEntered.add(commandNo);
											System.out.println(hotObj.getFootwear());
										}
										else if(commandNo!=1 && !footwearOn)
										{	
											System.out.println(a1.throwError());
											System.exit(0);
										}
										else if(footwearOn)
										{
											if(commandNo==7)
											{
												// ALL CLOTHES WORN, LEAVE THE HOUSE
												houseLeave = true;
												commandsEntered.add(commandNo);
												System.out.println(hotObj.houseLeave());
												allClothesWorn = true;
												System.exit(0);
											}
											else if (commandNo!=7 && !houseLeave)
											{	
												System.out.println(a1.throwError());
												System.exit(0);
											}
										}										
									}
								}
							}
							
						}

					}
				}
				
				
				// Check for a duplicate command
				else if(commandsEntered.contains(commandNo))
				{	
					System.out.println(a1.throwError());
					System.exit(0);
				}	
				
				else if(pajamasON && commandNo!=8)
				{	
					System.out.println(a1.throwError());
					System.exit(0);
				}
			}
		 }
		
		else if(tempInput==2)
		{
			TempIsCold coldObj = new TempIsCold();
			System.out.println("It is "+TempEnum.Temperature.COLD.toString()+" outside!");
			System.out.println("Commands: ");

			while(true)
			{				
				commandNo = sc.nextInt();
				
				if(pajamasON && commandNo==8)
				{
					if(commandNo==8)
					{
						pajamasON=false;
						commandsEntered.add(commandNo);
						System.out.println(coldObj.pajamasON());
					}
				}
				else if(!pajamasON && !commandsEntered.contains(commandNo))
				{
					// Wearing pants after removing Pajamas
					if(commandNo==6 && pantsOn==false)
					{
						pantsOn=true;
						commandsEntered.add(commandNo);
						System.out.println(coldObj.getPants());
					}
					else if(!shirtOn && commandNo!=6 && !pantsOn || commandsEntered.contains(commandNo))
					{	
						System.out.println(a1.throwError());
						System.exit(0);
					}
					else if(pantsOn)
					{						
						if(commandNo==3)
						{
							//commandsEntered.add(commandNo); 3 won't be added as we are not wearing in the summer
							System.out.println(coldObj.getSocks());
						}
						else
						{
							// Wearing shirt after wearing pants
							if (commandNo==4 && !shirtOn)
							{
								shirtOn=true;
								commandsEntered.add(commandNo);
								System.out.println(coldObj.getShirt());
							}
							else if(commandNo!=4 && !shirtOn)
							{	
								System.out.println(a1.throwError());	
								System.exit(0);
							}
							else if (commandNo==4 && shirtOn)
							{	System.out.println(a1.throwError());	
								System.exit(0);
							}
							else if(shirtOn)
							{
								if(commandNo==2 && !headwearOn)
								{
									headwearOn=true;
									commandsEntered.add(commandNo);
									System.out.println(coldObj.getHeadwear());
								}
								else if(commandNo!=2 && !headwearOn)
								{	
									System.out.println(a1.throwError());	
									System.exit(0);
								}
								else if(headwearOn)
								{
									if(commandNo==5)
									{
										jacketOn=true;
										commandsEntered.add(commandNo);
										System.out.println(coldObj.getJacket());
									}
									else if(commandNo!=5 && !jacketOn)
									{	
										System.out.println(a1.throwError());	
										System.exit(0);
									}
									else if (jacketOn)
									{
										if(commandNo==1)
										{
											footwearOn=true;
											commandsEntered.add(commandNo);
											System.out.println(coldObj.getFootwear());
										}
										else if(commandNo!=1 && footwearOn==false)
										{	
											System.out.println(a1.throwError());	
											System.exit(0);
										}
										else if(footwearOn)
										{
											if(commandNo==7)
											{
												houseLeave = true;
												commandsEntered.add(commandNo);
												System.out.println(coldObj.houseLeave());
												allClothesWorn = true;
												System.exit(0);
											}
											else if (commandNo!=7 && !houseLeave)
											{	
												System.out.println(a1.throwError());	
												System.exit(0);
											}
										}										
									}
								}
							}
							
						}

					}
				}			
				// Check for a duplicate command
				else if(commandsEntered.contains(commandNo))
				{	
					System.out.println(a1.throwError());
					System.exit(0);
				}	
				
				else if(pajamasON && commandNo!=8)
				{	System.out.println(a1.throwError());	}
			}
		}		
	}
		
}
