package com.example.todor.blueteam.MainMenuChoices;


import android.os.Bundle;
import android.app.Fragment;
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

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartingLineupFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ArrayAdapter<String> mPlayersAdapter;
    private FirebaseFirestore mDb;
    private FirebaseRepository<Player> mPlayersRepository;
    private ListView mPlayersListView;
    private Navigator mNavigator;


    public StartingLineupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_starting_lineup2, container, false);
mDb=FirebaseFirestore.getInstance();
        mPlayersListView = view.findViewById(R.id.lv_first_team);
        mPlayersAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1);
        mPlayersListView.setAdapter(mPlayersAdapter);

        mPlayersRepository = new FirebaseRepository<>(Player.class);

        mDb.collection("subtitutes")
                .get()
                .addOnCompleteListener(task -> {
                    List<Player> subtitutes  = task.getResult().toObjects(Player.class);

                    for(Player player:subtitutes)
                    {
                        mPlayersAdapter.add(player.Name);
                    }
                });



        mPlayersListView.setOnItemClickListener(this);
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
        String player = mPlayersAdapter.getItem(position);
        mNavigator.navigateWith(player);
    }
}
