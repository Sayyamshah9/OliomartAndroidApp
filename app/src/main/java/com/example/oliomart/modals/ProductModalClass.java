package com.example.oliomart.modals;

public class ProductModalClass {

    String pname;
    String description;
    String pcategory;
    String psubcategory;
    String price;
    String[] images;

    public String getProductName() {
        return pname;
    }

    public void setProductName(String productName) {
        this.pname = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return pcategory;
    }

    public void setCategory(String category) {
        this.pcategory = category;
    }

    public String getSubCategory() {
        return psubcategory;
    }

    public void setSubCategory(String subCategory) {
        this.psubcategory = subCategory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
