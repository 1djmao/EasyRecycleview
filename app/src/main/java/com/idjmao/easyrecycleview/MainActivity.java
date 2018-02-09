package com.idjmao.easyrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.idjmao.easyrecycleviewlib.EasyAdapter;
import com.idjmao.easyrecycleviewlib.HeaderGridLayoutManager;
import com.idjmao.easyrecycleviewlib.viewholder.TextViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.mmlist);

        defalutList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.default_list:
                defalutList();
                break;
            case R.id.grid:
                gridList();
                break;
            case R.id.header_footer:
                addHeaderAndFooter();
                break;
            case R.id.empty:
                empty();
                break;

        }
        return true;
    }

    private void empty() {
        adapter.setEmptyViewholder(new TextViewHolder(recyclerView,"数据为空"));
        adapter.setEmptyViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "EmptyView is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.clear();
    }

    private void addHeaderAndFooter() {
        adapter.setHeaderViewHolder(new TextViewHolder(recyclerView,"this is header"));
        adapter.setHeaderViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Header is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setFooterViewHolder(new TextViewHolder(recyclerView,"this is footer"));
        adapter.setFooterViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Footer is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.notifyDataSetChanged();


    }

    private void gridList() {
        recyclerView.setLayoutManager(new HeaderGridLayoutManager(this,adapter,4));
    }

    private void defalutList() {
        list=new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add("第"+i);
        }
        adapter=new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        adapter.setOnItemClickListener(new EasyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, position+" is clickeed", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongCilckListener(new EasyAdapter.OnItemLongCilckListener() {
            @Override
            public boolean onItemLongClick(int position) {
                adapter.removeData(position);
                Toast.makeText(MainActivity.this, position+" is delected", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
