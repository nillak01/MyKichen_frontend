package com.example.mykitchen.NoDB;

import com.example.mykitchen.domain.Device;
import com.example.mykitchen.domain.DeviceForRecipe;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.domain.ProductsForRecipe;
import com.example.mykitchen.domain.Recipe;

import java.util.ArrayList;
import java.util.List;

public class NoDB {

    private NoDB(){}


    public static final List<Recipe> RECIPE_LIST = new ArrayList<>();
    public static final List<Device> DEVICE_LIST = new ArrayList<>();
    public static final List<Products> PRODUCTS_LIST = new ArrayList<>();
    public static final List<ProductsForRecipe> PRODUCTS_FOR_RECIPE_LIST = new ArrayList<>();
    public static final List<DeviceForRecipe> DEVICE_FOR_RECIPE_LIST = new ArrayList<>();
    public static final List<DeviceForRecipe> DEVICE_FOR_RECIPE_LIST_BY_RECIPEID = new ArrayList<>();
}
