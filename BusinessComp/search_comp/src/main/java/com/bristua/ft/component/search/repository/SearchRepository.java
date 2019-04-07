package com.bristua.ft.component.search.repository;
import com.bristua.ft.component.search.SearchConstant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author richsjeson
 * 对象仓库
 */
public class SearchRepository {


    private static SearchRepository mInstance=null;

    private int mType;

    private ISearchInfo mUserInfo;

    private Map<Integer,ISearchInfo> mObjsMap=new HashMap<>();

    private SearchRepository(){

    }

    public static SearchRepository getFactory(){

        if(mInstance==null){
            mInstance=new SearchRepository();
        }
        return mInstance;
    }
    /**
     * 根据类型获取实体
     * @param pType
     * @return
     */
    public   ISearchInfo getSearchInfo(int pType){
        ISearchInfo mSearchInfo=null;
        if(mObjsMap.get(pType)==null) {
            switch (pType) {
                case SearchConstant.SEARCH_TYPE_FINDHISTORY:
                    mSearchInfo = new KeySearch();
                    break;
                case SearchConstant.SEARCH_TYPE_SEARCHBYSERVER:
                    mSearchInfo = new SearchProduct();
                    break;
                default:
                    mSearchInfo = new SearchProduct();
                    break;
            }
            mObjsMap.put(pType,mSearchInfo);
            return mSearchInfo;
        }
        return mObjsMap.get(mType);
    }

    /**
     * 实例化后应当进行销毁
     */
    public static void release(){
        mInstance=null;
    }

    public  ISearchInfo getUserInfo(){
        return mUserInfo;
    }

    public int getType(){
        return mType;
    }

    public void setType(int pType){
        this.mType=pType;
    }

}
