package com.wangqu.kuaqu.response;

import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */
public class AllWorldBean {


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AllWorldBean{" +
                "result='" + result + '\'' +
                ", cate=" + cate +
                ", flash=" + flash +
                ", hd=" + hd +
                ", zt=" + zt +
                ", brand=" + brand +
                ", goods=" + goods +
                '}';
    }

    /**
     * tid :
     * type : 1
     * name : 母婴2
     */
    private String result;
    private List<CateBean> cate;
    /**
     * tid : 1119
     * url :
     * type : 2
     * img : upload/goods/2016-09-28/600_0/20160928142105842445767a89f9cd01f585b00a73be63.png
     */

    private List<FlashBean> flash;
    /**
     * hid : 8
     * img : upload/special/2016-11-02/600_0/20160830113512c3a1db5ab1129c75f27848a3a3d39f06.jpg
     * goodsList : [{"mid":"1120","price":"20.00","mPrice":"25","mImg":"upload/goods/2016-09-28/600_0/201609281200228d532655a5886af8c75644f13535ca8f.jpg","goodsName":"丸江 儿童浓缩面汁 150毫升-测试商品1"},{"mid":"1135","price":"20.00","mPrice":"12","mImg":"upload/goods/2016-10-25/600_0/2016092817012240f55c8741567a8037a4f1222f38f18b.jpg","goodsName":"500g通便排毒防便秘果蔬纤维清宿便排肠毒-40粒"}]
     */

    private List<HdBean> hd;
    /**
     * zid : 6
     * img : upload/special/2016-08-30/600_0/2016083011140724953c822e6193095cac4a8081e9138b.jpg
     */

    private List<ZtBean> zt;
    /**
     * img : templete/ieUpload/uploads/201611/20161101161243de4153a9be1050ec4d567eede8c79506.jpg
     * brandList : [{"bid":"241","thumb":""},{"bid":"235","thumb":""},{"bid":"236","thumb":""},{"bid":"237","thumb":""},{"bid":"242","thumb":""},{"bid":"243","thumb":""},{"bid":"245","thumb":""},{"bid":"247","thumb":""},{"bid":"249","thumb":""},{"bid":"250","thumb":""}]
     */

    private List<BrandBean> brand;
    /**
     * gid : 106
     * img :
     * goodsListB : [{"mid":"1129","price":"","mPrice":"111","mImg":"upload/goods/2016-10-06/600_0/2016092814543693df84c12978dac681c7373bfa48c69d.jpg","goodsName":"蔓越莓胶囊精华30粒曼越梅卵巢保养女性泌尿蔓越梅-蔓越莓"},{"mid":"1130","price":"","mPrice":"12","mImg":"upload/goods/2016-10-26/600_0/2016092814543693df84c12978dac681c7373bfa48c69d.jpg","goodsName":"深海鱼油软胶囊400粒欧米伽3中老年保健品-400粒"},{"mid":"1135","price":"20.00","mPrice":"12","mImg":"upload/goods/2016-10-25/600_0/2016092817012240f55c8741567a8037a4f1222f38f18b.jpg","goodsName":"500g通便排毒防便秘果蔬纤维清宿便排肠毒-40粒"}]
     */

    private List<GoodsBean> goods;

    public List<CateBean> getCate() {
        return cate;
    }

    public void setCate(List<CateBean> cate) {
        this.cate = cate;
    }

    public List<FlashBean> getFlash() {
        return flash;
    }

    public void setFlash(List<FlashBean> flash) {
        this.flash = flash;
    }

    public List<HdBean> getHd() {
        return hd;
    }

    public void setHd(List<HdBean> hd) {
        this.hd = hd;
    }

    public List<ZtBean> getZt() {
        return zt;
    }

    public void setZt(List<ZtBean> zt) {
        this.zt = zt;
    }

    public List<BrandBean> getBrand() {
        return brand;
    }

    public void setBrand(List<BrandBean> brand) {
        this.brand = brand;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class CateBean {
        private String tid;
        private String type;
        private String name;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class FlashBean {
        private String tid;
        private String url;
        private String type;
        private String img;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

    public static class HdBean {
        private String hid;
        private String img;
        /**
         * mid : 1120
         * price : 20.00
         * mPrice : 25
         * mImg : upload/goods/2016-09-28/600_0/201609281200228d532655a5886af8c75644f13535ca8f.jpg
         * goodsName : 丸江 儿童浓缩面汁 150毫升-测试商品1
         */

        private List<GoodsListBean> goodsList;

        public String getHid() {
            return hid;
        }

        public void setHid(String hid) {
            this.hid = hid;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class GoodsListBean {
            private String mid;
            private String price;
            private String mPrice;
            private String mImg;
            private String goodsName;

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getMPrice() {
                return mPrice;
            }

            public void setMPrice(String mPrice) {
                this.mPrice = mPrice;
            }

            public String getMImg() {
                return mImg;
            }

            public void setMImg(String mImg) {
                this.mImg = mImg;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }
        }
    }

    public static class ZtBean {
        private String zid;
        private String img;

        public String getZid() {
            return zid;
        }

        public void setZid(String zid) {
            this.zid = zid;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

    public static class BrandBean {
        private String img;
        /**
         * bid : 241
         * thumb :
         */

        private List<BrandListBean> brandList;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public List<BrandListBean> getBrandList() {
            return brandList;
        }

        public void setBrandList(List<BrandListBean> brandList) {
            this.brandList = brandList;
        }

        public static class BrandListBean {
            private String bid;
            private String thumb;

            public String getBid() {
                return bid;
            }

            public void setBid(String bid) {
                this.bid = bid;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }
        }
    }

    public static class GoodsBean {
        private String gid;
        private String img;
        /**
         * mid : 1129
         * price :
         * mPrice : 111
         * mImg : upload/goods/2016-10-06/600_0/2016092814543693df84c12978dac681c7373bfa48c69d.jpg
         * goodsName : 蔓越莓胶囊精华30粒曼越梅卵巢保养女性泌尿蔓越梅-蔓越莓
         */

        private List<GoodsListBBean> goodsListB;

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public List<GoodsListBBean> getGoodsListB() {
            return goodsListB;
        }

        public void setGoodsListB(List<GoodsListBBean> goodsListB) {
            this.goodsListB = goodsListB;
        }

        public static class GoodsListBBean {
            private String mid;
            private String price;
            private String mPrice;
            private String mImg;
            private String goodsName;

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getMPrice() {
                return mPrice;
            }

            public void setMPrice(String mPrice) {
                this.mPrice = mPrice;
            }

            public String getMImg() {
                return mImg;
            }

            public void setMImg(String mImg) {
                this.mImg = mImg;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }
        }
    }
}
