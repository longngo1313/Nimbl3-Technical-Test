package com.example.longnv.nimbl3_test.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements IView, ICallBackPresenter {
    private static final String TAG = "BaseActivityMenuCar";
    protected P mPresenter;

    protected abstract int setViewLayout();

    protected abstract void onSetupLayout();

    private ICallbackFragment mICallbackFragment;

    @NonNull
    protected abstract P setPresenter();


    protected FragmentTransaction getFragmentTransactionMPV(BaseFragment callbackFragment) {
        try {
            callbackFragment.setICallBack((ICallbackFragment) this);
        } catch (Exception e) {
            Log.e(TAG, "" + e);
        }
        return getSupportFragmentManager().beginTransaction();
    }


    protected FragmentTransaction getFragmentTransactionMPV() {
        return getSupportFragmentManager().beginTransaction();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewLayout());

        try {
            mPresenter = setPresenter();
            mPresenter.setICallBackPresenter(this);
            onSetupLayout();
        } catch (Exception e) {
            Log.e(TAG, "" + e);
        }
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }


}
