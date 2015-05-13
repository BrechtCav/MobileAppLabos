package nmct.howest.be.bmi;


import android.app.Fragment;
import android.os.Bundle;
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
                toonindex(v);
            }
        });
        return v;
    }
    public void toonindex(View v)
    {
        int mass = Integer.parseInt(this.uwmass.getText().toString());
        float height = Float.parseFloat(this.uwheight.getText().toString().replace(',', '.'));
        float result = BMIInfo.recalculate(height,mass);
        txtindex.setText(Float.toString(result));
        BMIInfo.Category cat = BMIInfo.Category.getGategory(result);
        txtcat.setText(cat.toString());

        this.imgsil.setImageResource(getResourceId(cat));
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
}