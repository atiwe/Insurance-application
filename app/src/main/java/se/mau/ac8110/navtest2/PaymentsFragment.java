package se.mau.ac8110.navtest2;


import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentsFragment extends Fragment implements TabLayout.BaseOnTabSelectedListener {
    private TabItem tabItem_future;
    private TabItem tabItem_history;
    private TabLayout tabLayout;
    private FuturePaymentsFragment futurePaymentsFragment;
    private HistoryPaymentsFragment historyPaymentsFragment;
    private View view;

    public PaymentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_payments, container, false);
        initializeComponents(view);



        loadFragment(futurePaymentsFragment);
        return view;
    }

    private void initializeComponents(View view) {
        tabItem_future = (TabItem) view.findViewById(R.id.tabItem_future);
        tabItem_history = (TabItem) view.findViewById(R.id.tabItem_history);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(this);
        futurePaymentsFragment = new FuturePaymentsFragment();
        historyPaymentsFragment = new HistoryPaymentsFragment();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if(tab.getText().equals("Historik")){
            loadFragment(historyPaymentsFragment);
        }else if(tab.getText().equals("Kommande")){
            loadFragment(futurePaymentsFragment);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.payments_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
