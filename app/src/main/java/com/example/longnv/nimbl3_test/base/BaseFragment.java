package com.example.longnv.nimbl3_test.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public abstract class BaseFragment <P extends BasePresenter> extends Fragment implements ICallBackPresenter, IView {

    protected P mPresenter;
    private final String TAG = "BaseFragment";
    protected View mViewFragment;


    protected abstract int setViewLayout();

    protected abstract void onSetupLayout();

    protected abstract P setPresenter();

    private ICallbackFragment mICallbackFragment;

    public void setICallBack(ICallbackFragment iCallBack) {
        mICallbackFragment = iCallBack;
    }

    protected ICallbackFragment getICallBackActivity() {
        if (mICallbackFragment == null) {
            mICallbackFragment = new ICallbackFragment() {
                @Override
                public void onCallBackFragment(String key, Object data) {
//
                }
            };
        }
        return mICallbackFragment;
    }

    public BaseFragment() {

    }


    //Htai dag xu ly thu cong. vi getContext default thi bi err  ??????


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            mViewFragment = inflater.inflate(setViewLayout(), container, false);
//            String name = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].toString();
//            Log.d(TAG, "onCreateView: ");
//            mPresenter = (P) Utils.newClassInstance(name.replace("class ", ""), getContext());
            mPresenter = setPresenter();
            mPresenter.setICallBackPresenter(this);

            onSetupLayout();
        } catch (Exception e) {
            Log.e(TAG, "" + e);
        }

        return mViewFragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}

