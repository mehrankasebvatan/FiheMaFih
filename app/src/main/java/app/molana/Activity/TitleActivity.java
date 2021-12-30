package app.molana.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adivery.sdk.Adivery;
import com.adivery.sdk.AdiveryAdListener;
import com.adivery.sdk.AdiveryBannerAdView;
import com.valdesekamdem.library.mdtoast.MDToast;

import app.molana.Adapter.RvAdapter;
import app.molana.Application.App;
import app.molana.DataBase.MyDb;
import com.pushpole.sdk.PushPole;

import app.molana.R;

public class TitleActivity extends AppCompatActivity {

    RecyclerView rv_title;
    RvAdapter adapter;
    MyDb db;
    TextView tv_toolbar;
    ImageView img2;
    String APP_ID = "0a8736d2-8490-47c0-a917-f15565683e18";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        Adivery.configure(getApplication(), APP_ID);
        PushPole.initialize(this,true);



        castViews();
        doSomething();


        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_title.setHasFixedSize(true);
        rv_title.setLayoutManager(lm);
        db = new MyDb(this);
        adapter = new RvAdapter(this, db.getAllData());
        rv_title.setAdapter(adapter);


        AdiveryBannerAdView bannerAd = findViewById(R.id.banner_ad);
        bannerAd.setBannerAdListener(new AdiveryAdListener() {
            @Override
            public void onAdLoaded() {
                // تبلیغ به‌طور خودکار نمایش داده می‌شود، هر کار دیگری لازم است اینجا انجام دهید.
            }

            @Override
            public void onError(String reason) {
                // خطا را چاپ کنید تا از دلیل آن مطلع شوید
                App.t("Ad Error", MDToast.TYPE_ERROR);
            }

            @Override
            public void onAdClicked() {
                // کاربر روی بنر کلیک کرده
            }
        });
        bannerAd.loadAd();


    }


    public void castViews() {

        rv_title = findViewById(R.id.rv_title);
        tv_toolbar = findViewById(R.id.tv_toolbar);
        img2 = findViewById(R.id.img2);


    }


    public void doSomething() {

        tv_toolbar.setText(R.string.name);
        tv_toolbar.setTextSize(25);
        img2.setImageResource(R.drawable.icon_info);
        img2.setOnClickListener(view -> {
            startActivity(new Intent(TitleActivity.this, InfoActivity.class));
        });


    }
}