package com.jama.soddatalim.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jama.soddatalim.R
import com.jama.soddatalim.databinding.ItemChild1Binding
import com.jama.soddatalim.model.Topic

class FirstViewHolder(private val binding: ItemChild1Binding):RecyclerView.ViewHolder(binding.root) {
    fun bind(data:Topic){
        when(data.isFinishedTopic){
            1->{
                binding.iconLesson.setImageResource(R.drawable.green_topic)
                binding.startIcon.visibility = View.GONE
            }
            2->{
                binding.iconLesson.setImageResource(R.drawable.current_topic)
                binding.startIcon.visibility = View.VISIBLE
                binding.startIcon.visibility = View.VISIBLE
                val params = binding.iconLesson.layoutParams as ViewGroup.MarginLayoutParams
                params.topMargin = 80
            }
            0->{
                binding.iconLesson.setImageResource(R.drawable.lock_topic)
                binding.startIcon.visibility = View.GONE
            }
        }
        val random = (1..4).random()
        when(random){
            1->binding.qovoqIcon.setImageResource(R.drawable.qovoq)
            2->binding.qovoqIcon.setImageResource(R.drawable.qovoq2)
            3->binding.qovoqIcon.setImageResource(R.drawable.qovoq3)
            4->binding.qovoqIcon.setImageResource(R.drawable.qovoq4)
        }
    }
}