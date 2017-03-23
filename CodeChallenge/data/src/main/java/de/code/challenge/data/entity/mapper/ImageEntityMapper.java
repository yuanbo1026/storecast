package de.code.challenge.data.entity.mapper;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.code.challenge.data.entity.ImageEntity;
import de.code.challenge.domain.usercase.Image;

/**
 * Created by bo.yuan on 2017/3/23
 */
@Singleton
public class ImageEntityMapper {
    @Inject
    public ImageEntityMapper() {
    }

    public Image convertImageEntityToUsercase(@NonNull ImageEntity.ImagesBean imagesBean) {
        Image image = new Image();
        image.setId(imagesBean.getId());
        image.setTitle(imagesBean.getTitle());
        image.setCaption(imagesBean.getCaption());
        setImageUri(imagesBean, image);
        return image;
    }

    public void setImageUri(@NonNull ImageEntity.ImagesBean imagesBean, @NonNull Image image) {
        List<ImageEntity.ImagesBean.DisplaySizesBean> displaySizesBeanList = imagesBean.getDisplay_sizes();
        if (displaySizesBeanList.size() > 0) {
            image.setUri(displaySizesBeanList.get(0).getUri());
        } else
            throw new IllegalArgumentException("");
    }

    public List<Image> convertImageEntityToImages(@NonNull ImageEntity entity) {
        List<ImageEntity.ImagesBean> imagesBeanList = entity.getImages();
        List<Image> imageList = new ArrayList<>();
        if (verifyImageBeanList(imagesBeanList)) {
            for (ImageEntity.ImagesBean imagesBean : imagesBeanList) {
                imageList.add(convertImageEntityToUsercase(imagesBean));
            }
            return imageList;
        }else
            throw new IllegalArgumentException("convertImageEntityToImages:List<ImageEntity.ImagesBean> is null");
    }

    public boolean verifyImageBeanList(List<ImageEntity.ImagesBean> imagesBeanList) {
        return imagesBeanList.size() > 0;
    }
}
