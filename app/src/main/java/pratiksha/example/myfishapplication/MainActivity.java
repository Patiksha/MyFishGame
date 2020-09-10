package pratiksha.example.myfishapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private  FlyingFishView gameView;
    
    //Button slowBtn,midBut,fastBut;
    private Handler handler=new Handler();
    private final static long Interval=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
//       slowBtn=findViewById(R.id.slowGameBtn);
//       midBut=findViewById(R.id.mediumGameBtn);
//       fastBut=findViewById(R.id.fastGameBtn);
//        slowBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent slowIntent=new Intent(MainActivity.this,FlyingFishView.class);
//                startActivity(slowIntent);
//            }
//        });
//        midBut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent slowIntent=new Intent(MainActivity.this,FlyingFishView.class);
//                startActivity(slowIntent);
//            }
//        });

        gameView=new FlyingFishView(this);
        setContentView(gameView);

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                     gameView.invalidate();
                    }
                });
            }
        },0,Interval);
    }
}