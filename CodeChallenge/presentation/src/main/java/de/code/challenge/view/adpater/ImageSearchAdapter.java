package de.code.challenge.view.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import de.code.challenge.R;
import de.code.challenge.domain.usercase.Image;

/**
 * Created by bo.yuan on 2017/3/23
 */

public class ImageSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private final LayoutInflater layoutInflater;
    private List<Image> imageList = new ArrayList<>();

    @Inject
    public ImageSearchAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.image_search_recyclerview_item, parent, false);
        return new ImageSearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final Image image = this.imageList.get(position);

    }

    @Override
    public int getItemCount() {
        return (this.imageList != null) ? this.imageList.size() : 0;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
