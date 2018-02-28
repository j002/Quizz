package com.fastdev.djibril.quizz.data.remote;



public class ApiUtils {

    public static final String BASE_URL = "http://gettap.pythonanywhere.com/";


    private ApiUtils() {
    }

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
