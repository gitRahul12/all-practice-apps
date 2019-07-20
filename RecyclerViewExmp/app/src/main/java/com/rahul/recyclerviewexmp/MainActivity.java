package com.rahul.recyclerviewexmp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView courselist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courselist=findViewById(R.id.recycleview);
        courselist.setLayoutManager(new LinearLayoutManager(this));  //for custom use GridLayoutManager
        String course[]={"java","Html","android","flutter","React Native","Python","Machine Learning","Instagram","facebook","Rahul"};
        courselist.setAdapter(new CourseAdapter(course));

    }
}
