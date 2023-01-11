package EaDal;

import java.util.Date;

import com.google.gson.JsonObject;

public class status {
	double activatedDate;
	int createdAsLeagueType;
	int currentLeagueType;
	int currentMatchupPeriod;
	int finalScoringPeriod;
	int firstScoringPeriod;
	boolean isActive;
	boolean isExpired;
	boolean isFull;
	boolean isPlayoffMatchupEdited;
	boolean isToBeDeleted;
	boolean isViewable;
	boolean isWaiverOrderEdited;
	int latestScoringPeriod;
	int[] previousSeasons;
	double standingsUpdateDate;
	int teamsJoined;
	int transactionScoringPeriod;
	double waiverLastExecutionDate;
	double waiverNextExecutionDate;
	JsonObject waiverProcessStatus;

	public void print()
	{
		System.out.println("activatedDate: : " + activatedDate);    				
		System.out.println("createdAsLeagueType: : " + createdAsLeagueType);
		System.out.println("currentLeagueType: " + currentLeagueType);
		System.out.println("currentMatchupPeriod: " + currentMatchupPeriod);
		System.out.println("finalScoringPeriod: " + finalScoringPeriod);
		System.out.println("firstScoringPeriod: " + firstScoringPeriod);
		System.out.println("isActive: " + isActive);
		System.out.println("isExpired: " + isExpired);
		System.out.println("isFull: " + isFull);
		System.out.println("isPlayoffMatchupEdited: " + isPlayoffMatchupEdited);
		System.out.println("isToBeDeleted: " + isToBeDeleted);
		System.out.println("isViewable: " + isViewable);
		System.out.println("isWaiverOrderEdited: " + isWaiverOrderEdited);
		System.out.println("latestScoringPeriod: " + latestScoringPeriod);
		System.out.println("previousSeasons: " + listArrayOfInt(previousSeasons));
		System.out.println("standingsUpdateDate: " + standingsUpdateDate);
		System.out.println("teamsJoined: " + teamsJoined);
		System.out.println("transactionScoringPeriod: " + transactionScoringPeriod);
		System.out.println("waiverLastExecutionDate: " + waiverLastExecutionDate);
		System.out.println("waiverNextExecutionDate: " + waiverNextExecutionDate);
		System.out.println("waiverProcessStatus: " + waiverProcessStatus);
	}
	public String listArrayOfInt(int[] seasons)
	{
		StringBuffer buf = new StringBuffer();
		for(int i=0; i < seasons.length; i++)
		{
			if(buf.length() > 0)
			{
				buf.append(", ");
			}
			buf.append(String.format("%d", seasons[i]));
		}
		return buf.toString();
	}

}
