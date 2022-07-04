package com.dhandroid2022.projetointegrador.data.favorites

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "favorites", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS ${FeedReaderContract.FeedEntry.TABLE_NAME}(USERID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${FeedReaderContract.FeedEntry.COLUMN_NAME_NOME} TEXT, "+
                "${FeedReaderContract.FeedEntry.COLUMN_NAME_THUMB_URL} TEXT) ")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


}