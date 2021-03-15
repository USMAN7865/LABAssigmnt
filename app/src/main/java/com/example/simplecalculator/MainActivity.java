package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      EditText text1,text2,result;
      Button RESULTS;
      Spinner spinner;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=findViewById(R.id.Edit1);
        text2=findViewById(R.id.Edit2);
        RESULTS=findViewById(R.id.RESULTS);
        result=findViewById(R.id.result);
        spinner=findViewById(R.id.Spinner);
        String[] sp={"Select Operator","ADD","Subtract","Multiply","Divide"};

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,sp);
        spinner.setAdapter(arrayAdapter);

        RESULTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              process(Integer.parseInt(text1.getText().toString()),Integer.parseInt(text2.getText().toString()), (String)spinner.getSelectedItem());
            }
        });


    }
    void process(int first, int second,String operation){
        if(operation.equals("Select Operator")){
            Toast.makeText(MainActivity.this, "Select Operators", Toast.LENGTH_SHORT).show();
        }
        else if(operation.equals("ADD"))
        {


            int res=first+second;

            result.setText(String.valueOf(res));
        }
        else if(operation.equals("Subtract"))
        {


            int res=first-second;

            result.setText(String.valueOf(res));
        }
        else if(operation.equals("Multiply"))
        {


            int res=first*second;

            result.setText(String.valueOf(res));
        }
        else if(operation.equals("Divide"))
        {

            int res=first/second;
            int Remainder=first%second;
            result.setText("Result ;"+String.valueOf(res) +" "+"Remainder"+Remainder);

        }

    }

}