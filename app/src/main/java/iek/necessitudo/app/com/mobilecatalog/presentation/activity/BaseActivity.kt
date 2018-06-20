package iek.necessitudo.app.com.mobilecatalog.presentation.activity

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import iek.necessitudo.app.com.mobilecatalog.MobileCatalogApplication
import iek.necessitudo.app.com.mobilecatalog.R
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.BaseFragment
import iek.necessitudo.app.com.mobilecatalog.presentation.common.AppFragmentManager
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var fragmentManager: AppFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileCatalogApplication.graph.inject(this)
    }


    fun setContent(fragment:BaseFragment){
        fragmentManager.setFragment(this,fragment, R.id.fragmentPlace)
    }

    fun addContent(fragment:BaseFragment){
        fragmentManager.addfragment(this, fragment, R.id.fragmentPlace)
    }


    fun   removeCurrentFragment():Boolean {

        return fragmentManager.removeCurrentFragment(this);

    }

    @Override
    override fun onBackPressed() {

        val fragmentIsRemoved = removeCurrentFragment()

        if (!fragmentIsRemoved) {
            super.onBackPressed()
        }
    }

}