package com.example.android.popularmovies;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by acowell on 4/12/2016.
 */
public class Utility {
    private static final String LOG_TAG = Utility.class.getSimpleName();

    public Utility() {
    }

    public Uri buildURI(String query_type, String apikey) {

        // Construct the URL for the MovieDB query
        // the query type (popular, or top_rated) will passed-in
        // https://api.themoviedb.org/3/movie/popular?api_key=###########
        final String BASE_URL = "https://api.themoviedb.org/3/movie/";
        final String APIKEY_PARAM = "api_key";

        // build URI
        return Uri.parse(BASE_URL).buildUpon()
                .appendPath(query_type)
                .appendQueryParameter(APIKEY_PARAM, apikey)
                .build();
    }

    public List<String> parseJson(String jsonToParse)throws JSONException {
        final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185";
        List<String> paths = new ArrayList<String>();
        Log.d(LOG_TAG,"JSON STRING: " + jsonToParse);

        JSONObject joRoot = new JSONObject(jsonToParse);
        JSONArray jaResults = new JSONArray(); // array for results
        jaResults = joRoot.optJSONArray("results");

        // for each movie, add poster path to results array list
        for(int i=0; i<jaResults.length(); i++){
            paths.add(BASE_IMAGE_URL + jaResults.getJSONObject(i).getString("poster_path"));
            Log.d(LOG_TAG, "path[" + i + "]: " + jaResults.getJSONObject(i).getString("poster_path"));
        }

        return paths;
    }
}
