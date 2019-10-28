package com.chennikawangmai.firebaseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
  EditText toolid;
  EditText toolname;
  EditText toolnumber;
  Button submit;

  DatabaseReference Datatool;//= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolid=(EditText)findViewById(R.id.toolid);
        toolname=(EditText)findViewById(R.id.toolname);
        toolnumber=(EditText)findViewById(R.id.noofunits);
        submit=(Button)findViewById(R.id.submit);
        Datatool= FirebaseDatabase.getInstance().getReference();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTool();

            }
        });

    }
    public void addTool()
    {
        String name=toolname.getText().toString();
        String id=toolid.getText().toString();
        Integer numb=Integer.parseInt(toolnumber.getText().toString());
        if(!TextUtils.isEmpty(name))
        {
    String idb=Datatool.push().getKey();
    tool Tool=new tool(numb,name,id);
    Datatool.child(idb).setValue(Tool);
            Toast.makeText(this," Tool added" ,Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,"Enter name" ,Toast.LENGTH_LONG).show();
    }
}
