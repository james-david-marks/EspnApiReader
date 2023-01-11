package EaDal;

import com.google.gson.JsonObject;

public class EspnApiResponse {
	public draftDetail draftDetail;
	public String gameId;
	public String id;
	public String scoringPeriodId;
	public String seasonId;
	public String segmentId;
	public status status;
	public team[] teams;
	
	public void print()
	{
		draftDetail.print();
		System.out.println("gameId: " + gameId);    				
		System.out.println("id: " + id);    				
		System.out.println("scoringPeriodId: " + scoringPeriodId);    				
		System.out.println("seasonId: " + seasonId);    				
		System.out.println("segmentId: " + segmentId);
		status.print();
		printArrayOfTeam(teams);
	}
	public void printArrayOfTeam(team[] teams)
	{
		for(int i=0; i < teams.length; i++)
		{
			teams[i].print();
		}
	}
	public void printTeamRosterRanks(int i)
	{
		teams[i].printTeamRosterRanks();
	}
}
