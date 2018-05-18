package ydys.jinou.com.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ydys.jinou.com.model.db.DaoMaster;
import ydys.jinou.com.model.db.DaoSession;

/**
 * author: 晨光光
 * date : 2018/5/17 20:32
 */
public class SQLiteHelper {

    private static SQLiteHelper sqLiteHelper;
    private static DaoSession mDaoSession;
    private static SQLiteHelper getIntance(Context context){

        if (sqLiteHelper == null){
            synchronized (SQLiteHelper.class){
                if (sqLiteHelper == null){
                    setDatabase(context);
                }
            }
        }
        return sqLiteHelper;
    }

    private static void setDatabase(Context context) {
        DaoMaster.DevOpenHelper  mHelper = new DaoMaster.DevOpenHelper(context, "ydysCache", null);//string便是数据库的名字
        SQLiteDatabase db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster  mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
