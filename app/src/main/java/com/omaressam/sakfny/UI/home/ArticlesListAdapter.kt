package com.omaressam.sakfny.UI.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.omaressam.sakfny.NetworkLayer.Model.Data
import com.omaressam.sakfny.R
import com.omaressam.sakfny.Util.GlideApp

class ArticlesListAdapter ( val listItems : List<Data>) : RecyclerView.Adapter<ArticlesListAdapter.ViewHolder>() {

    class ViewHolder (val view : View): RecyclerView.ViewHolder(view)  {

        private var textview: TextView? = null
        private var img: ImageView? = null



        init {
            textview = view.findViewById(R.id.headline_item_head)
            img = view.findViewById(R.id.headline_item_img)
         }

        fun bind (item : Data){
            textview?.let { it.text=item.title }

            img?.let {
                GlideApp.with(view)
                        .load(item.url)
                    .apply(
                        RequestOptions()
                            .placeholder(R.mipmap.ic_launcher_foreground)
                    )
                        .into(it)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.headline_item, parent, false)
        return ViewHolder(inflater)    }

    override fun getItemCount() = listItems.size-1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       if (position != listItems.size){
           val newPostion = position+1
           Log.d("error", listItems[1].toString())
            holder.bind (listItems.get(newPostion))
       }


    }
}