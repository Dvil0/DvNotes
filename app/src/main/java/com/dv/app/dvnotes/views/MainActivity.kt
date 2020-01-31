package com.dv.app.dvnotes.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.dv.app.dvnotes.R
import com.dv.app.dvnotes.databinding.MainActivityBinding
import com.dv.app.dvnotes.views.board.BoardFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding : MainActivityBinding
    private val navController by lazy{ this.findNavController(R.id.navHostFragment) }

    override fun onCreate( savedInstanceState: Bundle? ){
        setTheme( R.style.AppTheme )
        super.onCreate( savedInstanceState )

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity )

        NavigationUI.setupActionBarWithNavController( this, navController )

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}