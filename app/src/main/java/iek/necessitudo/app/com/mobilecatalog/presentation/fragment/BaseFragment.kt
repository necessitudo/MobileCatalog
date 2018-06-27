package iek.necessitudo.app.com.mobilecatalog.presentation.fragment

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment:MvpAppCompatFragment() {

    @LayoutRes
    abstract fun getMainContentLayout():Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(getMainContentLayout(), container, false)
    }
}