package de.code.challenge.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.code.challenge.data.api.ImageSearchApi;
import de.code.challenge.data.network.RetrofitClientFactory;
import de.code.challenge.data.repositoryimpl.ImageRepositoryImpl;
import de.code.challenge.domain.repository.ImageRepository;
import de.code.challenge.view.activity.ImageSearchActivity;

/**
 * Created by bo.yuan on 2017/3/23
 */

@Module
public class ImageSearchModule {
    private ImageSearchActivity imageSearchActivity;

    public ImageSearchModule(ImageSearchActivity imageSearchActivity) {
        this.imageSearchActivity = imageSearchActivity;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return this.imageSearchActivity;
    }

    @Provides
    @Singleton
    public ImageSearchApi provideImageSearchApi(RetrofitClientFactory retrofitClientFactory){
        return retrofitClientFactory.createInstance(ImageSearchApi.class);
    }

    @Provides
    @Singleton
    public ImageRepository provideImageRepository(ImageRepositoryImpl impl){
        return impl;
    }

    @Provides
    @Singleton
    public ImageSearchActivity provideImageSearchActivity(){
        return this.imageSearchActivity;
    }
}
