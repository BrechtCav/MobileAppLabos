package nmct.howest.be.stopafstandandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by BrechtCaveye on 11/05/2015.
 */

public class StopAfstandFragment extends Fragment {
    private EditText uwSnelheidView;
    private EditText uwReactietijdView;
    private TextView uwStopAfstandView;
    private RadioButton droogWegTypeView;
    private RadioButton natWegTypeView;
    private RadioGroup radioGroup;
    private Button buttonStopAfstand;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_stop_afstand, container, false);
        this.uwSnelheidView = (EditText) v.findViewById(R.id.txtsnelheid);
        this.uwReactietijdView = (EditText) v.findViewById(R.id.txtreactie);
        this.uwStopAfstandView = (TextView) v.findViewById(R.id.txtresult);
        this.droogWegTypeView = (RadioButton) v.findViewById(R.id.rbtdroog);
        this.natWegTypeView = (RadioButton) v.findViewById(R.id.rbtnat);
        this.radioGroup = (RadioGroup) v.findViewById(R.id.rbtgroupweg);
        this.buttonStopAfstand = (Button) v.findViewById(R.id.btnbereken);
        this.buttonStopAfstand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toonStopAfstand(v);
            }
        });
        return v;
    }
    public void toonStopAfstand(View v)
    {
        int snelheid = Integer.parseInt(this.uwSnelheidView.getText().toString());
        float tijd = Float.parseFloat(this.uwReactietijdView.getText().toString().replace(',','.'));
        int remweg = 0;
        if(droogWegTypeView.isChecked() == true)
        {
            remweg = 8;
        }
        if(natWegTypeView.isChecked() == true)
        {
            remweg = 5;
        }
        float result = StopAfstandInfo.getStopafstand(snelheid,tijd,remweg);
        uwStopAfstandView.setText(Float.toString(result));
    }
}