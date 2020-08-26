package com.depromeet.humming.youtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;

public class Youtube {
  public String search(String search) throws IOException {
    String apiUrl = "https://www.googleapis.com/youtube/v3/search";
    apiUrl += "?key=AIzaSyBRa6UEjmyCOrv5ug1jEB8DOs2NuKZFePk";
    apiUrl += "&part=snippet&type=video&maxResults=20&videoEmbeddable=true";
    apiUrl += "&q=" + URLEncoder.encode(search, "UTF-8");

    URL url = new URL(apiUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
    String inputLine;
    StringBuffer response = new StringBuffer();
    while ((inputLine = br.readLine()) != null) {
      response.append(inputLine);
    }
    br.close();

    return response.toString();
  }
}