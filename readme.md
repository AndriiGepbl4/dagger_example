# My simple example how to use Dagger2

1) 	build.gradle (app)
	  add dagger dependencies

	implementation 'com.google.dagger:dagger:2.16'
    implementation 'com.google.dagger:dagger-android:2.16'
    implementation 'com.google.dagger:dagger-android-support:2.16'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.16'
    annotationProcessor 'com.google.dagger:dagger-android-processor:2.16'
	
2) 	create module classes 

	  AppModule provides Context
	  PreferencesModule provides preferences
  	DB module for db etc.
	
	https://github.com/AndriiGepbl4/dagger_example/blob/master/app/src/main/java/zz/dagger/daggerexample/dagger/AppModule.java
	
3) 	add @Inject to classes constructors
		see MyPrefs as example
		
	https://github.com/AndriiGepbl4/dagger_example/blob/master/app/src/main/java/zz/dagger/daggerexample/preferences/MyPrefs.java
	
4)	create component class

	  add modules into @Component annotation
	  inject  classes
	  https://github.com/AndriiGepbl4/dagger_example/blob/master/app/src/main/java/zz/dagger/daggerexample/dagger/AppComponent.java
	  
	
5)	MyApplication 
	
	  add compoment
	
	  @Override
    public void onCreate() {
        super.onCreate();
        appComponent = null;
    }
	
	  build the project

	  appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(getApplicationContext(), this))
                .build();
		
	https://github.com/AndriiGepbl4/dagger_example/blob/master/app/src/main/java/zz/dagger/daggerexample/MyApplication.java

6)  Manifest 
  	in application add android:name MyApplication
	https://github.com/AndriiGepbl4/dagger_example/blob/master/app/src/main/AndroidManifest.xml
				
7)  Activities - @Inject necessary classes
	
	  in onCreate
	  MyApplication.getAppComponent().inject(this);
	

