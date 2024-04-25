package com.example.foodapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class home_act : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var frameLayout: FrameLayout
    lateinit var navgationview: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var coordinatorLayout: CoordinatorLayout

    var previous: MenuItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        drawerLayout=findViewById(R.id.drawer)
        frameLayout=findViewById(R.id.frams)
        navgationview=findViewById(R.id.nav)
        toolbar=findViewById(R.id.toolbar)
        coordinatorLayout=findViewById(R.id.coordinator)
        actionbar()
        openHome()
        navgationview.setNavigationItemSelectedListener {
            if (previous!=null){
                previous?.isChecked=false }
            it.isCheckable=true
            it.isChecked=true
            previous=it

            when(it.itemId){
                R.id.home_menu->{
                    openHome()
                }
                R.id.My_profile_menu->{
                    supportFragmentManager.beginTransaction().replace(R.id.frams,My_Profile()).commit()
                supportActionBar?.title="MY_PROFILE"
                navgationview.setCheckedItem(R.id.My_profile_menu)
                    drawerLayout.closeDrawers()
                }
                R.id.faq->{
                    supportFragmentManager.beginTransaction().replace(R.id.frams,FAQ()).addToBackStack("home_menu").commit()
                    supportActionBar?.title="FAQ"
                    navgationview.setCheckedItem(R.id.faq)
                    drawerLayout.closeDrawers()
                }
            }
        return@setNavigationItemSelectedListener true
        }
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@home_act, drawerLayout,
            R.string.Close_drawer,
            R.string.Open_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }
    fun actionbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="TITLE"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun openHome(){
        val das=supportFragmentManager.beginTransaction()
        val fra=dash()
        das.replace(R.id.frams,fra).commit()
        supportActionBar?.title="Dash"
        navgationview.setCheckedItem(R.id.home_menu)
    }
    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frams)
        when(frag){
            !is dash->openHome()
            else->super.onBackPressed()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if (id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}