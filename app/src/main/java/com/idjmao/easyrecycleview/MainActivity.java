package com.idjmao.easyrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.idjmao.easyrecycleviewlib.EasyAdapter;
import com.idjmao.easyrecycleviewlib.viewholder.ImgViewHolder;
import com.idjmao.easyrecycleviewlib.viewholder.TextViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.mmlist);
        List<String> list=new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add("第"+i);
//        }
        MyAdapter adapter=new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        adapter.setEmptyViewholder(new TextViewHolder(this,recyclerView,"数据为空"));
        adapter.setEmptyViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("hhhhh", "onClick: empty");
            }
        });

        adapter.setHeaderViewHolder(new TextViewHolder(this,recyclerView,"this is header"));
        adapter.setHeaderViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("hhhhh", "onClick: header");
            }
        });
        adapter.setBottomViewHolder(new ImgViewHolder(this,recyclerView,R.drawable.ic_launcher_foreground));
        adapter.setBottomViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("hhhhh", "onClick: bottom");
            }
        });

        adapter.setOnItemClickListener(new EasyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i("hhhhh", "onItemClick: "+position);
            }
        });
        adapter.setOnItemLongCilckListener(new EasyAdapter.OnItemLongCilckListener() {
            @Override
            public boolean onItemLongClick(int position) {
                Log.i("hhhhh", "onItemLongClick: "+position);
                return false;
            }
        });

    }
}
