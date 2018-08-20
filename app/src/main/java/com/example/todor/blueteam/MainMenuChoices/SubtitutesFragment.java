package com.example.todor.blueteam.MainMenuChoices;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.todor.blueteam.Navigator;
import com.example.todor.blueteam.R;
import com.example.todor.blueteam.Repositories.FirebaseRepository;
import com.example.todor.blueteam.models.Player;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubtitutesFragment extends Fragment implements AdapterView.OnItemClickListener{


    private FirebaseFirestore mDb;
    private ListView mSubtitutesListView;
    private ArrayAdapter<String> mSubtitutesAdapter;
    private FirebaseRepository<Player> mSubtitutesRepo;
    private Navigator mNavigator;


    public SubtitutesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_subtitutes, container, false);
        mDb= FirebaseFirestore.getInstance();
        mSubtitutesListView = view.findViewById(R.id.lv_first_team);
        mSubtitutesAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1);
        mSubtitutesListView.setAdapter(mSubtitutesAdapter);

        mSubtitutesRepo = new FirebaseRepository<>(Player.class);

        mSubtitutesRepo.getAll(subtitutes-> {
            for (Player player : subtitutes) {
                mSubtitutesAdapter.add(player.Name);
            }
        });
        mSubtitutesListView.setOnItemClickListener(this);
        return view;
    }
    public static StartingLineupFragment newInstance(){
        return new StartingLineupFragment();
    }

    public void setNavigator(Navigator navigator){
        mNavigator = navigator;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String player = mSubtitutesAdapter.getItem(position);
        mNavigator.navigateWith(player);
    }
}
