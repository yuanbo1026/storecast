package de.code.challenge.presenter;

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

    public void searchImages(String phrase, int page, int pageSize){
        imageRepository.searchImages(phrase,page,pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Image>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Image> images) {

                    }
                });
    }

    public void showLoading(){

    }

    public void hideLoading(){

    }

    public  void showErrorMessage(String message){

    }

    public void setAdapter(){

    }
}
