package tacme.com.mddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.FitWindowsLinearLayout;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class LoginActivity extends BaseActivity{

    private static final String LCAT = "LoginActivity";

    private FitWindowsLinearLayout containerLayout;

    private AppCompatAutoCompleteTextView usernameEdittext;
    private AppCompatEditText passwordEdittext;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        containerLayout = (FitWindowsLinearLayout) findViewById(R.id.container_layout);

        usernameEdittext = (AppCompatAutoCompleteTextView) findViewById(R.id.username_edittext);
        passwordEdittext = (AppCompatEditText) findViewById(R.id.password_edittext);
    }

    /**
     * Login and open home fragment
     * @param v
     */
    public void login(View v){

        Log.i(LCAT, "Login");

        String username = usernameEdittext.getText().toString();
        String password = passwordEdittext.getText().toString();

        if(username.isEmpty()){
            usernameEdittext.setError(getString(R.string.empty_username));
            Snackbar
                    .make(containerLayout, getString(R.string.empty_username), Snackbar.LENGTH_SHORT)
                    .setAction("Enter Username", new OnClickListener() {
                        @Override
                        public void onClick (View v) {
                            usernameEdittext.requestFocus();
                        }
                    })
                    .show();
        }else if(password.isEmpty()){
            passwordEdittext.setError(getString(R.string.empty_password));
            Snackbar
                    .make(containerLayout, getString(R.string.empty_password), Snackbar.LENGTH_SHORT)
                    .setAction("Enter Password", new OnClickListener() {
                        @Override
                        public void onClick (View v) {
                            passwordEdittext.requestFocus();
                        }
                    })
                    .show();
        }else{
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }
}
