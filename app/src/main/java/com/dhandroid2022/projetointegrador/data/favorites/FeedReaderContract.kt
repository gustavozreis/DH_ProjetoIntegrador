package com.dhandroid2022.projetointegrador.data.favorites

import android.provider.BaseColumns

object FeedReaderContract {
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "favorites"
        const val COLUMN_NAME_NOME = "NOME"
        const val COLUMN_NAME_THUMB_URL = "THUMB_URL"
        const val COLUMN_NAME_DESCRIPTION = "DESCRIPTION"
    }
}