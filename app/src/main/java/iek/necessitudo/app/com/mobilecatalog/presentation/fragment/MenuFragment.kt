package iek.necessitudo.app.com.mobilecatalog.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import iek.necessitudo.app.com.mobilecatalog.R

class MenuFragment : RoundedBottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.bottom_navigation, container, false)

        //val mTypedValue = TypedValue()

        //context.theme.resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true)
        //val mBackground: Int = mTypedValue.resourceId

        //view.setBackgroundResource(mBackground)

        view.setOnClickListener { Toast.makeText(context, "Work!", Toast.LENGTH_LONG).show() }
        return view

    }

}