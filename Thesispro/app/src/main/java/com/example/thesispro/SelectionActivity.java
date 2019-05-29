package com.example.thesispro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class SelectionActivity extends AppCompatActivity {

    RadioGroup rgsub, rgfee;
    RadioButton  rbsub, rbfee;
    String subject, fee;
    double maxfee;
    public String email;

    double userSsc, userHsc, usertotalgpa, userSscgpa, userHscgpa;
    Button buttonCloudStore;
    Button buttonCloudStore2, logout;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    public TextView textViewLoad;
    public ArrayList<String> division_array = new ArrayList<String>();
    public ArrayList<String> division2_array = new ArrayList<String>();
    public ArrayList<String> university_array = new ArrayList<String>();
    public ArrayList<String> ctg_university_array = new ArrayList<String>();
    public ArrayList<String> sylhet_university_array = new ArrayList<String>();
    public ArrayList<String> barishal_university_array = new ArrayList<String>();
    public ArrayList<String> rajshahi_university_array = new ArrayList<String>();
    public ArrayList<String> khulna_university_array = new ArrayList<String>();
    public ArrayList<String> rongpur_university_array = new ArrayList<String>();
    public ArrayList<String> dhaka_university_array = new ArrayList<String>();
    public ArrayList<Double> sorted_university_array = new ArrayList<Double>();
    public ArrayList<String> namesorted_university_array = new ArrayList<String>();
    public ArrayList<String> fee_array = new ArrayList<String>();
    public ArrayList<Double> rating_array = new ArrayList<Double>();
    public ArrayList<String> varsityName_array = new ArrayList<String>();
    public static final String EMAIL = "Email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        rgsub = (RadioGroup) findViewById(R.id.subject_group);
        rgfee = (RadioGroup) findViewById(R.id.fee_group);
        textViewLoad = (TextView) findViewById(R.id.textViewData);
        buttonCloudStore = (Button) findViewById(R.id.buttonCloudStore);
        buttonCloudStore2 = (Button) findViewById(R.id.buttonCloudStore2);
        logout = (Button) findViewById(R.id.logout);
        Toast.makeText(this, "Select Categories", Toast.LENGTH_SHORT).show();

        try
        {
            Intent intent = getIntent();
            email = intent.getStringExtra(Login1.EMAIL);
        }catch(Exception e){
            Log.e("From Task Activity", e.toString());
            if(email.equals(null)){
                try {
                    Intent intent = getIntent();
                    email = intent.getStringExtra(TaskActivity.EMAIL);
                }catch (Exception e1){
                    e1.printStackTrace();
                    Intent intent = getIntent();
                    email = intent.getStringExtra(SelectionActivity.EMAIL);
                }
            }
        }




        try {
            db.collection("User").document(email).get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {


                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {

                                DocumentSnapshot documentSnapshot = task.getResult();

                                userSsc = Double.parseDouble(documentSnapshot.getString("ssc"));
                                userHsc = Double.parseDouble(documentSnapshot.getString("hsc"));
                                usertotalgpa = (userSsc + userHsc) / 10;
                                userSscgpa = Math.round((userSsc / 5) * 100.0) / 100.0;
                                userHscgpa = Math.round((userHsc / 5) * 100.) / 100.0;

                                Toast.makeText(SelectionActivity.this, "User Saved", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
        }catch(Exception e){
            Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        }


    }

    public void rbclick(View v){

        boolean checked = ((CheckBox) v).isChecked();

        switch (v.getId()){

            case R.id.dhaka_check:
                if(checked){
                    division_array.add("dhaka");
                }
                else{
                    division_array.remove("dhaka");
                }
                break;
            case R.id.chittagong_check:
                if(checked){
                    division_array.add("chittagong");
                }
                else{
                    division_array.remove("chittagong");
                }
                break;
            case R.id.barishal_check:
                if(checked){
                    division_array.add("barishal");
                }
                else{
                    division_array.remove("barishal");
                }
                break;
            case R.id.rajshahi_check:
                if(checked){
                    division_array.add("rajshahi");
                }
                else{
                    division_array.remove("rajshahi");
                }
                break;
            case R.id.khulna_check:
                if(checked){
                    division_array.add("khulna");
                }
                else{
                    division_array.remove("khulna");
                }
                break;
            case R.id.sylhet_check:
                if(checked){
                    division_array.add("sylhet");
                }
                else{
                    division_array.remove("sylhet");
                }
                break;
            case R.id.rongpur_check:
                if(checked){
                    division_array.add("rongpur");
                }
                else{
                    division_array.remove("rongpur");
                }
                break;

        }

    }
    public void feeclick(View view){
        int radiobuttonfee = rgfee.getCheckedRadioButtonId();
        rbfee = (RadioButton) findViewById(radiobuttonfee);

        fee = (String) rbfee.getText();
        if(fee.equals("3 Lakh")){
            maxfee = 300000;
        }
        else if(fee.equals("4 Lakh")){
            maxfee = 400000;
        }
        else if(fee.equals("6 Lakh")){
            maxfee = 600000;
        }
        else if(fee.equals("8 Lakh")){
            maxfee = 800000;
        }
        else if(fee.equals("Above 8 Lakh")){
            maxfee = 2000000;
        }

    }

    public void subclick(View v){

        int radiobuttonsubject = rgsub.getCheckedRadioButtonId();
        rbsub = (RadioButton) findViewById(radiobuttonsubject);
        subject = (String) rbsub.getText();
        if(subject.equals("Computer Science and Engineering")){
            subject = "cse";
        }
        else if(subject.equals("Electrical and Electronics Engineering")){
            subject = "eee";
        }
        else if(subject.equals("Bachelor of Business Administration")){
            subject = "bba";
        }
        else if(subject.equals("English")){
            subject = "eng";
        }
        else if(subject.equals("Textile Engineering")){
            subject = "bft";
        }
        else if(subject.equals("Civil Engineering")){
            subject = "civil";
        }
        else if(subject.equals("Economics")){
            subject = "eco";
        }
        else if(subject.equals("Architecture")){
            subject = "arch";
        }
        else if(subject.equals("Journalism")){
            subject = "journ";
        }
        else if(subject.equals("Law")){
            subject = "llb";
        }
        else if(subject.equals("Pharmacy")){
            subject = "pharma";
        }
        else if(subject.equals("Tourism")){
            subject = "tour";
        }
        else if(subject.equals("Telecomunication Engineering")){
            subject = "ete";
        }
        else if(subject.equals("Genetic Engineering")){
            subject = "genetic";
        }
        else if(subject.equals("Sociology")){
            subject = "socio";
        }
        else if(subject.equals("Statistics")){
            subject = "stat";
        }
        else if(subject.equals("Biochemistry")){
            subject = "biochem";
        }
        else if(subject.equals("Environmental Science")){
            subject = "environ";
        }
        else if(subject.equals("Micro Biology")){
            subject = "micro";
        }


        Toast.makeText(SelectionActivity.this,"Your selected subject is "+ subject , Toast.LENGTH_SHORT).show();
    }

    public void cloudstore(View v) {

        division2_array = division_array;
        try {
            for (final String division : division_array) {
                db.collection(division).get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (division.equals("dhaka")) {
                                        for (final QueryDocumentSnapshot document : task.getResult()) {
                                            dhaka_university_array.add(document.getId());
                                            //Toast.makeText(SelectionActivity.this, document.getId(), Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (division.equals("chittagong")) {
                                        for (final QueryDocumentSnapshot document : task.getResult()) {
                                            ctg_university_array.add(document.getId());
                                            //Toast.makeText(SelectionActivity.this, document.getId(), Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (division.equals("sylhet")) {
                                        for (final QueryDocumentSnapshot document : task.getResult()) {
                                            sylhet_university_array.add(document.getId());
                                            //Toast.makeText(SelectionActivity.this, document.getId(), Toast.LENGTH_SHORT).show();
                                        }
                                    }else if (division.equals("barishal")) {
                                        for (final QueryDocumentSnapshot document : task.getResult()) {
                                            barishal_university_array.add(document.getId());
                                            //Toast.makeText(SelectionActivity.this, document.getId(), Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (division.equals("rajshahi")) {
                                        for (final QueryDocumentSnapshot document : task.getResult()) {
                                            rajshahi_university_array.add(document.getId());
                                            //Toast.makeText(SelectionActivity.this, document.getId(), Toast.LENGTH_SHORT).show();
                                        }
                                    }else if (division.equals("khulna")) {
                                        for (final QueryDocumentSnapshot document : task.getResult()) {
                                            khulna_university_array.add(document.getId());
                                            //Toast.makeText(SelectionActivity.this, document.getId(), Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (division.equals("rongpur")) {
                                        for (final QueryDocumentSnapshot document : task.getResult()) {
                                            rongpur_university_array.add(document.getId());
                                            //Toast.makeText(SelectionActivity.this, document.getId(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    if (division.equals("dhaka")) {
                                        university_array = dhaka_university_array;
                                    } else if (division.equals("chittagong")) {
                                        university_array = ctg_university_array;
                                    }else if (division.equals("sylhet")) {
                                        university_array = sylhet_university_array;
                                    }else if (division.equals("barishal")) {
                                        university_array = barishal_university_array;
                                    }else if (division.equals("rajshahi")) {
                                        university_array = rajshahi_university_array;
                                    }else if (division.equals("khulna")) {
                                        university_array = khulna_university_array;
                                    }else if (division.equals("rongpur")) {
                                        university_array = rongpur_university_array;
                                    }
                                    for (final String varsity : university_array) {
                                        db.collection(division).document(varsity).get()
                                                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                    @Override
                                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                        try {
                                                            double varsitySsc, varsityHsc, varsitytotalgpa, varsityRating, varsityRanking;
                                                            varsitySsc = Double.parseDouble(documentSnapshot.getString("sscmin")) / 5;
                                                            varsityHsc = Double.parseDouble(documentSnapshot.getString("hscmin")) / 5;
                                                            varsitytotalgpa = Double.parseDouble(documentSnapshot.getString("totalgpa")) / 10;
                                                            double choiced = Double.parseDouble(documentSnapshot.getString(subject));
                                                            if ((choiced <= maxfee) && (varsitySsc <= userSscgpa) && (varsityHsc <= userHscgpa) && (varsitytotalgpa <= usertotalgpa)) {

                                                                double varsityfee = choiced / 10000000;
                                                                double userfee = maxfee / 10000000;
                                                                double review;

                                                                varsityRating = Double.parseDouble(documentSnapshot.getString("rating")) / 5;
                                                                review = Double.parseDouble(documentSnapshot.getString("review"));

                                                                varsityRating = varsityRating * (review/8918);

                                                                varsityRanking = 1 - (Double.parseDouble(documentSnapshot.getString("ranking")) / 100000);

                                                                double part1, part21, part22, part2, result;
                                                                part1 = varsityRanking + varsityRating + (varsitySsc * userSscgpa) + (varsityHsc * userHscgpa) + (varsitytotalgpa * usertotalgpa) + (varsityfee * userfee);

                                                                part21 = Math.sqrt((varsityRanking * varsityRanking) + (varsityRating * varsityRating) + (varsitySsc * varsitySsc) + (varsityHsc * varsityHsc) + (varsitytotalgpa * varsitytotalgpa) + (varsityfee * varsityfee));
                                                                part22 = Math.sqrt(1 + 1 + (userSscgpa * userSscgpa) + (userHscgpa * userHscgpa) + (usertotalgpa * usertotalgpa) + (userfee * userfee));

                                                                part2 = part1 / (part21 * part22);
                                                                result = part2 * 100;
                                                                double finalresult = Math.round(result * 100.0) / 100.0;
                                                                sorted_university_array.add(finalresult);
                                                                namesorted_university_array.add(varsity);
                                                                varsityRating = (varsityRating*5 + (finalresult*5)/100)/2;
                                                                rating_array.add(varsityRating);

                                                                Toast.makeText(SelectionActivity.this, "Submitted"+varsity+varsityRating, Toast.LENGTH_SHORT).show();

                                                            }

                                                        } catch (Exception e) {
                                                            Log.e("CANNOT FIND DATA", e.toString());

                                                        }
                                                    }
                                                });
                                    }
                                    if(sorted_university_array.size()>0){
                                        Toast.makeText(SelectionActivity.this, "No University data found Start again", Toast.LENGTH_SHORT).show();
                                    }else{
                                    }


                                } else {
                                    Toast.makeText(SelectionActivity.this, "ERROR", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }

        }catch(Exception e){
            Log.e("Not working", e.toString());
        }

    }
    public void step2(View view){

        double temp, tempRating;
        String tempVarsity;
        for (int i = 0; i < sorted_university_array.size(); i++) {
            for (int j = i + 1; j < sorted_university_array.size(); j++) {
                if (sorted_university_array.get(i) < sorted_university_array.get(j)) {
                    temp = sorted_university_array.get(i);
                    sorted_university_array.set(i, sorted_university_array.get(j));
                    sorted_university_array.set(j, temp);
                    tempVarsity = namesorted_university_array.get(i);
                    namesorted_university_array.set(i, namesorted_university_array.get(j));
                    namesorted_university_array.set(j, tempVarsity);

                    tempRating = rating_array.get(i);
                    rating_array.set(i, rating_array.get(j));
                    rating_array.set(j, tempRating);
                    Toast.makeText(this, "Calculating", Toast.LENGTH_SHORT).show();

                }
            }

        }

        Toast.makeText(this, ""+rating_array.get(0), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+rating_array.get(1), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+rating_array.get(2), Toast.LENGTH_SHORT).show();
        while(rating_array.remove(null));
        while(sorted_university_array.remove(null));
        while(namesorted_university_array.remove(null));

        for (final String division : division_array) {
            try {
                for (final String varsity : namesorted_university_array) {
                    db.collection(division).document(varsity).get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    try {
                                        varsityName_array.add(documentSnapshot.getString("name"));
                                        //rating_array.add(documentSnapshot.getString("rating"));
                                        fee_array.add(documentSnapshot.getString(subject));

                                        Toast.makeText(SelectionActivity.this, "Finishing", Toast.LENGTH_SHORT).show();

                                    } catch (Exception e) {
                                        Log.e("CANNOT FIND DATA", e.toString());
                                    }
                                }
                            });

                }
            }catch(Exception e){
                Log.e("Error in sorting", e.toString());
            }
        }

    }

    public void cloudstore2(View view){
        while(varsityName_array.remove(null));
        while(rating_array.remove(null));
        while(fee_array.remove(null));
        while(sorted_university_array.remove(null));

        if(subject=="cse"){
            subject = "Computer Science and Engineering";
        }else if(subject=="eee"){
            subject = "Electrical and Electronics Engineering";
        }else if(subject=="eng"){
            subject = "English";
        }else if(subject=="eco"){
            subject = "Economics";
        }else if(subject=="bba"){
            subject = "Bachelor of Business Administration";
        }else if(subject=="bft"){
            subject = "Textile Engineering";
        }else if(subject=="civil"){
            subject = "Civil Engineering";
        }




        Intent i = new Intent(SelectionActivity.this, TaskActivity.class);
        try {
            i.putExtra("varsity1", varsityName_array.get(0));
            i.putExtra("varsity2", varsityName_array.get(1));
            i.putExtra("varsity3", varsityName_array.get(2));
        }catch(Exception e){
            Log.e("Error ", e.toString());
        }

        try {
            i.putExtra("fee1", fee_array.get(0));
            i.putExtra("fee2", fee_array.get(1));
            i.putExtra("fee3", fee_array.get(2));
        }catch(Exception e){
            Log.e("Error ", e.toString());
        }

        try {
            i.putExtra("rating1", rating_array.get(0));
            //Toast.makeText(this, "Transfering rating1 "+rating_array.get(0), Toast.LENGTH_SHORT).show();

            i.putExtra("rating2", rating_array.get(1));
            //Toast.makeText(this, "Transfering rating2 "+rating_array.get(1), Toast.LENGTH_SHORT).show();
            i.putExtra("rating3", rating_array.get(2));
            //Toast.makeText(this, "Transfering rating3 "+rating_array.get(2), Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Log.e("Error ", e.toString());
        }

        try {
            i.putExtra("systemRating1", sorted_university_array.get(0));
            i.putExtra("systemRating2", sorted_university_array.get(1));
            i.putExtra("systemRating3", sorted_university_array.get(2));
        }catch(Exception e){
            Log.e("Error ", e.toString());
        }

        i.putExtra("email", email);
        i.putExtra("subject", subject);
        startActivity(i);
    }
    public void logout(View view){
        Intent intent = new Intent(SelectionActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}
