package com.omaressam.sakfny

 import android.os.Bundle

 import androidx.appcompat.app.AppCompatActivity

 import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
 import com.omaressam.sakfny.R

 import com.omaressam.sakfny.Util.ShareApp.ShareFragment
 import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity() {


     private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         setSupportActionBar(toolbar)
         share_btn.setOnClickListener{showShareDiaolge()}


        //Settuping Drawer + AppBar + NavGraph
        settupDrawerNav()









    }




    fun settupDrawerNav ()
      {
          val navController = findNavController(R.id.nav_host_fragment)

          appBarConfiguration = AppBarConfiguration(setOf(
                  R.id.nav_home), drawer_layout)

           setupActionBarWithNavController(navController, appBarConfiguration)
          nav_view.setupWithNavController(navController)


      }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    //Share Fragment to show
    fun showShareDiaolge() {
        val ShareFragment = ShareFragment()

        ShareFragment.show(supportFragmentManager  , ShareFragment.tag)

    }




}


