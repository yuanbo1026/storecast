package de.code.challenge.data.entity;

import java.util.List;

/**
 * Created by bo.yuan on 2017/3/23
 */

public class ImageEntity {

    /**
     * result_count : 94073
     * images : [{"id":"181264085","asset_family":"editorial","caption":"BERLIN, GERMANY - SEPTEMBER 20:  A customer tries out the new Apple iPhone 5C smartphone at the Berlin Apple Store on the first day of sales on September 20, 2013 in Berlin, Germany. The new iPhone 5S and 5C phones went on sale all over the world today and hundreds of customers waited outside the Berlin store in the rain to be among the first to buy the new phones starting at 8am.  (Photo by Sean Gallup/Getty Images)","collection_code":"NEW","collection_id":56,"collection_name":"Getty Images News","display_sizes":[{"is_watermarked":false,"name":"thumb","uri":"http://media.gettyimages.com/photos/customer-tries-out-the-new-apple-iphone-5c-smartphone-at-the-berlin-picture-id181264085?b=1&k=6&m=181264085&s=170x170&h=2Q0iuPkb3QbfPM_HWwuWSiXdswOVNZc6h1uy2c2xEpg="}],"license_model":"rightsmanaged","max_dimensions":{"height":2047,"width":3000},"title":"Apple Begins Selling iPhone 5 S/C In Berlin"},{"id":"486452556","asset_family":"editorial","caption":"BERLIN, GERMANY - SEPTEMBER 04:  Visitors try out the Honor 7 smartphone at the Huawei stand at the 2015 IFA consumer electronics and appliances trade fair on September 4, 2015 in Berlin, Germany. The 2015 IFA will be open to the public from September 4-9.  (Photo by Sean Gallup/Getty Images)","collection_code":"NEW","collection_id":56,"collection_name":"Getty Images News","display_sizes":[{"is_watermarked":false,"name":"thumb","uri":"http://media.gettyimages.com/photos/visitors-try-out-the-honor-7-smartphone-at-the-huawei-stand-at-the-picture-id486452556?b=1&k=6&m=486452556&s=170x170&h=u8b6tArXFWh6YxDMWToSxJaaqczEHbbLLi0H9GLHqUU="}],"license_model":"rightsmanaged","max_dimensions":{"height":3000,"width":4500},"title":"IFA 2015 Consumer Electronics And Appliances Trade Fair"}]
     */

    private int result_count;
    private List<ImagesBean> images;

    public int getResult_count() {
        return result_count;
    }

    public void setResult_count(int result_count) {
        this.result_count = result_count;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImagesBean {
        /**
         * id : 181264085
         * asset_family : editorial
         * caption : BERLIN, GERMANY - SEPTEMBER 20:  A customer tries out the new Apple iPhone 5C smartphone at the Berlin Apple Store on the first day of sales on September 20, 2013 in Berlin, Germany. The new iPhone 5S and 5C phones went on sale all over the world today and hundreds of customers waited outside the Berlin store in the rain to be among the first to buy the new phones starting at 8am.  (Photo by Sean Gallup/Getty Images)
         * collection_code : NEW
         * collection_id : 56
         * collection_name : Getty Images News
         * display_sizes : [{"is_watermarked":false,"name":"thumb","uri":"http://media.gettyimages.com/photos/customer-tries-out-the-new-apple-iphone-5c-smartphone-at-the-berlin-picture-id181264085?b=1&k=6&m=181264085&s=170x170&h=2Q0iuPkb3QbfPM_HWwuWSiXdswOVNZc6h1uy2c2xEpg="}]
         * license_model : rightsmanaged
         * max_dimensions : {"height":2047,"width":3000}
         * title : Apple Begins Selling iPhone 5 S/C In Berlin
         */

        private String id;
        private String asset_family;
        private String caption;
        private String collection_code;
        private int collection_id;
        private String collection_name;
        private String license_model;
        private MaxDimensionsBean max_dimensions;
        private String title;
        private List<DisplaySizesBean> display_sizes;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAsset_family() {
            return asset_family;
        }

        public void setAsset_family(String asset_family) {
            this.asset_family = asset_family;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getCollection_code() {
            return collection_code;
        }

        public void setCollection_code(String collection_code) {
            this.collection_code = collection_code;
        }

        public int getCollection_id() {
            return collection_id;
        }

        public void setCollection_id(int collection_id) {
            this.collection_id = collection_id;
        }

        public String getCollection_name() {
            return collection_name;
        }

        public void setCollection_name(String collection_name) {
            this.collection_name = collection_name;
        }

        public String getLicense_model() {
            return license_model;
        }

        public void setLicense_model(String license_model) {
            this.license_model = license_model;
        }

        public MaxDimensionsBean getMax_dimensions() {
            return max_dimensions;
        }

        public void setMax_dimensions(MaxDimensionsBean max_dimensions) {
            this.max_dimensions = max_dimensions;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<DisplaySizesBean> getDisplay_sizes() {
            return display_sizes;
        }

        public void setDisplay_sizes(List<DisplaySizesBean> display_sizes) {
            this.display_sizes = display_sizes;
        }

        public static class MaxDimensionsBean {
            /**
             * height : 2047
             * width : 3000
             */

            private int height;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }

        public static class DisplaySizesBean {
            /**
             * is_watermarked : false
             * name : thumb
             * uri : http://media.gettyimages.com/photos/customer-tries-out-the-new-apple-iphone-5c-smartphone-at-the-berlin-picture-id181264085?b=1&k=6&m=181264085&s=170x170&h=2Q0iuPkb3QbfPM_HWwuWSiXdswOVNZc6h1uy2c2xEpg=
             */

            private boolean is_watermarked;
            private String name;
            private String uri;

            public boolean isIs_watermarked() {
                return is_watermarked;
            }

            public void setIs_watermarked(boolean is_watermarked) {
                this.is_watermarked = is_watermarked;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }
        }
    }
}
