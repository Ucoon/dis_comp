package com.ft.business.component;


import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.framework.logger.Logger;
import com.ft.business.component.business.AllCollectionBusiness;
import com.ft.business.component.business.CollectionBuisiness;
import com.ft.business.component.business.GoodsCollectionBusiness;
import com.ft.business.component.domain.AllCollectionDomain;
import com.ft.business.component.domain.CollectionDomainFactory;
import com.ft.business.component.domain.GoodsCollectionDomain;
import com.ft.business.component.entity.AllCollectionEntity;
import com.ft.business.component.entity.GoodsCollectionEntity;
import com.ft.business.component.repository.CollectionRepository;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;

/**
 * 用户收藏模组
 *
 * @author richsjeson
 */
@Service(IComponent.class)
@Router(CollectionConstant.EVALUATE)
public class CollectionComp implements IComponent {
    private final String TAG = CollectionComp.class.getName();

    @Override
    public void init() {
        Logger.LOGD(TAG, "init", "");
        //todo richsjeson 快核对下模组创建时机吧，别乱创建业务服务层啊
        //执行一些初始化的操作,将服务层进行load
        AppConfig.getInstance().getAppContext().registerBusinessManager(CollectionConstant.EVALUATE, new CollectionBuisiness(CollectionConstant.EVALUATE));
    }

    @Override
    public void load() {
        //商品收藏
        ManagerFactory.getInstance().putFactory(CollectionConstant.GOODS_COLLECTION, new GoodsCollectionBusiness());
        CollectionDomainFactory.getFactory().putDomain(CollectionConstant.GOODS_COLLECTION, new GoodsCollectionDomain());
        CollectionRepository.getFactory().putEntity(CollectionConstant.GOODS_COLLECTION, new GoodsCollectionEntity());

        //获取所有收藏
        ManagerFactory.getInstance().putFactory(CollectionConstant.ALL_COLLECTION, new AllCollectionBusiness());
        CollectionDomainFactory.getFactory().putDomain(CollectionConstant.ALL_COLLECTION, new AllCollectionDomain());
        CollectionRepository.getFactory().putEntity(CollectionConstant.ALL_COLLECTION, new AllCollectionEntity());
    }

    @Override
    public void unload() {
        //模组登录成功后，记得可以执行卸载了 todo richsjeson 是否忘记了卸载业务服务？？？？登录完你还要使用该模组？？开玩笑吧，赶紧回收吧
        //AppConfig.getInstance().getAppContext().unregisterBusinessManager(UserLoginConstant.USER_LOGIN_MODULE);
    }

    @Override
    public void destory() {
        Logger.LOGD(TAG, "destory", "");
        CollectionDomainFactory.getFactory().release();
        CollectionRepository.getFactory().release();
    }

    @Override
    public void dispatch(@NonNull Object pEvent) {

    }

    @Override
    public void param(@NonNull IRouteMeta pMeta) {
        CollectionBuisiness business = (CollectionBuisiness) AppConfig.getInstance().getAppContext().getBusinessManager(CollectionConstant.EVALUATE);
        business.execute(pMeta.getProtocol(), pMeta.getResult());
    }
}
