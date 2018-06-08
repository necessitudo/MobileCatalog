package iek.necessitudo.app.com.mobilecatalog.presentation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import iek.necessitudo.app.com.mobilecatalog.R
import iek.necessitudo.app.com.mobilecatalog.data.Repository
import iek.necessitudo.app.com.mobilecatalog.data.rest.Model
import iek.necessitudo.app.com.mobilecatalog.data.rest.RestClient
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.MenuFragment
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   val apiService by lazy {
        RestClient.create()
    }
    var disposable: Disposable? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

               val menuFragment = MenuFragment()
                menuFragment.show(supportFragmentManager, menuFragment.tag)
                // message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                //message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                //message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                //message.setText(R.string.title_notifications)

                getGroupDDP()

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        BottomNavigationViewHelper.disableShiftMode(navigation)

        navigation.selectedItemId = R.id.navigation_dashboard
    }

    fun getGroupDDP() {
        val repository = Repository(this)
        val result = repository.getAllGroupDDP()

       /*disposable =
                apiService.getGroupsDDP(getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> resultSuccess(result) },
                                { error -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()}
                        )


        val a = 2*/
    }

    fun resultSuccess(result: List<Model.GroupDDP>){

        val a = 0
    }

    fun getAuthToken():String {
        val authData = "testapi@iek.ru:test12api13password14"

        val data = authData.toByteArray()

        return "Basic "+ Base64.encodeToString(data, Base64.NO_WRAP)


    }

}
