package nmct.howest.be.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by BrechtCaveye on 10/04/2015.
 */
public class LifeCycleFragment extends Fragment {

    public LifeCycleFragment() {
        // Required empty public constructor
    }
    private Button btnact;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.d(getClass().getSimpleName(), "onCreateView");
        View v = inflater.inflate(R.layout.fragment_life_cycle, container, false);
        this.btnact = (Button) v.findViewById(R.id.btnact);
        this.btnact.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
        });
        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(getClass().getSimpleName(), "onAttach");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //d staat voor debug
        Log.d(getClass().getSimpleName(), "OnCreate");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(getClass().getSimpleName(), "OnActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(getClass().getSimpleName(), "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(getClass().getSimpleName(), "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(getClass().getSimpleName(), "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(getClass().getSimpleName(), "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(getClass().getSimpleName(), "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(getClass().getSimpleName(), "onDetach");
    }
}
