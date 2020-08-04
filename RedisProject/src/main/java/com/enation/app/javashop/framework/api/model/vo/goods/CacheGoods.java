package com.enation.app.javashop.framework.api.model.vo.goods;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

/**
 * 缓存商品对象
 *
 * @author fk
 * @version v2.0
 * @since v7.0.0
 * 2018年3月29日 上午11:50:02
 */
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CacheGoods implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3642358108471082387L;
    private Integer goodsId;

    private Integer categoryId;

    private String goodsName;

    private String sn;

    private Double price;

    private Double weight;

    private String intro;

    private Integer goodsTransfeeCharge;

    private Integer templateId;

    private Integer marketEnable;

    private Integer disabled;

    private Integer isAuth;

    private Integer enableQuantity;

    private Integer quantity;

    private Integer sellerId;

    private String sellerName;

//    private List<GoodsSkuVO> skuList;

    private String thumbnail;

    private Long lastModify;

    /**
     * 是否虚拟
     * 0-否（实物类）；1-是（虚拟类） sear 2019-11-28
     */
    private Integer isVirtual;

    /**
     * 市场价格 sear 2019-11-28
     */
    private Double mktprice;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getGoodsTransfeeCharge() {
        return goodsTransfeeCharge;
    }

    public void setGoodsTransfeeCharge(Integer goodsTransfeeCharge) {
        this.goodsTransfeeCharge = goodsTransfeeCharge;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getMarketEnable() {
        return marketEnable;
    }

    public void setMarketEnable(Integer marketEnable) {
        this.marketEnable = marketEnable;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

//    public List<GoodsSkuVO> getSkuList() {
//        return skuList;
//    }
//
//    public void setSkuList(List<GoodsSkuVO> skuList) {
//        this.skuList = skuList;
//    }

    public Integer getEnableQuantity() {
        return enableQuantity;
    }

    public void setEnableQuantity(Integer enableQuantity) {
        this.enableQuantity = enableQuantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Integer isAuth) {
        this.isAuth = isAuth;
    }

    public Long getLastModify() {
        return lastModify;
    }

    public void setLastModify(Long lastModify) {
        this.lastModify = lastModify;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getIsVirtual() { return isVirtual; }

    public void setIsVirtual(Integer isVirtual) { this.isVirtual = isVirtual; }

    public Double getMktprice() { return mktprice; }

    public void setMktprice(Double mktprice) { this.mktprice = mktprice; }


    @Override
    public String toString() {
        return "CacheGoods{" +
                "goodsId=" + goodsId +
                ", categoryId=" + categoryId +
                ", goodsName='" + goodsName + '\'' +
                ", sn='" + sn + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", intro='" + intro + '\'' +
                ", goodsTransfeeCharge=" + goodsTransfeeCharge +
                ", templateId=" + templateId +
                ", marketEnable=" + marketEnable +
                ", disabled=" + disabled +
                ", isAuth=" + isAuth +
                ", enableQuantity=" + enableQuantity +
                ", quantity=" + quantity +
                ", sellerId=" + sellerId +
                ", sellerName='" + sellerName + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", lastModify=" + lastModify +
                ", isVirtual=" + isVirtual +
                ", mktprice=" + mktprice +
                '}';
    }
}
