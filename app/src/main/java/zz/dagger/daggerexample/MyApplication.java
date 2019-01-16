package zz.dagger.daggerexample;

        import android.app.Application;

        import zz.dagger.daggerexample.dagger.AppComponent;
        import zz.dagger.daggerexample.dagger.AppModule;
        import zz.dagger.daggerexample.dagger.DaggerAppComponent;

public class MyApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(getApplicationContext(), this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
