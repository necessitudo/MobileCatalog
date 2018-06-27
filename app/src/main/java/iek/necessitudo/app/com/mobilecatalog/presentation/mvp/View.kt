package iek.necessitudo.app.com.mobilecatalog.presentation.mvp


import com.arellomobile.mvp.MvpView
import iek.necessitudo.app.com.mobilecatalog.presentation.model.GroupDDP
import iek.necessitudo.app.com.mobilecatalog.presentation.common.MenuFragment
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.BaseFragment

interface MainView:MvpView{

    fun setContent(fragment: BaseFragment)

    fun setMenuHome(fragment: MenuFragment)


}

interface FragmentView:MvpView{


    /*abstract fun showRefreshing()

    abstract fun hideRefreshing()

    abstract fun showListProgress()

    abstract fun hideListProgress()

    abstract fun showError(message: String)

    abstract fun setItems(items: List<BaseViewModel>)*/

    abstract fun addItems(items: List<GroupDDP>)
}
