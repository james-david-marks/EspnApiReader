package EaReader;

import java.io.IOException;

import EaDal.EspnApiResponse;
import EaDal.ResponseWrapper;

public class ReaderMethods {
	public static void main(String[] args)
	{
		System.out.println("ESPN API Reader -->");
		try
		{
			HttpMethods httpMethods = new HttpMethods();
			ResponseWrapper responseWrapper = httpMethods.Request();
	       	System.out.println(String.format("Using endpoint: %s", responseWrapper.endpoint));
	       	
			EspnApiResponse result = responseWrapper.espnApiResponse;
			//result.print();
			result.printTeamRosterRanks(7);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

}
