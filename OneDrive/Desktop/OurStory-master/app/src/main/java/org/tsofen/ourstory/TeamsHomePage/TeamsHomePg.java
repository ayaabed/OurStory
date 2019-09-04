package org.tsofen.ourstory.TeamsHomePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ourstory.R;

import org.tsofen.ourstory.CreateEditMemoryActivity;
import org.tsofen.ourstory.YearActivity;

public class TeamsHomePg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_home_pg);
    }

    public void showUserPart(View view) {
    }

    public void showMem1Part(View view) {
        Intent intent = new Intent(this, CreateEditMemoryActivity.class);
        startActivity(intent);
    }

    public void showMem2Part(View view) {
        Intent intent = new Intent(this, YearActivity.class);
        startActivity(intent);
    }

    public void showStoryPart(View view) {
    }
}
