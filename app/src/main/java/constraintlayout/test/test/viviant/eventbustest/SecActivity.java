package constraintlayout.test.test.viviant.eventbustest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import constraintlayout.test.test.viviant.eventbustest.event.TestEvent;
import constraintlayout.test.test.viviant.eventbustest.manager.EventBusManager;

/**
 * 作者：viviant on 2016/7/4 10:37
 * 描述：
 */
public class SecActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sec);

        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);
        Button bt3 = (Button) findViewById(R.id.bt3);
        Button bt4 = (Button) findViewById(R.id.bt4);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        TestEvent te = new TestEvent();
        switch (view.getId()) {

            case R.id.bt1:
                te.setEventName("tv1");
                EventBusManager.getInstance().getGlobaEventBus().post(te);
                break;

            case R.id.bt2:
                te.setEventName("tv2");
                EventBusManager.getInstance().getGlobaEventBus().post(te);
                break;

            case R.id.bt3:
                break;

            case R.id.bt4:
                break;
            default:
                break;
        }
    }
}
