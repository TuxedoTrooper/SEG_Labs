package pkg.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isOpPressed = false;
    private double firstNum = 0;
    private double secondNum = 0;
    private int secondNumIndex = 0;
    private char currentOP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);

        final TextView calculatorScreen = findViewById(R.id.calculatorScreen); // The name of the text box in java code (id of that text box is calculatorScreen)

        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button ndot = findViewById(R.id.ndot);
        final Button equal = findViewById(R.id.equal);
        final Button minus = findViewById(R.id.minus);
        final Button division = findViewById(R.id.division);
        final Button mutltiply = findViewById(R.id.multiply);
        final Button plus = findViewById(R.id.plus);



        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch(id){
                    case R.id.n0:
                        calculatorScreen.append("0");
                        break;

                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;

                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;

                    case R.id.n3:
                        calculatorScreen.append("3");
                        break;

                    case R.id.n4:
                        calculatorScreen.append("4");
                        break;

                    case R.id.n5:
                        calculatorScreen.append("5");
                        break;

                    case R.id.n6:
                        calculatorScreen.append("6");
                        break;

                    case R.id.n7:
                        calculatorScreen.append("7");
                        break;

                    case R.id.n8:
                        calculatorScreen.append("8");
                        break;

                    case R.id.n9:
                        calculatorScreen.append("9");
                        break;

                    case R.id.ndot:
                        calculatorScreen.append(".");
                        break;

                    case R.id.equal:
                        if(isOpPressed){
                            if(currentOP == '+'){
                                String screenContent = calculatorScreen.getText().toString();
                                secondNum = Double.parseDouble(screenContent.substring(secondNumIndex, screenContent.length()));
                                secondNum += firstNum;
                                calculatorScreen.setText(String.valueOf(secondNum));
                            }
                        }
                        break;

                    case R.id.division:
                        calculatorScreen.append("/");
                        break;

                    case R.id.plus:
                        String screenContent = calculatorScreen.getText().toString();
                        secondNumIndex = screenContent.length() + 1;
                        firstNum = Double.parseDouble(screenContent);
                        calculatorScreen.append("+");
                        isOpPressed = true;
                        currentOP = '+';
                        break;

                    case R.id.minus:
                        calculatorScreen.append("-");
                        break;

                    case R.id.multiply:
                        calculatorScreen.append("*");
                        break;
                }
            }
        };

        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        ndot.setOnClickListener(calculatorListener);
        plus.setOnClickListener(calculatorListener);
        minus.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        mutltiply.setOnClickListener(calculatorListener);
        equal.setOnClickListener(calculatorListener);


        final Button delete = findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayedElements = calculatorScreen.getText().toString();
                int lengtth = displayedElements.length();

                if(lengtth > 0){

                    displayedElements = displayedElements.substring(0, lengtth-1);
                    calculatorScreen.setText(displayedElements);
                }
            }
        });

        final Button clearAll = findViewById(R.id.clearAll);
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculatorScreen.setText("");
            }
        });
    }
}
