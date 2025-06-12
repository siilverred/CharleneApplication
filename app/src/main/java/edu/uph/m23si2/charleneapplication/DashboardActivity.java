package edu.uph.m23si2.charleneapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout llyProfile, llyTodoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        llyProfile = findViewById(R.id.llyProfile);
        llyTodoList = findViewById(R.id.llyTodolist);
        llyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toProfile();
            }
        });

        llyTodoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTodoList();
            }
        });
    }

    public void toProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("nama", "satria");
        startActivity(intent);
    }

    private void toTodoList() {
        Intent intent = new Intent(this, TodoListActivity.class);
        intent.putExtra("nama", "satria");
        startActivity(intent);
    }

}