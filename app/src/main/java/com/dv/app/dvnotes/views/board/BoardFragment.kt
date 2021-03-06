package com.dv.app.dvnotes.views.board

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dv.app.dvnotes.R
import com.dv.app.dvnotes.databinding.BoardFragmentBinding
import com.dv.app.dvnotes.dto.NoteDto
import com.dv.app.dvnotes.interfaces.RecyclerItemClickListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BoardFragment : Fragment(), RecyclerItemClickListener{

    private lateinit var noteList : RecyclerView
    private lateinit var binding : BoardFragmentBinding

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

        binding = DataBindingUtil.inflate(
            inflater, R.layout.board_fragment, container, false )

        noteList = binding.root.findViewById( R.id.note_list )
        noteList.layoutManager = LinearLayoutManager( context )
        noteList.adapter = BoardAdapter( data, this )

        val fab = binding.root.findViewById<FloatingActionButton>( R.id.add_button )
        fab.setOnClickListener(
            Navigation.createNavigateOnClickListener( R.id.action_boardFragment_to_noteFragment )
        )

        setHasOptionsMenu( true )

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate( R.menu.overflow_menu , menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item!!, this.findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    override fun onRecItemClicked(note: NoteDto ) {
        binding.root.findNavController().navigate(
            BoardFragmentDirections.actionBoardFragmentToNoteFragment(
                note.title.toString(),
                note.content.toString()
            )
        )
    }
}