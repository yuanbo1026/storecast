package de.code.challenge.view.adpater;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<Image> imageList = new ArrayList<>();

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
        if (image != null) {
            viewHolder.image_id.setText(image.getId() == null ? "" : context.getString(R.string.image_id_text) + image.getId());
            viewHolder.image_title.setText(image.getTitle() == null ? "" : context.getString(R.string.image_title_text) + image.getTitle());
            if (image.getUri() == null) {
                viewHolder.image.setImageResource(R.drawable.default_image);
            } else {
                Picasso.with(context).load(image.getUri()).fit()
                        .placeholder(R.drawable.default_image)
                        .into(viewHolder.image);
            }
        } else {
            viewHolder.image_id.setText("");
            viewHolder.image_title.setText("");
            viewHolder.image.setImageResource(R.drawable.default_image);
        }

        holder.itemView.setOnClickListener(v -> {
            assert image != null;
            showAlertDialog(image.getCaption() != null ? image.getCaption() : "");
        });
    }

    public void setItemToPosition(Image image, int itemPosition) {
        this.imageList.set(itemPosition, image);
        notifyItemChanged(itemPosition);
    }

    @Override
    public int getItemCount() {
        return (this.imageList != null) ? this.imageList.size() : 0;
    }

    private void showAlertDialog(String caption) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(caption);
        builder.setPositiveButton(R.string.ok, (dialog, which) -> dialog.dismiss());
        builder.setNegativeButton(R.string.cancel, (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
    }

    public void addImages(List<Image> searchResultList) {
        this.imageList.addAll(searchResultList);
        notifyDataSetChanged();
    }

    public void clearImages() {
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
