package com.nit.error;

public class DoctorNotFoundException extends RuntimeException
{
	public DoctorNotFoundException(String msg)
	{
		super(msg);
	}
	public DoctorNotFoundException()
	{
		
	}

}
