package zz.dagger.daggerexample.dagger;

import javax.inject.Singleton;

import dagger.Component;
import zz.dagger.daggerexample.activities.MainActivity;
import zz.dagger.daggerexample.activities.WatchActivity;

@Singleton
@Component (modules = {AppModule.class, PrefsModule.class})
public interface AppComponent {

    void inject (MainActivity mainActivity);
    void inject (WatchActivity watchActivity);
}
