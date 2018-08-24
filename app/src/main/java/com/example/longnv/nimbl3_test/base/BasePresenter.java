package com.example.longnv.nimbl3_test.base;

import android.content.Context;
import android.util.Log;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public abstract class BasePresenter<M extends BaseModel> implements ICallBackModel {
    private static final String TAG = "BasePresenter";
    protected M mModel;
    protected Context mContext;

    protected abstract M setModel();

    protected Context getContext() {
        return mContext;
    }

    public BasePresenter(Context context) {
        super();
//        String name = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].toString();
//        mModel = (M) Utils.newClassInstance(name.replace("class ", ""), context);
        mContext = context;
        mModel = setModel();
        mModel.setICallBackModel(this);

    }

    public void setmModel(M mModel) {
        mModel.setModel(mModel);
    }

    private ICallBackPresenter mICallBackPresenter;


    public void setICallBackPresenter(ICallBackPresenter iCallBackPresenter) {
        mICallBackPresenter = iCallBackPresenter;
    }

    protected ICallBackPresenter getmICallBackPresenter() {
        if (mICallBackPresenter == null) {
            Log.e(TAG, "ICallBackPresenter is null !!!");
            mICallBackPresenter = new ICallBackPresenter() {
                @Override
                public void onCallBackPresenter(String key, Object data) {

                }
            };
        }
        return mICallBackPresenter;
    }

}