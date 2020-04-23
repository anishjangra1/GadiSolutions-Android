package com.digi.gadisolutions.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digi.gadisolutions.R
import com.digi.gadisolutions.Utils.UtilFun
import com.digi.gadisolutions.models.Brand
import com.digi.gadisolutions.models.News
import com.digi.gadisolutions.ui.news.NewsViewModel
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class NewsFragment : Fragment() {
    private var util = UtilFun()
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsViewModel =
            ViewModelProviders.of(this).get(NewsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)

        initViewModel()
        getNewsFromServer()
        return root
    }

    fun initViewModel() {

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)

        newsViewModel.responseLiveData.observe(this, Observer { response: ArrayList<News>? ->
            util.dismissProgressDialog()

            if (response != null) {
                val newslistAdaptor = NewsAdaptor(response, activity!!.applicationContext)
                recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext, LinearLayoutManager.VERTICAL, false) as RecyclerView.LayoutManager?

                recyclerView.adapter = newslistAdaptor
                newslistAdaptor.notifyDataSetChanged()

            }

            newsViewModel.responseServerError.observe(this, Observer { string: String? ->
                util.dismissProgressDialog()
                if (string != null) {
                    activity?.applicationContext?.let { util.showToast(it, string) }
                }

            })

    })}

    private fun getNewsFromServer() {
        util.showProgressDialog(activity?.applicationContext, "Loading...", "", false)
        newsViewModel.getNews()
    }
}