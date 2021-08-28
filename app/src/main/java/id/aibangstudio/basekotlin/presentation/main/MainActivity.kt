package id.aibangstudio.basekotlin.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.ajalt.timberkt.e
import id.aibangstudio.basekotlin.R
import id.aibangstudio.basekotlin.core.ext.gone
import id.aibangstudio.basekotlin.core.ext.visible
import id.aibangstudio.basekotlin.databinding.ActivityMainBinding
import id.aibangstudio.basekotlin.domain.entity.Team
import id.aibangstudio.basekotlin.presentation.base.BaseViewBindingActivity
import id.aibangstudio.basekotlin.utils.UiState
import me.ibrahimyilmaz.kiel.adapterOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val teamAdapter = adapterOf<Team> {
            register(
                layoutResource = R.layout.item_row_team,
                viewHolder = ::TeamViewHolder,
                onViewHolderCreated = { vh ->
                    //you may handle your on click listener
                    vh.itemView.setOnClickListener {

                    }
                },
                onBindViewHolder = { vh, _, team ->
                    Glide.with(vh.teamBadge)
                        .load(team.teamLogo)
                        .into(vh.teamBadge)

                    vh.teamName.text = team.teamName
                }

            )
        }

        binding.rvTeams.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = teamAdapter
        }

        vm.teamState.observe(this, Observer {
            when(it){
                is UiState.Loading -> {
                    binding.progressBar.visible()
                }
                is UiState.Success -> {
                    binding.progressBar.gone()
                    teamAdapter.submitList(it.data)
                }
                is UiState.Error -> {
                    binding.progressBar.gone()
                    e(it.throwable)
                }
            }
        })

        vm.getTeams("English Premier League")

    }

}
