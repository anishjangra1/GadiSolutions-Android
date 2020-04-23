package com.digi.gadisolutions.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Brand implements Serializable {
    private String brand_image;

    private String brand_name;

    public String getBrand_image ()
    {
        return brand_image;
    }

    public void setBrand_image (String brand_image)
    {
        this.brand_image = brand_image;
    }

    public String getBrand_name ()
    {
        return brand_name;
    }

    public void setBrand_name (String brand_name)
    {
        this.brand_name = brand_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [brand_image = "+brand_image+", brand_name = "+brand_name+"]";
    }
}
