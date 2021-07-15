package com.example.task1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   RadioButton b1,b2,b3,b4;
   Button bcheck,bwrng;
    int score=0;
    int rem=0,check=0;
    int c=0,cs=0,k=1;
    String c1=" ";
    TextView ts,tn,text_timer;
    viewclass vc;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        vc =new ViewModelProvider(this).get(viewclass.class);
        implement_timer();
            if(vc.vgetc()==0){
                start();

}}

    private void implement_timer() {
        Timer timer;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dispay();
            }
        },0,1000);
    }

    private void dispay() {
        vc= new ViewModelProvider(this).get(viewclass.class);
        text_timer=(TextView)findViewById(R.id.timer);
        if(vc.vgetsec()>0)
            vc.subsecond();
        else{
           vc.submint();
           vc.subsecond();
        }
        String sec=String.valueOf(vc.vgetsec());
        String min=String.valueOf(vc.vgetmint());
        if(sec.length()==1) {
            sec="0"+sec;
        }
        if(min.length()==1) {
            min="0"+min;
        }
        if(vc.vgetmint()>=0)
            text_timer.setText(min+":"+sec);
    }

    public void start(){
        ConstraintLayout l=(ConstraintLayout) findViewById(R.id.quiz);
        vc= new ViewModelProvider(this).get(viewclass.class);
        ts=findViewById(R.id.total);
        tn=(TextView)findViewById(R.id.textView4);
        ts.setText("Score="+vc.vgetscore());
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
        tq.setText("The given date is :");
        tn.setText(String.valueOf(vc.getk()));
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
        vc= new ViewModelProvider(this).get(viewclass.class);
         ts=findViewById(R.id.total);
        /*TextView t= findViewById(R.id.textView3);*/
        TextView tfs= findViewById(R.id.finalscore);
        String[] d = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String g = d[rem];

        switch (v.getId())
        {
            case R.id.radioButton1:
                c1= (String) b1.getText();
                bwrng=b1;
                //Toast.makeText(MainActivity.this,"Clicked one",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                c1= (String) b2.getText();
                bwrng=b2;
                //Toast.makeText(MainActivity.this,"Clicked Two",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                c1= (String) b3.getText();
                bwrng=b3;
                //Toast.makeText(MainActivity.this,"Clicked Three",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton4:
                c1= (String) b4.getText();
                bwrng=b4;
               // Toast.makeText(MainActivity.this,"Clicked Four",Toast.LENGTH_SHORT).show();
                break;
        }
        b1.setChecked(false);
        b2.setChecked(false);
        b3.setChecked(false);
        b4.setChecked(false);
        vc.addk();
        if(c1.compareTo(g)==0 && check==0){
           /* t.setText("Correct");*/
            Toast.makeText(MainActivity.this,"Correct",Toast.LENGTH_SHORT).show();
            layout.setBackgroundColor(Color.GREEN);
            l.setBackgroundResource(R.drawable.star);
            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    layout.setBackgroundResource(R.drawable.star);
                    l.setBackgroundResource(R.drawable.styling_outer);
                }
            },1000);
        }
        else {
            c=1;
           vc.addc();
            cs=0;
            check=1;
            Toast.makeText(MainActivity.this,"GAME OVER",Toast.LENGTH_LONG).show();
            layout.setBackgroundColor(Color.RED);
            Handler handler1=new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    layout.setBackgroundResource(R.drawable.star);
                    l.setBackgroundResource(R.drawable.styling_outer);

                }
            },1000);
            Handler handler2=new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    bcheck.setBackgroundResource(R.drawable.styling_crct);
                    bwrng.setBackgroundResource(R.drawable.styling_wrng);
                }
            },1000);
            tfs.setVisibility(1);
            String z=String.valueOf(vc.vgetscore());
            tfs.setText("FINAL SCORE:"+z);
            vib.vibrate(400);
        }

        Handler hs=new Handler();
        hs.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(c==0){
                    ts.setVisibility(1);
                   vc.addscore();
                    ts.setText("Score="+vc.vgetscore());
                    start();
                }
            }
        },1000);
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
