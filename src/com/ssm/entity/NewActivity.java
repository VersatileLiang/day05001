package com.ssm.entity;

public class NewActivity {
    private String collection;
    private String id;
    private String releaseTime;
    private String share;
    private String source;
    private String summary;
    private String thumbnail;
    private String title;
    private String whetherAdvertising;
    private String whetherCollection;
    private String whetherPay;
    private String type;
    private String datetime;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhetherAdvertising() {
        return whetherAdvertising;
    }

    public void setWhetherAdvertising(String whetherAdvertising) {
        this.whetherAdvertising = whetherAdvertising;
    }

    public String getWhetherCollection() {
        return whetherCollection;
    }

    public void setWhetherCollection(String whetherCollection) {
        this.whetherCollection = whetherCollection;
    }

    public String getWhetherPay() {
        return whetherPay;
    }

    public void setWhetherPay(String whetherPay) {
        this.whetherPay = whetherPay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "NewActivity{" +
                "collection='" + collection + '\'' +
                ", id='" + id + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", share='" + share + '\'' +
                ", source='" + source + '\'' +
                ", summary='" + summary + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", whetherAdvertising='" + whetherAdvertising + '\'' +
                ", whetherCollection='" + whetherCollection + '\'' +
                ", whetherPay='" + whetherPay + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
