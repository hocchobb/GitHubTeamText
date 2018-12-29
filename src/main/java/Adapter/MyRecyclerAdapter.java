package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cn.waimai.JavaBean;
import com.cn.waimai.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private Context context;
    private List<JavaBean.MessageBean.AnchorsBean> anchors;

    public MyRecyclerAdapter(Context context, List<JavaBean.MessageBean.AnchorsBean> anchors) {
        this.context = context;
        this.anchors = anchors;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,null);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(anchors.get(position).getGameName());
        Picasso.with(context).load(anchors.get(position).getGameIcon()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return anchors.size();
    }
}
