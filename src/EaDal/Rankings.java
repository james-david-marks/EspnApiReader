package EaDal;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Rankings {
	
	private HashMap<String, Object> rankingsMap;
	private int rankingsCount;
	
	public static void print(JsonObject jsonObject)
	{
		Rankings rankings = new Rankings();
		rankings.buildRankingsMap(jsonObject);
		//System.out.println("rankingsMap size: " + rankings.countRankings());
		//System.out.println("lastRankingIndex: " + rankings.lastRanking.rankingIndex);
	}

	public void buildRankingsMap(JsonObject jsonObject)
	{
		rankingsMap = new Gson().fromJson(jsonObject, HashMap.class);
		rankingsCount = rankingsMap.size();
//		System.out.println("rankingsCount: " + rankingsCount);

//		for(int i=0; i<rankingsCount; i++)
//		{
//			printRankSet(i);
//		}
		printRankSet(rankingsCount);
	}

	private void printRankSet(int i) {
		Object rankArrayObject = rankingsMap.get(String.format("%d", i));
//		System.out.println(String.format("Rank Set %d", i));
		try
		{
			if(rankArrayObject != null)
			{
				Gson gson = new Gson();
				String rankArrayString = gson.toJson(rankArrayObject);
				JsonArray rankArrayJsonArray = (JsonArray) new JsonParser().parse(rankArrayString);
				rank[] rankArray = gson.fromJson(rankArrayJsonArray, rank[].class);
				for(int j = 0; j < 2 /*rankArray.length*/; j++)
				{
					if(rankArray[j].rankType.equals("PPR"))
					{
						System.out.println(String.format("PPR Rank: %d", rankArray[j].rank));
					}
				}
//				System.out.println(String.format("rank (%s): %d", rankArray[0].rankType, rankArray[0].rank));
//				System.out.println(String.format("rank (%s): %d", rankArray[1].rankType, rankArray[1].rank));
			}
		}
		catch(Exception e)
		{
			System.out.println("--rank read exception --");
		}
	}
	
	public HashMap<String, Object> getRankingsMap()
	{
		return rankingsMap;
	}
	
	public int countRankings()
	{
		return rankingsCount;
	}
}
