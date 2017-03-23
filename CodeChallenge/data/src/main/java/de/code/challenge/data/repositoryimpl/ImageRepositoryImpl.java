package de.code.challenge.data.repositoryimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.code.challenge.data.api.ImageSearchApi;
import de.code.challenge.data.entity.mapper.ImageEntityMapper;
import de.code.challenge.domain.repository.ImageRepository;
import de.code.challenge.domain.usercase.Image;
import rx.Observable;

/**
 * Created by bo.yuan on 2017/3/23
 */
@Singleton
public class ImageRepositoryImpl implements ImageRepository {
    private ImageEntityMapper imageEntityMapper;
    private ImageSearchApi imageSearchApi;

    @Inject
    public ImageRepositoryImpl(ImageEntityMapper imageEntityMapper, ImageSearchApi imageSearchApi) {
        this.imageEntityMapper = imageEntityMapper;
        this.imageSearchApi = imageSearchApi;
    }

    @Override
    public Observable<List<Image>> searchImages(String phrase, int page, int perPage) {
        return imageSearchApi.searchImages(phrase, page, perPage)
                .map(imageEntityMapper::convertImageEntityToImages);
    }
}
