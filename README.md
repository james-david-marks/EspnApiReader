# EspnApiReader
A java library for parsing ESPN Fantasy Football requests

1. This project is designed to construct some basic features of a data access layer (DAL) for ESPN API result sets.
2. The pattern of this project is to construct Plain Old Java Objects (POJO) to mirror elements in the JSON payload response to an ESPN API request.
3. The initial result set mapping is for what is identified as an "mroster" filter.
4. This project uses a largely undocumented API loosely identified as "ESPN API v3"
5. The initial endpoint used for mapping is: https://fantasy.espn.com/apis/v3/games/ffl/seasons/2022/segments/0/leagues/{league}?rosterForTeamId=10&view=mroster where {league} will be replace with your league id
6. CRITICAL: You need to edit the file src/resources/config.properties and add four values
  a. LEAGUE
  b. TEAMID (replace TEAMID 10 with your TEAMID for your league)
  c. SWID
  d. espn_s2
7. You can find all of these vaules by opening ESPN in Chrome and logging in to your fantasy team
  a. LEAGUE may be found on your URI as "leagueid="
  b. TEAMID may be found on our URI as "teamid="
  c. SWID may be found by using developer tools (right click on the page and select inspect, go to Application and find the cookies for https://espn.fantasy.com and find      the SWID cookie)
  d. espn_s2 may be found by using developer tools (right click on the page and select inspect, go to Application and find the cookies for https://espn.fantasy.com and        find the espn_s2 cookie)
8. Run the application as a Java Application

What you should expect is that it will connect to the API, make a request using the mroster filter, return a JSON object that will be parsed into some classes in the project, and, finally, print the latest Season 2022 rankings for your team. 

Here's what to look for. The main program is in a class called ReaderMethods. It will call a method in the HttpMethods class called Request. This method will map the JSON payload into a collection of objects by using GSON to deserialize the payload.

Objects:
    EspnApiResponse - this is the base class for the JSON Payload. All of the contents of the payload will be serialized into this class. This class has a bunch of string varibles and three objects: draftDetail, status and an array of team objects -- only your team will be populated, but there are other result sets that would populate all teams.
    
    draftDetail - the draftDetail class holds a couple of boolean objects, not very interesting
    
    status - the status class has many variables including a JsonObject for WaiverProcessStatus which we have not explored, also not very interesting
    
    team - this object has a roster object, very interesting
    
    roster - the roster object has an array of rosterEntry objects, this is what you are looking for
    
    rosterEntry - the rosterEntity has a playerId and a playerPoolEntry
    
    playerPoolEntry - in the player pool entry you will find a player object
    
    player - the player object has a fullName, a proTeamId and a complex JsonObject called rankings. There are many more fields in the player object that we have not mapped. The proTeamId no doubt maps to a Professional Football Team which may be returned in another payload from the EspnApi site. The complex ranking object may be mapped into a rankingsMap in a Rankings object for further analysis.
    
What we have done is to create a framework for deserializing the JSON payload into these objects and included at least a print() method in each object. This makes it possible to expose the contents of these objects in the console through System.out.println statements. 

The main method in the ReaderMethod class will tease you by returning a team roster with the lastest 2022 ranks for PPR leagues (one of about a billion different rankings that may be found in the complex JsonObject ranking). For a more comprehensive data dump, you may uncomment the result.print() statement in the main method of the ReaderMethod class.

We welcome your feedback and would love you to join us on our journey to map ESPN API v3. 

Stay tuned for more information about where we learned what little we know about ESPN API v3. We intend to attribute sources that have pointed us in the right direction. It is getting late, however, so more to come later.
    
