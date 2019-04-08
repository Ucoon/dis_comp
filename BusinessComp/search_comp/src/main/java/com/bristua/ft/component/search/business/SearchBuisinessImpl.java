package com.bristua.ft.component.search.business;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.bristua.ft.component.search.domain.HistorySearchDomain;
import com.bristua.ft.component.search.domain.ISearchDomain;
import com.bristua.ft.component.search.domain.SearchFactory;
import com.bristua.ft.component.search.repository.SearchProduct;
import com.bristua.ft.component.search.repository.SearchRepository;

/**
 * 设置用户搜索模块
 * @author richsjeson
 */
public class SearchBuisinessImpl implements ISearchBusiness, IBusinessManager {

    @Override
    public void exec(@NonNull String pProtocol, @NonNull IFlutterResult pCallback) {

        //此处进入解析操作方式，1.解析json报文，读取type类型

    }

    @Override
    public void findHistoryFromKey(@NonNull SearchRepository pRepository, @NonNull IFlutterResult pCallback) {

        ISearchDomain domain= SearchFactory.getFactory().getDommain(pRepository.getType());
        if(domain ==  null){
            return;
        }

        //domain执行操作
        domain.findData(pCallback);
    }

    @Override
    public void findProductsFromName(@NonNull SearchRepository pRepository, @NonNull IFlutterResult pCallback) {
        ISearchDomain domain= SearchFactory.getFactory().getDommain(pRepository.getType());
        if(domain ==  null){
            return;
        }
        //domain执行操作
        domain.findData(pCallback);
    }
}
