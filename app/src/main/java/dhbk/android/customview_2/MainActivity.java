package dhbk.android.customview_2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private LovelyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (LovelyView) findViewById(R.id.custView);


    }

    public void btnPressed(View view) {
        myView.setCircleCol(Color.GREEN);
        myView.setLabelCol(Color.MAGENTA);
        myView.setCircleText("Help");
    }
}
