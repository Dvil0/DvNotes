package com.dv.app.dvnotes.views.board

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dv.app.dvnotes.R
import com.dv.app.dvnotes.dto.NoteDto
import com.dv.app.dvnotes.views.note.NoteFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BoardFragment : Fragment(){

    private lateinit var noteList : RecyclerView
    private val data = mutableListOf(
        NoteDto( "1", "Note 1", "Daniel1 Daniel1 Daniel1 Daniel1 Daniel1, Daniel1.", "", "f","21/01/2020", "","","","","f","f"),
        NoteDto( "2", "Note 2", "Anyi2 Anyi2 Anyi2 Anyi2 Anyi2, Anyi2.", "","f","21/01/2020", "","","","","f", "f"),
        NoteDto( "3", "Note 3", "Claudia3 Claudia3 Claudia3 Claudia3 Claudia3, Claudia3.", "","f","21/01/2020", "","","","","f", "f"),
        NoteDto( "4", "Note 4", "Andres4 Andres4 Andres4 Andres4 Andres4, Andres4.", "", "f","21/01/2020", "","","","","f", "f"),
        NoteDto( "5", "Note 5", "Hellen5 Hellen5 Hellen5 Hellen5 Hellen5, Hellen5.", "","f", "21/01/2020", "","","","","f", "f"),
        NoteDto( "6", "Note 6", "Sofia6 Sofia6 Sofia6 Sofia6 Sofia6, Sofia6.", "","","21/01/2020", "","","","","f", "f"),
        NoteDto( "7", "Note 7", "Scoot7 Scoot7 Scoot7 Scoot7 Scoot7, Scoot7.", "","","21/01/2020", "","","","","f", "f"),
        NoteDto( "8", "Note 8", "Firu8 Firu8 Firu8 Firu8 Firu8, Firu8.", "","","21/01/2020", "","","","","f", "f")
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate( R.layout.board_fragment, container, false)

        noteList = view.findViewById( R.id.note_list )
        noteList.layoutManager = LinearLayoutManager( context )
        noteList.adapter = BoardAdapter( data )

        val fab = view.findViewById<FloatingActionButton>( R.id.add_button )
        fab.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace( R.id.container_fragment, NoteFragment() )
            transaction?.commit()
        }

        return view
    }
}