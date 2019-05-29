package com.example.thesispro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Login1 extends AppCompatActivity {

    public static final String EMAIL = "Email";
    public static final String PASSWORD = "Password";

    public FirebaseFirestore db = FirebaseFirestore.getInstance();

    private EditText editTextEmail;
    private EditText editTextPassword;
    TextView text_view_reg;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    final String PASSWORD_PATTERN = "^(?=\\S+$).{4,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login1);


        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);
        text_view_reg = findViewById(R.id.text_view_reg);
        text_view_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login1.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
    public void SignIn(View v){

        final String email = editTextEmail.getText().toString();
        final String password = editTextPassword.getText().toString();

        try{
            if(editTextEmail!=null && editTextPassword!=null) {
                if(email.matches(emailPattern)) {
                    if(password.matches(PASSWORD_PATTERN)) {
                        db.collection("User").document(email).get()
                                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {


                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if (task.isSuccessful()) {

                                            DocumentSnapshot documentSnapshot = task.getResult();

                                            String userpassword = documentSnapshot.getString("password");
                                            try {
                                                if (userpassword.equals(password)) {
                                                    Toast.makeText(Login1.this, "Successful", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(Login1.this, SelectionActivity.class);
                                                    intent.putExtra(EMAIL, email);
                                                    intent.putExtra(PASSWORD, password);
                                                    startActivity(intent);
                                                } else {
                                                    Toast.makeText(Login1.this, "Error", Toast.LENGTH_SHORT).show();
                                                }
                                            } catch (Exception e) {
                                                Log.e("IDProblem", e.toString());
                                                Toast.makeText(Login1.this, "Error", Toast.LENGTH_SHORT).show();
                                            }


                                        }

                                    }
                                });
                    }else{
                        Toast.makeText(this, "Password at least 4 letters and no WhiteSpace", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Please use valid Email", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Please fill all of the information", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("Error", e.toString());
            Toast.makeText(this, "Please fill all of the information", Toast.LENGTH_SHORT).show();
        }


    }

}
