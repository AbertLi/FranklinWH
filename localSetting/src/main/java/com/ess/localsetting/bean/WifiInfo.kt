package com.ess.localsetting.bean

/**
 * connectStatus 1 表示连接
 * connectStatus 0 未连接
 */
class WifiInfo {
    var name: String = ""
    var connectStatus: Int = 0

    constructor(name: String, connectStatus: Int) {
        this.name = name
        this.connectStatus = connectStatus
    }

    constructor() {
    }

    companion object {
        const val CONNECT = 1
        const val NOT_CONNECT = 0
    }
}
