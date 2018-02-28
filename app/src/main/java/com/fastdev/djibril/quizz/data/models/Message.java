package com.fastdev.djibril.quizz.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("message_id")
    @Expose
    private Integer message_id;

    @SerializedName("message_wording")
    @Expose
    private String message_wording;

    @SerializedName("message_time")
    @Expose
    private String message_time;

    @SerializedName("player_id")
    @Expose
    private Integer player_id;




}
