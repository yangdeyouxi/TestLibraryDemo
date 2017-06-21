package yang.personal.app.testlibrarydemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import yang.personal.app.testlibrarydemo.BR;

import com.bumptech.glide.Glide;

/**
 * Created by yangjh on 2017/5/30 0030.
 */

public class DemoBean extends BaseObservable {

    public String name;

    public int age;

    public String description;

    public String type;

    public DemoBean(String mname,int mage,String mdescrip,String mtype){
        name = mname;
        age = mage;
        description = mdescrip;
        type = mtype;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }


    /**
     * 使用ImageLoader显示图片
     * @param imageView
     * @param url
     */
    @BindingAdapter({"imageUrl"})
    public static void imageLoader(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
