package de.code.challenge.data.entity.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.code.challenge.data.entity.ImageEntity;
import de.code.challenge.domain.usercase.Image;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bo.yuan on 2017/3/23
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageEntityMapperTest {

    @InjectMocks ImageEntityMapper imageEntityMapper;
    private List<ImageEntity.ImagesBean.DisplaySizesBean> displaySizesBeanList = new ArrayList<>();
    private ImageEntity imageEntity;
    private List<ImageEntity.ImagesBean> imagesBeanList = new ArrayList<>();
    private ImageEntity.ImagesBean imageBean;
    private Image image;

    @Before
    public void setup(){
        setupImage();
        setupImageEntity();

    }

    @Test
    public void verifyImageBeanList_should_return_false_with_empty_list(){
        assertTrue(!imageEntityMapper.verifyImageBeanList(Collections.emptyList()));

    }

    @Test
    public void convertImageEntityToUsercase_should_return_right_image(){
        assertThat(imageEntityMapper.convertImageEntityToUsercase(setupImageBean()).getId(),is(this.image.getId()));
        assertThat(imageEntityMapper.convertImageEntityToUsercase(setupImageBean()).getTitle(),is(this.image.getTitle()));
        assertThat(imageEntityMapper.convertImageEntityToUsercase(setupImageBean()).getCaption(),is(this.image.getCaption()));
        assertThat(imageEntityMapper.convertImageEntityToUsercase(setupImageBean()).getUri(),is(this.image.getUri()));
    }

    @Test
    public void convertImageEntityToImages_should_return_image_list(){
        assertTrue(imageEntityMapper.convertImageEntityToImages(this.imageEntity).size()>0);
    }

    private void setupImageEntity() {
        imageEntity = new ImageEntity();
        imageEntity.setImages(setupImageBeanList());
    }

    private ImageEntity.ImagesBean setupImageBean(){
        this.imageBean = new ImageEntity.ImagesBean();
        this.imageBean.setId("12");
        this.imageBean.setTitle("title");
        this.imageBean.setCaption("dummy content");
        this.imageBean.setDisplay_sizes(setupDisplaySizeBeanList());
        return this.imageBean;
    }

    private List<ImageEntity.ImagesBean> setupImageBeanList() {
        imagesBeanList.add(setupImageBean());
        return imagesBeanList;
    }

    private List<ImageEntity.ImagesBean.DisplaySizesBean> setupDisplaySizeBeanList() {
        ImageEntity.ImagesBean.DisplaySizesBean displaySizesBean = new ImageEntity.ImagesBean.DisplaySizesBean();
        displaySizesBean.setUri("dummy uri");
        displaySizesBeanList.add(displaySizesBean);
        return displaySizesBeanList;
    }

    private void setupImage() {
        this.image = new Image();
        image.setId("12");
        image.setTitle("title");
        image.setCaption("dummy content");
        image.setUri("dummy uri");
    }

}