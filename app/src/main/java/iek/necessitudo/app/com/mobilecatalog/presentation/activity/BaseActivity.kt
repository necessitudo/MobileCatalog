package iek.necessitudo.app.com.mobilecatalog.presentation.activity

import com.arellomobile.mvp.MvpAppCompatActivity
import iek.necessitudo.app.com.mobilecatalog.MobileCatalogApplication
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.BaseFragment
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.AppFragmentManager
import javax.inject.Inject

open abstract class BaseActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var fragmentManager: AppFragmentManager

    init {
        MobileCatalogApplication.graph.inject(this)
    }

    fun setContent(fragment:BaseFragment){
        //fragmentManager.setFragment(this,fragment, R.id.fragmentPlace)
    }

}