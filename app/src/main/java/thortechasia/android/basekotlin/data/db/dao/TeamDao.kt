package thortechasia.android.basekotlin.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Single
import thortechasia.android.basekotlin.data.db.entity.TeamEntity

@Dao
interface TeamDao : BaseDao<TeamEntity> {

    @Query("SELECT * FROM team")
    fun findAll() : Single<List<TeamEntity>>

}