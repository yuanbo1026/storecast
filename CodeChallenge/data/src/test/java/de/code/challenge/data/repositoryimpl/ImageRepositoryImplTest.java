package de.code.challenge.data.repositoryimpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import de.code.challenge.data.api.ImageSearchApi;
import de.code.challenge.data.entity.ImageEntity;
import de.code.challenge.data.entity.mapper.ImageEntityMapper;
import de.code.challenge.domain.usercase.Image;
import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bo.yuan on 2017/3/23
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageRepositoryImplTest {

    @InjectMocks
    ImageRepositoryImpl imageRepository;
    @Mock
    ImageEntityMapper imageEntityMapper;
    @Mock
    ImageSearchApi imageSearchApi;

    private TestSubscriber<List<Image>> testSubscriber;

    @Before
    public void setup(){
        testSubscriber = new TestSubscriber<>();
        when(imageSearchApi.searchImages(anyString(),anyInt(),anyInt())).thenReturn(Observable.just(new ImageEntity()));
    }

    @Test
    public void searchImages_should_call_mapper(){
        imageRepository.searchImages(anyString(),anyInt(),anyInt()).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        verify(imageEntityMapper).convertImageEntityToImages(any(ImageEntity.class));
    }

    @Test
    public void searchImages_should_return_list(){
        imageRepository.searchImages(anyString(),anyInt(),anyInt()).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        assertTrue(testSubscriber.getOnNextEvents().size()>0);
    }
}