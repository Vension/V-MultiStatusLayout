package com.vension.multistatuslayout.demo

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.vension.multistatuslayout.MultiStatusLayout
import kotlinx.android.synthetic.main.activity_wrap_view.*

/**
 * ===================================================================
 * @author: Created by Vension on 2019/1/21 16:20.
 * @email:  250685***4@qq.com
 * @update: update by *** on 2019/1/21 16:20
 * @desc:   character determines attitude, attitude determines destiny
 * ===================================================================
 */
class WrapViewActivity :AppCompatActivity() {

    private lateinit var msl_WrapView: MultiStatusLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wrap_view)

        msl_WrapView = MultiStatusLayout(this)
            .setEmptyLayout(R.layout.layout_custom_empty)
            .wrap(textview)
        msl_WrapView.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary))
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_empty -> {
                msl_WrapView.showEmpty()
                return true
            }
            R.id.action_loading -> {
                msl_WrapView.showLoading()
                return true
            }
            R.id.action_content -> {
                msl_WrapView.showContent()
                return true
            }
            R.id.action_error -> {
                msl_WrapView.showError()
                return true
            }
            R.id.action_not_net -> {
                msl_WrapView
                    .setErrorImage(R.drawable.img_default_no_net)
                    .setErrorText(R.string.page_not_network)
                    .showError()
                return true
            }
            R.id.action_custom_loading -> {
                msl_WrapView
                    .setLoadingText("我是自定义加载文本~")
                    .setLoadingColor(Color.parseColor("#cddc39"))
                    .showLoading()
                return true
            }
            R.id.action_custom_empty -> {
                msl_WrapView
                    .setTextColor(ContextCompat.getColor(this,android.R.color.holo_red_dark))
                    .setTextSize(40)
                    .setEmptyImage(R.drawable.img_change_empty)
                    .setEmptyText("我是自定义的空数据数据提示")
                    .showEmpty()
                return true
            }
            R.id.action_custom_error -> {
                msl_WrapView
                    .setTextColor(ContextCompat.getColor(this,android.R.color.holo_red_dark))
                    .setTextSize(40)
                    .setErrorImage(R.drawable.img_change_error)
                    .setErrorText("我是自定义的错误数据提示")
                    .setRetryTextColor(ContextCompat.getColor(this,R.color.colorAccent))
                    .setRetryBackground(R.drawable.shape_custom_retry)
                    .showError()
                return true
            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.msl_menu, menu)
        return true
    }

}