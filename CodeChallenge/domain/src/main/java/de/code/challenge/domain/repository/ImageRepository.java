package de.code.challenge.domain.repository;

import java.util.List;

import de.code.challenge.domain.usercase.Image;
import rx.Observable;

/**
 * Created by bo.yuan on 2017/3/23
 */

public interface ImageRepository {
    Observable<List<Image>> searchImages(String phrase, int page, int perPage);
}
