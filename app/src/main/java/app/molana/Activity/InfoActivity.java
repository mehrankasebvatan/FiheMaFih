package app.molana.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import app.molana.R;


public class InfoActivity extends AppCompatActivity {

    TextView toolbar;
    String url_instagram = "https://instagram.com/mkv.dev";
    String url_telegram = "https://t.me/mkv_dev";
    String url_github = "https://github.com/mehrankasebvatan";
    String url_site = "https://yek.link/MehranKasebvatan";
    String url_rate = "bazaar://details?id=" + "app.molana";
    String url_apps = "bazaar://collection?slug=by_author&aid=" + "kasebvatan";
    String url_donate = "https://zarinp.al/mehrankasebvatan";
    CardView cv_instagram, cv_telegram, cv_github, cv_site, cv_rate, cv_apps, cv_donate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        toolbar = findViewById(R.id.tv_toolbar);
        toolbar.setText(R.string.about);


        cv_instagram = findViewById(R.id.cv_instagram);
        cv_instagram.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url_instagram));
            startActivity(i);
        });

        cv_telegram = findViewById(R.id.cv_telegram);
        cv_telegram.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url_telegram));
            startActivity(i);
        });

        cv_github = findViewById(R.id.cv_github);
        cv_github.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url_github));
            startActivity(i);
        });

        cv_site = findViewById(R.id.cv_site);
        cv_site.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url_site));
            startActivity(i);
        });

        cv_rate = findViewById(R.id.cv_rate);
        cv_rate.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setData(Uri.parse(url_rate));
            intent.setPackage("com.farsitel.bazaar");
            startActivity(intent);
        });

        cv_apps = findViewById(R.id.cv_apps);
        cv_apps.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url_apps));
            intent.setPackage("com.farsitel.bazaar");
            startActivity(intent);
        });

        cv_donate = findViewById(R.id.cv_donate);
        cv_donate.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url_donate));
            startActivity(i);
        });


    }


}