package iek.necessitudo.app.com.mobilecatalog.presentation.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import iek.necessitudo.app.com.mobilecatalog.R
import iek.necessitudo.app.com.mobilecatalog.presentation.common.CatalogAdapter
import iek.necessitudo.app.com.mobilecatalog.presentation.model.GroupDDP
import iek.necessitudo.app.com.mobilecatalog.presentation.mvp.CatalogPresenter
import iek.necessitudo.app.com.mobilecatalog.presentation.mvp.FragmentView
import kotlinx.android.synthetic.main.list_fragment.*

class CatalogFragment :BaseFragment() , FragmentView{

    lateinit var adapter: CatalogAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        setUpAdapter()


    }

    @InjectPresenter
    lateinit var mPresenter : CatalogPresenter

    fun setUpRecyclerView() {
        val mLinearLayoutManager = LinearLayoutManager(activity)
        rv_list.setLayoutManager(mLinearLayoutManager)
    }


    fun setUpAdapter(){
        adapter = CatalogAdapter()
        rv_list.adapter = adapter

    }
    override fun getMainContentLayout(): Int { return R.layout.catalog_fragment}


    override fun addItems(items: List<GroupDDP>) {
        adapter.addItem(items)
    }

}

