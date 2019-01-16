package zz.dagger.daggerexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zz.dagger.daggerexample.MyApplication;
import zz.dagger.daggerexample.R;
import zz.dagger.daggerexample.preferences.MyPrefs;

public class MainActivity extends AppCompatActivity {

    @Inject
    MyPrefs prefs;

    @BindView(R.id.etTypeSometh)
    EditText etTypeSometh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyApplication.getAppComponent().inject(this);

    }

    @OnClick(R.id.btnSave)
    public void onBtnSaveClicked(){
        prefs.saveText(etTypeSometh.getText().toString());
    }

    @OnClick(R.id.btnWatch)
    public void onBtnWatchClicked(){
        Intent intent = new Intent(this, WatchActivity.class);
        startActivity(intent);
    }
}
