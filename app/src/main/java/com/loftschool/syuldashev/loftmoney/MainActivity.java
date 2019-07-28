package com.loftschool.syuldashev.loftmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView helloWorldView = findViewById(R.id.hello_world);
        helloWorldView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BudgetActivity.class));
            }
        });

        LoftApp loftApp = (LoftApp) getApplication();

        Api api = loftApp.getApi();

        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        Call<AuthResponse> authCall = api.auth(androidId);
        authCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(
                    final Call<AuthResponse> call, final Response<AuthResponse> response
            ) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("auth_token", response.body().getAuthToken());
                editor.apply();
            }

            @Override
            public void onFailure(final Call<AuthResponse> call, final Throwable t) {

            }
        });

    }
}
