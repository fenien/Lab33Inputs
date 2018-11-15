package my.edu.tarc.lab33inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale, radioButtonTransgender;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonTransgender = findViewById(R.id.radioButtonTransgender);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremuim);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.age_group, android.R.layout.simple_spinner_item

        );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAge.setAdapter(adapter);
            spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(this,"position=" + position, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int position;
        float premium = 0;


        position = spinnerAge.getSelectedItemPosition();
        switch(position){
            case 0:
                //TODO calculate the basic premium;
                premium = 50;
                break;
            case 1:
                //TODO calculate the basic premium;
                premium = 55;
                break;
            case 2:
                //TODO calculate the basic premium;
                premium = 60;
                break;
            case 3:
                //TODO calculate the basic premium;
                premium = 70;
                break;
            case 4:
                //TODO calculate the basic premium;
                premium = 120;
                break;
            case 5:
                //TODO calculate the basic premium;
                premium = 160;
                break;
            case 6:
                //TODO calculate the basic premium;
                premium = 200;
                break;
            case 7:
                //TODO calculate the basic premium;
                premium = 250;
                break;
        }

        int gender;
        gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender ==R.id.radioButtonMale){
            //TODO calculate extra premium for male
            switch(position){
                case 2:
                case 5:
                    //TODO calculate the basic premium;
                    premium += 50;
                    break;
                case 3:
                case 4:
                    //TODO calculate the basic premium;
                    premium += 100;
                    break;
            }
        }
        if(checkBoxSmoker.isChecked()){
            //TODO calculate extra premium for smoker
            switch(position){
                case 3:
                    premium += 100;
                    break;
                case 4:
                case 5:
                    premium += 150;
                    break;
                case 6:
                case 7:
                    premium += 250;
                    break;
            }
        }
        Currency currency = Currency.getInstance(Locale.getDefault());
        String symbol = currency.getSymbol();
        textViewPremium.setText(getString(R.string.premium) + " = "+ symbol + " "+ String.valueOf(premium));
    }
}

