package com.hfad.beeradviser;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manu on 06/02/2017.
 */

public class BeerExpert {

    List<String> getBrands(String color)
    {
        Log.d(this.getClass().getSimpleName(),color);
        List<String> brands = new ArrayList<String>();
        if(color.equals("amber"))
        {
            brands.add("Jack Amber");
            brands.add("Red moose");
        }
        else
        {
            brands.add("Jail Pale Ale");
            brands.add("Gout Sout");
        }
        return brands;
    }
}
