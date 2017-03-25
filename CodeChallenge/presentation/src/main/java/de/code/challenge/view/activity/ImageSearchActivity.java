package de.code.challenge.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.paginate.Paginate;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.code.challenge.R;
import de.code.challenge.di.component.DaggerImageSearchComponent;
import de.code.challenge.di.module.ImageSearchModule;
import de.code.challenge.domain.usercase.Image;
import de.code.challenge.presenter.ImageSearchPresenter;
import de.code.challenge.view.adpater.ImageRecyclerViewAdapter;

public class ImageSearchActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image_recyclerview)
    RecyclerView image_recyclerview;
    @BindView(R.id.search_edit_text)
    EditText search_edit_text;

    @Inject
    ImageSearchPresenter imageSearchPresenter;
    @Inject
    ImageRecyclerViewAdapter imageSearchAdapter;

    private String searchKey="mobile";
    private int page = 1;
    private final static int perPage = 10;
    private boolean isLoading = false;
    private Unbinder unbinder;
    private Paginate paginate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_search);
        setSupportActionBar(toolbar);
        unbinder = ButterKnife.bind(this);
        DaggerImageSearchComponent.builder().imageSearchModule(new ImageSearchModule(this)).build().inject(this);
        setupPagination();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick(R.id.search_confirm_button)
    public void searchConfirm(){
        String searchKey = search_edit_text.getText().toString();
        if (!searchKey.isEmpty()) {
            setSearchKey(searchKey);
            page = 1;
            imageSearchAdapter.clearImages();
            if (paginate != null) {
                paginate.unbind();
            }
            setupPagination();
            hideSoftKeyboard();
        }
    }

    private void setupPagination() {
        isLoading = false;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        image_recyclerview.setAdapter(imageSearchAdapter);
        image_recyclerview.setLayoutManager(layoutManager);

        paginate = Paginate.with(image_recyclerview, callbacks)
                .setLoadingTriggerThreshold(2)
                .build();
    }

    private Paginate.Callbacks callbacks = new Paginate.Callbacks() {
        @Override
        public void onLoadMore() {
            isLoading = true;
            imageSearchPresenter.searchImages(getSearchKey(), page, perPage);
            page++;
        }

        @Override
        public boolean isLoading() {
            return isLoading;
        }

        @Override
        public boolean hasLoadedAllItems() {
            return false;
        }
    };

    public void setAdapter(List<Image> images) {
        imageSearchAdapter.addImages(images);
        isLoading = false;
    }

    public void updateItemOnPosition(int position, Image image){
        imageSearchAdapter.setItemToPosition(image,position);
    }

    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void hideSoftKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

}
