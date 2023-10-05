package com.jama.soddatalim.model

data class Lesson (
    var name:String,
    var numberLesson:Int,
    var topicList:List<Topic>,
    var isFinished:Int, //1 - yashil yani tugatilgan mashg'ulot, 2 - sariq endi bajarilayotgan mashg'ulot, 0 - mashg'ulotga ruxsat yo'q
)