package com.dv.app.dvnotes.views.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dv.app.dvnotes.R
import com.dv.app.dvnotes.dto.NoteDto

class BoardAdapter( private val data : MutableList<NoteDto>)
    : RecyclerView.Adapter<BoardAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from( parent?.context )
            .inflate( R.layout.item_note_list, parent, false )

        return ViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = data[ position ].title
        holder.content?.text = data[ position ].content
    }

    override fun getItemCount() : Int = data.size

    class ViewHolder( itemView: View ) : RecyclerView.ViewHolder ( itemView ){
        var title : TextView? = null
        var content : TextView? = null

        init{
            title = itemView.findViewById( R.id.title_item_text )
            content = itemView.findViewById( R.id.content_item_text )
        }
    }
}