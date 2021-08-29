package id.aibangstudio.basekotlin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import id.aibangstudio.basekotlin.data.local.db.dao.TeamDao
import id.aibangstudio.basekotlin.data.local.db.entity.TeamEntity

@Database(
    entities = [TeamEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun teamDao() : TeamDao

}