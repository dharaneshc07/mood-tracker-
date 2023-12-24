package com.example.moodtrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ImageView moodImageView;
    private Spinner moodSpinner;
    private EditText journalEntryEditText;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        moodImageView = findViewById(R.id.moodImageView);
        moodSpinner = findViewById(R.id.moodSpinner);
        journalEntryEditText = findViewById(R.id.journalEntryEditText);
        saveButton = findViewById(R.id.saveButton);

        // Set up the mood spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.moods,
                android.R.layout.simple_spinner_dropdown_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moodSpinner.setAdapter(adapter);

        // Set up the mood image based on the selected mood
        moodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateMoodImage(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Save button click listener
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveJournalEntry();
            }
        });
    }

    private void updateMoodImage(int i) {
        int[] moodImages = {R.drawable.happy_emoji, R.drawable.normal_emoji, R.drawable.sad_emoji};
        moodImageView.setImageResource(moodImages[i]);
        // Hide all emoji images
       /* for (int imageId : moodImages) {
            findViewById(imageId).setVisibility(View.GONE);
        }

        // Show the selected emoji image
        int selectedImageId = moodImages[i];
        findViewById(selectedImageId).setVisibility(View.VISIBLE);
   */ }
    private void saveJournalEntry() {
        String mood = moodSpinner.getSelectedItem().toString();
        String entry = journalEntryEditText.getText().toString();

        Toast.makeText(this, "Journal entry saved!", Toast.LENGTH_SHORT).show();
   }
}