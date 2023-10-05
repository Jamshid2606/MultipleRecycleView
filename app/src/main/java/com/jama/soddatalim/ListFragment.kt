package com.jama.soddatalim

import com.jama.soddatalim.adapter.LessonAdapter
import com.jama.soddatalim.databinding.FragmentListBinding
import com.jama.soddatalim.model.Lesson
import com.jama.soddatalim.model.Topic

class ListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {
    private val adapter by lazy {
        LessonAdapter()
    }
    private var listLesson = ArrayList<Lesson>()
    override fun onViewCreate() {
        adddata()
        binding.list.adapter = adapter
        adapter.addAll(listLesson.reversed())
        binding.list.scrollToPosition(listLesson.size-1)
    }
    fun adddata() {
        val topicList1 = ArrayList<Topic>()
        val topicList2 = ArrayList<Topic>()
        val topicList3 = ArrayList<Topic>()
        topicList1.add(Topic(1, "", "", 1))
        topicList1.add(Topic(2, "", "", 1))
        topicList1.add(Topic(3, "", "", 1))
        topicList1.add(Topic(2, "", "", 1))
        topicList1.add(Topic(1, "", "", 1))
        topicList1.add(Topic(2, "", "", 1))
        topicList2.add(Topic(1, "", "", 1))
        topicList2.add(Topic(2, "", "", 1))
        topicList2.add(Topic(3, "", "", 1))
        topicList2.add(Topic(2, "", "", 2))
        topicList2.add(Topic(1, "", "", 0))
        topicList2.add(Topic(2, "", "", 0))
        topicList2.add(Topic(3, "", "", 0))
        topicList2.add(Topic(2, "", "", 0))
        topicList2.add(Topic(1, "", "", 0))
        topicList3.add(Topic(1, "", "", 0))
        topicList3.add(Topic(2, "", "", 0))
        topicList3.add(Topic(3, "", "", 0))
        topicList3.add(Topic(2, "", "", 0))
        topicList3.add(Topic(1, "", "", 0))
        topicList3.add(Topic(2, "", "", 0))
        topicList3.add(Topic(3, "", "", 0))
        topicList3.add(Topic(2, "", "", 0))
        topicList3.add(Topic(1, "", "", 0))
        topicList3.add(Topic(2, "", "", 0))
        topicList3.add(Topic(3, "", "", 0))
        topicList3.add(Topic(2, "", "", 0))
        listLesson.add(Lesson("1-dars nomi", 1, topicList1, 1))
        listLesson.add(Lesson("2-dars nomi", 2, topicList2, 2))
        listLesson.add(Lesson("3-dars nomi", 3, topicList3, 0))
    }
}