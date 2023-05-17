package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.ListFragment;

public class MyListFragment extends ListFragment {

    ListViewAdaptor adaptor;
    public MyListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adaptor = new ListViewAdaptor();
        setListAdapter(adaptor);

        addItem(new ListItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_background), "버스정류장1", "1111"));
        addItem(new ListItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground), "버스정류장2", "2222"));
        addItem(new ListItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_background), "버스정류장3", "3333"));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
    public void addItem(ListItem listItem) {
        adaptor.addItem(listItem);
    }
}
