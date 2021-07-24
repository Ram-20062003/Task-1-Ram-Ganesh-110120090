package com.example.task1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button b1,b2,b3,b4;
   Button bcheck,bwrng;
    public  int score;
    int rem=0,check=0,clik=0,f=0;
    int c=0,cs=0,k=1,chk_time=0;
    String c1=" ",min,sec;
    TextView ts,tn,text_timer,live;
    viewclass vc;
  CountDownTimer countDownTimer;
    TimerTask timerTask;
    long millis=90000;
    int second,minutes;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        vc =new ViewModelProvider(this).get(viewclass.class);
             implement_timer();
                start();
}

    private void implement_timer() {

        countDownTimer=new CountDownTimer(millis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                millis=millisUntilFinished-(f*1000);
                display();
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onFinish: bye");

            }
        }.start();
    }

    private void display() {
        text_timer = (TextView) findViewById(R.id.timer);
        second= (int) ((millis/1000)%60);
        minutes=(int)(millis/1000)/60;
        String time=String.format(Locale.getDefault(),"%02d:%02d",minutes,second);
        text_timer.setText(time);
        if(minutes<=0&&second<=0){
            countDownTimer.cancel();
                 Intent intent=new Intent(MainActivity.this,result_main.class);
                intent.putExtra(("score"),vc.vgetscore());
                intent.putExtra(("wrong"),vc.vgetwrng());
                intent.putExtra(("k"),vc.getk());
                intent.putExtra(("r"),vc.getk()/5+1);
                startActivity(intent);}
        }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("millisLeft",millis);
    }

    @Override
    protected void onRestoreInstanceState( Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        millis=savedInstanceState.getLong("millisLeft");
        //display();
        implement_timer();
    }
    public void start(){
        text_timer = (TextView) findViewById(R.id.timer);
        clik=1;
        ConstraintLayout l=(ConstraintLayout) findViewById(R.id.quiz);
        vc= new ViewModelProvider(this).get(viewclass.class);
        ts=findViewById(R.id.total);
        tn=(TextView)findViewById(R.id.textView4);
        ts.setText("Score="+vc.vgetscore());
        TextView text_life=(TextView)findViewById(R.id.lives);
        text_life.setText("Wrongs:"+vc.vgetwrng());
        String a="";
        int m = new Random().nextInt(12)+1;
        int y= new Random().nextInt(21)+2000;
        if(m==1)
            a="Jan";
        if(m==2)
            a="Feb";
        if(m==3)
            a="Mar";
        if(m==4)
            a="Apr";
        if(m==5)
            a="May";
        if(m==6)
            a="Jun";
        if(m==7)
            a="Jul";
        if(m==8)
            a="Aug";
        if(m==9)
            a="Sept";
        if(m==10)
            a="Oct";
        if(m==11)
            a="Nov";
        if(m==12)
            a="Dec";
        int d=datecheck(m,y);
        String date= d +"-"+ a +"-"+ y;
        TextView tq=findViewById(R.id.textView);
        tn.setText(String.valueOf(vc.getk()));
        tq.setText("ROUND:"+String.valueOf(vc.getk()/5+1));
        TextView tv= findViewById(R.id.textView2);
        tv.setText(date);
        day(d,m,y);
        buttons();

    }
    public int datecheck(int mm,int yy){
        int var=0;
        if (mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)
            var=new Random().nextInt(31) + 1;
        if((mm==4) || (mm == 6) || (mm==9)|| (mm==11))
           var=new Random().nextInt(30) + 1;
        if (mm == 2) {
            if(yy%4==0)
                var=new Random().nextInt(29) + 1;
            else
                var=new Random().nextInt(28) + 1;
        }
        return var;
    }
    public void day(int dd,int mm,int yy)
    {
       /* TextView t= findViewById(R.id.textView3);*/
        int[] mc ={1,4,4,0,2,5,0,3,6,1,4,6};
        String[] d ={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        int s,l,f,y=yy,yc=0,sum=0,q,lr=yy;
        l=yy%100;
        s=(l/4)+dd+mc[mm-1];
        f=yy/100;
        yc=6;
        sum=s+yc+l;
        if(lr%4==0){
       if(mm==1||mm==2){
            sum=sum-1;
        }}
        rem=sum%7;
    }
    public void buttons()
    {
        /*TextView t= findViewById(R.id.textView3);
        t.setText(String.valueOf(rem));*/
        b1= findViewById(R.id.radioButton1);
        b2= findViewById(R.id.radioButton2);
        b3= findViewById(R.id.radioButton3);
        b4= findViewById(R.id.radioButton4);
        setbuttons();

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View v) {
        Vibrator vib=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        ConstraintLayout l=(ConstraintLayout) findViewById(R.id.quiz);
        RelativeLayout layout=(RelativeLayout)findViewById(R.id.rel);
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.question);
        TextView text_life=(TextView)findViewById(R.id.lives);
        vc= new ViewModelProvider(this).get(viewclass.class);
         ts=findViewById(R.id.total);
        /*TextView t= findViewById(R.id.textView3);*/
        String[] d = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String g = d[rem];
        if(clik==1){
        switch (v.getId())
        {
            case R.id.radioButton1:
                c1= (String) b1.getText();
                clik=0;
                bwrng=b1;
                //Toast.makeText(MainActivity.this,"Clicked one",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                c1= (String) b2.getText();
                clik=0;
                bwrng=b2;
                //Toast.makeText(MainActivity.this,"Clicked Two",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                c1= (String) b3.getText();
                clik=0;
                bwrng=b3;
                //Toast.makeText(MainActivity.this,"Clicked Three",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton4:
                c1= (String) b4.getText();
                clik=0;
                bwrng=b4;
               // Toast.makeText(MainActivity.this,"Clicked Four",Toast.LENGTH_SHORT).show();
                break;
        }
        vc.addk();
            text_timer = (TextView) findViewById(R.id.timer);


        if(c1.compareTo(g)==0 && check==0){
           /* t.setText("Correct");*/
            Toast.makeText(MainActivity.this,"Correct",Toast.LENGTH_SHORT).show();
            layout.setBackgroundColor(Color.GREEN);
            l.setBackgroundResource(R.drawable.star);
            linearLayout.setBackgroundResource(R.drawable.star);
            bcheck.setBackgroundResource(R.drawable.styling_crct);
            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    layout.setBackgroundResource(R.drawable.star);
                    l.setBackgroundResource(R.drawable.styling_outer);
                    linearLayout.setBackgroundResource(R.drawable.styling_question);
                    bcheck.setBackgroundResource(R.drawable.styling_back);
                }
            },1000);
        }
        else {
            c=1;
           vc.addc();
           vc.addwrng();
            cs=0;
            check=0;
            layout.setBackgroundColor(Color.RED);
            l.setBackgroundResource(R.drawable.star);
            linearLayout.setBackgroundResource(R.drawable.star);
            Handler handler1=new Handler();
            bwrng.setBackgroundResource(R.drawable.styling_wrng);
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    layout.setBackgroundResource(R.drawable.star);
                    l.setBackgroundResource(R.drawable.styling_outer);
                    linearLayout.setBackgroundResource(R.drawable.styling_question);
                    bwrng.setBackgroundResource(R.drawable.styling_back);


                }
            },1000);
            vib.vibrate(400);
        }

        Handler hs=new Handler();
        hs.postDelayed(new Runnable() {
            @Override
            public void run() {
                    ts.setVisibility(1);
                    if(c==0){
                   vc.addscore();}
                    ts.setText("Score="+vc.vgetscore());
                    text_life.setText("Wrongs:"+vc.vgetwrng());
                if(c==1)
                {f+=5;
                    ts.setVisibility(1);
                    ts.setText("Score="+vc.vgetscore());
                    c=0;
                }
                clik=0;
                start();
            }
        },1000);}
    }
    public void setbuttons() {
       Button[] b = new Button[]{b1, b2, b3, b4};
        String[] d = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String g = d[rem];
        List<Button> bl=Arrays.asList(b);
        Collections.shuffle(bl);
        bl.get(0).setText(d[rem]);
        bcheck=bl.get(0);
        List<String> wd= Arrays.asList(d);
        Collections.shuffle(wd);
        int j=1;
        for(int i =1;;i++)
        {
            if(wd.get(i).compareTo(g)==0) continue;
            else{
                bl.get(j).setText(wd.get(i));
                j++;
            }
            if(j==4) break;
        }
    }
    }
