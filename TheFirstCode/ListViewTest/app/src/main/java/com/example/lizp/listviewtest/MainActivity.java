package com.example.lizp.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
    private String[] data = { "Apple ", "Banana ", "Orange ", "Watermelon ",
            "Pear ", "Grape ", "Pineapple ", "Strawberry ", "Cherry ", "Mango ",
            "Apple ", "Banana ", "Orange ", "Watermelon ", "Pear ", "Grape ",
            "Pineapple ", "Strawberry ", "Cherry ", "Mango "
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this, fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        for (int i = 0; i < data.length; i ++){
            Fruit fruit = new Fruit(data[i], R.drawable.fruits);
            fruitList.add(fruit);
        }
    }
}
