package com.silence.account.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.silence.account.R;
import com.silence.account.model.ExpenseCat;
import com.silence.account.model.User;
import com.silence.account.utils.DBOpenHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silence on 2016/3/10.
 */
public class ExpenseCatDao {
    private Dao<ExpenseCat, Integer> mDao;

    public ExpenseCatDao(Context context) {
        mDao = DBOpenHelper.getInstance(context).getDao(ExpenseCat.class);
    }

    public List<ExpenseCat> getExpenseCat(int userId) {
        List<ExpenseCat> cats = null;
        try {
            cats = mDao.queryForEq("ASuserId", userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cats;
    }

    public boolean addCategory(ExpenseCat expenseCat) {
        int row = 0;
        try {
            row = mDao.create(expenseCat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public boolean delete(ExpenseCat expenseCat) {
        int row = 0;
        try {
            row = mDao.delete(expenseCat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public boolean update(ExpenseCat expenseCat) {
        int row = 0;
        try {
            row = mDao.update(expenseCat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }
    public void initExpensesCat(User user) {
        int resId[] = {R.mipmap.icon_shouru_type_qita, R.mipmap.icon_zhichu_type_canyin,
                R.mipmap.icon_zhichu_type_jiaotong, R.mipmap.icon_zhichu_type_yanjiuyinliao,
                R.mipmap.icon_zhichu_type_shuiguolingshi, R.mipmap.lingshi, R.mipmap.maicai, R.mipmap.yifu,
                R.mipmap.richangyongpin, R.mipmap.icon_zhichu_type_shoujitongxun, R.mipmap.huazhuangpin,
                R.mipmap.fangzu, R.mipmap.dianying, R.mipmap.icon_zhichu_type_taobao, R.mipmap.huankuan,
                R.mipmap.icon_shouru_type_hongbao, R.mipmap.yaopinfei};
        String labels[] = {"一般", "餐飲", "交通", "酒水飲料", "水果", "零食", "買菜", "衣服鞋包", "生活用品",
                "電話費", "護膚彩妝", "房租", "電影", "網購", "還錢", "紅包", "藥品"};
        List<ExpenseCat> cats = new ArrayList<>(resId.length);
        ExpenseCat expenseCat;
        for (int i = 0; i < resId.length; i++) {
            expenseCat = new ExpenseCat();
            expenseCat.setUser(user);
            expenseCat.setImageId(resId[i]);
            expenseCat.setName(labels[i]);
            cats.add(expenseCat);
        }
        try {
            for (int i = 0, j = cats.size(); i < j; i++) {
                mDao.create(cats.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}