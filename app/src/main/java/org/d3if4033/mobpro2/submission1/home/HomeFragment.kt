package org.d3if4033.mobpro2.submission1.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.*
import org.d3if4033.mobpro2.submission1.R
import org.d3if4033.mobpro2.submission1.core.data.Resource
import org.d3if4033.mobpro2.submission1.core.ui.BanyuwangiAdapter
import org.d3if4033.mobpro2.submission1.detail.DetailBanyuwangiActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.actionBar?.setTitle(R.string.app_name)
        if (activity != null) {

            val tourismAdapter = BanyuwangiAdapter()
            tourismAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailBanyuwangiActivity::class.java)
                intent.putExtra(DetailBanyuwangiActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.banyuwangi.observe(viewLifecycleOwner, Observer { tourism ->
                if (tourism != null) {
                    when (tourism) {
                        is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progress_bar.visibility = View.GONE
                            tourismAdapter.setData(tourism.data)
                        }
                        is Resource.Error -> {
                            progress_bar.visibility = View.GONE
                            view_error.visibility = View.VISIBLE
                            tv_error.text = tourism.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(rv_tourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }
    }
}
