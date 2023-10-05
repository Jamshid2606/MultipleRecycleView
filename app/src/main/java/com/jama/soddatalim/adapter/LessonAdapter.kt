package com.jama.soddatalim.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jama.soddatalim.R
import com.jama.soddatalim.databinding.ItemLessonBinding
import com.jama.soddatalim.model.Lesson

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LoadVh>(){
    private var lessonList = ArrayList<Lesson>()
    fun addAll(list: List<Lesson>){
        lessonList.clear()
        list.forEach {
            lessonList.add(it)
        }
        notifyDataSetChanged()
    }
    inner class LoadVh(var binding: ItemLessonBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("ResourceAsColor")
        fun onBind(data:Lesson){
            binding.numberLesson.text =data.numberLesson.toString() + " Mashg'ulot"
            binding.description.text = data.name
            when(data.isFinished){
                1->{
                    binding.iconLesson.setImageResource(R.drawable.green_lesson)
                    binding.layoutLesson.setBackgroundColor(R.color.green)
                }
                2->{
                    binding.iconLesson.setImageResource(R.drawable.orange_lesson)
                    binding.layoutLesson.setBackgroundColor(R.color.orange)
                }
                0->{
                    binding.iconLesson.setImageResource(R.drawable.pink_lesson)
                    binding.layoutLesson.setBackgroundColor(R.color.pink)
                }
            }
            val topicAdapter = MultipleViewAdapter(data.topicList.reversed())
            binding.listNested.adapter = topicAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoadVh =LoadVh(ItemLessonBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = lessonList.size

    override fun onBindViewHolder(holder: LoadVh, position: Int) {
        val dataVh = holder as LoadVh
        dataVh.onBind(lessonList[position])
    }
}