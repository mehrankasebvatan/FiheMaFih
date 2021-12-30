package app.molana.Application;

import android.util.Log;
import com.valdesekamdem.library.mdtoast.MDToast;

public class App {

    public static final String TAG = "tv";

    public static void l(String message) {
        Log.e(TAG, message);
    }

    public static void t(String message, int type) {
        MDToast mdToast = MDToast.makeText(Application.getContext(), message, MDToast.LENGTH_SHORT, type);
        mdToast.show();
    }


}
