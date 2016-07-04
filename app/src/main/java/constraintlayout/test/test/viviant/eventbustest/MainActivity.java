package constraintlayout.test.test.viviant.eventbustest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;

import constraintlayout.test.test.viviant.eventbustest.event.TestEvent;
import constraintlayout.test.test.viviant.eventbustest.manager.EventBusManager;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBusManager.getInstance().getGlobaEventBus().register(this);
        Button bt = (Button) findViewById(R.id.bt);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);

        final Intent intent = new Intent(this, SecActivity.class);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    /**
     * 不同模块之间数据的同步
     *2.4的用法必须使用以下的几个方法，不需要注解
     * @param event
     */
    public void onEventMainThread(TestEvent event) {
        Log.d("weiwei", "onEventMainThread收到了消息：" );

        if (event.getEventName().equals("tv1")) {
            tv1.setText("change by bt1");

        } else if (event.getEventName().equals("tv2")) {
            tv2.setText("tv2");

        } else if (event.getEventName().equals("tv3")) {

        } else if (event.getEventName().equals("tv4")) {

        }
    }

    //SecondEvent接收函数二
    public void onEventBackgroundThread(TestEvent event){
        Log.d("weiwei", "onEventBackground收到了消息：" );
    }
    //SecondEvent接收函数三
    public void onEventAsync(TestEvent event){
        Log.d("weiwei", "onEventAsync收到了消息：" );
    }


    //--------------------------------------------------------------------------------2.4用法

    /**
     * 3.0接收消息用法，随便定义名字，要有注解
     *
     */


    @Subscribe
    public void onEventReceive(TestEvent event){

        Log.d("weiwei", "onEventReceive收到了消息：");
    }



}
