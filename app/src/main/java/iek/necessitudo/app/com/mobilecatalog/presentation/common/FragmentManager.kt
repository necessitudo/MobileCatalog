package iek.necessitudo.app.com.mobilecatalog.presentation.common

import android.support.annotation.IdRes
import iek.necessitudo.app.com.mobilecatalog.presentation.MainActivity
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.BaseFragment

class FragmentManager {

    val BACK_STACK_ROOT_TAG = "fragment"


    fun setFragment(activity: MainActivity, fragment: BaseFragment, @IdRes containerId:Int){

        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(BACK_STACK_ROOT_TAG)
                .commit();


    }

}