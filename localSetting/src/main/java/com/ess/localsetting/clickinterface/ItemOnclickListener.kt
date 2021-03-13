package com.ess.localsetting.clickinterface
abstract class ItemOnclickListener<T> {
    open fun onClick(itemBean: T?) {}
    open fun onLongClick(itemBean: T?) {}
}