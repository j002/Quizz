package com.fastdev.djibril.quizz.data.remote;


import com.fastdev.djibril.quizz.data.models.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface APIService {

    @POST("/api/user/login/")
    @FormUrlEncoded
    Call<Player> userLogin(
            @Field("login") String user_phonenumber,
            @Field("pwd") String user_password
    );


    @POST("api/user/")

    Call<Player> savePost1(@Body Player user);

    @GET("/userss")
    Call<List<Player>> getAnswers();

    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<Player> updatePost(@Path("id") long id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);

    @DELETE("/posts/{id}")
    Call<Player> deletePost(@Path("id") long id);

}
