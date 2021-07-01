package keyone.keytwo.mytestapplicationhw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;

public class MainActivityChoice extends AppCompatActivity{

    private final static String KEY_CHOICE = "CALCULATOR_CHOICE";
    private RadioButton radioButton1, radioButton2;

    // Имя настроек
    private static final String NameSharedPreference = "LOGIN";

    // Имя параметра в настройках
    private static final String AppTheme = "APP_THEME";

    protected static final int MyLightStyle = 0;
    protected static final int MyDarkStyle = 1;

    public boolean getRadioButtonState(RadioButton radioButton) {
        return radioButton.isChecked();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choice);
        // понять как взять текущий режим Dark или Light
        setTheme(MyLightStyle);
        setRadioButton();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.radioButtonLightStyle:
                setTheme(MyLightStyle);
                break;
            case R.id.radioButtonDarkStyle:
                    setTheme(MyLightStyle);
                break;

    }

    private void initView(){

        radioButton1 = findViewById(R.id.radioButtonLightStyle);
            radioButton1.setOnClickListener(this);


    }
}

    private void setRadioButton() {

    }
}