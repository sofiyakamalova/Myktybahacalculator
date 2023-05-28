package kz.cource.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnC, btnplusminus, btnplus, btnminus, btnX, btnbolu,  btnten;
    TextView tvSan, tvZapis;

    String birinshiSan, ekinshiSan, znak, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        sandarMethods();
        oshiruPlusMinusMethod();
        functionMethods();
    }

    public void initViews(){
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnC = findViewById(R.id.removeC);
        btnplusminus = findViewById(R.id.btnplusminus);

        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        btnten = findViewById(R.id.btnten);
        btnX = findViewById(R.id.btnX);
        btnbolu = findViewById(R.id.btnbolu);

        tvSan = findViewById(R.id.tv_san);
        tvZapis = findViewById(R.id.shownum);
    }
    public void sandarMethods(){
        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aldingiSan = tvSan.getText().toString();
                String basilganSan = "";
                String songiResult = "";

                int id = view.getId();

                if (id == R.id.btn0) {
                    basilganSan="0";
                }

                if (id == R.id.btn1) {
                    basilganSan="1";
                }

                if (id == R.id.btn2) {
                    basilganSan="2";
                }

                if (id == R.id.btn3) {
                    basilganSan="3";
                }

                if (id == R.id.btn4) {
                    basilganSan="4";
                }

                if (id == R.id.btn5) {
                    basilganSan="5";
                }

                if (id == R.id.btn6) {
                    basilganSan="6";
                }

                if (id == R.id.btn7) {
                    basilganSan="7";
                }

                if (id == R.id.btn8) {
                    basilganSan="8";
                }

                if (id == R.id.btn9) {
                    basilganSan="9";
                }

                if (!aldingiSan.equals("0")) songiResult = aldingiSan + basilganSan;
                else songiResult=basilganSan;
                tvSan.setText(songiResult);
            }
        };

        btn0.setOnClickListener(buttonSandar);
        btn1.setOnClickListener(buttonSandar);
        btn2.setOnClickListener(buttonSandar);
        btn3.setOnClickListener(buttonSandar);
        btn4.setOnClickListener(buttonSandar);
        btn5.setOnClickListener(buttonSandar);
        btn6.setOnClickListener(buttonSandar);
        btn7.setOnClickListener(buttonSandar);
        btn8.setOnClickListener(buttonSandar);
        btn9.setOnClickListener(buttonSandar);
    }
    public void oshiruPlusMinusMethod(){
        View.OnClickListener buttonOwiruplusminus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.removeC) {
                    tvSan.setText("0");
                    tvZapis.setText("0");
                }


                if (id == R.id.btnplusminus) {
                    String sanText= tvSan.getText(). toString();
                    int san = Integer.parseInt(sanText);

                    if(san > 0) tvSan.setText("-"+sanText);
                    else {
                        san = san * (-1);
                        tvSan.setText(""+san);
                    }

                }
            }
        };

        btnC.setOnClickListener(buttonOwiruplusminus);
        btnplusminus.setOnClickListener(buttonOwiruplusminus);
    }
    public void functionMethods(){
        View.OnClickListener btnFunction = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                birinshiSan = tvSan.getText().toString();

                int id = view.getId();

                if(id==R.id.btnminus) {
                    znak = "-";
                }

                if(id==R.id.btnplus) {
                    znak = "+";
                }

                if(id==R.id.btnX) {
                    znak = "*";
                }

                if(id==R.id.btnbolu) {
                    znak = "/";
                }

                zapisText = birinshiSan + znak;
                tvZapis.setText(zapisText);
                tvSan.setText("0");
            }
        };

        btnplus.setOnClickListener(btnFunction);
        btnminus.setOnClickListener(btnFunction);
        btnX.setOnClickListener(btnFunction);
        btnbolu.setOnClickListener(btnFunction);

        btnten.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ekinshiSan = tvSan.getText().toString();
                int san1 = Integer.parseInt(birinshiSan);
                int san2 = Integer.parseInt(ekinshiSan);
                int res=0;

                if(znak.equals("+")){
                    res = san1 + san2;
                }else if(znak.equals("-")) {
                    res = san1 - san2;
                }else if(znak.equals("*")) {
                    res = san1 * san2;
                }else if(znak.equals("/")) {
                    res = san1 / san2;
                }

                zapisText = birinshiSan + znak + ekinshiSan +"="+res;

                tvZapis.setText(zapisText);
                tvSan.setText(""+res);
            }
        });
    }

}
