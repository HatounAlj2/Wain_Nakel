package com.example.enghatoun.aqwas.HTTP;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://wainnakel.com/api/v1/";

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
