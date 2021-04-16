package com.sele.demo;

/**
 * Created by Administrator on 2017/5/2.
 */
public class ABMain {
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GuanWangDengLu.main(null);
                    GuanWangGongKaiKe.main(null);
                    GuanWangShouYe.main(null);
                    GuanWangShouYeChuSan.main(null);
                    GuanWangShouYeChuSanHuaXue.main(null);
                    GuanWangShouYeChuSanShuXue.main(null);
                    GuanWangShouYeChuSanWuLi.main(null);
                    GuanWangShouYeChuSanYingYu.main(null);
                    GuanWangShouYeChuSanYuWen.main(null);
                    GuanWangShouYeChuYiChuEr.main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GuanWangShouYeChuYiChuErShuXue.main(null);
                    GuanWangShouYeChuYiChuErWuLi.main(null);
                    GuanWangShouYeChuYiChuErYingYu.main(null);
                    GuanWangShouYeChuYiChuErYuWen.main(null);
                    GuanWangShouYeGaoSan.main(null);
                    GuanWangShouYeGaoSanHuaXue.main(null);
                    GuanWangShouYeGaoSanShengWu.main(null);
                    GuanWangShouYeGaoSanShuXue.main(null);
                    GuanWangShouYeGaoSanWuLi.main(null);
                    GuanWangShouYeGaoSanYingYu.main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GuanWangShouYeGaoSanYuWen.main(null);
                    GuanWangShouYeGaoYiGaoEr.main(null);
                    GuanWangShouYeGaoYiGaoErHuaXue.main(null);
                    GuanWangShouYeGaoYiGaoErShengWu.main(null);
                    GuanWangShouYeGaoYiGaoErShuXue.main(null);
                    GuanWangShouYeGaoYiGaoErWuLi.main(null);
                    GuanWangShouYeGaoYiGaoErYingYu.main(null);
                    GuanWangShouYeGaoYiGaoErYuWen.main(null);
                    GuanWangShouYeXiaoXue.main(null);
                    GuanWangShouYeXiaoXueShuXue.main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GuanWangShouYeXiaoXueYingYu.main(null);
                    GuanWangShouYeXiaoXueYuWen.main(null);
                    GuanWangXiaoXueKeCheng.main(null);
                    GuanWangXueYuanKouBei.main(null);
                    GuanWangZhangMenKeCheng.main(null);
                    GuanWangZhangMenYouShi.main(null);
                    GuanWangZhuCeDengLu.main(null);
                    LpSem.main(null);
                    Mobile.main(null);
                    MobileJDBaiTiao.main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MobileLpDsp.main(null);
                    MobileLpSem.main(null);
                    MobileLpVad.main(null);
                    MobilePublicTeacherRegister.main(null);
                    MobileTeacherRegister.main(null);
//                    MobileTeacherUploadExam.main(null);
                    MobileWechatWechatBinding.main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
