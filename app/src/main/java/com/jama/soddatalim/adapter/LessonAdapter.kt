package com.jama.soddatalim.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jama.soddatalim.R
import com.jama.soddatalim.databinding.ItemLessonBinding
import com.jama.soddatalim.model.Lesson

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LoadVh>(){
    private var lessonList = ArrayList<Lesson>()
    fun addAll(list: List<Lesson>) {
        val oldSize = lessonList.size
        lessonList.addAll(list)
        notifyItemRangeInserted(oldSize, list.size)
    }
    inner class LoadVh(var binding: ItemLessonBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("ResourceAsColor")
        fun onBind(data:Lesson){
            binding.numberLesson.text = "${data.numberLesson} Mashg'ulot"
            binding.description.text = data.name
            binding.iconLesson.setOnClickListener {
                //invoke
            }
            when(data.isFinished){
                1->{
                    binding.layoutLesson.setBackgroundResource(R.color.greenLayout)
                    binding.iconLesson.setImageResource(R.drawable.green_lesson)
                    binding.iconLesson2.setImageResource(R.drawable.green_lesson_bg)
                }
                2->{
                    binding.layoutLesson.setBackgroundResource(R.color.orangeLayout)
                    binding.iconLesson.setImageResource(R.drawable.orange_lesson)
                    binding.iconLesson2.setImageResource(R.drawable.orange_bg)
                }
                0->{
                    binding.layoutLesson.setBackgroundResource(R.color.pinkLayout)
                    binding.iconLesson.setImageResource(R.drawable.pink_lesson)
                    binding.iconLesson2.setImageResource(R.drawable.pink_bg)
                }
            }
            val topicAdapter = MultipleViewAdapter(data.topicList.reversed())
            binding.listNested.adapter = topicAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoadVh {
        val binding = ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadVh(binding)
    }

    override fun getItemCount(): Int = lessonList.size

    override fun onBindViewHolder(holder: LoadVh, position: Int) {
        val dataVh = holder as LoadVh
        dataVh.onBind(lessonList[position])
    }
}
