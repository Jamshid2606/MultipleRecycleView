package com.jama.soddatalim.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jama.soddatalim.R
import com.jama.soddatalim.databinding.ItemChild1Binding
import com.jama.soddatalim.model.Topic

class FirstViewHolder(private val binding: ItemChild1Binding):RecyclerView.ViewHolder(binding.root) {
    fun bind(data:Topic, position:Int){

        when(data.isFinishedTopic){
            1->{
                Glide.with(binding.root).load(R.drawable.green_topic).into(binding.iconLesson)
                binding.startIcon.visibility = View.GONE
                binding.startIconText.visibility = View.GONE
            }
            2->{
                Glide.with(binding.root).load(R.drawable.current_topic1).into(binding.iconLesson)
                binding.startIcon.visibility = View.VISIBLE
                binding.startIconText.visibility = View.VISIBLE
                binding.currentTopicTXT.visibility = View.VISIBLE
                binding.currentTopicTXT.text = (position).toString()
                val params = binding.iconLesson.layoutParams as ViewGroup.MarginLayoutParams
                params.topMargin = 80
            }
            0->{
                Glide.with(binding.root).load(R.drawable.lock_topic).into(binding.iconLesson)
                binding.startIcon.visibility = View.GONE
                binding.startIconText.visibility = View.GONE
            }
        }
        val random = (1..4).random()
        when(random){
            1->{
                Glide.with(binding.root).load(R.drawable.qovoq).into(binding.qovoqIcon)
            }
            2->{
                Glide.with(binding.root).load(R.drawable.qovoq2).into(binding.qovoqIcon)
                val params = binding.qovoqShadow.layoutParams as ViewGroup.MarginLayoutParams
                params.marginStart = 40
            }
            3->{
                Glide.with(binding.root).load(R.drawable.qovoq3).into(binding.qovoqIcon)
            }
            4->{
                Glide.with(binding.root).load(R.drawable.qovoq4).into(binding.qovoqIcon)
            }
        }
    }
}