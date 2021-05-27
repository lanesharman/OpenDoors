package com.opendoors.landmanagement.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;


@Service
public class RagicHttpService {
    String user_agent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.192 Safari/537.36";
    String api_key = "VEYxNE5hM1o2b01WWHBuc1Z5MWZic21kSlY5YXpNcEI1eXJvZG55MEN5Y280eWE2YW1uYXl4Qyt5Tnp3Vk95Rg==";
    //String api_key = "MjRYclcwaUp3TUdPUGFjQU1zcDN3NE5VY1hJNlBETm5DVllSTWliMUpLNEUxaDJyeG10aWgwL3BWRmc1Q2lYMg==";
    // HTTP GET request
    public String sendGet(String url, String query) throws Exception {
        if (url.indexOf("?") == -1)
            url += "?" + query;
        else
            url += "&" + query;
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setRequestMethod("GET");
        // add request header
        conn.setRequestProperty("User-Agent", user_agent);
        conn.setRequestProperty("charset", "UTF-8");
        conn.setRequestProperty("Authorization", "Basic " + api_key);

        // Java7 resource try catch
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder jsonStr = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                jsonStr.append(inputLine);
            }
            return jsonStr.toString();
        }
    }

    // HTTP POST request
    public String sendPost(String url, String data) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        // add reuqest header
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", user_agent);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", "" + Integer.toString(data.getBytes().length));
        conn.setRequestProperty("Authorization", "Basic " + api_key);

        // send post data
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.writeBytes(data);
        }
        // read response, use Java7 resource try catch
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder jsonStr = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                jsonStr.append(inputLine);
            }
            return jsonStr.toString();
        }
    }

    public String sendDelete(String url, String query) throws Exception {
        if (url.indexOf("?") == -1)
            url += "?" + query;
        else
            url += "&" + query;
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setRequestMethod("DELETE");
        // add request header
        conn.setRequestProperty("User-Agent", user_agent);
        conn.setRequestProperty("charset", "UTF-8");
        conn.setRequestProperty("Authorization", "Basic " + api_key  );

        // Java7 resource try catch
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder jsonStr = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                jsonStr.append(inputLine);
            }
            return jsonStr.toString();
        }
    }
}
