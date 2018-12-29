package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cn.waimai.R;

class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public ImageView image;
    public MyViewHolder(View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        image=itemView.findViewById(R.id.image);
    }
}
