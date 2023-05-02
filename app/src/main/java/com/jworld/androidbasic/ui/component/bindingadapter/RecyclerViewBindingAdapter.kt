package com.jworld.androidbasic.ui.component.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jworld.androidbasic.ui.component.GeneralBindAdapter

object RecyclerViewBindingAdapter {

    /**
     * 데이터 갱신 시 사용합니다.
     * @param scrollToTop -> false 값 줬을 때만 데이터 갱신 시 scroll 하지 않음
     */
    @JvmStatic
    @BindingAdapter(value = ["replaceAll", "scrollToTop"], requireAll = false)
    fun <T:Any> setItems(view: RecyclerView, list: List<T>?, scrollToTop: Boolean?) {
        if (list == null) {
            return
        }

        val adapter = view.adapter as GeneralBindAdapter<Any,*> ?: return
        adapter.setItems(list)

        if (scrollToTop == null || scrollToTop) { //default : scrollToTop
            view.scrollToPosition(0)
        }

    }


    /**
     * 데이터 추가 시 사용합니다.
     */
    @JvmStatic
    @BindingAdapter("addItems")
    fun <T:Any> addItems(view: RecyclerView, list: List<T>?) {
        val adapter = view.adapter as GeneralBindAdapter<Any,*>
        adapter.addItems(list)
    }

    /**
     * 데이터 갱신 시 사용합니다.
     */
    @JvmStatic
    @BindingAdapter("updateItem")
    fun <T:Any> updateItem(view: RecyclerView, map: Map<Int?, T>?) {
        if (map == null || map.isEmpty()) {
            return
        }
        val adapter = view.adapter as GeneralBindAdapter<Any,*>

        for ((key, value) in map) {
            adapter.updateItem(value , key)
        }
    }


    /**
     * RecyclerView 특정 순서로 스크롤 합니다.
     */
    @JvmStatic
    @BindingAdapter("setPosition")
    fun setPosition(view: RecyclerView, position: Int) {
        view.smoothScrollToPosition(position)
    }

}