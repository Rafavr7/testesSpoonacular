package pt.iade.andre.cooking.testesandrecooking.model;

import pt.iade.andre.cooking.testesandrecooking.utils.StringUtils;

public class Ingredient {
    private String name;
    private String image;
    private Integer id;
    private String aisle;

    public Ingredient() {
        // EMPTY CONSTRUCTOR
    }
    
    public Ingredient(String name, String image, Integer id, String aisle) {
        this.name = name;
        this.image = image;
        this.id = id;
        this.aisle = aisle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }
    
    @Override
    public String toString() {
        return StringUtils.toString(this.getClass(), this);
    }
}
