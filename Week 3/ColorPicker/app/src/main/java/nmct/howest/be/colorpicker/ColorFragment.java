package nmct.howest.be.colorpicker;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by BrechtCaveye on 10/04/2015.
 */
public class ColorFragment extends Fragment {

    public ColorFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        myColorView = (ColorView) v.findViewById(R.id.myColorView1);

        if (savedInstanceState != null) {
            Log.d("ColorView", "onRestore: " + savedInstanceState.getString(SS_COLOR));
            myColorView.setColor(savedInstanceState.getString(SS_COLOR));
        }

        return v;
    }
    private static final String SS_COLOR = "color";
    public ColorView myColorView;
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SS_COLOR, myColorView.getColor());
        Log.d("ColorView", "onSaveInstance: " + myColorView.getColor());
    }
}
