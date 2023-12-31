package com.jama.soddatalim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jama.soddatalim.R
import com.jama.soddatalim.adapter.diffUtil.MyLessonDiffUtil
import com.jama.soddatalim.databinding.ItemLessonBinding
import com.jama.soddatalim.model.Lesson

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LoadVh>(){
    private var oldlessonList = emptyList<Lesson>()
    fun addAll(newLessonList: List<Lesson>) {
        val diffUtil = MyLessonDiffUtil(oldlessonList, newLessonList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        oldlessonList = newLessonList
        diffResults.dispatchUpdatesTo(this)
    }
    inner class LoadVh(var binding: ItemLessonBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(data:Lesson){
            val topicAdapter = MultipleViewAdapter()
            topicAdapter.addAll(data.topicList)
            binding.apply {
                listNested.adapter = topicAdapter
                numberLesson.text = "${data.numberLesson} Mashg'ulot"
                description.text = data.name
            }
//            binding.iconLesson.setOnClickListener {
//                //invoke
//            }
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
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoadVh {
        val binding = ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadVh(binding)
    }

    override fun getItemCount(): Int = oldlessonList.size

    override fun onBindViewHolder(holder: LoadVh, position: Int) {
        val dataVh = holder as LoadVh
        dataVh.onBind(oldlessonList[position])
    }
}
