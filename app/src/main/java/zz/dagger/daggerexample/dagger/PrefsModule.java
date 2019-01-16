package zz.dagger.daggerexample.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zz.dagger.daggerexample.preferences.MyPrefs;

@Module
public class PrefsModule {

    @Singleton
    @Provides
    MyPrefs getPrefs(Context context){
        return new MyPrefs(context);
    }
}
