package com.jama.soddatalim.adapter

import android.app.ActionBar.LayoutParams
import android.util.Log
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jama.soddatalim.R
import com.jama.soddatalim.databinding.ItemChild1Binding
import com.jama.soddatalim.databinding.ItemChild2Binding
import com.jama.soddatalim.model.Topic

class SecondViewHolder(val binding: ItemChild2Binding):RecyclerView.ViewHolder(binding.root) {
    fun bind(data:Topic, position:Int){
        when(data.isFinishedTopic){
            1->{
                Glide.with(binding.root).load(R.drawable.green_topic).into(binding.iconLesson)
                binding.startIcon.visibility = View.GONE
                binding.startIconText.visibility = View.GONE
                binding.currentTopicTXT.visibility = View.GONE
            }
            2->{
                Glide.with(binding.root).load(R.drawable.current_topic1).into(binding.iconLesson)
                binding.startIcon.visibility = View.VISIBLE
                binding.startIconText.visibility = View.VISIBLE
                binding.currentTopicTXT.visibility = View.VISIBLE
                binding.currentTopicTXT.text = (position).toString()
                val params = binding.iconLesson.layoutParams as MarginLayoutParams
                params.topMargin = 80
            }
            0->{
                Glide.with(binding.root).load(R.drawable.lock_topic).into(binding.iconLesson)
                binding.startIcon.visibility = View.GONE
                binding.startIconText.visibility = View.GONE
                binding.currentTopicTXT.visibility = View.GONE
            }
        }
    }
}