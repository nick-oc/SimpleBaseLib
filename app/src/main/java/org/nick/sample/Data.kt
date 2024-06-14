package org.nick.sample

data class SimpleData(var id: Int, var title: String, var type: Int) {
    var tag: Any? = null
    val contents = arrayListOf<String>()
}