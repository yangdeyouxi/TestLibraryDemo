package yang.personal.app.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<String> sentenceObservable = Observable.just("this", "is", "a", "sentence");
        sentenceObservable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("yang","onSubscribe:" + d.toString());
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("yang","onNext:" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("yang","onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("yang","onComplete:");
            }
        });


        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("111111");
                e.onComplete();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String o) throws Exception {
                Log.d("yang","accept:" + o);
            }
        });


        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> e) throws Exception {

            }
        }, BackpressureStrategy.BUFFER);

    }
}
