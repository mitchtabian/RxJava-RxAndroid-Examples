package com.codingwithmitch.todolist;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codingwithmitch.todolist.models.Task;
import com.codingwithmitch.todolist.util.DataSource;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //ui
    private TextView text;

    // vars
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);


//        text.setText("doing stuff...");
//        Observable.fromIterable(DataSource.createTasksList())
//                .filter(new Predicate<Task>() {
//                    @Override
//                    public boolean test(Task task) throws Exception {
//                        return task.isComplete();
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .distinct(new Function<Task, String>() {
//                    @Override
//                    public String apply(Task task) throws Exception {
//                        return task.getTask();
//                    }
//                })
//                .subscribe(new Observer<Task>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe: called.");
//                        disposables.add(d);
//                    }
//
//                    @Override
//                    public void onNext(Task value) {
//                        Log.d(TAG, "onNext: COMPLETE: " + value.getTask());
//                        text.setText("still doing stuff...");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: ", e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: found all the completed tasks...");
//                        text.setText("done");
//                    }
//                });


//        Observable<Task> observableTasksList = Observable.fromIterable(DataSource.createTasksList());

//        Observable<Integer> integers = Observable.from(DataSource.createTasksList())
//                .map(new Func1<Task, Integer>() {
//                    @Override
//                    public Integer call(Task task) {
//                        return task.getPriority();
//                    }
//                });
//        MathObservable
//                .max(integers)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG, "onCompleted: done.");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: ", e);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "onNext: " + integer);
//                    }
//                });


        Observable<Task> taskObservable = Observable
                .fromIterable(DataSource.createTasksList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        taskObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Task task) {
                Log.d(TAG, "onNext: : " + task.getDescription());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        Observable.range(0,3)
                .repeat(2)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        disposables.clear();
    }
}

































