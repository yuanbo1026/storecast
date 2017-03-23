package de.code.challenge.di.component;

import javax.inject.Singleton;

import dagger.Component;
import de.code.challenge.di.module.ImageSearchModule;
import de.code.challenge.view.activity.ImageSearchActivity;

/**
 * Created by bo.yuan on 2017/3/23
 */
@Singleton
@Component(modules = ImageSearchModule.class)
public interface ImageSearchComponent {
    void inject(ImageSearchActivity imageSearchActivity);
}
