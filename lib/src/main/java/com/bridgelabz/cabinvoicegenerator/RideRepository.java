package com.bridgelabz.cabinvoicegenerator;
import java.util.HashMap;

public class RideRepository 
{
	HashMap<Integer, Ride[]> ridesByUserId = new HashMap<>();

	public RideRepository() 
	{
		Ride[] rides1 = { new Ride(2.0, 5, "normal"), new Ride(0.1, 1, "normal") };
		ridesByUserId.put(1, rides1);
		Ride[] rides2 = { new Ride(5.0, 10, "premium"), new Ride(0.1, 1, "normal") };
		ridesByUserId.put(2, rides2);
		Ride[] rides3 = { new Ride(10.0, 10, "normal"), new Ride(0.1, 1, "premium") };
		ridesByUserId.put(3, rides3);
	}

	public Ride[] getRideList(Integer userId) 
	{
		return ridesByUserId.get(userId);
	}
}
