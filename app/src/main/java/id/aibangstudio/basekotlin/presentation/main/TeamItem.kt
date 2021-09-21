package id.aibangstudio.basekotlin.presentation.main

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import id.aibangstudio.basekotlin.R
import id.aibangstudio.basekotlin.databinding.ItemRowTeamBinding
import id.aibangstudio.basekotlin.domain.Team
import id.aibangstudio.basekotlin.utils.loadImageFromUrl

class TeamItem(private val team: Team) : BindableItem<ItemRowTeamBinding>(){

    override fun initializeViewBinding(view: View): ItemRowTeamBinding {
        return ItemRowTeamBinding.bind(view)
    }

    override fun bind(viewBinding: ItemRowTeamBinding, position: Int) {
        viewBinding.imgTeam.loadImageFromUrl(team.teamLogo)
        viewBinding.txtTeam.text = team.teamName
    }

    override fun getLayout(): Int = R.layout.item_row_team

}