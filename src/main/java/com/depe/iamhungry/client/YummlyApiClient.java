package com.depe.iamhungry.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class YummlyApiClient {

    @Value("${yummly.api.url}")
    private String URL;
    @Value("${yummly.api.header_key}")
    private String API_HEADER_KEY;
    @Value("${yummly.api.header_key_value}")
    private String API_HEADER_KEY_VALUE;
    @Value("${yummly.api.header_host}")
    private String API_HEADER_HOST;
    @Value("${yummly.api.header_host_value}")
    private String API_HEADER_HOST_VALUE;
    private final OkHttpClient client = new OkHttpClient();

    public ResponseBody getResponseBodyWithRecipe(int startNumber) {
        Request request = new Request.Builder()
                .url(URL + "feeds/search?maxResult=1&start=" + startNumber)
                .get()
                .addHeader(API_HEADER_KEY, API_HEADER_KEY_VALUE)
                .addHeader(API_HEADER_HOST, API_HEADER_HOST_VALUE)
                .build();
        try {
           return client.newCall(request).execute().body();
        }
        catch (IOException ex) {
            throw new ApiException();
        }
    }

    public ResponseBody getResponseBodyWithRecipeWithName(String name) {
        Request request = new Request.Builder()
                .url(URL + "feeds/search?maxResult=1&start=0&q=" + name)
                .get()
                .addHeader(API_HEADER_KEY, API_HEADER_KEY_VALUE)
                .addHeader(API_HEADER_HOST, API_HEADER_HOST_VALUE)
                .build();
        try{
            return client.newCall(request).execute().body();
        }
        catch (IOException exception){
            throw new ApiException();
        }
    }


    public ResponseBody getResponseBodyWithRecipesWithNameAndLimitAndStart(String name, int limit, int start) {
        Request request = new Request.Builder()
                .url(URL + "feeds/search?maxResult=" + limit + "&start=" + start + "&q=" + name)
                .get()
                .addHeader(API_HEADER_KEY, API_HEADER_KEY_VALUE)
                .addHeader(API_HEADER_HOST, API_HEADER_HOST_VALUE)
                .build();
        try{

            ResponseBody responseBody = client.newCall(request).execute().body();
            return responseBody;
        }
        catch (IOException exception){
            throw new ApiException();
        }
    }
}