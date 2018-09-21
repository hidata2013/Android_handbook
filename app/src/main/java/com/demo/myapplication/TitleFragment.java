package com.demo.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TitleFragment extends Fragment {

    RecyclerView recyclerView;
    TitleAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TitleAdapter(getActivity());
        List<String> titleList = new ArrayList<>();
        titleList.add("TextView");
        titleList.add("TextView");
        titleList.add("TextView");
        adapter.setTitleList(titleList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.title_list, null);
    }

    class ItemClick implements TitleAdapter.OnItemClick {

        @Override
        public void onItemClick(int position, View view) {
            String titleName = null;
            if (view.getTag() instanceof String) {
                titleName = (String) view.getTag();
            }
            if (titleName == null || titleName.length() == 0) {
                return;
            }
//            switch (titleName){
//                case
//            }
        }
    }
}
