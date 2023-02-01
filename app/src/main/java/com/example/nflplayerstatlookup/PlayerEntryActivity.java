package com.example.nflplayerstatlookup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerEntryActivity extends AppCompatActivity implements View.OnClickListener {

    EditText playerFirstNameEditText;
    EditText playerLastNameEditText;

    Button playerEntryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_entry);

        playerFirstNameEditText = findViewById(R.id.playerFirstNameEditText);
        playerLastNameEditText = findViewById(R.id.playerLastNameEditText);

        playerEntryButton = findViewById(R.id.playerEntryButton);
        playerEntryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String firstName = playerFirstNameEditText.getText().toString();
        String lastName = playerLastNameEditText.getText().toString();

        // this Intent sends data back to a different Activity, e.g. "MainActivity"
        Intent i = new Intent();
        // sends the word inputted by the user
        i.putExtra("FIRSTNAME", firstName);
        i.putExtra("LASTNAME", lastName);
        setResult(RESULT_OK, i);

        // finish() means we leave this Activity
        finish();
    }
}