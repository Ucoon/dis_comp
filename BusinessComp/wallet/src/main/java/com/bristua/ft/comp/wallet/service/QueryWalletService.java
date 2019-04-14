package com.bristua.ft.comp.wallet.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.comp.wallet.R;
import com.bristua.ft.comp.wallet.entity.WalletWrapperEntity;
import com.bristua.ft.comp.wallet.restapi.IUserQueryWallet;
import com.bristua.ft.protocol.ProtocolFactory;
import com.nd.adhoc.framework.entity.IEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

/**
 * 钱包组件service服务
 * @author richsjeson
 */
public class QueryWalletService {
    /**
     * 钱包查询
     * @param pEntity
     * @param pResult
     */
    public static void queryUserWallet(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult){

        WalletWrapperEntity entity= (WalletWrapperEntity) pEntity;
        int pageNo=entity.getObjectValue().getPageNo();
        int pageSize=entity.getObjectValue().getPageSize();

        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.wallet_error_http), 500, null);
            pResult.success(null, 500, errorTip);
            return;
        }
        IUserQueryWallet restApi = retrofit.create(IUserQueryWallet.class);
        Disposable disposable = restApi.qeury(pageNo,pageSize)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String pResult) {
                        AndroidRxManager.clear();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        AndroidRxManager.clear();
                    }
                });

        AndroidRxManager.addDisposable(disposable);
    }

}
