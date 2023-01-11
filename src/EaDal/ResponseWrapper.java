package EaDal;

public class ResponseWrapper {
	public String status;
	public String stacktrace;
	public String endpoint;
	public EspnApiResponse espnApiResponse;
	
	public ResponseWrapper()
	{
		status = "ok";
		stacktrace = "";
		espnApiResponse = new EspnApiResponse();
	}
}
