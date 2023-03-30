package com.example.pr17;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import io.paperdb.Paper;

public class AddActivity extends AppCompatActivity {
    EditText charName, charClass;
    Button addChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Paper.init(this);

        charName = findViewById(R.id.char_name);
        charClass = findViewById(R.id.char_class);
        addChar = findViewById(R.id.char_add);

        PaperBDC paperBDC = new PaperBDC();

        addChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Character character = new Character(0, charName.getText().toString(), charClass.getText().toString());

                paperBDC.addCharacter(character, getApplicationContext());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}