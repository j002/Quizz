package com.fastdev.djibril.quizz.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Question {

    @SerializedName("question_id")
    @Expose
    private Integer question_id;

    @SerializedName("question_wording")
    @Expose
    private String question_wording;

    @SerializedName("theme_id")
    @Expose
    private Integer theme_id;

    @SerializedName("list_responses")
    @Expose
    private ArrayList<Response> list_responses;
}
