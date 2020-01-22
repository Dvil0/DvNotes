package com.dv.app.dvnotes.dto

data class NoteDto(
    var id : String,
    var title : String,
    var content : String,
    var tag : String? = "",
    var task : String? = "f",
    var createDate : String,
    var startDate : String? = "",
    var startHour : String? = "",
    var finalDate : String? = "",
    var finalHour : String? = "",
    var completed : String? = "f",
    var notify: String? = "f"
)