package se.mau.ac8110.navtest2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class InjuryFragment extends Fragment {
    private Button btnInjury;

    public InjuryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_injury, container, false);
        btnInjury = (Button) view.findViewById(R.id.btnInjury);
        btnInjury.setOnClickListener(new BtnListener());
        return view;
    }

    private class BtnListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("https://www.trygghansa.se/anmal-en-skada"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }
}
