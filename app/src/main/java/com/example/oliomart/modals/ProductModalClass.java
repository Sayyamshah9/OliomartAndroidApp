package com.example.oliomart.modals;

import java.util.ArrayList;

public class ProductModalClass {

    String pname;
    String description;
    String pcategory;
    String psubcategory;
    String price;
    ArrayList<String> pimages = new ArrayList<>();

    public ArrayList<String> getPimages() {
        return pimages;
    }

    public void setPimages(ArrayList<String> pimages) {
        this.pimages = pimages;
    }

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

}
