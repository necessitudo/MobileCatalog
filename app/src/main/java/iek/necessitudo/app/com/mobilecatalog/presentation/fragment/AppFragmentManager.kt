package iek.necessitudo.app.com.mobilecatalog.presentation.fragment

import android.support.annotation.IdRes
import android.support.v4.app.FragmentTransaction
import iek.necessitudo.app.com.mobilecatalog.presentation.activity.BaseActivity
import java.util.Stack

class AppFragmentManager {

    var mFragmentStack:Stack<BaseFragment> = Stack()

    lateinit var mCurrentFragment : BaseFragment

    fun setFragment(activity: BaseActivity, fragment: BaseFragment, @IdRes containerId:Int){
        if (activity !=null && !activity.isFinishing && !isAlreadyContains(fragment)){

            val transaction: FragmentTransaction = createAddTransaction(activity, fragment, false)
            transaction.replace(containerId, fragment)
            commitAddTransaction(activity, fragment, transaction, false)

        }

    }

    fun createAddTransaction(activity: BaseActivity, fragment: BaseFragment, addToBackStack : Boolean):FragmentTransaction{
       val fragmentTransaction: FragmentTransaction = activity.supportFragmentManager.beginTransaction()

        if (addToBackStack) { fragmentTransaction.addToBackStack(fragment.tag)}

        return fragmentTransaction
    }

    fun isAlreadyContains(fragment: BaseFragment):Boolean {

        if (fragment == null) return false

        return mCurrentFragment != null && mCurrentFragment.javaClass.name.equals(fragment.javaClass.name)

    }

    fun commitAddTransaction(activity: BaseActivity, fragment: BaseFragment, fragmentTransaction: FragmentTransaction, addToBackStack: Boolean){

        if (fragmentTransaction != null) {

            mCurrentFragment = fragment

            if (!addToBackStack) {
                mFragmentStack = Stack<BaseFragment>()
            }

            mFragmentStack.add(fragment)

            commitTransaction(activity, fragmentTransaction)

        }
    }

    fun commitTransaction(activity: BaseActivity, fragmentTransaction: FragmentTransaction){
        fragmentTransaction.commit()
    }
}