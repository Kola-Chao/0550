package com.tang.demo.mmsjapi.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.tang.demo.mmsjapi.RxRetrofitApp;
import com.tang.demo.mmsjapi.http.cookie.CookieResulte;
import com.tang.demo.mmsjapi.http.cookie.CookieResulteDao;
import com.tang.demo.mmsjapi.http.cookie.DaoMaster;
import com.tang.demo.mmsjapi.http.cookie.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/15
 * Time   :10:47
 */

public class CookieDbUtil {
    private static CookieDbUtil dbUtil;
    private static final String dbName = "test_db";
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private CookieResulteDao downInfoDao;

    public CookieDbUtil() {
        context = RxRetrofitApp.getApplication();
        openHelper = new DaoMaster.DevOpenHelper(context, dbName);
    }

    /**
     * 获取单例
     *
     * @return
     */
    public static CookieDbUtil getInstance() {
        if (dbUtil == null) {
            synchronized (CookieDbUtil.class) {
                if (dbUtil == null) {
                    dbUtil = new CookieDbUtil();
                }
            }
        }
        return dbUtil;
    }

    /**
     * 初始化一个可读的数据库
     *
     * @return
     */
    private SQLiteDatabase initReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 初始化一个可写的数据库与
     *
     * @return
     */
    private SQLiteDatabase initWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    /**
     * 初始化CookieResulteDao
     * Write
     *
     * @return
     */
    private CookieResulteDao initCookieResulteDaoWritable() {
        daoMaster = new DaoMaster(getWritableDatabase());
        daoSession = daoMaster.newSession();
        downInfoDao = daoSession.getCookieResulteDao();
        return downInfoDao;
    }


    /**
     * 初始化CookieResulteDao
     * Read
     *
     * @return
     */
    private CookieResulteDao initCookieResulteDaoReadable() {
        daoMaster = new DaoMaster(getReadableDatabase());
        daoSession = daoMaster.newSession();
        downInfoDao = daoSession.getCookieResulteDao();
        return downInfoDao;
    }

    /**
     * 获取可读数据库
     *
     * @return
     */
    private SQLiteDatabase getReadableDatabase() {
        return initReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     * @return
     */
    private SQLiteDatabase getWritableDatabase() {
        return initWritableDatabase();
    }

    /**
     * 保存缓存信息
     *
     * @param info
     */
    public void saveCookie(CookieResulte info) {
        initCookieResulteDaoWritable();
        if (downInfoDao != null) {
            downInfoDao.insert(info);
        }
    }

    /**
     * 更新缓存信息
     *
     * @param info
     */
    public void updateCookie(CookieResulte info) {
        initCookieResulteDaoWritable();
        if (downInfoDao != null) {
            downInfoDao.update(info);
        }
    }

    /**
     * 删除缓存信息
     *
     * @param info
     */
    public void deleteCookie(CookieResulte info) {
        initCookieResulteDaoWritable();
        if (downInfoDao != null) {
            downInfoDao.delete(info);
        }
    }

    /**
     * 通过URL查找最近的一条缓存信息
     *
     * @param url
     * @return
     */
    public CookieResulte queryCookieBy(String url) {
        initCookieResulteDaoReadable();
        if (downInfoDao != null) {
            QueryBuilder<CookieResulte> qb = downInfoDao.queryBuilder();
            qb.where(CookieResulteDao.Properties.Url.eq(url));
            List<CookieResulte> list = qb.list();
            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(0);
            }
        } else {
            return null;
        }
    }

    /**
     * 查找所有的缓存信息
     *
     * @return
     */
    public List<CookieResulte> queryAllCookies() {
        initCookieResulteDaoReadable();
        if (downInfoDao != null) {
            QueryBuilder<CookieResulte> qb = downInfoDao.queryBuilder();
            return qb.list();
        } else {
            return null;
        }
    }
}
