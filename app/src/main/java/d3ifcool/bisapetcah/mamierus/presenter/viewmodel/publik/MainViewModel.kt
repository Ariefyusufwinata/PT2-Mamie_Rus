package d3ifcool.bisapetcah.mamierus.presenter.viewmodel.publik

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.*
import d3ifcool.bisapetcah.mamierus.core.connection.Client
import d3ifcool.bisapetcah.mamierus.core.helper.INTERNAL_SERVER
import d3ifcool.bisapetcah.mamierus.core.model.publik.DataItem
import d3ifcool.bisapetcah.mamierus.core.model.publik.PublicGetProductResponses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val list = MutableLiveData<ArrayList<DataItem>>()
    fun getValue() : MutableLiveData<ArrayList<DataItem>> {
        return list
    }

    fun getAllMenu() {
        Client.instance.getPublicProduct().enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful){
                    list.postValue(response.body()?.dataAllMenu?.dataItem as ArrayList<DataItem>)
                } else {
                    Log.i("Blank Data", response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }
        })
    }

    fun getSearchMenu(search : String) {
        Client.instance.getPublicProductSearch(
            search
        ).enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful) {
                    list.postValue(response.body()?.dataAllMenu?.dataItem as ArrayList<DataItem>)
                } else {
                    Log.i("Blank Data", response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }

        })
    }

    fun getSortMost() {
        Client.instance.getPublicProductSortMost().enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful) {
                    list.postValue(response.body()?.dataAllMenu?.dataItem as ArrayList<DataItem>)
                } else {
                    Log.i("Blank Data", response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }
        })
    }

    fun getSortPriceDESC() {
        Client.instance.getPublicProductSortPriceDESC().enqueue(object : Callback<PublicGetProductResponses> {
            override fun onResponse(
                call: Call<PublicGetProductResponses>,
                response: Response<PublicGetProductResponses>
            ) {
                if(response.isSuccessful) {
                    list.postValue(response.body()?.dataAllMenu?.dataItem as ArrayList<DataItem>)
                } else {
                    Log.i("Blank Data", response.body().toString())
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
                    list.postValue(response.body()?.dataAllMenu?.dataItem as ArrayList<DataItem>)
                } else {
                    Log.i("Blank Data", response.body().toString())
                }
            }

            override fun onFailure(call: Call<PublicGetProductResponses>, t: Throwable) {
                Log.e(INTERNAL_SERVER, t.toString())
            }
        })
    }
}