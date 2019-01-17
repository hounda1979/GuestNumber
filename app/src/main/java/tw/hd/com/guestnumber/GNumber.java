package tw.hd.com.guestnumber;

import android.util.Log;

import java.util.Random;

public class GNumber {
    int m_guestNum;
    int y_guestNum;

    public GNumber() {
    }

    public int getM_guestNum() {
        return m_guestNum;
    }

    public void setM_guestNum(int m_guestNum) {
        this.m_guestNum = m_guestNum;
    }

    public int getY_guestNum() {
        Random r = new Random();

        do {
            y_guestNum = r.nextInt(98)+1;
        }while(! ChickDouble(y_guestNum));
        if(ChickDouble(y_guestNum)){
            Log.d("GNumber", "getY_guestNum:    不重覆" );
        }else {
            Log.d("GNumber", "getY_guestNum:    重覆" );
        }



            return y_guestNum;
    }

  protected boolean ChickDouble (int chickNum) {
      boolean b = true;
      int ten = chickNum / 10;
      int sing = chickNum % 10;
      if (ten == sing){
          b = false;
      }


      return b;
  }

  public String isSame(int guestNums,int secretNumber){
        int ten = guestNums/10;
        int singular = guestNums%10;
        int secretTen = secretNumber/10;
        int secretSing = secretNumber%10;
        String  isGuest = "NO";
        //判斷10位數&個位數是否相同
      if(secretTen == ten){
          isGuest = "1A";
      }
      if (secretTen == singular){
          isGuest = "1B";
           }
           if(secretSing == ten) {
          isGuest = isGuest + "1B";
      }
          if (secretSing == singular){
          isGuest = isGuest+"1A";
      }
        if(isGuest.equals("1A1A")){
          isGuest = "2A";
        }
        if (isGuest.equals("1B1B")){
          isGuest ="2B";
        }
        if(isGuest.equals("NO1A")){
          isGuest= "1A";
        }
        if(isGuest.equals("NO1B")){
          isGuest="1B";
        }


        return isGuest;
  }



}
