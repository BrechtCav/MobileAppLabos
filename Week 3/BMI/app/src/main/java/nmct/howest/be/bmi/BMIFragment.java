package nmct.howest.be.bmi;


import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BrechtCaveye on 10/04/2015.
 */
public class BMIFragment extends Fragment {
    private EditText uwheight;
    private EditText uwmass;
    private Button btnUpdate;
    private ImageView imgsil;
    private TextView txtindex;
    private TextView txtcat;


    public BMIFragment() {
        // Required empty public constructor
    }
    public static final String PREFS_NAME = "MyPrefsFile";
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        this.uwheight = (EditText) v.findViewById(R.id.txtheight);
        this.uwmass = (EditText) v.findViewById(R.id.txtmass);
        this.txtindex = (TextView) v.findViewById(R.id.txtindex);
        this.txtcat = (TextView) v.findViewById(R.id.txtcat);
        this.imgsil = (ImageView) v.findViewById(R.id.imgsil);
        this.btnUpdate = (Button) v.findViewById(R.id.btnUpdate);
        this.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toonindex();
            }
        });
        return v;
    }
    public void toonindex()
    {
        if(this.uwheight.getText().toString().isEmpty() || this.uwmass.getText().toString().equals("")) {
            int mass = Integer.parseInt(this.uwmass.getText().toString());
            float height = Float.parseFloat(this.uwheight.getText().toString().replace(',', '.'));
            float result = BMIInfo.recalculate(height, mass);
            txtindex.setText(Float.toString(result));
            BMIInfo.Category cat = BMIInfo.Category.getGategory(result);
            txtcat.setText(cat.toString());
            this.imgsil.setImageResource(getResourceId(cat));
        }
    }
    private int getResourceId(BMIInfo.Category category)
    {
        switch (category){
            case Groot_Ondergewicht:
                return R.drawable.silhouette_1;
            case Ernstig_ondergewicht:
                return R.drawable.silhouette_2;
            case Ondergewicht:
                return R.drawable.silhouette_3;
            case Normaal:
                return R.drawable.silhouette_4;
            case Overgewicht:
                return R.drawable.silhouette_5;
            case Matig_Overgewicht:
                return R.drawable.silhouette_6;
            case Ernstig_overgewicht:
                return R.drawable.silhouette_7;
            case Zeer_groot_overgewicht:
                return R.drawable.silhouette_8;
            default:break;
        }
        return R.drawable.silhouette_1;
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
        toonindex();
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

        if(!(this.uwheight.getText().toString().equals("") || this.uwmass.getText().toString().equals("")))
        {
            SharedPreferences settings = this.getActivity().getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();

            float tempHeight = Float.parseFloat(this.uwheight.getText().toString());
            int tempMass = Integer.parseInt(this.uwmass.getText().toString());
            editor.putFloat("uwheight", tempHeight);
            editor.putInt("uwmass", tempMass);

            editor.apply();
        }
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