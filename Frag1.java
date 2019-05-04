package com.example.lenovo.a220419h2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class Frag1 extends Fragment {
   private TextView food_text, food_text1, food_text2, food_text3;
   private String detail_text,detail_text1,detail_text2,detail_text3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.frag1_layout,container,false);
        food_text = v.findViewById(R.id.food_text);
        food_text1 = v.findViewById(R.id.food_text1);
        food_text2 = v.findViewById(R.id.food_text2);
        food_text3 = v.findViewById(R.id.food_text3);




       Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    Document document = Jsoup.connect("https://aybu.edu.tr/sks/").get();
                   // Element element = document.selectFirst("table");
                    for(Element table :document.select("table")){
                        for(Element row : table.select("tr")){
                            Elements tds = row.select("td");
                            if(tds.size()>5){
                                detail_text = tds.get(3).text();
                                detail_text1 = tds.get(4).text();
                                detail_text2 = tds.get(5).text();
                                detail_text3 = tds.get(6).text();


                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        food_text.setText(detail_text);
                                        food_text1.setText(detail_text1);
                                        food_text2.setText(detail_text2);
                                        food_text3.setText(detail_text3);

                                    }
                                });
                            }
                        }
                }



        }
                catch (IOException e) {
                   Log.d("Details", e.getLocalizedMessage());                }

            }

        });
        thread.start();

        return v;

    }






}
