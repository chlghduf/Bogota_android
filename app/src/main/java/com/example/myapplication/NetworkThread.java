package com.example.myapplication;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NetworkThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/stationinfo/getStationByName");
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8")+"=k8TV0tzwFHNJE4z7KzTipafjxxhhC3EFYBxQdW9/ouXJed3WkRjL8haC7LPgdozPFALzfWx0HwCZ7JjRxPPuzQ==");
            urlBuilder.append("&" + URLEncoder.encode("stSrch","UTF-8") + "="+ URLEncoder.encode("가곡초교","UTF-8"));
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            Log.e("TEST1", ""+conn.getResponseCode());

            BufferedReader rd;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            Log.e("TEST", sb.toString());
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
