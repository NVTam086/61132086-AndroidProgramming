package ntu.vntam.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land,parent,false);
        ItemLandHolder viewholderCreater = new ItemLandHolder(vItem);

        return viewholderCreater;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //lay doi tuong hien thi
        LandScape landScapeHthi = lstData.get(position);
        //Trich thong tin
        String caption  = landScapeHthi.getLandCaption();
        String tenfileAnh = landScapeHthi.getLandImageFileName();
        //Dat vao cac truong thong tin cua holder
        holder.tvCaption.setText(caption);
        //dat anh
        String packagename = holder.itemView.getContext().getPackageName();
        int imageId = holder.itemView.getResources().getIdentifier(tenfileAnh,"mipmap",packagename);
        holder.imvLand.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder{
        TextView tvCaption;
        ImageView imvLand;
        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.tvCaption);
            imvLand = itemView.findViewById(R.id.imvLand);
        }
    }
}
