package app.molana.Application;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

public class Application extends android.app.Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        setFont();
    }

    public static Context getContext() {
        return context;
    }

    public void setFont() {
        String font = "fonts/vazir.ttf";
        setDefaultFont(this, font);
    }


    public static void setDefaultFont(Context context, String font) {

        final Typeface typeface = Typeface.createFromAsset(context.getAssets(), font);

        try {
            final Field field = Typeface.class.getDeclaredField("MONOSPACE");
            field.setAccessible(true);
            field.set(null, typeface);
        } catch (Exception ignored) {
        }


    }

}
