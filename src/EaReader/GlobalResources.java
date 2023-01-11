package EaReader;

import java.io.*;
import java.util.Properties;

public class GlobalResources {
	
	private static final String EAGLOBALCONFIGPATH = "src/resources/config.properties";
	private Properties properties;
	
	public String League;
	public String Season;
	public String TeamId;
	public String Filter_Roster;
	
	public GlobalResources()
	{
		loadProperties();
		
		League = readProperty("LEAGUE");
		Season = readProperty("SEASON");
		TeamId = readProperty("TEAMID");
		Filter_Roster = readProperty("ROSTERFILTER");
	}

	/* STATIC METHODS */
    public static String getProperty(String propName) {
    	
    	String propValue = "";
        try {
            String configFilePath = EAGLOBALCONFIGPATH;
            FileInputStream propsInput = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(propsInput);

            propValue = prop.getProperty(propName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return propValue;
    }
    
    /* INSTANCE METHODS */
    public String buildEndpoint()
    {
    	/* https://{domain}/apis/v3/games/ffl/seasons/{season}/segments/0/leagues/{league}?rosterForTeamId={teamid}&view={filter_roster} */
    	
    	final String requestPrefix = "https://";
    	final String domain = readProperty("FANTASYDOMAIN");
    	final String route_part_a = "/apis/v3/games/ffl/seasons/";
    	final String season = Season;
    	final String route_part_b = "/segments/0/leagues/";
    	final String league = League;
    	final String query_part_1 = "?rosterFForTeamId=";
    	final String teamid = TeamId;
    	final String query_part_2 = "&view=";
    	final String filter_roster = Filter_Roster;
    	
    	String endpoint = "";
    	StringBuffer endpointBuf = new StringBuffer();
    	
    	endpointBuf.append(requestPrefix);
    	endpointBuf.append(domain);
       	endpointBuf.append(route_part_a);
       	endpointBuf.append(season);
       	endpointBuf.append(route_part_b);
       	endpointBuf.append(league);
       	endpointBuf.append(query_part_1);
       	endpointBuf.append(teamid);
       	endpointBuf.append(query_part_2);
       	endpointBuf.append(filter_roster);
       	
       	endpoint=endpointBuf.toString();
       	
       	//System.out.println(String.format("Using endpoint: %s", endpoint));
       	
       	return endpoint;
    }
    public String readProperty(String propName) {
    	String propValue = "";
    	propValue = properties.getProperty(propName);
    	return propValue;
    }
    public void loadProperties() {
    	
        try {
            String configFilePath = EAGLOBALCONFIGPATH;
            FileInputStream propsInput = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(propsInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
