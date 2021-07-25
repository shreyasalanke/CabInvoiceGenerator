package com.bridgelabz.cabinvoicegenerator;
import java.util.HashMap;

public class RideRepository 
{
	HashMap<Integer, Ride[]> ridesByUserId = new HashMap<>();

	public RideRepository() 
	{
		Ride[] rides1 = { new Ride(5.0, 3), new Ride(0.1, 1) };
		ridesByUserId.put(1, rides1);
		Ride[] rides2 = { new Ride(5.0, 10), new Ride(0.1, 1) };
		ridesByUserId.put(2, rides2);
		Ride[] rides3 = { new Ride(10.0, 10), new Ride(0.1, 1) };
		ridesByUserId.put(3, rides3);
	}

	public Ride[] getRideList(Integer userId) 
	{
		return ridesByUserId.get(userId);
	}
}
