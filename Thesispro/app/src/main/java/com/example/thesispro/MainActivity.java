package com.example.thesispro;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String KEY_NAME = "username";
    private static final String KEY_SSC = "ssc";
    private static final String KEY_HSC = "hsc";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "password";
    public EditText editTextUsername;
    public EditText editTextSSC;
    Button btnSave;

    public EditText editTextHSC;
    private EditText editTextEmail;
    private EditText editTextPassword;
    TextView text_view_signin;
    final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    final String PASSWORD_PATTERN = "^(?=\\S+$).{4,}$";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.edit_text_username);
        editTextSSC = findViewById(R.id.edit_text_ssc);
        editTextHSC = findViewById(R.id.edit_text_hsc);
        editTextEmail = (EditText)findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);
        text_view_signin = (TextView) findViewById(R.id.text_view_signin);
        btnSave = (Button) findViewById(R.id.btnSave);
        text_view_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login1.class);
                startActivity(intent);

            }
        });
    }

    public void saveNote(View v) {

        try {
            String username = editTextUsername.getText().toString();
            double ssc = Double.parseDouble(editTextSSC.getText().toString());
            double hsc = Double.parseDouble(editTextHSC.getText().toString());
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();


            double sscCheck, hscCheck;
            sscCheck = ssc;
            hscCheck = hsc;
            if (editTextSSC.getText().equals("") || editTextHSC.getText().equals("") || username.equals("") || email.equals("") || password.equals("")) {
                Toast.makeText(this, "not all", Toast.LENGTH_SHORT).show();
            } else {
                if (sscCheck <= 5 && hscCheck <= 5) {
                    if(email.matches(emailPattern)) {
                        if(password.matches(PASSWORD_PATTERN)) {

                            String Ssc = Double.toString(ssc);
                            String Hsc = Double.toString(hsc);
                            Map<String, Object> note = new HashMap<>();
                            note.put(KEY_NAME, username);
                            note.put(KEY_SSC, Ssc);
                            note.put(KEY_HSC, Hsc);
                            note.put(KEY_EMAIL, email);
                            note.put(KEY_PASS, password);

                            db.collection("User").document(email).set(note)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(MainActivity.this, "User Profile Saved", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(MainActivity.this, Login1.class);
                                            startActivity(intent);
                                        }
                                    });
                        }else{
                            Toast.makeText(this, "Password at least 4 letters and no WhiteSpace", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(this, "Please use valid Email", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "SSC or HSC GPA cannot be more than 5", Toast.LENGTH_SHORT).show();
                }
            }
        }catch(Exception e){
            Log.e("Error", e.toString());
            Toast.makeText(this, "Fill all", Toast.LENGTH_SHORT).show();
        }
    }

}


