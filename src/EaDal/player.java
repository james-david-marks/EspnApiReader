package EaDal;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class player {
	
	public String fullName;
	public int proTeamId;
	public JsonObject rankings;
	
	public void print()
	{
		System.out.println("fullName: " + fullName);
//		System.out.println("proTeamId: " + proTeamId);
		
		Rankings.print(rankings);
	}	
}
