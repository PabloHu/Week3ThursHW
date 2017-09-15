package com.example.admin.week3thurshw;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;



public class CelebFragment extends Fragment implements RecyclerViewAdapterCeleb.OnViewHolderInteractionListener{
    private static final String CELEB_PARAM = "celebList";
    public static final String TAG = "RedFragmantTAG";
    // TODO: Rename and change types of parameters

    RecyclerView rvCelebList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    List<Celebrity> celebrityList = new ArrayList<>();
ToggleButton toggleButton ;

    private OnFragmentInteractionListener mListener;

    public CelebFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static CelebFragment newInstance(List<Celebrity> celebrityList) {
        for (int i = 0; i < celebrityList.size(); i++) {

            Log.d(TAG, "newInstance: " + celebrityList.get(i).getName());
        }



        CelebFragment fragment = new CelebFragment();
        Bundle args = new Bundle();

        try {
            args.putParcelableArrayList(CELEB_PARAM, (ArrayList<? extends Parcelable>) celebrityList);
            Log.d(TAG, "newInstance: "+ "parcelable work!!");
        }
        catch (Exception e){
            Log.d(TAG, "newInstance: "+ e.toString());
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            celebrityList = getArguments().getParcelableArrayList(CELEB_PARAM);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCelebList = view.findViewById(R.id.rvCelebList);
        toggleButton = view.findViewById(R.id.toggle_button_id);

        // famousRecyclerView = view.findViewById(R.id.recycler_view_fragment_left);
        //I need to receive by paremeter the layout manager then a switch to select the correct one




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        RecyclerViewAdapterCeleb adapter = new RecyclerViewAdapterCeleb(celebrityList);
        adapter.setListener(this);
        rvCelebList.setAdapter(adapter);
        //layoutManager = new LinearLayoutManager(getContext());

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

          //      Toast.makeText(getContext(), "click in frag", Toast.LENGTH_SHORT).show();
                if (toggleButton.isChecked()){

                    layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
                    rvCelebList.setLayoutManager(layoutManager);
                }else {


                    layoutManager = new LinearLayoutManager(getContext());
                    rvCelebList.setLayoutManager(layoutManager);
                }
            }
        });

        layoutManager = new LinearLayoutManager(getContext());
        rvCelebList.setLayoutManager(layoutManager);

        // layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        //layoutManager = new LinearLayoutManager(getContext());
        itemAnimator = new DefaultItemAnimator();
        rvCelebList.setLayoutManager(layoutManager);
        rvCelebList.setItemAnimator(itemAnimator);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celeb, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
           // Toast.makeText(getContext(), "RedFrag"+data, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewHolderInteraction(String data) {
        onButtonPressed(data);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String uri);
        void sendDataToActivity(String data);
    }

    @Override
    public void onStop() {
        super.onStop();
      //  Toast.makeText(getContext(), "onstop", Toast.LENGTH_SHORT).show();
        celebrityList.clear();
    }
}
