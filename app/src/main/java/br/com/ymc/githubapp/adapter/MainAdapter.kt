package br.com.ymc.githubapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.ymc.githubapp.R
import br.com.ymc.githubapp.databinding.ItemListBinding
import br.com.ymc.githubapp.model.DataItem
import com.bumptech.glide.Glide

class MainAdapter(private val arrData : List<DataItem>? = null) : RecyclerView.Adapter<MainAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        return MyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.bind(arrData?.get(position)!!)
    }

    override fun getItemCount(): Int
    {
        if(arrData == null) return 0

        return arrData.size
    }

    class MyViewHolder(private var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
    {
        val imgAvatar = binding.imgAvatar
        val txtTitle = binding.txtTitle
        val txtDescription = binding.txtDescription

        fun bind(data: DataItem)
        {
            txtTitle.text = data.name
            txtDescription.text = data.description

            Glide.with(imgAvatar).load(data.owner.avatar_url).into(imgAvatar)
        }
    }
}