package com.vension.multistatuslayout.demo

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vension.multistatuslayout.MultiStatusLayout

/**
 * ===================================================================
 * @author: Created by Vension on 2019/1/21 16:20.
 * @email:  250685***4@qq.com
 * @update: update by *** on 2019/1/21 16:20
 * @desc:   character determines attitude, attitude determines destiny
 * ===================================================================
 */
class WrapActivity :AppCompatActivity() {

    private lateinit var msl_WrapActivity: MultiStatusLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wrap)

        msl_WrapActivity = MultiStatusLayout(this).wrap(this)

        loadData()//模拟加载数据

        //重试点击监听
        msl_WrapActivity.setOnRetryClickListener(View.OnClickListener { v ->
            loadData()//获取数据
        })
    }

    /**模拟网络获取数据*/
    private fun loadData() {
        msl_WrapActivity.showLoading()
        Handler().postDelayed({
            msl_WrapActivity.showContent()
        }, 3000)
    }


    @SuppressLint("ResourceAsColor")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_loading -> {
                loadData()//获取数据
                return true
            }
            R.id.action_empty -> {
                msl_WrapActivity.showEmpty()
                return true
            }
            R.id.action_error -> {
                msl_WrapActivity.showError()
                return true
            }
            R.id.action_not_net -> {
                msl_WrapActivity
                    .setErrorImage(R.drawable.img_default_no_net)
                    .setErrorText(R.string.page_not_network)
                    .showError()
                return true
            }
            R.id.action_content -> {
                msl_WrapActivity.showContent()
                return true
            }

            R.id.action_custom_loading -> {
                msl_WrapActivity
                    .setLoadingText("我是自定义加载文本~")
                    .setLoadingColor(Color.parseColor("#cddc39"))
                    .showLoading()
                return true
            }
            R.id.action_custom_empty -> {
                msl_WrapActivity
                    .setTextColor(android.R.color.holo_red_dark)
                    .setTextSize(40)
                    .setEmptyImage(R.drawable.img_change_empty)
                    .setEmptyText("我是自定义的空数据数据提示")
                    .showEmpty()
                return true
            }
            R.id.action_custom_error -> {
                msl_WrapActivity
                    .setTextColor(android.R.color.holo_red_dark)
                    .setTextSize(40)
                    .setErrorImage(R.drawable.img_change_error)
                    .setErrorText("我是自定义的错误数据提示")
                    .setRetryTextColor(R.color.colorAccent)
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