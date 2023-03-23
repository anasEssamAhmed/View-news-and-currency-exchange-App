package com.offersonlineworld.uigandroid2project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var nav: NavigationView
    var auto : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawer = drawerLayout
        toggle = ActionBarDrawerToggle(this , drawer , 0 , 0)
        drawer.addDrawerListener(toggle)
        nav = navView
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
        var toDoList = To_Do_List()
        var psot = Post()
        var photo = photo()
        var currency = Currency_converter()
        auto = FirebaseAuth.getInstance()
        nav.setNavigationItemSelectedListener { it ->
            when(it.itemId){
                R.id.posts -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.ss , psot )
                    transaction.commit()
                    true
                }
                R.id.to_do_list -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.ss , toDoList )
                   transaction.commit()
                    true
                }
                R.id.Photos -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.ss , photo )
                    transaction.commit()
                    true
                }
                R.id.Currency_converter -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.ss , currency)
                    transaction.commit()
                    true
                }
                R.id.LogOut -> {
                    Toast.makeText(this , "Log Out success" , Toast.LENGTH_SHORT).show()
                    auto!!.signOut()
                    finishAffinity()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            drawer.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}