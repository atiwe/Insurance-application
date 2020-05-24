package se.mau.ac8110.navtest2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {
    private static final String TAG = "CardListActivity";
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;
    private String[] ensurances = {"Barnförsäkring", "Hemförsäkring"};
    private String[] dates = {"2020-07-09", "2020-11-03"};

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        listView = (ListView) view.findViewById(R.id.card_listView);
        cardArrayAdapter = new CardArrayAdapter(getActivity().getApplicationContext(), R.layout.list_item_card);

        for (int i = 0; i < ensurances.length; i++) {
            Card card = new Card(ensurances[i], dates[i]);
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);

        return view;
    }

}