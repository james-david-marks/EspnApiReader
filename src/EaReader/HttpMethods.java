package EaReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import EaDal.EspnApiResponse;
import EaDal.ResponseWrapper;

public class HttpMethods {
	
	public ResponseWrapper Request() throws IOException
	{
		GlobalResources globalResources = new GlobalResources();
		final String DOMAIN_FANTASY = globalResources.readProperty("FANTASYDOMAIN");
		final String SERVICE_URL = globalResources.buildEndpoint();
		final String SWID = globalResources.readProperty("SWID");
		final String ESPNS2 = globalResources.readProperty("espn_s2");
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		String url = SERVICE_URL;
		responseWrapper.endpoint = url;
		
		CloseableHttpClient httpClient;
		CloseableHttpResponse response = null;
	    RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
	    BasicCookieStore cookieStore = new BasicCookieStore();
	    BasicClientCookie cookieSwid = new BasicClientCookie("SWID", SWID);
	    BasicClientCookie cookieEspnS2 = new BasicClientCookie("espn_s2", ESPNS2);

	    HttpClientContext context = HttpClientContext.create();
	    context.setCookieStore(cookieStore);
	    
	    cookieSwid.setDomain(DOMAIN_FANTASY);
	    cookieEspnS2.setDomain(DOMAIN_FANTASY);
	    cookieSwid.setPath("/");
	    cookieEspnS2.setPath("/");
	    cookieStore.addCookie(cookieSwid);
	    cookieStore.addCookie(cookieEspnS2);
	    
	    httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig)
	            .setDefaultCookieStore(cookieStore).build();
		try {


		    HttpGet request = new HttpGet(url);
		    
		    request.addHeader("content-type", "application/json");
		    request.addHeader("Accept", "application/json");
		    
		    response = httpClient.execute(request);
			try
			{
				StringBuffer buf = new StringBuffer();
				buf.append(response.getProtocolVersion() + "\n");
				buf.append(response.getStatusLine().getStatusCode() + "\n");
				buf.append(response.getStatusLine().getReasonPhrase() + "\n");
				buf.append(response.getStatusLine().toString() + "\n");

                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
    				String responseString = EntityUtils.toString(responseEntity, "UTF-8");
    				//System.out.println(responseString);
                    buf.append(responseString + "\n");
                    
    				Gson gson = new Gson();
    				JsonObject responseObject = (JsonObject) new JsonParser().parse(responseString);
					JsonElement teamsResponseObject = responseObject.get("teams");
                    buf.append(teamsResponseObject.toString() + "\n");

                    EspnApiResponse result = gson.fromJson(responseObject, EspnApiResponse.class);
                    responseWrapper.espnApiResponse = result;
                }
                
				//System.out.println(buf.toString());
				
			} catch(IOException ioex) {
				responseWrapper.status = "error";
	            StringWriter sw = new StringWriter();
	            ioex.printStackTrace(new PrintWriter(sw));
	            String exceptionAsString = sw.toString();
	            responseWrapper.stacktrace = exceptionAsString;
	            
			} finally {
				response.close();
			}
		} catch (Exception ex) {
		} finally {
			httpClient.close();
		}
		
		return responseWrapper;
	}
		
}
