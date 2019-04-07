package com.bristua.ft.component.search.domain;

import com.bristua.ft.component.search.SearchConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author richsjeson
 * 根据领域模型查找出对应的领域
 */
public class SearchFactory {

    private  Map<Integer,ISearchDomain> mObjsMap=new HashMap<>();
    private static SearchFactory mInstance=null;


    public static SearchFactory getFactory(){

        if(mInstance==null){
            mInstance=new SearchFactory();
        }
        return mInstance;
    }

    /**
     * 获取领域下的模型
     * @param pCurentType
     * @return
     */
    public  ISearchDomain getDommain(int pCurentType) {
        ISearchDomain mInstance=null;
        if(mObjsMap.get(pCurentType)==null){
            switch (pCurentType) {
                case SearchConstant.SEARCH_TYPE_FINDHISTORY:
                    mInstance = new HistorySearchDomain();
                    break;
                case SearchConstant.SEARCH_TYPE_SEARCHBYSERVER:
                    mInstance = new SearchProductsDomain();
                    break;
                default:
                    mInstance = new SearchProductsDomain();
                    break;
            }
            mObjsMap.put(pCurentType,mInstance);
            return mInstance;
        }
        return mObjsMap.get(pCurentType);
    }

    public  void release(){
        mObjsMap.clear();
    }
}
