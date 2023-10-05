package com.jama.soddatalim.adapter

import android.app.ActionBar.LayoutParams
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.jama.soddatalim.R
import com.jama.soddatalim.databinding.ItemChild1Binding
import com.jama.soddatalim.databinding.ItemChild2Binding
import com.jama.soddatalim.model.Topic

class SecondViewHolder(val binding: ItemChild2Binding):RecyclerView.ViewHolder(binding.root) {
    fun bind(data:Topic){
        when(data.isFinishedTopic){
            1->{
                binding.iconLesson.setImageResource(R.drawable.green_topic)
                binding.startIcon.visibility = View.GONE
            }
            2->{
                binding.iconLesson.setImageResource(R.drawable.current_topic)
                binding.startIcon.visibility = View.VISIBLE
                val params = binding.iconLesson.layoutParams as MarginLayoutParams
                params.topMargin = 80
            }
            0->{
                binding.iconLesson.setImageResource(R.drawable.lock_topic)
                binding.startIcon.visibility = View.GONE
            }
        }
    }
}