package de.code.challenge.data.api;

import de.code.challenge.data.entity.ImageEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bo.yuan on 2017/3/23
 */

public interface ImageSearchApi {
    @GET("images")
    Observable<ImageEntity> searchImages(@Query("phrase") String phrase, @Query("page") int page, @Query("page_size") int pageSize);
}
