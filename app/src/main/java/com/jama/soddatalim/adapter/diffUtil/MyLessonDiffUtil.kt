package com.jama.soddatalim.adapter.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.jama.soddatalim.model.Lesson

class MyLessonDiffUtil(
    private val oldList:List<Lesson>,
    private val newList:List<Lesson>
) :DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].numberLesson == newList[newItemPosition].numberLesson
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].numberLesson!=newList[newItemPosition].numberLesson->false
            oldList[oldItemPosition].name!=newList[newItemPosition].name->false
            oldList[oldItemPosition].topicList!=newList[newItemPosition].topicList->false
            else->true
        }
    }
}