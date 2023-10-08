package com.jama.soddatalim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jama.soddatalim.databinding.ItemChild1Binding
import com.jama.soddatalim.databinding.ItemChild2Binding
import com.jama.soddatalim.databinding.ItemChild3Binding
import com.jama.soddatalim.model.Topic
import java.lang.IllegalArgumentException

class MultipleViewAdapter(private val list:List<Topic>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        const val FIRSTVIEW = 1
        const val SECONDVIEW = 2
        const val THIRDVIEW = 3
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FIRSTVIEW->FirstViewHolder(ItemChild1Binding.inflate(LayoutInflater.from(parent.context), parent, false ))
            SECONDVIEW->SecondViewHolder(ItemChild2Binding.inflate(LayoutInflater.from(parent.context), parent, false ))
            THIRDVIEW->ThirdViewHolder(ItemChild3Binding.inflate(LayoutInflater.from(parent.context), parent, false ))
            else->throw IllegalArgumentException("invalid item type")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(list[position].viewType){
            FIRSTVIEW->(holder as FirstViewHolder).bind(list[position], list.size-position)
            SECONDVIEW->(holder as SecondViewHolder).bind(list[position], list.size-position)
            THIRDVIEW->(holder as ThirdViewHolder).bind(list[position], list.size-position)
            else->throw IllegalArgumentException("invalid item type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }
}