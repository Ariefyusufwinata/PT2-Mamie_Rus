package d3ifcool.bisapetcah.mamierus.presenter.viewmodel.konsumen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import d3ifcool.bisapetcah.mamierus.core.connection.Client
import d3ifcool.bisapetcah.mamierus.core.helper.BLANK_DATA
import d3ifcool.bisapetcah.mamierus.core.helper.INTERNAL_SERVER
import d3ifcool.bisapetcah.mamierus.core.model.publik.DataItem
import d3ifcool.bisapetcah.mamierus.core.model.publik.PublicGetProductResponses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainKViewModel : ViewModel() {

    val list = MutableLiveData<List<DataItem?>?>()
    fun getValue() : MutableLiveData<List<DataItem?>?> {
        return list
    }

    fun getAllMenuK() {
        Client.instance.getPublicProduct().enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful){
                    list.postValue(response.body()?.dataAllMenu?.dataItem)
                } else {
                    Log.i(BLANK_DATA, response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }
        })
    }

    fun getSearchMenuK(search : String) {
        Client.instance.getPublicProductSearch(
            search
        ).enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful) {
                    list.postValue(response.body()?.dataAllMenu?.dataItem)
                } else {
                    Log.i(BLANK_DATA, response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }

        })
    }

    fun getSortMostK() {
        Client.instance.getPublicProductSortMost().enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful) {
                    list.postValue(response.body()?.dataAllMenu?.dataItem)
                } else {
                    Log.i(BLANK_DATA, response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }
        })
    }

    fun getSortPriceDESCK() {
        Client.instance.getPublicProductSortPriceDESC().enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful) {
                    list.postValue(response.body()?.dataAllMenu?.dataItem)
                } else {
                    Log.i(BLANK_DATA, response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }
        })
    }

    fun getSortPriceASC() {
        Client.instance.getPublicProductSortPriceASC().enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful) {
                    list.postValue(response.body()?.dataAllMenu?.dataItem)
                } else {
                    Log.i(BLANK_DATA, response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }
        })
    }
}