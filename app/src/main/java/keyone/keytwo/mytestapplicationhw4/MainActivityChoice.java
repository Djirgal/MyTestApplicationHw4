package keyone.keytwo.mytestapplicationhw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivityChoice extends AppCompatActivity{

    public Configuration configuration;
    private RadioButton radioButton1, radioButton2;

    // Имя настроек
    private static final String NameSharedPreference = "CHOICE";

    // Имя параметра в настройках
    private static final String AppTheme = "APP_THEME";

    protected static final int MyLightStyle = 0;
    protected static final int MyDarkStyle = 1;

    public void setRadioButton(RadioButton radioButton) {
         radioButton.setChecked(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        radioButton1 = findViewById(R.id.radioButtonLightStyle);
        radioButton2 = findViewById(R.id.radioButtonDarkStyle);
        //попробуем понять режим
        initMyRadioButtons();
        // Устанавливать тему надо только до установки макета активити
       // setTheme(getAppTheme(R.style.MyRadioButtonStyle));
        setContentView(R.layout.activity_main_choice);
       // initThemeChooser();
    }

    private void initMyRadioButtons(){
        int currentNightMode = configuration.uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                // Night mode is not active, we're using the light theme
                System.out.println("Сработало по UI_MODE_NIGHT_NO");
                setRadioButton(radioButton1);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                // Night mode is active, we're using dark theme
                System.out.println("Сработало по UI_MODE_NIGHT_YES");
                setRadioButton(radioButton2);
                break;
            default:
                System.out.println("Сработало по дефолту");
                setRadioButton(radioButton1);
        }
    }

    // Инициализация радиокнопок
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonLightStyle), MyLightStyle);
        initRadioButton(findViewById(R.id.radioButtonDarkStyle), MyDarkStyle);

        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(MyLightStyle))).setChecked(true);
    }

    // Все инициализации кнопок очень похожи, поэтому создадим метод для переиспользования
    private void initRadioButton(View button, final int codeStyle){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраним настройки
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    // Чтение настроек, параметр «тема»
    private int getCodeStyle(int codeStyle){
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    // Сохранение настроек
    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle){
        switch(codeStyle){
            case MyLightStyle:
                return 0;
            case MyDarkStyle:
                return 1;
            default:
                return 0;
        }
    }

}