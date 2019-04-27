package com.ft.business.component;


import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.framework.logger.Logger;
import com.ft.business.component.business.AllEvaluateBusiness;
import com.ft.business.component.business.EvaluateBuisiness;
import com.ft.business.component.business.GoodsEvaluateBusiness;
import com.ft.business.component.domain.AllEvaluateDomain;
import com.ft.business.component.domain.EvaluateDomainFactory;
import com.ft.business.component.domain.GoodsEvaluateDomain;
import com.ft.business.component.entity.AllEvaluateEntity;
import com.ft.business.component.entity.GoodsEvaluateEntity;
import com.ft.business.component.repository.EvaluateRepository;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;

/**
 * 用户信息模组
 *
 * @author richsjeson
 */
@Service(IComponent.class)
@Router(EvaluateConstant.EVALUATE)
public class EvaluateComp implements IComponent {
    private final String TAG = EvaluateComp.class.getName();

    @Override
    public void init() {
        Logger.LOGD(TAG, "init", "");
        //todo richsjeson 快核对下模组创建时机吧，别乱创建业务服务层啊
        //执行一些初始化的操作,将服务层进行load
        AppConfig.getInstance().getAppContext().registerBusinessManager(EvaluateConstant.EVALUATE, new EvaluateBuisiness(EvaluateConstant.EVALUATE));
    }

    @Override
    public void load() {
        //商品评价
        ManagerFactory.getInstance().putFactory(EvaluateConstant.GOODS_EVALUATE, new GoodsEvaluateBusiness());
        EvaluateDomainFactory.getFactory().putDomain(EvaluateConstant.GOODS_EVALUATE, new GoodsEvaluateDomain());
        EvaluateRepository.getFactory().putEntity(EvaluateConstant.GOODS_EVALUATE, new GoodsEvaluateEntity());

        //获取所有评价
        ManagerFactory.getInstance().putFactory(EvaluateConstant.ALL_EVALUATE, new AllEvaluateBusiness());
        EvaluateDomainFactory.getFactory().putDomain(EvaluateConstant.ALL_EVALUATE, new AllEvaluateDomain());
        EvaluateRepository.getFactory().putEntity(EvaluateConstant.ALL_EVALUATE, new AllEvaluateEntity());
    }

    @Override
    public void unload() {
        //模组登录成功后，记得可以执行卸载了 todo richsjeson 是否忘记了卸载业务服务？？？？登录完你还要使用该模组？？开玩笑吧，赶紧回收吧
        //AppConfig.getInstance().getAppContext().unregisterBusinessManager(UserLoginConstant.USER_LOGIN_MODULE);
    }

    @Override
    public void destory() {
        Logger.LOGD(TAG, "destory", "");
        EvaluateDomainFactory.getFactory().release();
        EvaluateRepository.getFactory().release();
    }

    @Override
    public void dispatch(@NonNull Object pEvent) {

    }

    @Override
    public void param(@NonNull IRouteMeta pMeta) {
        EvaluateBuisiness business = (EvaluateBuisiness) AppConfig.getInstance().getAppContext().getBusinessManager(EvaluateConstant.EVALUATE);
        business.execute(pMeta.getProtocol(), pMeta.getResult());
    }
}
