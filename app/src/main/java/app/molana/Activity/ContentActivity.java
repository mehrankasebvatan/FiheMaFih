package app.molana.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.adivery.sdk.Adivery;
import com.adivery.sdk.AdiveryAdListener;
import com.adivery.sdk.AdiveryBannerAdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.valdesekamdem.library.mdtoast.MDToast;

import app.molana.Application.App;
import app.molana.R;

public class ContentActivity extends AppCompatActivity {

    TextView tv_content, tv_toolbar;
    Bundle bundle;
    String APP_ID = "0a8736d2-8490-47c0-a917-f15565683e18";
    FloatingActionButton share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Adivery.configure(getApplication(), APP_ID);


        tv_content = findViewById(R.id.tv_content);
        tv_toolbar = findViewById(R.id.tv_toolbar);
        share = findViewById(R.id.btn_share);

        share.setOnClickListener(view -> {
            Intent sh = new Intent(Intent.ACTION_SEND);
            String shareBody = tv_content.getText().toString() + getString(R.string.share);
            sh.setType("text/plain");
            sh.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            sh.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sh, getString(R.string.app_name)));
        });




        bundle = getIntent().getExtras();
        if (bundle != null) {
            String id = getIntent().getStringExtra("idKey");
            tv_content.setText(getIntent().getStringExtra("contentKey"));
            tv_toolbar.setText(getIntent().getStringExtra("titleKey"));
            tv_toolbar.setTextSize(20);
        }


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
}