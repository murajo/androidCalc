package com.example.calc2;

import android.icu.math.BigDecimal;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {
    Button button_0,button_1,button_2,button_3,button_4,button_5,button_6,button_7,
        button_8,button_9,button_equal,button_plus,button_minus,button_kake,button_waru,
        button_syousuu,button_C;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_equal = (Button) findViewById(R.id.button_equal);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_kake = (Button) findViewById(R.id.button_kake);
        button_waru = (Button) findViewById(R.id.button_waru);
        button_syousuu = (Button) findViewById(R.id.button_syousuu);
        button_C = (Button) findViewById(R.id.button_C);
        result = (TextView) findViewById(R.id.result);
        result.setText("0");
    }
    public void teigi_1(View v){
        String x = "1";
        check(x);
    }
    public void teigi_2(View v){
        String x = "2";
        check(x);
    }
    public void teigi_3(View v){
        String x = "3";
        check(x);
    }
    public void teigi_4(View v){
        String x = "4";
        check(x);
    }
    public void teigi_5(View v){
        String x = "5";
        check(x);
    }
    public void teigi_6(View v){
        String x = "6";
        check(x);
    }
    public void teigi_7(View v){
        String x = "7";
        check(x);
    }
    public void teigi_8(View v){
        String x = "8";
        check(x);
    }
    public void teigi_9(View v){
        String x = "9";
        check(x);
    }
    public void teigi_0(View v){
        String x = "0";
        check_0_double(x);
    }
    public void teigi_syousuu(View v){
        String x = ".";
        check_0_double(x);
    }
    public void teigi_plus(View v){
        String x = "+";
        check_enzan(x);
    }
    public void teigi_minus(View v){
        String x = "-";
        check_enzan(x);
    }
    public void teigi_kake(View v){
        String x = "*";
        check_enzan(x);
    }
    public void teigi_waru(View v){
        String x = "/";
        check_enzan(x);
    }
    public void teigi_C(View v){
        reset();
    }

    public void teigi_equal(View v){
        keisan();
    }
    public void check(String x) {
        String y = result.getText().toString();
        String array[] = y.split(" ");
        if (y.equals("0")) {
            result.setText(x);
        } else if (array.length == 1 && array[0].length() < 8 || array.length == 2 || array.length == 3 && array[2].length() < 8) {
            String z = y + x;
            result.setText(z);
        }
    }
    public void check_enzan(String x){
        String y = result.getText().toString();
        String array[] = y.split(" ");
        if(array.length == 1){
            String z = y + " " + x + " ";
            result.setText(z);
        }else if(array.length == 3){
            keisan();
            String y_2 = result.getText().toString();
            String z = y_2 + " " + x + " ";
            result.setText(z);
        }
    }
    public void check_0_double(String x){
        String y = result.getText().toString();
        String z = y;
        String[] array = y.split(" ");
        if(x.equals("0") && !(y.equals("0")) && (array.length == 1 && array[0].length() < 8 || array.length == 2 || array.length == 3 && array[2].length() < 8)){
            z = y + x;
            result.setText(z);
        }else if(array.length == 1 && x.equals(".") && y.indexOf(x) == -1){
            z = y + x;
        }else if(array.length == 3 && x.equals(".") && array[2].indexOf(x) == -1){
            z = y + x;
        }
        result.setText(z);
    }
    public void reset(){
        result.setText("0");
    }
    public void keisan(){
        String y = result.getText().toString();
        String[] array = y.split(" ");
        String z = null;
       if(array.length == 3){
           BigDecimal a = new BigDecimal(array[0]);
           BigDecimal b = new BigDecimal(array[2]);
           if(array[1].equals("+")){
               BigDecimal n = a.add(b);
               z = String.valueOf(n);
           }else if(array[1].equals("-")){
               BigDecimal n = a.subtract(b);
               z = String.valueOf(n);
           }else if(array[1].equals("*")){
               BigDecimal n = a.multiply(b);
               z = String.valueOf(n);
           }else if(array[1].equals("/")){
               BigDecimal n = a.divide(b, 10, BigDecimal.ROUND_HALF_UP);
               z = String.valueOf(n);
           }
           if(z.indexOf(".") != -1){
               z = delete_0(z);
           }
           if(z.equals("∞")){
               z = "0";
           }
           if(z.length() > 14){
               z = "桁数オーバー";
           }
           result.setText(z);
       }
    }
    public String delete_0(String z){
        for(int i = z.length(); i > 0; i--){
            String x = z.substring(i-1,i);
            if(x.equals("0")){
                z = z.substring(0,i-1);
            }else if(x.equals(".")){
                z = z.substring(0,i-1);
                break;
            }else{
                break;
            }
        }
        return z;
    }
}
