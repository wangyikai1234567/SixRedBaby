package com.redbaby.shoppingcar.utils;

/**
 * data:2017/5/17
 * author:高亚男(Administrator)
 * function:商品购物车数据操作类,首先是从本地拿到数据放入(SpareseArray)容器(内存)中,增删改查
 */

public class CartStorage {
//        public static final String JSON_CART = "json_cart";
//
//        //A.使类为单例模式,其构造方法里有上下文.
//        private static CartStorage instance;
//        private Context mContext;
//
//        //A.得到购物车的实例.
//        public static CartStorage getInstance() {
//            if(instance ==null){
//                instance = new CartStorage(MyApplication.getmContext());
//            }
//            return instance;
//        }
//
//        //B.此集合是安卓特有而非java的,是替代HashMap.性能更好的集合
//        private SparseArray<GoodsBean> mGoodsBeanSparseArray;
//
//        //A.各类的构造方法,此类以创建就执行的方法,上下文是从MyApplication里得到(MyApplication没有,就创建)
//        private CartStorage(Context context) {
//            mContext=context;
//            //B.创建读取之前存储数据的容器,大小100
//            mGoodsBeanSparseArray =new SparseArray<>(100);
//            //C.SparseArray容器装好数据.
//            listToSpareseArray();
//        }
//
//        //C.把本地读取的数据加入到SparseArray中
//        private void listToSpareseArray() {
//            //C.先把本地数据放入List集合里
//            List<GoodsBean> goodsBeanList= getAllData();
//            //E.把列表数据转化为SparseArray
//            for(int x=0; x<goodsBeanList.size(); x++){
//                //取出对应位置的goodsBean数据
//                GoodsBean goodsBean =goodsBeanList.get(x);
//                //存入到SparseArray集合中.参数:1.int型,以商品ID作为键(因为商品ID为String类型,所以要进行类型转换)  2.要存数据
//                mGoodsBeanSparseArray.put(Integer.parseInt(goodsBean.getProduct_id()),goodsBean);
//            }
//
//        }
//
//        //C.读取本地的数据
//        public List<GoodsBean> getAllData() {
//            ArrayList<GoodsBean> goodsBeanList = new ArrayList<>();
//            //D.从本地获取
//            String json= CacheUtils.getString(mContext,JSON_CART);
//            //D.判断获取到的数据是否为null.
//            if(!TextUtils.isEmpty(json)){
//                //使用Gson把String类型转换为list列表
//                goodsBeanList=new Gson().fromJson(json,new TypeToken<List<GoodsBean>>(){}.getType());
//            }
//            return goodsBeanList;
//        }
//
//        /**
//         * E.数据添加到内存(SparseArray)中
//         * @param goodsBean
//         */
//        public void addData(GoodsBean goodsBean){
//            //从内存(SparseArray)中根据商品ID,拿出对应的数据
//            GoodsBean tempData =mGoodsBeanSparseArray.get(Integer.parseInt(goodsBean.getProduct_id()));
//            //如果当前数据已经存在,就把number递增
//            if(tempData !=null){
//                //内存中有了这条数据
//                tempData.setNumber(tempData.getNumber()+1);
//            }else {
//                tempData =goodsBean;
////            tempData.setNumber(1);
//            }
//            //修改后的数据,同步到内存(SparseArray)中
//            mGoodsBeanSparseArray.put(Integer.parseInt(tempData.getProduct_id()),tempData);
//            //同步到本地
//            saveLocal();
//        }
//
//        /**
//         * E.删除数据
//         * @param goodsBean
//         */
//        public void deleteData(GoodsBean goodsBean){
//            //从内存(SparseArray)中根据商品ID,删除对应的数据
//            mGoodsBeanSparseArray.delete(Integer.parseInt(goodsBean.getProduct_id()));
//            //同步到本地
//            saveLocal();
//        }
//
//        /**
//         * E.更新数据
//         * @param goodsBean
//         */
//        public void updateData(GoodsBean goodsBean){
//            //内存中更新
//            mGoodsBeanSparseArray.put(Integer.parseInt(goodsBean.getProduct_id()),goodsBean);
//            //同步到本地
//            saveLocal();
//        }
//
//        //F.保存数据到本地
//        private void saveLocal() {
//            //SparseArray转换成List集合
//            List<GoodsBean> goodsBeanList=sparseToList();
//            //使用Gson把列表转换Strng类型
//            String json=new Gson().toJson(goodsBeanList);
//            //把String类型数据存入到SP里即可
//            CacheUtils.saveString(mContext,JSON_CART,json);
//        }
//
//        //F.把SparseArray里的数据取出,放入list集合里.
//        private List<GoodsBean> sparseToList() {
//            ArrayList<GoodsBean> goodsBeenList= new ArrayList<>();
//            for(int x=0; x<mGoodsBeanSparseArray.size(); x++){
//                GoodsBean goodsBean = mGoodsBeanSparseArray.valueAt(x);
//                goodsBeenList.add(goodsBean);
//            }
//            return goodsBeenList;
//        }

}

