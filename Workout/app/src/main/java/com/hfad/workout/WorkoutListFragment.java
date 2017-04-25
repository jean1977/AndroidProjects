package com.hfad.workout;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {


    static interface  WorkoutListListener{
        void itemClick(long id);
    }

    private WorkoutListListener listener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] names = new String[Workout.workouts.length];
        for(int i=0;i<names.length;i++)
        {
            names[i] = Workout.workouts[i].getName();
        }
        ArrayAdapter adapter = new ArrayAdapter(inflater.getContext(),android.R.layout.simple_expandable_list_item_1,names);

        setListAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (WorkoutListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener != null)
        {
            listener.itemClick(id);
        }
    }
}