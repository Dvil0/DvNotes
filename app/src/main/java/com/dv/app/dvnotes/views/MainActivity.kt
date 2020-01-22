package com.dv.app.dvnotes.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dv.app.dvnotes.R
import com.dv.app.dvnotes.views.board.BoardFragment

class MainActivity : AppCompatActivity(){

    private val fragmentTransaction by lazy { supportFragmentManager.beginTransaction() }

    override fun onCreate( savedInstanceState: Bundle? ){
        setTheme( R.style.AppTheme )
        super.onCreate( savedInstanceState )
        setContentView( R.layout.main_activity )

        val fragment = BoardFragment()
        fragmentTransaction.add( R.id.container_fragment, fragment )
        fragmentTransaction.commit()
    }

}