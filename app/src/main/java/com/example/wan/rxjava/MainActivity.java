package com.example.wan.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //http://120.27.23.105/user/login
        RetrofitManager instance = RetrofitManager.getInstance();
        APi aPi = instance.create(APi.class);
        /*Call<Databean> login = aPi.login("15701577141", "123456");
        login.enqueue(new Callback<Databean>() {
            @Override
            public void onResponse(Call<Databean> call, Response<Databean> response) {
                Databean body = response.body();
                Toast.makeText(MainActivity.this,body.getMsg(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Databean> call, Throwable t) {

            }
        });*/
        Observable<Databean> login = aPi.login("15701577141", "123456");
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Databean>() {
                    @Override
                    public void accept(Databean databean) throws Exception {

                        Toast.makeText(MainActivity.this,databean.getMsg(),Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
