package id.aibangstudio.basekotlin.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import id.aibangstudio.basekotlin.R
import id.aibangstudio.basekotlin.core.base.BaseActivityBinding
import id.aibangstudio.basekotlin.databinding.ActivityMainBinding
import id.aibangstudio.basekotlin.domain.entity.Team
import me.ibrahimyilmaz.kiel.adapterOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivityBinding<ActivityMainBinding>() {

    private val vm: MainViewModel by viewModel()

    private val teamAdapter = adapterOf<Team> {
        register(
            layoutResource = R.layout.item_row_team,
            viewHolder = ::TeamViewHolder,
            onViewHolderCreated = { vh ->
                //you may handle your on click listener
                vh.itemView.setOnClickListener {}
            },
            onBindViewHolder = { vh, _, team ->
                Glide.with(vh.teamBadge)
                    .load(team.teamLogo)
                    .into(vh.teamBadge)

                vh.teamName.text = team.teamName
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeState()

        vm.getTeams("English Premier League")
    }

    private fun observeState() {
        vm.uiState().observe(this, { state ->
            when (state) {
                is MainViewState.Loading -> showLoading(true)
                is MainViewState.Success -> {
                    showLoading(false)
                    teamAdapter.submitList(state.teams)
                }
                is MainViewState.Error -> showLoading(false)
            }
        })
    }

    private fun showLoading(isLoading: Boolean) = with(binding){
        if (isLoading){
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setupView(binding: ActivityMainBinding) {
        binding.rvTeams.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = teamAdapter
        }
    }

}
