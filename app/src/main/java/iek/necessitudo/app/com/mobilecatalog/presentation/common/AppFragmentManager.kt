package iek.necessitudo.app.com.mobilecatalog.presentation.common

import android.support.annotation.IdRes
import android.support.v4.app.FragmentTransaction
import iek.necessitudo.app.com.mobilecatalog.R
import iek.necessitudo.app.com.mobilecatalog.presentation.activity.BaseActivity
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.BaseFragment
import java.util.Stack

class AppFragmentManager {

    val EMPTY_FRAGMENT_STACK_SIZE = 1

    var mFragmentStack:Stack<BaseFragment> = Stack()

    var mCurrentFragment : BaseFragment? = null

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

        return mCurrentFragment != null && mCurrentFragment!!.javaClass.name.equals(fragment.javaClass.name)

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

    fun addfragment(activity: BaseActivity, fragment: BaseFragment, @IdRes containerId: Int){
        if (activity !=null && !activity.isFinishing && !isAlreadyContains(fragment)){
            val transaction: FragmentTransaction = createAddTransaction(activity, fragment, false)
            transaction.add(containerId, fragment)
            commitAddTransaction(activity, fragment, transaction, true)
        }
    }

    fun removeFragment(activity: BaseActivity, fragment: BaseFragment?): Boolean {

        val canRemove = fragment != null && mFragmentStack.size > EMPTY_FRAGMENT_STACK_SIZE

        if (canRemove) {

            val transaction = activity.supportFragmentManager.beginTransaction()

            mFragmentStack.pop()
            mCurrentFragment = mFragmentStack.lastElement()

            transaction.remove(fragment)
            commitTransaction(activity, transaction)
        }

        return canRemove

    }

    fun removeCurrentFragment(activity: BaseActivity): Boolean {
        return removeFragment(activity, mCurrentFragment)

    }
}