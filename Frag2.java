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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Frag2 extends Fragment {

    private TextView annoucement1,annoucement2,annoucement3,
            annoucement4,annoucement5,annoucement6;
    private String detail_text1,detail_text2,detail_text3,
            detail_text4,detail_text5,detail_text6;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.frag2_layout,container,false);
        annoucement1 = v.findViewById(R.id.announcement1);
        annoucement2 = v.findViewById(R.id.announcement2);
        annoucement3 = v.findViewById(R.id.announcement3);
        annoucement4 = v.findViewById(R.id.announcement4);
        annoucement5 = v.findViewById(R.id.announcement5);
        annoucement6 = v.findViewById(R.id.announcement6);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Document document = Jsoup.connect("http://ybu.edu.tr/muhendislik/bilgisayar/").get();
                    Element element = document.selectFirst("a#ContentPlaceHolder1_ctl02_rpData_hplink_0");//a[class=brand brand-image]
                    Element element1 = document.selectFirst("a#ContentPlaceHolder1_ctl02_rpData_hplink_1");
                    Element element2 = document.selectFirst("a#ContentPlaceHolder1_ctl02_rpData_hplink_2");
                    Element element3 = document.selectFirst("a#ContentPlaceHolder1_ctl02_rpData_hplink_3");
                    Element element4 = document.selectFirst("a#ContentPlaceHolder1_ctl02_rpData_hplink_4");
                    Element element5 = document.selectFirst("a#ContentPlaceHolder1_ctl02_rpData_hplink_5");
                    detail_text1 = element.text();
                    detail_text2 = element1.text();
                    detail_text3 = element2.text();
                    detail_text4 = element3.text();
                    detail_text5 = element4.text();
                    detail_text6 = element5.text();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            annoucement1.setText(detail_text1);
                            annoucement2.setText(detail_text2);
                            annoucement3.setText(detail_text3);
                            annoucement4.setText(detail_text4);
                            annoucement5.setText(detail_text5);
                            annoucement6.setText(detail_text6);
                        }
                    });
                }
                catch (IOException e)
                {
                    Log.d("Announcements", e.getLocalizedMessage());
                }

            }
        });
        thread.start();
        annoucement1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-257-738-2018---2019-spring-midterm-schedule-(new-program)-updated-05042019.html?src=0";
                Intent anIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(anIntent);

            }
        });
        annoucement2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-257-737-about-software-engineering-course-(12032019).html?src=0";
                Intent anIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(anIntent);

            }
        });
        annoucement3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-257-736-turkce-ders-programi-(guncellendi-01032019).html?src=0";
                Intent anIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(anIntent);

            }
        });
        annoucement4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-257-732-2018---2019-spring-course-schedule-(updated-26022019).html?src=0";
                Intent anIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(anIntent);

            }
        });
        annoucement5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-257-735-ceng-202-lab-announcement.html?src=0";
                Intent anIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(anIntent);

            }
        });
        annoucement6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url = "https://aybu.edu.tr/muhendislik/bilgisayar/content_detail-257-733-ceng-104-lab-sections-(updated-18022019).html?src=0";
                Intent anIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(anIntent);

            }
        });
        return v;
    }
}
