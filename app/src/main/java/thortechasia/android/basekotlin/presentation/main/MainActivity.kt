package thortechasia.android.basekotlin.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ajalt.timberkt.e
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import thortechasia.android.basekotlin.R
import thortechasia.android.basekotlin.utils.UiState
import thortechasia.android.basekotlin.utils.gone
import thortechasia.android.basekotlin.utils.visible

class MainActivity : AppCompatActivity() {

    private val groupAdapter: GroupAdapter<ViewHolder> = GroupAdapter()
    private val vm: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTeams.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupAdapter
        }

        vm.teamState.observe(this, Observer {
            when(it){
                is UiState.Loading -> {
                    progressBar.visible()
                }
                is UiState.Success -> {
                    progressBar.gone()
                    it.data.forEach {
                        groupAdapter.add(TeamItem(it))
                    }
                }
                is UiState.Error -> {
                    progressBar.gone()
                    e(it.throwable)
                }
            }
        })

        vm.getTeams("English Premier League")


    }

}
