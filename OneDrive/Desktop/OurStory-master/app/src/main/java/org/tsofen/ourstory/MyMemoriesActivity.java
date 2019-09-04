package org.tsofen.ourstory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.ourstory.R;

import org.tsofen.ourstory.TeamsHomePage.PopActivity;
import org.tsofen.ourstory.model.Memory;

import java.util.ArrayList;

public class MyMemoriesActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<Memory> data;
    MyMemoriesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_memories);
        Intent intent = getIntent();
        String message =intent.getStringExtra(YearActivity.EXTRA_MESSAGE);
        rv = findViewById(R.id.recycler);
        data = Memory.createContactsListMyMemories();
        adapter = new MyMemoriesAdapter(data);
        filter(message);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));



    }


    private void filter(String text)
    {
        ArrayList<Memory> filteredList = new ArrayList<>();
        for (Memory memory: data){

            String name = memory.getCreatorName();
            if(name.equals(text))
                filteredList.add(memory);
        }

        adapter.filterList(filteredList);
    }

}
