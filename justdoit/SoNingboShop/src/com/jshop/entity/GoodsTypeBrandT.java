package com.jshop.entity;
// Generated 2011-12-21 20:50:55 by Hibernate Tools 3.2.1.GA



/**
 * GoodsTypeBrandT generated by hbm2java
 */
public class GoodsTypeBrandT  implements java.io.Serializable {


     private String goodsTypeBrandTid;
     private String goodsTypeId;
     private String name;
     private String brandname;
     private String brandid;

    public GoodsTypeBrandT() {
    }

	
    public GoodsTypeBrandT(String goodsTypeBrandTid) {
        this.goodsTypeBrandTid = goodsTypeBrandTid;
    }
    public GoodsTypeBrandT(String goodsTypeBrandTid, String goodsTypeId, String name, String brandname, String brandid) {
       this.goodsTypeBrandTid = goodsTypeBrandTid;
       this.goodsTypeId = goodsTypeId;
       this.name = name;
       this.brandname = brandname;
       this.brandid = brandid;
    }
   
    public String getGoodsTypeBrandTid() {
        return this.goodsTypeBrandTid;
    }
    
    public void setGoodsTypeBrandTid(String goodsTypeBrandTid) {
        this.goodsTypeBrandTid = goodsTypeBrandTid;
    }
    public String getGoodsTypeId() {
        return this.goodsTypeId;
    }
    
    public void setGoodsTypeId(String goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getBrandname() {
        return this.brandname;
    }
    
    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
    public String getBrandid() {
        return this.brandid;
    }
    
    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }




}


