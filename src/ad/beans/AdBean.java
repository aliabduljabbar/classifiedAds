package ad.beans;

import java.io.Serializable;
import java.util.ArrayList;


/*
 * This is a bean that will be used to pass an Ad.
 * It is Serializable, since it implements java.io.Serializable interface.
 */

public class AdBean implements Serializable {

    /*
     * private properties.
     */
    private int id;
    private String title;
    private String category;
    private String description;
    private ArrayList<String> images;
    private String location;
    private ArrayList<String> tags;

    /*
     * default, no-arg constructor
     */
    public AdBean() {
        this.id = 0;
        this.title = "";
        this.category = "";
        this.description = "";
        this.images = null;
        this.location = "";
        this.tags = null;
    }

    /*
     * Setters
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    /*
     * Getters.
     */
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
