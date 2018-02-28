package com.fastdev.djibril.quizz.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("response_id")
    @Expose
    private Integer response_id;

    @SerializedName("response_wording")
    @Expose
    private String response_wording;

    @SerializedName("response_statut")
    @Expose
    private Boolean response_statut;



}
