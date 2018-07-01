package com.calc.travis.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    //Setting String Values
    String runningNumber = "";
    String leftValueContainer = "";
    String rightValueContainer = "";
    int result = 0;
    Operation currentOperation;

    //Sets results text view reference
    TextView resultsTextView;

    public enum Operation{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        //Sets number button references
        Button oneButton = (Button) findViewById(R.id.oneButton);
        Button twoButton = (Button) findViewById(R.id.twoButton);
        Button threeButton = (Button) findViewById(R.id.threeButton);
        Button fourButton = (Button) findViewById(R.id.fourButton);
        Button fiveButton = (Button) findViewById(R.id.fiveButton);
        Button sixButton = (Button) findViewById(R.id.sixButton);
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        Button eightButton = (Button) findViewById(R.id.eightButton);
        Button nineButton = (Button) findViewById(R.id.nineButton);
        Button zeroButton = (Button) findViewById(R.id.zeroButton);

        //Sets operator button references
        ImageButton equalButton = (ImageButton) findViewById(R.id.equalButton);
        ImageButton divideButton = (ImageButton) findViewById(R.id.divideButton);
        ImageButton multiplyButton = (ImageButton) findViewById(R.id.multiplyButton);
        ImageButton subtractButton = (ImageButton) findViewById(R.id.subtractButton);
        ImageButton addButton = (ImageButton) findViewById(R.id.addButton);

        //Sets clear button reference
        Button clearButton = (Button) findViewById(R.id.clearButton);

        //initializing resultsTextView
        resultsTextView = (TextView) findViewById(R.id.resultsTextView);

        //Set Results
        resultsTextView.setText("");

        //Click functions for buttons
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(1);
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(2);
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(4);
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(5);
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(6);
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(7);
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(8);
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(9);
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.EQUAL);
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULTIPLY);
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUBTRACT);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftValueContainer = "";
                rightValueContainer = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultsTextView.setText("0");
            }
        });
    }

    void processOperation(Operation operation){

        if (currentOperation != null){

            if (runningNumber != ""){

                rightValueContainer = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValueContainer) + Integer.parseInt(rightValueContainer);
                        break;

                    case SUBTRACT:
                        result = Integer.parseInt(leftValueContainer) - Integer.parseInt(rightValueContainer);
                        break;

                    case DIVIDE:
                        result = Integer.parseInt(leftValueContainer) / Integer.parseInt(rightValueContainer);
                        break;

                    case MULTIPLY:
                        result = Integer.parseInt(leftValueContainer) * Integer.parseInt(rightValueContainer);
                        break;
                }

                leftValueContainer = String.valueOf(result);
                resultsTextView.setText(leftValueContainer);
            }

        } else {
            leftValueContainer = runningNumber;
            runningNumber = "";
        }

        currentOperation = operation;
    }

    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultsTextView.setText(runningNumber);
    }
}
