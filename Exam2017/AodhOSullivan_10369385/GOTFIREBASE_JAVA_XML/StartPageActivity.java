package com.example.marvin.login;



        import android.content.Context;
        import android.content.SharedPreferences;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.EditText;
        import android.view.View;
        import android.widget.TextView;

        import android.widget.Toast;

public class StartPageActivity extends AppCompatActivity {

    EditText editTextCharacter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        editTextCharacter = (EditText) findViewById(R.id.editTextCharacter);
        textView = (TextView) findViewById(R.id.textViewCharacter);


    }

    public void saveInfo(View view){

        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("favCharacter", editTextCharacter.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved!!", Toast.LENGTH_LONG).show();
    }

    public void displayData(View view) {

        SharedPreferences sharedPref = getSharedPreferences("userinfo",Context.MODE_PRIVATE);

        String charName = sharedPref.getString("favCharacter", "");

        textView.setText("Your favourite character is" + " " + charName);

    }
}
