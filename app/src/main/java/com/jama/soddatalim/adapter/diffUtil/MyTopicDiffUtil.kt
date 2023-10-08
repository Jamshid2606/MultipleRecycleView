package com.jama.soddatalim.adapter.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.jama.soddatalim.model.Lesson
import com.jama.soddatalim.model.Topic

class MyTopicDiffUtil(
    private val oldList:List<Topic>,
    private val newList:List<Topic>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size


    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].nameTopic == newList[newItemPosition].nameTopic
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].nameTopic!=newList[newItemPosition].nameTopic->false
            oldList[oldItemPosition].isFinishedTopic!=newList[newItemPosition].isFinishedTopic->false
            oldList[oldItemPosition].viewType!=newList[newItemPosition].viewType->false
            oldList[oldItemPosition].biography!=newList[newItemPosition].biography->false
            else->true
        }
    }
}