package com.dv.app.dvnotes.views.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.dv.app.dvnotes.R
import com.dv.app.dvnotes.databinding.NoteFragmentBinding
import com.dv.app.dvnotes.dto.NoteDto

class NoteFragment : Fragment(){

    private val note : NoteDto = NoteDto( "1", "Note 1", "Daniel1 Daniel1 Daniel1 Daniel1 Daniel1, Daniel1.", "", "f","21/01/2020", "","","","","f","f")
    private lateinit var binding : NoteFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<NoteFragmentBinding>(
            inflater, R.layout.note_fragment, container, false )

        onRenderDataIntoUI()

        return binding.root
    }

    private fun onRenderDataIntoUI(){
        arguments?.let { arguments ->
            val args = NoteFragmentArgs.fromBundle( arguments )

            binding.titleNoteEdittext.setText( args.title )
            binding.contentNoteEdittext.setText( args.content )

            binding.invalidateAll()
        }
    }
}