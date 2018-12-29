package com.cn.waimai;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import Adapter.MyRecyclerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //http://qf.56.com/home/v4/moreAnchor.android?&type=0&index=0
        //请求主播博主的数据：
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://qf.56.com/home/v4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Myzhibo myzhibo = retrofit.create(Myzhibo.class);
        myzhibo.getzhibo().enqueue(new Callback<JavaBean>() {
            @Override
            public void onResponse(Call<JavaBean> call, Response<JavaBean> response) {
                JavaBean body = response.body();
                List<JavaBean.MessageBean.AnchorsBean> anchors = body.getMessage().getAnchors();
                MyRecyclerAdapter adapter=new MyRecyclerAdapter(MainActivity.this,anchors);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JavaBean> call, Throwable t) {

            }
        });
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
    }
}
