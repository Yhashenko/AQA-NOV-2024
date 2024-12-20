package org.prog.testng;

public class PhoneDto {
    private String phoneName;
    private String goodsId;


    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "PhoneDto{" +
                "phoneName='" + phoneName + '\'' +
                ", goodsId='" + goodsId + '\'' +
                '}';
    }

}

