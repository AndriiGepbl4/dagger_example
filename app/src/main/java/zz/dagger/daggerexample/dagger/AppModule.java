package zz.dagger.daggerexample.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zz.dagger.daggerexample.MyApplication;

@Module
public class AppModule {

    private Context appContext;
    private final MyApplication application;

    public AppModule(Context appContext, MyApplication application) {
        this.appContext = appContext;
        this.application = application;
    }

    @Provides
    @Singleton
    Context providesContext(){
        return appContext;
    }
}
