package com.alireza.firstkmmapp.data.note

import com.alireza.firstkmmapp.domain.note.Note
import com.alireza.firstkmmapp.domain.time.DateTimeUtil

class SearchNotes {

    fun execute(notes: List<Note>, query: String): List<Note> {
        if (query.isBlank()) return notes

        return notes.filter {
            it.title.trim().lowercase().contains(query.lowercase()) or
                    it.content.trim().lowercase().contains(query.lowercase())
        }.sortedBy { DateTimeUtil.toEpochMillis(it.created) }
    }
}