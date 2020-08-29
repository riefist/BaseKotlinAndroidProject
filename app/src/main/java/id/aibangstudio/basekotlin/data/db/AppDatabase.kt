package id.aibangstudio.basekotlin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import id.aibangstudio.basekotlin.data.db.dao.TeamDao
import id.aibangstudio.basekotlin.data.db.entity.TeamEntity

@Database(
    entities = [TeamEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun teamDao() : TeamDao

}