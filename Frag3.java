package com.example.lenovo.a220419h2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Frag3 extends Fragment {

    private TextView news1, news2, news3;
    String detail_text1,detail_text2,detail_text3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag3_layout,container,false);

        news1 = v.findViewById(R.id.news1);
        news2 = v.findViewById(R.id.news2);
        news3 = v.findViewById(R.id.news3);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Document document = null;
                try {
                    document = Jsoup.connect("http://ybu.edu.tr/muhendislik/bilgisayar/").get();
                    Element element = document.selectFirst("a#ContentPlaceHolder1_ctl01_rpData_hplink_0");
                    Element element1= document.selectFirst("a#ContentPlaceHolder1_ctl01_rpData_hplink_1");
                    Element element2= document.selectFirst("a#ContentPlaceHolder1_ctl01_rpData_hplink_2");
                    detail_text1 = element.text();
                    detail_text2 = element1.text();
                    detail_text3 = element2.text();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            news1.setText(detail_text1);
                            news2.setText(detail_text2);
                            news3.setText(detail_text3);
                        }
                    });
                }

                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-314-647-ogretim-uyemizin-calismasi-irlanda-haberlerinde.html?src=0";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-314-561-akademik-faaliyetler-degerlendirme-toplantisi.html?src=0";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        news3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-314-551-1-sinif-ogrencimize-tubitak-lisans-yazilim-projesi-3-luk-odulu.html?src=0";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        return v;


    }
}
