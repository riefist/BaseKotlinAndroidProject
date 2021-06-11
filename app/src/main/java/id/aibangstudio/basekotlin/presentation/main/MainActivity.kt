package id.aibangstudio.basekotlin.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ajalt.timberkt.e
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import id.aibangstudio.basekotlin.databinding.ActivityMainBinding
import id.aibangstudio.basekotlin.presentation.base.BaseViewBindingActivity
import id.aibangstudio.basekotlin.utils.UiState
import id.aibangstudio.basekotlin.utils.gone
import id.aibangstudio.basekotlin.utils.visible
import org.koin.android.ext.android.inject

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val groupAdapter: GroupAdapter<GroupieViewHolder> = GroupAdapter()
    private val vm: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rvTeams.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupAdapter
        }

        vm.teamState.observe(this, Observer {
            when(it){
                is UiState.Loading -> {
                    binding.progressBar.visible()
                }
                is UiState.Success -> {
                    binding.progressBar.gone()
                    it.data.forEach {
                        groupAdapter.add(TeamItem(it))
                    }
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
