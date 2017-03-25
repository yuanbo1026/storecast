package de.code.challenge.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.code.challenge.domain.repository.ImageRepository;
import de.code.challenge.domain.usercase.Image;
import de.code.challenge.view.activity.ImageSearchActivity;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bo.yuan on 2017/3/23
 */
@Singleton
public class ImageSearchPresenter {
    private ImageRepository imageRepository;
    private ImageSearchActivity imageSearchActivity;

    @Inject
    public ImageSearchPresenter(ImageRepository imageRepository, ImageSearchActivity imageSearchActivity) {
        this.imageRepository = imageRepository;
        this.imageSearchActivity = imageSearchActivity;
    }

    public void searchImages(String phrase, int page, int pageSize) {
        setupAdapterWithNullImages(pageSize);
        imageRepository.searchImages(phrase, page, pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Image>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        showErrorMessage(e.toString());
                    }

                    @Override
                    public void onNext(List<Image> images) {
                        updateAdapterItemOnPosition(images,page);
                    }
                });
    }

    private void setupAdapterWithNullImages(int itemSize) {
        List<Image> images = new ArrayList<>(itemSize);
        for (int i = 0; i < itemSize; i++) {
            Image image = new Image();
            images.add(image);
        }
        setAdapter(images);
    }


    private void updateAdapterItemOnPosition(List<Image> images, int page) {
        if (images != null && images.size() > 0) {
            for (int i = 0; i < images.size(); i++) {
                Image image = images.get(i);
                imageSearchActivity.updateItemOnPosition(getItemPosition(page, i), image);
            }
        }
    }
    //page is 1 by default
    private int getItemPosition(int page, int index) {
        return ((page - 1) * 10) + index;
    }

    private void showErrorMessage(String message) {
        imageSearchActivity.showErrorMessage(message);
    }

    private void setAdapter(List<Image> images) {
        imageSearchActivity.setAdapter(images);
    }
}
