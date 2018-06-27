package iek.necessitudo.app.com.mobilecatalog.presentation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import iek.necessitudo.app.com.mobilecatalog.MobileCatalogApplication
import iek.necessitudo.app.com.mobilecatalog.R
import iek.necessitudo.app.com.mobilecatalog.presentation.common.BottomNavigationViewHelper
import iek.necessitudo.app.com.mobilecatalog.presentation.common.FragmentManager
import iek.necessitudo.app.com.mobilecatalog.presentation.common.MenuFragment
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.BaseFragment
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.CatalogFragment
import iek.necessitudo.app.com.mobilecatalog.presentation.mvp.MainPresenter
import iek.necessitudo.app.com.mobilecatalog.presentation.mvp.MainView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var fragmentManager: FragmentManager

    @InjectPresenter
    lateinit var mPresenter : MainPresenter


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item -> mPresenter.selectBottomMenuItem(item.itemId)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        MobileCatalogApplication.graph.inject(this)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        BottomNavigationViewHelper.disableShiftMode(navigation)

        navigation.selectedItemId = R.id.navigation_catalog
        setContent(CatalogFragment())
    }

    override fun setContent(fragment: BaseFragment) { fragmentManager.setFragment(this,fragment, R.id.fragmentPlace) }

    override fun setMenuHome(fragment: MenuFragment) { fragment.show(supportFragmentManager, fragment.tag) }


}
