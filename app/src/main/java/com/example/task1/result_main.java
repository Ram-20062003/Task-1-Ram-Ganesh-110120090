package com.example.task1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class result_main extends AppCompatActivity {
    int score1;
    int high_score,kval,wrng,crct,r_round;
    TextView t_score,t_crct,t_wrng,t_round;
    Button button;
    public static final String shared_prefs="shared_prefs",save_score="save_score";
    public static int save_highscore;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.linearLayout);
        t_score=(TextView)findViewById(R.id.textView3);
        t_crct=(TextView)findViewById(R.id.textView5);
        t_wrng=(TextView)findViewById(R.id.textView6);
        t_round=(TextView)findViewById(R.id.textView7);
        TextView textView = (TextView) findViewById(R.id.textView9);
        Intent intent=getIntent();
       score1= intent.getIntExtra("score",0);
        wrng= intent.getIntExtra("wrong",0);
        kval= intent.getIntExtra("k",0);
        r_round=intent.getIntExtra("r",0);
        t_round.setText("LEVEL REACHED="+r_round);
        t_crct.setText("Correct answer="+String.valueOf(score1));
        t_wrng.setText("Wrong answer="+String.valueOf(wrng));
        score1=score1-wrng;
        t_score.setText("FINAL-SCORE ="+String.valueOf(score1));
        if(score1<(int)(0.33*kval))
            linearLayout.setBackgroundResource(R.drawable.bronze_cup);
        if(score1>=(int)(0.33*kval)&&score1<(int)(0.66*kval))
            linearLayout.setBackgroundResource(R.drawable.silver_cup);
        if(score1>=(int)(0.66*kval))
            linearLayout.setBackgroundResource(R.drawable.gold_cup);
        SharedPreferences sharedPreferences = getSharedPreferences(shared_prefs, Context.MODE_PRIVATE);
        MainActivity mainActivity=new MainActivity();
         high_score=save_highscore;
        if(sharedPreferences.getInt(save_score,0)<score1) {
            high_score = score1;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(save_score, high_score);
            editor.apply();
            save_highscore = sharedPreferences.getInt(save_score, 0);
            textView.setText("HIGH-SCORE ="+String.valueOf( sharedPreferences.getInt(save_score, 0)));
            high_score=save_highscore;
        }
        textView.setText("HIGH-SCORE ="+String.valueOf( sharedPreferences.getInt(save_score, 0)));
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(result_main.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       finishAffinity();
    }
}
