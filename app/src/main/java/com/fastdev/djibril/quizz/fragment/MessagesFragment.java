package com.fastdev.djibril.quizz.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fastdev.djibril.quizz.R;
import com.fastdev.djibril.quizz.activity.Message;
import com.fastdev.djibril.quizz.adapter.Movie;
import com.fastdev.djibril.quizz.adapter.MessageAdapter;
import com.fastdev.djibril.quizz.adapter.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MessageAdapter mAdapter;


    public MessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_messages, container, false);


        recyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_view);

        mAdapter = new MessageAdapter(movieList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(getActivity(),Message.class));

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();

        return rootview;
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Tamsir Sall", "on joue une partie?", "20:30");
        movieList.add(movie);

        movie = new Movie("Abdoulaye Loum", "les test sont ok", "20:29");
        movieList.add(movie);

        movie = new Movie("Demba Thiam", "salut petit ", "20:15");
        movieList.add(movie);

        movie = new Movie("Paul François", "Mdr tu changes pas mec", "20:15");
        movieList.add(movie);

        movie = new Movie("Martial", "bon a plus", "20:15");
        movieList.add(movie);

        movie = new Movie("Moulaye", "ok bye bye", "20:15");
        movieList.add(movie);

        movie = new Movie("Jean Paul", "tu as regardé le match?", "20:09");
        movieList.add(movie);

        movie = new Movie("Abdoul Diouf", "je sais vraiment pas", "20:09");
        movieList.add(movie);

        movie = new Movie("Marina", "salut boy cava?", "20:04");
        movieList.add(movie);

        movie = new Movie("Ahmadou Lo", "Tu le met dans le android mannifest", "20:01");
        movieList.add(movie);

        movie = new Movie("Djibril Diop", "bon a toute", "20:00");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "tu fait quoi?", "20:00");
        movieList.add(movie);

        movie = new Movie("Pape Modou", "Yo Mec Cava", "19:55");
        movieList.add(movie);

        movie = new Movie("Cristianio Ronaldo", "Tu aime le foot?", "19:41");
        movieList.add(movie);

        movie = new Movie("Anias", "Bonjour çava?", "19:25");
        movieList.add(movie);

        movie = new Movie("Maxime", "Bonjour Comment tu vas?", "19:14");
        movieList.add(movie);

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

}
