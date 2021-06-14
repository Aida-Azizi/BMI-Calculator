package net.aida.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText edWeg,edHei;
        TextView txtRes, txtInter;
        Button btnRes,btnReset;

        edWeg=(EditText) findViewById (R.id.edweg);
        edHei=(EditText) findViewById(R.id.edhei);

        txtInter=(TextView) findViewById(R.id.txtinter);
        txtRes=(TextView) findViewById(R.id.txtres);

        btnRes=(Button) findViewById(R.id.btnres);
        btnReset= (Button) findViewById(R.id.btnreset);

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweg = edWeg.getText().toString();
                String strhei = edHei.getText().toString();

                if(strweg.equals("")){
                    edWeg.setError("Please Enter Your Weight");
                    edWeg.requestFocus();
                    return;
                }
                if (strhei.equals("")){
                    edHei.setError("Please Enter Your Weight");
                    edHei.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strhei)/100;

                float bmiValue = BMICalculate (weight,height);

                txtInter.setText(interpreteBMI(bmiValue));
                txtRes.setText(("BMI= " + bmiValue));
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edHei.setText("");
                edWeg.setText("");
                txtInter.setText("");
                txtRes.setText("");
            }
        });
    }
    public float BMICalculate (float weight,float height){
        return weight / (height * height);
    }
    public String interpreteBMI(float bmiValue){
        if (bmiValue < 18.4){
            return "UnderWeight & Mainutrition Risk";
        }
        else if (bmiValue >= 18.5 && bmiValue <= 24.9){
            return "NormalWeight & Low Risk";
        }
        else if (bmiValue >= 25 && bmiValue <= 29.9){
            return "OverWeight & Enchanced Risk";
        }
        else if (bmiValue >= 30 && bmiValue <= 34.9){
            return "ModeratelyObese & Medium Risk";
        }
        else if (bmiValue >= 35 && bmiValue <= 39.9){
            return "SeverelyObese & High Risk";
        }
        else
            return "VerySeverelyObese & Very High Risk";
    }
}