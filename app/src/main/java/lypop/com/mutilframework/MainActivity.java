package lypop.com.mutilframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.annotation.ContentView;

import lypop.com.util_library.InjectUtil;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtil.inject(this);
    }
}
