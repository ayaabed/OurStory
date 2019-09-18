package org.tsofen.ourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.tsofen.ourstory.model.Comment;
import org.tsofen.ourstory.model.Memory;
import org.tsofen.ourstory.model.api.User;
import org.tsofen.ourstory.web.OurStoryService;
import org.tsofen.ourstory.web.WebFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends Activity {

    User user;
    RecyclerView rv;
    Memory memoryA;
    CommentAdapter adapter;
    Intent i;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
         i = getIntent();
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout((int) (width * .8), (int) (height * .8));
        memoryA = (Memory) i.getSerializableExtra("memory");
        user = (User) i.getSerializableExtra("user");
        rv = findViewById(R.id.recycler_comment);
        adapter = new CommentAdapter(getApplicationContext(), memoryA.getComments());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(CommentActivity.this));
        adapter.notifyDataSetChanged();

        Button btn = findViewById(R.id.sendBtn2);




    }
    public void SendCmnt(View view) {

        Comment comment = new Comment();
        TextView txtview = findViewById(R.id.AddComment);
        comment.setText(txtview.getText().toString());
        comment.setUser(user);
        OurStoryService service = WebFactory.getService();
        service.newComment(memoryA.getId(),comment).enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                Toast.makeText(getApplicationContext(),"added",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();

            }
        });

        adapter.notifyDataSetChanged();



    }
}
