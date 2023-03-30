package com.example.pr17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.paperdb.Paper;

public class InfoActivity extends AppCompatActivity {
    Button butt_del, butt_back;
    EditText name_char, class_char;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Paper.init(this);

        PaperBDC paperBDC = new PaperBDC();

        name_char = findViewById(R.id.info_name);
        class_char = findViewById(R.id.info_class);

        Bundle arguments = getIntent().getExtras();
        name_char.setText(arguments.get("Name").toString());
        class_char.setText(arguments.get("Class").toString());

        butt_back = findViewById(R.id.back);
        butt_del = findViewById(R.id.del);

        butt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Character character = new Character(0, name_char.getText().toString(), class_char.getText().toString());
                paperBDC.updateCharacter(character, (Integer) arguments.get("ID"));
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        butt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paperBDC.deleteCharacter((Integer) arguments.get("ID"));
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}