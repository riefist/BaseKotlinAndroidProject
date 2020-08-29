package id.aibangstudio.basekotlin.presentation.main

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_team.view.*
import id.aibangstudio.basekotlin.R
import id.aibangstudio.basekotlin.domain.Team
import id.aibangstudio.basekotlin.utils.loadImageFromUrl

class TeamItem(val team: Team) : Item(){

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.apply {
            itemView.imgTeam.loadImageFromUrl(team.teamLogo)
            itemView.txtTeam.text = team.teamName
        }

    }

    override fun getLayout(): Int = R.layout.item_row_team

}