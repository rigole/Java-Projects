package com.covidtracker.covidtracker.services;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.net.http.HttpClient;
public class CoronaDataService {
    private static String DATA_SET_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    //private List<> allStats = new ArrayList<>();
    //public List<> getAllStats(){
    //    return allStats;
   // }

    public void fetchVirusData() throws IOException, InterruptedException {
      //  List<> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DATA_SET_URL))
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
    }
}
