package com.dv.app.dvnotes.interfaces

import com.dv.app.dvnotes.dto.NoteDto

interface RecyclerItemClickListener{
    fun onRecItemClicked(note: NoteDto )
}