package com.alireza.firstkmmapp.android.note_list

import com.alireza.firstkmmapp.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)
