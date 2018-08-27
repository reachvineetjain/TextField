package com.nehavin.textfield;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    TextInputEditText user;
    TextInputEditText pwd;
    ConstraintLayout relLayout;
    TextInputLayout tpLayout;
    TextInputLayout pwdLayout;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.username_TextField);
        pwd = findViewById(R.id.password_TextField);

        relLayout = findViewById(R.id.con_layout);
        relLayout.setOnClickListener(null);

        tpLayout = findViewById(R.id.username_textinputlayout);
        pwdLayout = findViewById(R.id.password_textinputlayout);

        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                tpLayout.setErrorEnabled(false);

                if(TextUtils.isEmpty(user.getText().toString())){
                    tpLayout.setErrorEnabled(true);
                    tpLayout.setError("Please enter a valid username ");
                }
                else if(!(Patterns.EMAIL_ADDRESS.matcher(user.getText().toString()).matches()))
                {
                    tpLayout.setErrorEnabled(true);
                    tpLayout.setError("Please enter a valid email id");
                }
                else
                {
                    tpLayout.setErrorEnabled(false);
                }
            }
        });

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(user.getText().toString())){
                    tpLayout.setErrorEnabled(true);
                    tpLayout.setError("Please enter a valid username ");
                }
                else if(!(Patterns.EMAIL_ADDRESS.matcher(user.getText().toString()).matches()))
                {
                    tpLayout.setErrorEnabled(true);
                    tpLayout.setError("Please enter a valid email id");
                }
                else
                {
                    tpLayout.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pwdLayout.setCounterEnabled(true);
        pwdLayout.setCounterMaxLength(4);

    }
}