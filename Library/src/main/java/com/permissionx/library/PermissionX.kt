package com.permissionx.library

import android.app.Activity
import androidx.fragment.app.FragmentActivity

/**
 * @author zhangkai
 * @description:
 * @date: 2023/11/23 15:10
 */
object PermissionX {

    private const val TAG = "InvisibleFragment"
    fun request(activity: FragmentActivity, vararg permissions: String, callback: PermissionCallback) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as InvisibleFragment
        }else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }
}