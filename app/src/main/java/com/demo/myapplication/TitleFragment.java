package com.demo.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TitleFragment extends Fragment implements TitleAdapter.OnItemClick {

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
        adapter.setOnItemClick(this);
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


    @Override
    public void onItemClick(int position, View view) {
        String titleName = null;
        if (view.getTag() instanceof String) {
            titleName = (String) view.getTag();
        }
        if (titleName == null || titleName.length() == 0) {
            return;
        }
        switch (titleName) {
            case "title":

        }
    }


    public void add(Fragment fragment, int id, String tag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //优先检查，fragment是否存在，避免重叠
        Fragment tempFragment = (Fragment) fragmentManager.findFragmentByTag(tag);
//        if (fragment.isAdded()) {
//            addOrShowFragment(fragmentTransaction, fragment, id, tag);
//        } else {
//            if (currentFragment != null && currentFragment.isAdded()) {
//                fragmentTransaction.hide(currentFragment).add(id, fragment, tag).commit();
//            } else {
//                fragmentTransaction.add(id, fragment, tag).commit();
//            }
//            currentFragment = fragment;
//        }
        fragmentTransaction.add(id, fragment, tag).commit();
//        fragmentTransaction.replace();
    }

    /**
     * 添加或者显示 fragment
     *
     * @param fragment
     */
    private void addOrShowFragment(FragmentTransaction transaction, Fragment fragment, int id, String tag) {
//        if (currentFragment == fragment)
//            return;
//        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
//            transaction.hide(currentFragment).add(id, fragment, tag).commit();
//        } else {
//            transaction.hide(currentFragment).show(fragment).commit();
//        }
//        currentFragment.setUserVisibleHint(false);
//        currentFragment = fragment;
//        currentFragment.setUserVisibleHint(true);
    }
}
