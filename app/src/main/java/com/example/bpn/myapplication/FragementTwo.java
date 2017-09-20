package com.example.bpn.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpn on 20/09/17.
 */

public class FragementTwo extends Fragment  {


    List list;
    ListView mListView;
    ArrayAdapter arrayAdapter;
    View view;
    Main2Activity main2Activity ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    BroadcastReceiver mBroadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            ArrayList<String> data = intent.getStringArrayListExtra("ParsedData");
            for(int i=0; i<data.size() ;i++){
                Object o = data.get(i) +" \n" + data.get(++i) +"  \n "+ data.get(++i) ;
                list.add(o.toString());
            }

            arrayAdapter.notifyDataSetChanged();

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.fragement_layout_two, container, false);

        mListView = view.findViewById(R.id.list_item2);
        list = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.list_view_layout, R.id.text, list);
        mListView.setAdapter(arrayAdapter);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mBroadCastReceiver,new IntentFilter("passDataToFragement1"));
        return view;
    }


//    @Override
//    public void receiveDataFromDownloadClass(ArrayList a ) {
//
//        for (int i = 0; i < a.size(); i++) {
//            Object o = a.get(i) + " \n" + a.get(++i) + "  \n " + a.get(++i);
//            list.add(o.toString());
//        }
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                arrayAdapter.notifyDataSetChanged();
//            }
//        });
//
//    }
}