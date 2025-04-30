package com.jacob.fruitoftek.safecrop.login.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpRequest {

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    private URL url;
    private HttpURLConnection connection;

    public HttpRequest(String urlString) throws IOException {
        this.url = new URL(urlString);
    }

    public HttpRequest prepare(String method) throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        return this;
    }

    public HttpRequest withData(Map<String, String> data) throws IOException {
        if(connection.getRequestMethod().equals(METHOD_POST)) {
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write(getQuery(data));
            writer.flush();
            writer.close();
            os.close();
        }
        return this;
    }

    public String sendAndReadString() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

    private String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }
        } catch (UnsupportedEncodingException e) {
            Log.e("EncodingError", "UTF-8 not supported", e);
        }
        return result.length() > 0
                ? result.substring(0, result.length() - 1)
                : result.toString();
    }
}
