package com.digi.gadisolutions.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digi.gadisolutions.models.Brand
import com.digi.gadisolutions.models.News
import com.giantcell.services.AuthenticationService
import com.giantcell.services.ServiceBuilder
import com.giantcell.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    public val responseLiveData = MutableLiveData<ArrayList<News>>()
    public val responseServerError = MutableLiveData<String>()


    fun getNews() {
        val destinationService = ServiceBuilder.buildService(AuthenticationService::class.java)
        val requestCall = destinationService.getNews()

        requestCall.enqueue(object : Callback<ArrayList<News>> {

            override fun onResponse(call: Call<ArrayList<News>>, response: Response<ArrayList<News>>) {
                try {
                    if (response.isSuccessful) {
                        responseLiveData.setValue(response.body()!!);
                    } else {
                        responseServerError.setValue(response.body()!!.toString());
                    }
                } catch (e: Exception) {
                    responseServerError.setValue(e.toString());
                }

            }

            override fun onFailure(call: Call<ArrayList<News>>, t: Throwable) {
                responseServerError.setValue(t.toString());
            }
        })
    }


}