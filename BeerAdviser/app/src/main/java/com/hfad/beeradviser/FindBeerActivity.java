package com.hfad.beeradviser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
        ImageView photo =  (ImageView) findViewById(R.id.imageView);
        String description ="this is the logo";
        int image = R.drawable.apple_logo_318_40184;
        photo.setImageResource(image);
        photo.setContentDescription(description);

    }

    public void onClickFindBeer(View view)
    {
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());
        Log.d(this.getClass().getSimpleName(),beerType);
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();

        for(String brand:brandsList)
        {
            brandsFormatted.append(brand + '\n');
        }

        brands.setText(brandsFormatted);
    }

    public void onClickShowLinearLayout(View view)
    {
        onClickSwitch(view);
    }

    public void onClickSwitch(View view)
    {
        Intent intent = new Intent(this,LinearLayoutActivity.class);
        startActivity(intent);
        //Toast.makeText(this,"ciao",Toast.LENGTH_LONG).show();

    }
}
