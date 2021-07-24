package com.example.task1;

import androidx.lifecycle.ViewModel;
import android.os.CountDownTimer;
import java.sql.Time;
import java.util.Random;

public class viewclass extends ViewModel {
    int score=0,k=1,c=-1,m;
    int wrng=0;
    public int vgetscore()
    {
        return score;
    }
    public void addscore()
    {
        score=score+2;
    }
   public int vgetwrng(){return wrng;}
    public void addwrng(){ wrng=wrng+1;
    }
    public int getk()
    {
        return k;
    }
    public void addk()
    {
        k++;
    }
    public int vgetc(){
        return c;
    }
    public void addc(){
        c++;
    }
    public int month(){
         m = new Random().nextInt(12)+1;
        return m;
    }

}
