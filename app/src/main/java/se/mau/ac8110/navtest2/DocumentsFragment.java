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
public class DocumentsFragment extends Fragment {
    private static final String TAG = "CardListActivity";
    private DocumentCardArrayAdapter cardArrayAdapter;
    private ListView listView;

    private String[] dates = {"2019-11-14", "2019-04-03"};
    private String[] title = {"Barnförsäkring", "Hemförsäkring"};
    private String[] types = {"Faktura", "Faktura"};

    public DocumentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_documents, container, false);
        listView = (ListView) view.findViewById(R.id.documents_listView);
        cardArrayAdapter = new DocumentCardArrayAdapter(getActivity().getApplicationContext(), R.layout.list_item_card);

        for (int i = 0; i < title.length; i++) {
            DocumentCard card = new DocumentCard(dates[i], title[i], types[i]);
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);

        return view;
    }

}
