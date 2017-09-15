package com.example.admin.week3thurshw;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class CelebInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String CELEB_PARAM = "celebList";
public static final String TAG = "BlueFragmantTAG";
    // TODO: Rename and change types of parameters

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
Celebrity celebrity;
    private TextView tvName ;
    private TextView tvAge;
    private TextView tvWeight;
    private ImageView imageDisplay;
    private OnFragmentInteractionListener mListener;

    public CelebInfoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CelebInfoFragment newInstance(Celebrity celebrity) {



        CelebInfoFragment fragment = new CelebInfoFragment();
        Bundle args = new Bundle();
        args.putParcelable(CELEB_PARAM, celebrity);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            celebrity = getArguments().getParcelable(CELEB_PARAM);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = view.findViewById(R.id.tvName);
        tvAge = view.findViewById(R.id.tvAge);
        tvWeight = view.findViewById(R.id.tvWeight);
        imageDisplay = view.findViewById(R.id.imageDisplay);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvName.setText(celebrity.getName());
        tvAge.setText(String.valueOf(celebrity.getAge()));
        tvWeight.setText(String.valueOf(celebrity.getWeight()));
        imageDisplay.setImageResource(celebrity.getImageID());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celeb_info, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String uri);
        void sendDataToActivity(String data);
    }
}
