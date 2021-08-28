package id.aibangstudio.basekotlin.presentation.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.aibangstudio.basekotlin.R
import id.aibangstudio.basekotlin.domain.entity.Team
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

class TeamViewHolder(view: View): RecyclerViewHolder<Team>(view) {

    val teamBadge = view.findViewById<ImageView>(R.id.imgTeam)
    val teamName = view.findViewById<TextView>(R.id.txtTeam)

}