package zz.dagger.daggerexample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zz.dagger.daggerexample.MyApplication;
import zz.dagger.daggerexample.R;
import zz.dagger.daggerexample.preferences.MyPrefs;

public class WatchActivity extends AppCompatActivity {

    @BindView(R.id.tvSavedText)
    TextView tvSavedText;

    @Inject
    MyPrefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        ButterKnife.bind(this);
        MyApplication.getAppComponent().inject(this);

        tvSavedText.setText(prefs.loadText());
    }

    @OnClick(R.id.btnReturn)
    public void onReturnClicked(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
