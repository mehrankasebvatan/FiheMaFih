package app.molana.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.molana.Activity.ContentActivity;
import app.molana.DataBase.FiheMaFih;
import app.molana.R;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    Context context;
    List<FiheMaFih> fiheMaFih;



    public RvAdapter(Context context, List<FiheMaFih> fiheMaFih) {
        this.context = context;
        this.fiheMaFih = fiheMaFih;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_title, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FiheMaFih content = fiheMaFih.get(position);

        holder.tv_title.setText(fiheMaFih.get(position).getTitle());
        holder.cv_title.setOnClickListener(view -> {

            Intent in = new Intent(context, ContentActivity.class);
            in.putExtra("idKey", content.id );
            in.putExtra("titleKey", content.title );
            in.putExtra("contentKey", content.content );
            context.startActivity(in);


        });


    }

    @Override
    public int getItemCount() {
        return fiheMaFih.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_title;
        public CardView cv_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            cv_title = itemView.findViewById(R.id.cv_title);

        }
    }
}
