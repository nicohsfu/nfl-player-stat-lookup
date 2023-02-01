package com.example.nflplayerstatlookup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button inputPlayerNameButton;

    private static int REQUEST_WORD_ENTRY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPlayerNameButton = findViewById(R.id.inputPlayerNameButton);
        inputPlayerNameButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, PlayerEntryActivity.class);
        // strikethrough just means it's deprecated, it still works though
        startActivityForResult(i, REQUEST_WORD_ENTRY);
    }

    @Override
    protected void onActivityResult(int requestedCode, int resultCode, Intent data) {
        if (requestedCode == REQUEST_WORD_ENTRY) {
            if (resultCode == RESULT_OK) {
                if (data.hasExtra("FIRSTNAME") && data.hasExtra("LASTNAME")) {
                    // extracts the user-inputted words (i.e. the values) based on their keys
                    String player_first_name = data.getExtras().getString("FIRSTNAME");
                    String player_last_name = data.getExtras().getString("LASTNAME");

                    // adds the user-inputted word to the statistics URL in order to "look it up"
                    Uri webpage = Uri.parse("https://www.nfl.com/players/" + player_first_name + "-" + player_last_name + "/stats/career");

                    // implicit Intent - opens the webpage as determined above
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(webIntent);
                }
            }
        }
        super.onActivityResult(requestedCode, resultCode, data);
    }
}