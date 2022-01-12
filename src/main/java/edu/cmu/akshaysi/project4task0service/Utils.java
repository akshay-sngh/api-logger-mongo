package edu.cmu.akshaysi.project4task0service;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;

public class Utils {
    public static LocationsWouldAttend jsonToLocationsWouldAttend (String json) {
        LocationsWouldAttend lwa = new LocationsWouldAttend();
        JSONObject obj = new JSONObject(json);
        lwa.setResultsCount(obj.getInt("results_count"));
        lwa.setSampleSize(obj.getDouble("effective_sample_size"));
        JSONObject locationObject = obj.getJSONObject("locations_would_attend");
        HashMap<String, HashMap<String, String>> inputParams = (HashMap) (obj.getJSONObject("input_params")).toMap();
        HashMap<String, HashMap<String, HashMap<String, HashMap<String, Double>>>> locations = (HashMap) (obj.getJSONObject("locations_would_attend")).toMap();

        for (String key : locations.keySet()) {
            HashMap map = locations.get(key).get("weighted");
            Location l = new Location(key, ((BigDecimal)map.get("Yes")).doubleValue(), ((BigDecimal)map.get("No")).doubleValue());
            lwa.getLocations().add(l);
        }

        return lwa;
    }

    public static SurveyResult jsonToSurveyResult (String json) {
        SurveyResult result = new SurveyResult();
        JSONObject obj = new JSONObject(json);
        result.setResultsCount(obj.getInt("results_count"));
        result.setSampleSize(obj.getDouble("effective_sample_size"));
        result.setSurveyOutcome(json.substring(json.indexOf("locations_would_attend") + "locations_would_attend".length()));
        return result;
    }

    public static JSONObject jsonToSurveyResultJSON(String json) {
        JSONObject obj = new JSONObject(json);
        JSONObject surveyResults = new JSONObject();
        JSONObject locations = new JSONObject();
        if(obj.has("locations_would_attend")) {
            surveyResults = obj.getJSONObject("locations_would_attend");
            for (String locationName : surveyResults.keySet()) {
                JSONObject weight = surveyResults.getJSONObject(locationName).getJSONObject("weighted");
                System.out.println(weight.getDouble("Yes"));
                locations.append(locationName, String.format("%s, -%s", weight.getDouble("Yes"), weight.getDouble("No")));
            }
            obj.put("survey_results", locations);
            obj.remove("locations_would_attend");
        }
        else
            obj.put("error", "No data returned");
        obj.remove("input_params");
        obj.remove("results_count");

        return obj;
    }
}