package com.omaressam.sakfny.UI.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.request.RequestOptions
import com.omaressam.sakfny.Injection.HomeInjector
import com.omaressam.sakfny.NetworkLayer.Model.Data
import com.omaressam.sakfny.R
import com.omaressam.sakfny.Util.GlideApp
import kotlinx.android.synthetic.main.fragment_home.*

 import kotlinx.android.synthetic.main.top_headline_item.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    //Vm
     lateinit var homeViewModel: HomeViewModel
     @Inject
     lateinit var homeViewModelFactory : HomeViewModelFactory


    //Binding List + Headline
    fun bindHeadline (data : Data)
    {
        top_headline_item_include.visibility = View.VISIBLE
        top_headline_item_head.text = data.title
        GlideApp.with(this)

            .load(data.url)
            .apply(
                RequestOptions()
                .placeholder(R.mipmap.ic_launcher_foreground)
            ).into(top_headline_item_img)
    }

    fun bindList (dataList: List<Data>)
    {


        recycler_list.apply {
            visibility = View.VISIBLE
            layoutManager = LinearLayoutManager(this@HomeFragment.activity)
            adapter = ArticlesListAdapter(dataList)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        beginShimmer()

        //Vm
        //getting data From VM
        homeViewModel.articleDataList.observe(viewLifecycleOwner, Observer {
            it?.let {
                endShimmer()
                bindHeadline(it[0])
                 bindList(it)
            }

        })





    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        //Inject factory to Inject whole ViewModel with its Params
         HomeInjector().injectHome(this)


         homeViewModel = ViewModelProvider  (this , homeViewModelFactory).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    //Shimmer Progress to beign
    fun beginShimmer()
    {
      shimmerTop2.startShimmerAnimation()
         shimmerHead2.startShimmerAnimation()
    }

    fun endShimmer()
    {
       shimmerHead2.visibility = View.INVISIBLE
        shimmerTop2.visibility = View.INVISIBLE
        shimmerTop2.stopShimmerAnimation()
        shimmerHead2.stopShimmerAnimation()
    }

}