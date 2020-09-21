package org.d3if4033.mobpro2.submission1.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_banyuwangi.*
import kotlinx.android.synthetic.main.content_detail_tourism.*
import org.d3if4033.mobpro2.submission1.R
import org.d3if4033.mobpro2.submission1.core.domain.model.Banyuwangi
import org.koin.android.viewmodel.ext.android.viewModel

class DetailBanyuwangiActivity : AppCompatActivity() {

   private val detailBanyuwangiViewModel: DetailBanyuwangiViewModel by viewModel()

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_banyuwangi)
        setSupportActionBar(toolbar)

        val detailBanyuwangi = intent.getParcelableExtra<Banyuwangi>(EXTRA_DATA)
        showDetailBanyuwangi(detailBanyuwangi)
    }

    private fun showDetailBanyuwangi(detailBanyuwangi: Banyuwangi?) {
        detailBanyuwangi?.let {
            supportActionBar?.title = detailBanyuwangi.nama
            tv_detail_description.text = detailBanyuwangi.deskripsi
            Glide.with(this@DetailBanyuwangiActivity)
                .load(detailBanyuwangi.gambar)
                .into(text_detail_image)

            var statusFavorite = detailBanyuwangi.isFavorite
            setStatusFavorite(statusFavorite)
            fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailBanyuwangiViewModel.setFavoriteBanyuwangi(detailBanyuwangi, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}
