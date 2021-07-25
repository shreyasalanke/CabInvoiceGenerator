package com.bridgelabz.cabinvoicegenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CabInvoiceGeneratorTest 
  {
	CabInvoiceGenerator invoiceGenerator = null;

	@Before
	public void setUp() throws Exception
	{
		invoiceGenerator = new CabInvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldCalculate_ReturnTotalFare() 
	{
		double distance = 5;
		int time = 3;
		String rideType = "normal";
		double fare = invoiceGenerator.calculateFare(distance, time, rideType);
		Assert.assertEquals(53, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldCalculate_ReturnMinimumFare() 
	{
		double distance = 0.1;
		int time = 1;
		String rideType = "premium";
		double fare = invoiceGenerator.calculateFare(distance, time, rideType);
		Assert.assertEquals(20, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5, "normal"), new Ride(0.1, 1, "premium") };
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	@Test
	public void givenUserId_ShouldReturnTheInvoiceSummary() 
	{
		int userId = 2;
		RideRepository rideRepository = new RideRepository();
		Ride[] rideList = rideRepository.getRideList(userId);
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rideList);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 100.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}