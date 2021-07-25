package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator 
{
	private static final double MINIMUM_COST_PER_KM_NORMAL_RIDE = 10.0;
	private static final int COST_PER_TIME_NORMAL_RIDE = 1;
	private static final double MINIMUM_FARE_NORMAL_RIDE = 5.0;
	private static final double MINIMUM_COST_PER_KM_PREMIUM_RIDE = 15.0;
	private static final int COST_PER_TIME_PREMIUM_RIDE = 2;
	private static final double MINIMUM_FARE_PREMIUM_RIDE = 20.0;

	public double calculateFare(double distance, int time, String rideType) 
	{
		if (rideType.equalsIgnoreCase("normal"))
		{
			double totalFare = distance * MINIMUM_COST_PER_KM_NORMAL_RIDE + time * COST_PER_TIME_NORMAL_RIDE;
			return Math.max(totalFare, MINIMUM_FARE_NORMAL_RIDE);
		}
		if (rideType.equalsIgnoreCase("premium")) 
		{
			double totalFare = distance * MINIMUM_COST_PER_KM_PREMIUM_RIDE + time * COST_PER_TIME_PREMIUM_RIDE;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM_RIDE);
		} else 
		{
			return 0;
		}
	}

	public InvoiceSummary calculateFare(Ride[] rides)
	{
		double totalFare = 0.0;
		for (Ride ride : rides) 
		{
			totalFare += this.calculateFare(ride.distance, ride.time, ride.rideType);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}