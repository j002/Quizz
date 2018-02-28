package com.fastdev.djibril.quizz.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Game {

    @SerializedName("game_id")
    @Expose
    private Integer game_id;

    @SerializedName("game_wording")
    @Expose
    private String game_wording;

    @SerializedName("theme_id")
    @Expose
    private Integer theme_id;

    @SerializedName("list_questions")
    @Expose
    private ArrayList<Question> list_questions;
}
