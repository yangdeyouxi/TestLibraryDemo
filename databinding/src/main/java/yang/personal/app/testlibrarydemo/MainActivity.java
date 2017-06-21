package yang.personal.app.testlibrarydemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import yang.personal.app.testlibrarydemo.databinding.LayoutBinding;

public class MainActivity extends AppCompatActivity {

    private LayoutBinding layoutBinding;
    private DemoBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        layoutBinding = DataBindingUtil.setContentView(
                this, R.layout.layout);
        bean = new DemoBean("lilei",21,"man","2");
        layoutBinding.setBean(bean);
    }


    public void onViewClick(View v){
        Log.d("textLibrary","view:" + v);
//        Toast.makeText(this,"onClick",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"descriptionValue:" + bean.getDescription(),Toast.LENGTH_SHORT).show();
    }
}

