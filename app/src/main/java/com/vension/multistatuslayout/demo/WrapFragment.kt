package com.vension.multistatuslayout.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vension.multistatuslayout.MultiStatusLayout

class WrapFragment : Fragment() {

    private lateinit var layout: MultiStatusLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wrap, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout = MultiStatusLayout(context!!).wrap(this)
    }

    fun getMulLayout(): MultiStatusLayout {
        return layout
    }
}
