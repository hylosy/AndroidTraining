package jp.mixi.practice.activity.beg;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MyFragment extends Fragment {
    public MyFragment() {}

    // 初期化専用のメソッド。Fragment に対する初期化用の引数はここで管理する
    public static Fragment createInstance(int hoge) {
        Fragment fragment = new MyFragment();
        // Fragment に渡す引数を詰めこむオブジェクト
        Bundle args = new Bundle();
        args.putInt("hoge", hoge);

        // 詰め込んだオブジェクトを Fragment に渡す
        fragment.setArguments(args);

        // 新しいインスタンスを返す
        return fragment;
    }
}