package com.jama.soddatalim.model

data class Topic (
    var viewType:Int,
    var nameTopic:String,
    var biography:String,
    var isFinishedTopic:Int//1 - yashil yani tugatilgan mashg'ulot, 2 - sariq endi bajarilayotgan mashg'ulot, 0 - mashg'ulotga ruxsat yo'q
)