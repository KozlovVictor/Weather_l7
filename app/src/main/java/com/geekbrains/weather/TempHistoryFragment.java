package com.geekbrains.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TempHistoryFragment extends BaseFragment {
    RecyclerView rec_view_temp_list;
    EditText add_temp_to_list_edit;
    Button add_temp_to_list_button;
    int [] temp_array;


    public TempHistoryFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.temp_history_fragment, container, false);
    }

    @Override
    protected void initLayout(View view, Bundle savedInstanceState) {
        add_temp_to_list_edit = view.findViewById(R.id.add_temp_to_list_edit);
        add_temp_to_list_button = view.findViewById(R.id.add_temp_to_list_button);
        add_temp_to_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO add item to array
            }
        });
        temp_array = getResources().getIntArray(R.array.temp_list_item);

        rec_view_temp_list = view.findViewById(R.id.temp_history_list);
        rec_view_temp_list.setHasFixedSize(true);

        rec_view_temp_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rec_view_temp_list.setAdapter(new TempListAdapter(temp_array));


    }

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.activity_base_drawer, menu);
    }*/
}
