package com.ess.localsetting
abstract class ItemOnclickListener<T> {
    open fun onClick(itemBean: T?) {}
    open fun onLongClick(itemBean: T?) {}
}