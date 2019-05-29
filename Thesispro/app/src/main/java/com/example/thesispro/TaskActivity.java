package com.example.thesispro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskActivity extends AppCompatActivity {


    public String varsity1, varsity2, varsity3, fee1, fee2, fee3, subject, email;

    Double rating1,rating2, rating3;
    public double  systemRating1, systemRating2, systemRating3;
    public static final String EMAIL = "Email";
    TextView textViewVarsityName1, textViewFee1, textViewRating1;
    TextView textViewVarsityName2, textViewFee2, textViewRating2;
    TextView textViewVarsityName3, textViewFee3, textViewRating3;
    TextView textViewFirst, textViewSecond, textViewThird;
    TextView textViewSub1, textViewSub2, textViewSub3;
    public Button web1btn, web2btn, web3btn, buttonCloudStore2, ratingbtn;

    RatingBar ratingBar;

    public FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();

        email = intent.getStringExtra("email");
        varsity1 = intent.getStringExtra("varsity1");
        varsity2 = intent.getStringExtra("varsity2");
        varsity3 = intent.getStringExtra("varsity3");

        fee1 = intent.getStringExtra("fee1");
        fee2 = intent.getStringExtra("fee2");
        fee3 = intent.getStringExtra("fee3");

        rating1 = intent.getDoubleExtra("rating1", 0.00);
        rating2 = intent.getDoubleExtra("rating2", 0.00);
        rating3 = intent.getDoubleExtra("rating3", 0.00);
        subject = intent.getStringExtra("subject");

        //Toast.makeText(this, "New rating " + rating1, Toast.LENGTH_SHORT).show();
        systemRating1 = intent.getDoubleExtra("systemRating1",0.00);
        systemRating2 = intent.getDoubleExtra("systemRating2",0.00);
        systemRating3 = intent.getDoubleExtra("systemRating3",0.00);


        textViewVarsityName1 = (TextView) findViewById(R.id.textViewVarsityName1);
        textViewFee1 = (TextView) findViewById(R.id.textViewFee1);
        textViewRating1 = (TextView) findViewById(R.id.textViewRating1);

        textViewVarsityName2 = (TextView) findViewById(R.id.textViewVarsityName2);
        textViewFee2 = (TextView) findViewById(R.id.textViewFee2);
        textViewRating2 = (TextView) findViewById(R.id.textViewRating2);

        textViewVarsityName3 = (TextView) findViewById(R.id.textViewVarsityName3);
        textViewFee3 = (TextView) findViewById(R.id.textViewFee3);
        textViewRating3 = (TextView) findViewById(R.id.textViewRating3);

        textViewFirst = findViewById(R.id.textViewFirst);
        textViewSecond = findViewById(R.id.textViewSecond);
        textViewThird = findViewById(R.id.textViewThird);

        textViewSub1 = findViewById(R.id.textViewSub1);
        textViewSub2 = findViewById(R.id.textViewSub2);
        textViewSub3 = findViewById(R.id.textViewSub3);

        web1btn = findViewById(R.id.web1btn);
        web2btn = findViewById(R.id.web2btn);
        web3btn = findViewById(R.id.web3btn);

        buttonCloudStore2 = (Button) findViewById(R.id.buttonCloudStore2);
        ratingbtn = (Button) findViewById(R.id.ratingbtn);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);

        if(varsity1!=null){
            web1btn.setText("Web: "+varsity1);
        }else{
            web1btn.setText(" ");
        }
        if(varsity2!=null && varsity1!=null){
            web2btn.setText("Web: "+varsity2);
        }else{
            web2btn.setText(" ");
        }
        if(varsity3!=null && varsity2!=null && varsity1!=null){
            web3btn.setText("Web: "+varsity3);
        }else{
            web3btn.setText(" ");
        }


        if(varsity1!=null){
            textViewFirst.setText("FIRST");
            textViewSub1.setText(subject);
            textViewFee1.setText("Course Fee: "+ fee1);
        }else{
            textViewFirst.setText("Your requirements do not match Try Again");

        }
        if(varsity2!=null){
            textViewSecond.setText("SECOND");
            textViewSub2.setText(subject);
            textViewFee2.setText("Course Fee: "+fee2);
        }
        if (varsity3!=null){
            textViewThird.setText("THIRD");
            textViewSub3.setText(subject);
            textViewFee3.setText("Course Fee: " + fee3);
        }

        double sysRate1 = 0, sysRate2 = 0, sysRate3 = 0;

        //THIS NEED TO BE CHANGED
        //Toast.makeText(this, "New Rating "+ rating1, Toast.LENGTH_SHORT).show();

        try {
            sysRate1 = rating1;
            sysRate1 = Math.round(sysRate1*10.0)/10.0;
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            sysRate2 = rating2;
            sysRate2 = Math.round(sysRate2*10.0)/10.0;
        }catch (Exception e){
            e.printStackTrace();

        }
        try {
            sysRate3 = rating3;
            sysRate3 = Math.round(sysRate3*10.0)/10.0;
        }catch (Exception e){
            e.printStackTrace();

        }

        textViewVarsityName1.setText(varsity1);
        textViewRating1.setText(String.valueOf(sysRate1));

        textViewVarsityName2.setText(varsity2);
        textViewRating2.setText(String.valueOf(sysRate2));


        textViewVarsityName3.setText(varsity3);
        textViewRating3.setText(String.valueOf(sysRate3));




    }
    public void repeated(View view){
        Intent intent = new Intent(TaskActivity.this, SelectionActivity.class);
        intent.putExtra(EMAIL, email);
        startActivity(intent);
    }
    public void ratinguser(View view){
        int userrating = (int) ratingBar.getRating();

        double sys1, sys2, sys3, systemrating = 0;

        int n;
        if(rating2==null && rating1!=null && rating3==null){
            n=1;
            sys1 = rating1;
            systemrating = Math.round(((sys1) / n)*100.0)/100.0;

        }
        else if(rating3==null && rating2!=null && rating1!=null){
            n=2;
            sys2 = rating2;
            sys1 = rating1;
            systemrating = Math.round(((sys1+sys2) / n)*100.0)/100.0;
        }
        else if(rating1!=null && rating2!=null && rating3!=null){
            n=3;
            sys3 = rating3;
            sys2 = rating2;
            sys1 = rating1;
            systemrating = Math.round(((sys1+sys2+sys3) / n)*100.0)/100.0;
        }




        Map<String, Object> note = new HashMap<>();
        note.put("userRating", userrating);
        note.put("systemrating", systemrating);

        db.collection("User").document(email).update(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(TaskActivity.this, "Your Rating is Saved", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void website1(View view){
        Log.d("ddd", varsity1);
        try{
            if(varsity1.equals("Port City International University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.portcity.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("Chittagong Independent University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ciu.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("Britannia University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://britannia.ac/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("Daffodil University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://daffodilvarsity.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("University of Creative Technology Chittagong")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uctc.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("East West University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ewubd.edu/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("North South University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.northsouth.edu/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("Victoria University of Bangladesh")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vub.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("East Delta University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eastdelta.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("International Islamic University Chittagong")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iiuc.ac.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("United International University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uiu.ac.bd/"));
                startActivity(webintent);
            }
            else {
                Toast.makeText(this, "No Preview", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Log.e("WebLink1", e.toString());
        }
    }
    public void website2(View view){
        Log.d("ddd", varsity2);
        try{
            if(varsity2.equals("Port City International University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.portcity.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity2.equals("Chittagong Independent University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ciu.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity2.equals("Britannia University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://britannia.ac/"));
                startActivity(webintent);
            }
            else if(varsity2.equals("Daffodil University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://daffodilvarsity.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity2.equals("University of Creative Technology Chittagong")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uctc.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity2.equals("East West University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ewubd.edu/"));
                startActivity(webintent);
            }
            else if(varsity2.equals("North South University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.northsouth.edu/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("Victoria University of Bangladesh")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vub.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("East Delta University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eastdelta.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("International Islamic University Chittagong")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iiuc.ac.bd/"));
                startActivity(webintent);
            }
            else if(varsity2.equals("United International University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uiu.ac.bd/"));
                startActivity(webintent);
            }
            else {
                Toast.makeText(this, "No Preview", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e("WebLink2", e.toString());
        }
    }
    public void website3(View view){
        Log.d("ddd", varsity3);
        try{
            if(varsity3.equals("Port City International University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.portcity.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity3.equals("Chittagong Independent University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ciu.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity3.equals("Britannia University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://britannia.ac/"));
                startActivity(webintent);
            }
            else if(varsity3.equals("Daffodil University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://daffodilvarsity.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity3.equals("University of Creative Technology Chittagong")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uctc.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity3.equals("East West University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ewubd.edu/"));
                startActivity(webintent);
            }
            else if(varsity3.equals("North South University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.northsouth.edu/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("Victoria University of Bangladesh")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vub.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("East Delta University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eastdelta.edu.bd/"));
                startActivity(webintent);
            }
            else if(varsity1.equals("International Islamic University Chittagong")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iiuc.ac.bd/"));
                startActivity(webintent);
            }
            else if(varsity3.equals("United International University")){
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uiu.ac.bd/"));
                startActivity(webintent);
            }
            else {
                Toast.makeText(this, "No Preview", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Log.e("WebLink3", e.toString());
        }
    }
}
