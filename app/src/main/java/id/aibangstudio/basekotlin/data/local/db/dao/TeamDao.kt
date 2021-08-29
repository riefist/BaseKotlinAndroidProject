package id.aibangstudio.basekotlin.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import id.aibangstudio.basekotlin.data.local.db.entity.TeamEntity

@Dao
interface TeamDao : BaseDao<TeamEntity> {

    @Query("SELECT * FROM team")
    fun findAll() : List<TeamEntity>

}