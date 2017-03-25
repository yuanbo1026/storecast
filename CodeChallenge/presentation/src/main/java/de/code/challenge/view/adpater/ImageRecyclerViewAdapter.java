package de.code.challenge.view.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.code.challenge.R;
import de.code.challenge.domain.usercase.Image;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bo.yuan on 2017/3/23
 */
@Singleton
public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<Image> imageList  = new ArrayList<>();

    @Inject
    public ImageRecyclerViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.image_search_recyclerview_item, parent, false);
        return new ImageRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final Image image = this.imageList.get(position);
        viewHolder.image_id.setText(image.getId());
        viewHolder.image_title.setText(image.getTitle());
        Picasso.with(context).load(image.getUri()).fit()
                .placeholder(R.drawable.default_image)
                .into(viewHolder.image);
        holder.itemView.setOnClickListener(v -> Toast.makeText(context,image.getCaption(),Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return (this.imageList != null) ? this.imageList.size() : 0;
    }

    public void addImages(List<Image> searchResultList){
        this.imageList.addAll(searchResultList);
        notifyDataSetChanged();
    }

    public void clearImages(){
        this.imageList.clear();
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        CircleImageView image;
        @BindView(R.id.image_id)
        TextView image_id;
        @BindView(R.id.image_title)
        TextView image_title;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
