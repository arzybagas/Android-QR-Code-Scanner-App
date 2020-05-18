package id.inixindo.qrbarcodescanner.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.inixindo.qrbarcodescanner.R;

public class MySimpleAdapter extends RecyclerView.Adapter<MySimpleAdapter.ViewHolder> {
    List<MyListItem> itemLists;
    Context context;

    public MySimpleAdapter(List<MyListItem> itemLists, Context context){
        this.itemLists = itemLists;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final MyListItem itemList = itemLists.get(position);
        holder.tvCode.setText(itemList.getCode());
        holder.tvType.setText(itemList.getType());
        Linkify.addLinks(holder.tvCode, Linkify.ALL);
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCode;
        public TextView tvType;
        public Button btnShare;
        public Context context;

        ViewHolder(View viewItem){
            super(viewItem);
            context = viewItem.getContext();
            tvCode = viewItem.findViewById(R.id.tv_view_code);
            tvType = viewItem.findViewById(R.id.tv_view_type);
            btnShare = viewItem.findViewById(R.id.btn_share);
            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, tvCode.getText().toString());
                    intent.setType("text/plain");
                    context.startActivity(intent);
                }
            });
        }
    }
}
