package com.example.task1;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class viewclass extends ViewModel {
    int score=0,k=1,c=0,m;
    int mint=1,s=30;
    public int vgetscore()
    {
        return score;
    }
    public void addscore()
    {
        score=score+1;
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
        c=1;
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
}
