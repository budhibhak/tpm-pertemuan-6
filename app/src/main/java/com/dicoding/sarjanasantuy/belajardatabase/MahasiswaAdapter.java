package com.dicoding.sarjanasantuy.belajardatabase;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dicoding.sarjanasantuy.belajardatabase.database.DataDiri;


public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.VH> {
    private MainListener listener;
    private DataDiri[] list;

    public  MahasiswaAdapter(DataDiri[] list, MainListener listener) {
        this.list = list;
        this.listener = listener;
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_diri_item, parent, false);
        return new VH (view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        final DataDiri item = list[position];

        holder.tvNama.setText(item.getNama());
        holder.tvKelamin.setText("" + item.getJkelamin());
        holder.tvAlamat.setText(item.getAlamat());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent = new Intent(context, UpdateActivity.class);
               intent.putExtra("nama", item.getNama());
               intent.putExtra("alamat", item.getAlamat());
               intent.putExtra("kelamin", item.getJkelamin());
               intent.putExtra("id", item.getId());
               context.startActivity(intent);
           }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VH extends RecyclerView.ViewHolder {
        TextureView tvNama, tvKelamin, tvAlamat;
        View itemView;
        public VH(@NonNull View itemView) {
            super(itemView);

            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvKelamin = itemView.findViewById(R.id.tvKelamin);
            tvNama = itemView.findViewById(R.id.tvNama);
            this.itemView = itemView;
        }
    }
}
