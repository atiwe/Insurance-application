package se.mau.ac8110.navtest2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FuturePaymentsFragment extends Fragment {
    private PaymentsCardArrayAdapter cardArrayAdapter;
    private ListView listView;
    private String[] dates = {"2020-04-14", "2020-05-21"};
    private String[] title = {"Hemförsäkring", "Barnförsäkring"};
    private String[] types = {"989 kr", "1354 kr"};


    public FuturePaymentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_future_payments, container, false);
        listView = (ListView) view.findViewById(R.id.payments_listView);
        cardArrayAdapter = new PaymentsCardArrayAdapter(getActivity().getApplicationContext(), R.layout.payments_item_card);

        for (int i = 0; i < title.length; i++) {
            PaymentsCard card = new PaymentsCard(dates[i], title[i], types[i]);
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);

        return view;
    }

}
