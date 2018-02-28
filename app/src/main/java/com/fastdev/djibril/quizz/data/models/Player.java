package com.fastdev.djibril.quizz.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("player_name")
    @Expose
    private String player_name;

    @SerializedName("player_password")
    @Expose
    private String player_password;

    @SerializedName("player_id")
    @Expose
    private Integer player_id;

    @SerializedName("player_email")
    @Expose
    private String player_email;


}
