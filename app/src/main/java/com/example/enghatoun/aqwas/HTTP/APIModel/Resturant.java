package com.example.enghatoun.aqwas.HTTP.APIModel;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resturant{

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("cat")
    @Expose
    private String cat;
    @SerializedName("catId")
    @Expose
    private String catId;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("Ulat")
    @Expose
    private String ulat;
    @SerializedName("Ulon")
    @Expose
    private String ulon;
    @SerializedName("open")
    @Expose
    private String open;
    @SerializedName("image")
    @Expose
    private List<String> image = null;

    public Resturant(Resturant body) {
        this.error = body.error;
        this.name = body.name;
        this.id = body.id;
        this.link = body.link;
        this.cat = body.cat;
        this.catId = body.catId;
        this.rating = body.rating;
        this.lat = body.lat;
        this.lon = body.lon;
        this.ulat = body.ulat;
        this.ulon = body.ulon;
        this.open = body.open;
        this.image = body.image;

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getUlat() {
        return ulat;
    }

    public void setUlat(String ulat) {
        this.ulat = ulat;
    }

    public String getUlon() {
        return ulon;
    }

    public void setUlon(String ulon) {
        this.ulon = ulon;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

}