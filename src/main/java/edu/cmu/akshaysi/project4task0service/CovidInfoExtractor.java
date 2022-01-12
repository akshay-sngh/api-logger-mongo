package edu.cmu.akshaysi.project4task0service;

// Client side code making calls to an HTTP service
// The service provides GET, DELETE, and PUT
// Simple example client storing and deleting name, value pairs on the server


import edu.cmu.akshaysi.project4task0service.model.CovidInfoStore;
import edu.cmu.akshaysi.project4task0service.rest.Result;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class CovidInfoExtractor {
    private static Scanner input;
    private static final String API_ENDPOINT = "http://covidsurvey.mit.edu:5000/query?age=";
    private static final String API_TAILER = "&gender=all&country=US&signal=locations_would_attend";

    public static void main(String[] args) throws Exception {

    }

    public SurveyResult getCovidInfo(String ageRange) {
        String requestURL = createRequestURL(ageRange);
        Result apiResponse = doGet(requestURL);
        return extractCovidInfo(apiResponse);
    }

    public JSONObject getCovidInfoJSON(String ageRange) {
        String requestURL = createRequestURL(ageRange);
        Result apiResponse = doGet(requestURL);
        return extractCovidInfoJSON(apiResponse);
    }

    private SurveyResult extractCovidInfo(Result apiResponse) {
        return Utils.jsonToSurveyResult(apiResponse.getResponseText());
    }

    private JSONObject extractCovidInfoJSON(Result apiResponse) {
        return Utils.jsonToSurveyResultJSON(apiResponse.getResponseText());
    }

    private String createRequestURL(String ageRange) {
        StringBuilder sb = new StringBuilder();
        sb.append(API_ENDPOINT).append(ageRange).append(API_TAILER);
        return sb.toString();
    }

    // Call doGet with a name
    public Result read(String name) {
        Result r = doGet(name);
        return r;
    }


    // Make an HTTP GET request
    public Result doGet(String requestURL) {

        HttpURLConnection conn;
        int status = 0;
        Result result = new Result();
        try {
            // GET wants us to pass the name on the URL line
            URL url = new URL(requestURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // we are sending plain text
            conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
            // tell the server what format we want back
            conn.setRequestProperty("Accept", "text/plain");

            // wait for response
            status = conn.getResponseCode();

            // set http response code
            result.setResponseCode(status);
            // set http response message - this is just a status message
            // and not the body returned by GET
            result.setResponseText(conn.getResponseMessage());

            if (status == 200) {
                String responseBody = getResponseBody(conn);
                result.setResponseText(responseBody);
            }

            conn.disconnect();

        }
        // handle exceptions
        catch (MalformedURLException e) {
            System.out.println("URL Exception thrown" + e);
        } catch (IOException e) {
            System.out.println("IO Exception thrown" + e);
        } catch (Exception e) {
            System.out.println("IO Exception thrown" + e);
        }
        return result;
    }

    // Gather up a response body from the connection
    // and close the connection.
    public String getResponseBody(HttpURLConnection conn) {
        String responseText = "";
        try {
            String output = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            while ((output = br.readLine()) != null) {
                responseText += output;
            }
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("Exception caught " + e);
        }
        return responseText;
    }
}