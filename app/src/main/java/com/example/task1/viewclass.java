package com.example.task1;

import androidx.lifecycle.ViewModel;
import android.os.CountDownTimer;
import java.sql.Time;
import java.util.Random;

public class viewclass extends ViewModel {
    int score=0,k=1,c=-1,m;
    int mint=1,s=30,resec=30,wrng=0;
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
    public void subtime(){
        if(s-10>0&&s-10<=59)
            s=s-10;
        else{
            s=s-10+59;
            mint--;
        }  }
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
    public int vgetmint(){return mint;}
    public int vgetsec(){
        return s;

    }
    public void submint(){mint=mint-1;}
    public void subsecond(){
        if(s>0&&s<=59)
           s=s-1;
        else
            s=59;}

    public void addsec(){
        s=s+1;
    }
    public void resetscore(){
        score=0;
    }
    /*public void resettime(){
        mint=1;
        s=20;
    }*/

}
