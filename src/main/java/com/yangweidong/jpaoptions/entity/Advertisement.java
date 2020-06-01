package com.yangweidong.jpaoptions.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_advertisement")
public class Advertisement {
    @Id
    @Column(name = "c_ad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adId;

    @Column(name = "c_ad_photo")
    private String adPhoto;

    @Column(name = "c_ad_link")
    private String adLink;

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdPhoto() {
        return adPhoto;
    }

    public void setAdPhoto(String adPhoto) {
        this.adPhoto = adPhoto;
    }

    public String getAdLink() {
        return adLink;
    }

    public void setAdLink(String adLink) {
        this.adLink = adLink;
    }
}
