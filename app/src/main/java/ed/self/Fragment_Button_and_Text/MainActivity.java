package ed.self.Fragment_Button_and_Text;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 画面がはじめて作成された時ににだけ、Fragmentを追加
        if (savedInstanceState == null) {
            MainFragment fragment = new MainFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container2, fragment);
            // 最後にcommitします
            transaction.commit();

        }


        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // 新しく追加を行うのでaddを使用します
        // 他にも、よく使う操作で、replace removeといったメソッドがあります
        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment

        for (int i=1;i<4;i++) {
            MainFragment fragment = new MainFragment();
            int j=i*36;
            String tag = "tag" + Integer.toString(i);
            fragment= MainFragment.createInstance(Integer.toString(i), Color.rgb(j,j,j));
            transaction.add(R.id.container2, fragment,tag);
        }
//        ViewGroup.LayoutParams params = fragment.getView().getLayoutParams();
//        fragment.getView().setLayoutParams(
//                    new ViewGroup.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                ViewGroup.LayoutParams.WRAP_CONTENT));



//        transaction.add(R.id.container2, MainFragment.createInstance("fuga", Color.BLACK),"tag2");
//
//        transaction.add(R.id.container2, MainFragment.createInstance("piyo", Color.BLUE),"tag3");

        // addToBackStack() を呼ぶことで置換トランザクションがバックスタックに保存され、
        // ユーザーはバックボタンを押すことでトランザクションをリバースして前のフラグメントに戻すことができる。
        transaction.addToBackStack(null);
        // 最後にcommitを使用することで変更を反映します
        transaction.commit();
    }
}
