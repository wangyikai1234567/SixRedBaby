package com.redbaby.group.bean;

import java.util.List;

/**
 * date: 2017/5/22.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class MuYingBean  {

    /**
     * categories : [{"id":23,"name":"用品","sort":1},{"id":8,"name":"辅食","sort":2},{"id":24,"name":"服装玩具","sort":3},{"id":27,"name":"图书","sort":4}]
     * enrolls : {"list":[{"actId":"41cb7614","actType":1,"activityEndTime":1495468799000,"activityStartTime":1494864000000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":10395,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/209482623124647109533940.jpg","itemDesc":"德国工匠品质 全植物初配方 每人限购1份","itemName":"【多拍不发】谷斑 麦纤抽纸18包*300张","memberNum":2,"origin":"2","preheatEndTime":1494864000000,"preheatStartTime":1494864000000,"price":19.99,"productCode":"000000000619038542","sort":0.1,"venderCode":"70161296"},{"actId":"21545642","actType":1,"activityEndTime":1496159999000,"activityStartTime":1494414000000,"auditStatus":1,"cateId":1003,"categoryId":8,"enrollId":11296,"flag":1,"imgUrl":"//image.suning.cn/uimg/pgs/activity/149440578355088773_710x400.jpg","itemDesc":"不添加蔗糖、香精、人造色素、防腐剂，6个月以上婴幼儿适用","itemName":"【苏宁自营】贝斯美（bestme）婴幼儿磨牙棒（香橙味）64g/盒","memberNum":2,"origin":"1","preheatEndTime":1494410400000,"preheatStartTime":1494410129000,"price":9.9,"productCode":"000000000183512143","sort":0.1,"venderCode":"0000000000"},{"actId":"99bb8323","actType":1,"activityEndTime":1495727999000,"activityStartTime":1495162800000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":12870,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/184856326112679035487536.jpg","itemDesc":"【大容量防水】【时尚新款休闲】","itemName":"优衣乐新款尼龙帆布休闲单肩女包","memberNum":2,"origin":"2","preheatEndTime":1495162800000,"preheatStartTime":1495123200000,"price":29.9,"productCode":"000000000619036466","sort":0.1,"venderCode":"70154142"},{"actId":"0e97d48e","actType":1,"activityEndTime":1495727999000,"activityStartTime":1495162800000,"auditStatus":1,"cateId":1003,"categoryId":24,"enrollId":12848,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/205918787019254411959637.jpg","itemDesc":"面料亲肤舒适 避免着凉 宝宝必备单品","itemName":"运智贝 宝宝肚兜连腿棉柔春夏季薄款","memberNum":2,"origin":"2","preheatEndTime":1495162800000,"preheatStartTime":1495123200000,"price":9.9,"productCode":"000000000161380629","sort":0.2,"venderCode":"70141726"},{"actId":"9e1f0494","actType":1,"activityEndTime":1496246399000,"activityStartTime":1495036800000,"auditStatus":1,"cateId":1003,"categoryId":0,"enrollId":14132,"flag":1,"imgUrl":"//image.suning.cn/uimg/pgs/activity/149509790006204164_710x400.jpg","itemDesc":"植物性精油配方，绿色环保。【苏宁自营 正品速达】","itemName":"蓝贝coolbaby驱蚊贴(儿童型)26+4片装","memberNum":2,"origin":"1","price":9.9,"productCode":"000000000102553230","sort":0.3,"venderCode":"0000000000"},{"actId":"bf7ab920","actType":1,"activityEndTime":1495468799000,"activityStartTime":1494864000000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":9948,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/184046845113658311415200.jpg","itemDesc":"每包仅3.9元 手口专用 温和洁净","itemName":"怡恩贝芦荟湿巾带盖80抽5包","memberNum":2,"origin":"2","preheatEndTime":1494864000000,"preheatStartTime":1494864000000,"price":19.9,"productCode":"000000000129273185","sort":0.3,"venderCode":"70092228"},{"actId":"9fd9cae8","actType":1,"activityEndTime":1496244299000,"activityStartTime":1490684100000,"auditStatus":1,"cateId":1003,"categoryId":0,"enrollId":2987,"flag":1,"imgUrl":"http://image.suning.cn/uimg/mpms/pingoupic/207429401188484538122660.jpg","itemDesc":"需要多套请乐拼多次 收货相信一致可以一起发 百世和邮政小包可以指定","itemName":"【背心+短裤】2017夏季儿童背心套装纯棉不褪色 ","memberNum":2,"origin":"2","price":12.9,"productCode":"000000000600132206","sort":0.4,"venderCode":"70152645"},{"actId":"496ca856","actType":1,"activityEndTime":1495727999000,"activityStartTime":1495162800000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":11695,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/171869318715273737497415.jpg","itemDesc":"德国工匠品质 全植物初配方 每人限购1份","itemName":"【多拍不发】谷斑 麦纤湿巾80抽*5包","memberNum":2,"origin":"2","preheatEndTime":1495162800000,"preheatStartTime":1495123200000,"price":17.77,"productCode":"000000000617390106","sort":0.6,"venderCode":"70161296"},{"actId":"a9798f7a","actType":1,"activityEndTime":1496246399000,"activityStartTime":1494899053000,"auditStatus":1,"cateId":1003,"categoryId":0,"enrollId":12562,"flag":1,"imgUrl":"//image.suning.cn/uimg/pgs/activity/149489903108882481_710x400.jpg","itemDesc":"金盾植物驱蚊，健康长效，安全放心。两瓶液送器，夏季无忧。【苏宁自营 正品速达】","itemName":"金盾婴宝电热蚊香液促销装（2瓶）送加热器 {苏宁自营}","memberNum":2,"origin":"1","price":35.9,"productCode":"000000000143025218","sort":0.6,"venderCode":"0000000000"},{"actId":"8c8114b9","actType":1,"activityEndTime":1495468799000,"activityStartTime":1494864000000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":10393,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/539443130146902186117290.jpg","itemDesc":"【多拍不发】免洗清爽啫喱型 远离光敏雾霾伤害","itemName":"喜朗 宝宝清爽黑莓隔离霜52g","memberNum":2,"origin":"2","preheatEndTime":1494864000000,"preheatStartTime":1494864000000,"price":19.87,"productCode":"000000000154129864","sort":1,"venderCode":"70107735"}],"realCount":10}
     */

    private EnrollsBean enrolls;
    private List<CategoriesBean> categories;

    public EnrollsBean getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(EnrollsBean enrolls) {
        this.enrolls = enrolls;
    }

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class EnrollsBean {
        /**
         * list : [{"actId":"41cb7614","actType":1,"activityEndTime":1495468799000,"activityStartTime":1494864000000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":10395,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/209482623124647109533940.jpg","itemDesc":"德国工匠品质 全植物初配方 每人限购1份","itemName":"【多拍不发】谷斑 麦纤抽纸18包*300张","memberNum":2,"origin":"2","preheatEndTime":1494864000000,"preheatStartTime":1494864000000,"price":19.99,"productCode":"000000000619038542","sort":0.1,"venderCode":"70161296"},{"actId":"21545642","actType":1,"activityEndTime":1496159999000,"activityStartTime":1494414000000,"auditStatus":1,"cateId":1003,"categoryId":8,"enrollId":11296,"flag":1,"imgUrl":"//image.suning.cn/uimg/pgs/activity/149440578355088773_710x400.jpg","itemDesc":"不添加蔗糖、香精、人造色素、防腐剂，6个月以上婴幼儿适用","itemName":"【苏宁自营】贝斯美（bestme）婴幼儿磨牙棒（香橙味）64g/盒","memberNum":2,"origin":"1","preheatEndTime":1494410400000,"preheatStartTime":1494410129000,"price":9.9,"productCode":"000000000183512143","sort":0.1,"venderCode":"0000000000"},{"actId":"99bb8323","actType":1,"activityEndTime":1495727999000,"activityStartTime":1495162800000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":12870,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/184856326112679035487536.jpg","itemDesc":"【大容量防水】【时尚新款休闲】","itemName":"优衣乐新款尼龙帆布休闲单肩女包","memberNum":2,"origin":"2","preheatEndTime":1495162800000,"preheatStartTime":1495123200000,"price":29.9,"productCode":"000000000619036466","sort":0.1,"venderCode":"70154142"},{"actId":"0e97d48e","actType":1,"activityEndTime":1495727999000,"activityStartTime":1495162800000,"auditStatus":1,"cateId":1003,"categoryId":24,"enrollId":12848,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/205918787019254411959637.jpg","itemDesc":"面料亲肤舒适 避免着凉 宝宝必备单品","itemName":"运智贝 宝宝肚兜连腿棉柔春夏季薄款","memberNum":2,"origin":"2","preheatEndTime":1495162800000,"preheatStartTime":1495123200000,"price":9.9,"productCode":"000000000161380629","sort":0.2,"venderCode":"70141726"},{"actId":"9e1f0494","actType":1,"activityEndTime":1496246399000,"activityStartTime":1495036800000,"auditStatus":1,"cateId":1003,"categoryId":0,"enrollId":14132,"flag":1,"imgUrl":"//image.suning.cn/uimg/pgs/activity/149509790006204164_710x400.jpg","itemDesc":"植物性精油配方，绿色环保。【苏宁自营 正品速达】","itemName":"蓝贝coolbaby驱蚊贴(儿童型)26+4片装","memberNum":2,"origin":"1","price":9.9,"productCode":"000000000102553230","sort":0.3,"venderCode":"0000000000"},{"actId":"bf7ab920","actType":1,"activityEndTime":1495468799000,"activityStartTime":1494864000000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":9948,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/184046845113658311415200.jpg","itemDesc":"每包仅3.9元 手口专用 温和洁净","itemName":"怡恩贝芦荟湿巾带盖80抽5包","memberNum":2,"origin":"2","preheatEndTime":1494864000000,"preheatStartTime":1494864000000,"price":19.9,"productCode":"000000000129273185","sort":0.3,"venderCode":"70092228"},{"actId":"9fd9cae8","actType":1,"activityEndTime":1496244299000,"activityStartTime":1490684100000,"auditStatus":1,"cateId":1003,"categoryId":0,"enrollId":2987,"flag":1,"imgUrl":"http://image.suning.cn/uimg/mpms/pingoupic/207429401188484538122660.jpg","itemDesc":"需要多套请乐拼多次 收货相信一致可以一起发 百世和邮政小包可以指定","itemName":"【背心+短裤】2017夏季儿童背心套装纯棉不褪色 ","memberNum":2,"origin":"2","price":12.9,"productCode":"000000000600132206","sort":0.4,"venderCode":"70152645"},{"actId":"496ca856","actType":1,"activityEndTime":1495727999000,"activityStartTime":1495162800000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":11695,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/171869318715273737497415.jpg","itemDesc":"德国工匠品质 全植物初配方 每人限购1份","itemName":"【多拍不发】谷斑 麦纤湿巾80抽*5包","memberNum":2,"origin":"2","preheatEndTime":1495162800000,"preheatStartTime":1495123200000,"price":17.77,"productCode":"000000000617390106","sort":0.6,"venderCode":"70161296"},{"actId":"a9798f7a","actType":1,"activityEndTime":1496246399000,"activityStartTime":1494899053000,"auditStatus":1,"cateId":1003,"categoryId":0,"enrollId":12562,"flag":1,"imgUrl":"//image.suning.cn/uimg/pgs/activity/149489903108882481_710x400.jpg","itemDesc":"金盾植物驱蚊，健康长效，安全放心。两瓶液送器，夏季无忧。【苏宁自营 正品速达】","itemName":"金盾婴宝电热蚊香液促销装（2瓶）送加热器 {苏宁自营}","memberNum":2,"origin":"1","price":35.9,"productCode":"000000000143025218","sort":0.6,"venderCode":"0000000000"},{"actId":"8c8114b9","actType":1,"activityEndTime":1495468799000,"activityStartTime":1494864000000,"auditStatus":1,"cateId":1003,"categoryId":23,"enrollId":10393,"flag":1,"imgUrl":"//image.suning.cn/uimg/mpms/pingoupic/539443130146902186117290.jpg","itemDesc":"【多拍不发】免洗清爽啫喱型 远离光敏雾霾伤害","itemName":"喜朗 宝宝清爽黑莓隔离霜52g","memberNum":2,"origin":"2","preheatEndTime":1494864000000,"preheatStartTime":1494864000000,"price":19.87,"productCode":"000000000154129864","sort":1,"venderCode":"70107735"}]
         * realCount : 10
         */

        private int realCount;
        private List<ListBean> list;

        public int getRealCount() {
            return realCount;
        }

        public void setRealCount(int realCount) {
            this.realCount = realCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * actId : 41cb7614
             * actType : 1
             * activityEndTime : 1495468799000
             * activityStartTime : 1494864000000
             * auditStatus : 1
             * cateId : 1003
             * categoryId : 23
             * enrollId : 10395
             * flag : 1
             * imgUrl : //image.suning.cn/uimg/mpms/pingoupic/209482623124647109533940.jpg
             * itemDesc : 德国工匠品质 全植物初配方 每人限购1份
             * itemName : 【多拍不发】谷斑 麦纤抽纸18包*300张
             * memberNum : 2
             * origin : 2
             * preheatEndTime : 1494864000000
             * preheatStartTime : 1494864000000
             * price : 19.99
             * productCode : 000000000619038542
             * sort : 0.1
             * venderCode : 70161296
             */

            private String actId;
            private int actType;
            private long activityEndTime;
            private long activityStartTime;
            private int auditStatus;
            private int cateId;
            private int categoryId;
            private int enrollId;
            private int flag;
            private String imgUrl;
            private String itemDesc;
            private String itemName;
            private int memberNum;
            private String origin;
            private long preheatEndTime;
            private long preheatStartTime;
            private double price;
            private String productCode;
            private double sort;
            private String venderCode;

            public String getActId() {
                return actId;
            }

            public void setActId(String actId) {
                this.actId = actId;
            }

            public int getActType() {
                return actType;
            }

            public void setActType(int actType) {
                this.actType = actType;
            }

            public long getActivityEndTime() {
                return activityEndTime;
            }

            public void setActivityEndTime(long activityEndTime) {
                this.activityEndTime = activityEndTime;
            }

            public long getActivityStartTime() {
                return activityStartTime;
            }

            public void setActivityStartTime(long activityStartTime) {
                this.activityStartTime = activityStartTime;
            }

            public int getAuditStatus() {
                return auditStatus;
            }

            public void setAuditStatus(int auditStatus) {
                this.auditStatus = auditStatus;
            }

            public int getCateId() {
                return cateId;
            }

            public void setCateId(int cateId) {
                this.cateId = cateId;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getEnrollId() {
                return enrollId;
            }

            public void setEnrollId(int enrollId) {
                this.enrollId = enrollId;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getItemDesc() {
                return itemDesc;
            }

            public void setItemDesc(String itemDesc) {
                this.itemDesc = itemDesc;
            }

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public int getMemberNum() {
                return memberNum;
            }

            public void setMemberNum(int memberNum) {
                this.memberNum = memberNum;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public long getPreheatEndTime() {
                return preheatEndTime;
            }

            public void setPreheatEndTime(long preheatEndTime) {
                this.preheatEndTime = preheatEndTime;
            }

            public long getPreheatStartTime() {
                return preheatStartTime;
            }

            public void setPreheatStartTime(long preheatStartTime) {
                this.preheatStartTime = preheatStartTime;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public double getSort() {
                return sort;
            }

            public void setSort(double sort) {
                this.sort = sort;
            }

            public String getVenderCode() {
                return venderCode;
            }

            public void setVenderCode(String venderCode) {
                this.venderCode = venderCode;
            }
        }
    }

    public static class CategoriesBean {
        /**
         * id : 23
         * name : 用品
         * sort : 1
         */

        private int id;
        private String name;
        private int sort;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
