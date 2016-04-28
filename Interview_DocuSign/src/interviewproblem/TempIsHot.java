package interviewproblem;

import java.util.HashMap;

public class TempIsHot implements TempEnum
{
	String footwear, headwear, socks, shirt, jacket, pants, house, pajamas;
	
	Alerts a = new Alerts();
	HashMap<Integer, String> hotClothes = new HashMap<Integer, String>();
	
	// As soon as the object is created, HashMap is instantiated
	// And the instance variables are initialized
	TempIsHot()
	{
		hotClothes.put(1, "sandals");
		hotClothes.put(2, "sun visor");
		hotClothes.put(3, a.fail);
		hotClothes.put(4, "t-shirt");
		hotClothes.put(5, a.fail);
		hotClothes.put(6, "shorts");
		hotClothes.put(7, "leaving house");
		hotClothes.put(8, "Removing PJs");	
		
		this.footwear = hotClothes.get(1);
		this.headwear = hotClothes.get(2);
		this.socks = hotClothes.get(3);
		this.shirt = hotClothes.get(4);
		this.jacket = hotClothes.get(5);
		this.pants = hotClothes.get(6);
		this.house = hotClothes.get(7);
		this.pajamas = hotClothes.get(8);	
	}

	public Temperature setTemp() 
	{
		return TempEnum.Temperature.HOT;
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
