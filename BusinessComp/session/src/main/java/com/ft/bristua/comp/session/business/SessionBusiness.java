package com.ft.bristua.comp.session.business;

import android.support.annotation.NonNull;

import com.bristua.framework.system.IBusinessManager;
import com.ft.bristua.comp.session.business.callback.IRouterCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * 注入回调事件
 */
public class SessionBusiness  implements IBusinessManager {

    private List<IRouterCallback> callbacks=new ArrayList();

    /**
     * 注册flutter层的activity事件
     */
    public void registerFlutterActivity(@NonNull IRouterCallback pCallback){
        callbacks.add(pCallback);
    }

    public void router(){

        for(int i=0;i<callbacks.size();i++){
            IRouterCallback callback=callbacks.get(i);
            callback.routerLogin();
        }
    }

    public void relase(){
        callbacks.clear();
    }
}
