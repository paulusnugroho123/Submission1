package org.d3if4033.mobpro2.submission1.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_home.rv_tourism
import org.d3if4033.mobpro2.submission1.R
import org.d3if4033.mobpro2.submission1.core.ui.BanyuwangiAdapter
import org.d3if4033.mobpro2.submission1.detail.DetailBanyuwangiActivity
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val tourismAdapter = BanyuwangiAdapter()
            tourismAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailBanyuwangiActivity::class.java)
                intent.putExtra(DetailBanyuwangiActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.favoriteBanyuwangi.observe(viewLifecycleOwner, Observer { dataTourism ->
                tourismAdapter.setData(dataTourism)
                view_empty.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(rv_tourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }
    }
}
