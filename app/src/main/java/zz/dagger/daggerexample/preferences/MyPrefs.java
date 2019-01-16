package zz.dagger.daggerexample.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class MyPrefs {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String PREFS_NAME = "prefs name";
    private final String SAVED_TEXT = "saved text";

    @Inject
    public MyPrefs(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveText(String text){
        editor.putString(SAVED_TEXT, text);
        editor.apply();
    }

    public String loadText(){
        return sharedPreferences.getString(SAVED_TEXT, "no text");
    }
}