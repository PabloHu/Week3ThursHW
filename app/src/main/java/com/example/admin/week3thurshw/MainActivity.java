package com.example.admin.week3thurshw;

import android.support.v4.app.FragmentActivity;


import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
        CelebInfoFragment.OnFragmentInteractionListener, CelebFragment.OnFragmentInteractionListener{
    private static final String BLUE_FRAGMENT_TAG = "bluefragmentRAG";
    private static final String CELEB_OPTIONS_FRAGMENT_TAG = "celebfragRAG";
    private static final String TAG = "HomeActivityTag";
    List<Celebrity> celebrityList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoFillData();
        addCelebDetailsFragment();

    }



    private void addCelebDetailsFragment() {



        CelebInfoFragment celebInfoFragment = CelebInfoFragment.newInstance(celebrityList.get(0));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragHolderBlue, celebInfoFragment, CELEB_OPTIONS_FRAGMENT_TAG)
                .addToBackStack(CELEB_OPTIONS_FRAGMENT_TAG)

                .commit();

        CelebFragment redFragment = CelebFragment.newInstance(celebrityList);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragHolderCelebOptions, redFragment, BLUE_FRAGMENT_TAG)
                .addToBackStack(BLUE_FRAGMENT_TAG)

                .commit();

    }



    private void autoFillData() {
        Celebrity celebrity;
        celebrity = new Celebrity(1, "Maria Sharapova", 24, 110, R.drawable.mariasharapova);
        celebrityList.add(celebrity);
        celebrity = new Celebrity(2, "Anne Hathaway", 30, 110, R.drawable.annehathaway);
        celebrityList.add(celebrity);
        celebrity = new Celebrity(3, "Emma Watson", 21, 110, R.drawable.emmawatson);
        celebrityList.add(celebrity);
        celebrity = new Celebrity(4, "Haruna Ono", 26, 105, R.drawable.harunaono);
        celebrityList.add(celebrity);
        celebrity = new Celebrity(5, "Sabine Schmitz", 42, 130, R.drawable.sabineschmitz);
        celebrityList.add(celebrity);
        celebrity = new Celebrity(6, "Jeremy Clarkson", 56, 185, R.drawable.jeremyclarkson);
        celebrityList.add(celebrity);
        celebrity = new Celebrity(7, "Richard Hammond", 46, 165, R.drawable.richardhammond);
        celebrityList.add(celebrity);
        celebrity = new Celebrity(8, "James May", 60, 175, R.drawable.jamesmay);
        celebrityList.add(celebrity);
    }

    @Override
    public void onFragmentInteraction(String uri) {
     //   Toast.makeText(this, uri, Toast.LENGTH_SHORT).show();

        int position = Integer.parseInt(uri);
        CelebInfoFragment celebInfoFragment = CelebInfoFragment.newInstance(celebrityList.get(position));
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flFragHolderBlue, celebInfoFragment, CELEB_OPTIONS_FRAGMENT_TAG)
                .addToBackStack(CELEB_OPTIONS_FRAGMENT_TAG)

                .commit();
    }

    @Override
    public void sendDataToActivity(String data) {


    }



}
