package com.depe.iamhungry.recipe;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class YummlyApiClient {

    private final String URL = "https://yummly2.p.rapidapi.com/";
    private final String API_HEADER_KEY = "x-rapidapi-key";
    private final String API_HEADER_KEY_VALUE = "7d88bb3f4fmsh0b5f0ba848cc569p1ffa9ajsn4738de6c13f4";
    private final String API_HEADER_HOST = "x-rapidapi-host";
    private final String API_HEADER_HOST_VALUE = "yummly2.p.rapidapi.com";
    private final OkHttpClient client = new OkHttpClient();


    public Root getRecipe(int startNumber) {
        Root root;
        Request request = new Request.Builder()
                .url(URL + "feeds/search?maxResult=1&start=" + startNumber)
                .get()
                .addHeader(API_HEADER_KEY, API_HEADER_KEY_VALUE)
                .addHeader(API_HEADER_HOST, API_HEADER_HOST_VALUE)
                .build();
        try {
            Gson gson = new Gson();
            ResponseBody responseBody = client.newCall(request).execute().body();
            root = gson.fromJson(responseBody.string(), Root.class);
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        return root;
    }
    public Root getRecipeWithName(String name) {
        Request request = new Request.Builder()
                .url(URL + "feeds/search?maxResult=1&start=0&q=" + name)
                .get()
                .addHeader(API_HEADER_KEY, API_HEADER_KEY_VALUE)
                .addHeader(API_HEADER_HOST, API_HEADER_HOST_VALUE)
                .build();
        try{
            ResponseBody responseBody = client.newCall(request).execute().body();
            return getRootFromResponseBodyInJson(responseBody);
        }
        catch (IOException exception){
            throw new RestServerException();
        }
    }

    private static Root getRootFromResponseBodyInJson(ResponseBody responseBody) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(responseBody.string(), Root.class);
    }

    public Root getRecipesWithNameAndLimitAndStart(String name, int limit, int start) {
        Request request = new Request.Builder()
                .url(URL + "feeds/search?maxResult=" + limit + "&start=" + start + "&q=" + name)
                .get()
                .addHeader(API_HEADER_KEY, API_HEADER_KEY_VALUE)
                .addHeader(API_HEADER_HOST, API_HEADER_HOST_VALUE)
                .build();
        try{
            ResponseBody responseBody = client.newCall(request).execute().body();
            return getRootFromResponseBodyInJson(responseBody);
        }
        catch (IOException exception){
            throw new RestServerException();
        }
    }

}

