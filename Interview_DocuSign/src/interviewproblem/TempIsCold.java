package interviewproblem;

import java.util.HashMap;

// This module defines the cold behavior. 
public class TempIsCold implements TempEnum
{	
	String footwear, headwear, socks, shirt, jacket, pants, house, pajamas;
	HashMap<Integer, String> coldClothes = new HashMap<Integer, String>();
	
	// As soon as the object is created, HashMap is instantiated
	// And the instance variables are initialized
	TempIsCold()
	{
		coldClothes.put(1, "boots");
		coldClothes.put(2, "hat");
		coldClothes.put(3, "socks");
		coldClothes.put(4, "shirt");
		coldClothes.put(5, "jacket");
		coldClothes.put(6, "pants");
		coldClothes.put(7, "leaving house");
		coldClothes.put(8, "removing PJs");		
		
		this.footwear = coldClothes.get(1);
		this.headwear = coldClothes.get(2);
		this.socks = coldClothes.get(3);
		this.shirt = coldClothes.get(4);
		this.jacket = coldClothes.get(5);
		this.pants = coldClothes.get(6);
		this.house = coldClothes.get(7);
		this.pajamas = coldClothes.get(8);
	}

	public Temperature setTemp() 
	{
		return TempEnum.Temperature.COLD;
	}

	public String getFootwear() 
	{	return footwear;	}

	public String getHeadwear() 
	{	return headwear;	}

	public String getSocks() 
	{	return socks;	}

	public String getShirt() 
	{	return shirt;	}

	public String getJacket() {
		// TODO Auto-generated method stub
		return jacket;
	}

	public String getPants() {
		// TODO Auto-generated method stub
		return pants;
	}

	public String houseLeave() {
		// TODO Auto-generated method stub
		return house;
	}

	public String pajamasON() {
		// TODO Auto-generated method stub
		return pajamas;
	}
}
