package com.digi.gadisolutions.ui.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.digi.gadisolutions.R
import com.digi.gadisolutions.models.News
import kotlinx.android.synthetic.main.news_list.view.*

import java.lang.Exception

class NewsAdaptor(val items: ArrayList<News>, val context: Context) : RecyclerView.Adapter<ViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolders {
        return ViewHolders(
            LayoutInflater.from(context).inflate(
                R.layout.news_list,
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        holder?.tvTitle?.text = items.get(position).news_title
        holder?.txtDetail?.text = items.get(position).news

//             try {
//            var url: String = ServiceBuilder.imageBaseUrl+"equipment/" + items.get(position).image
//            Picasso.with(context).load(url).resize(120, 100).error(R.drawable.equipment_rental).into(holder?.ivEquipmentIv)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }

//        holder?.ivEquipmentIv.setOnClickListener(View.OnClickListener {
//            viewEqiupmentDetailActivity(context, items.get(position))
//        })
     }


}





class ViewHolders(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvTitle = view.txtTitle
    val txtDetail = view.txtDetail

}



