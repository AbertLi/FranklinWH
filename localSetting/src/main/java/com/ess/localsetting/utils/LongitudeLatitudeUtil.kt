package com.ess.localsetting.utils

class LongitudeLatitudeUtil {
    companion object {
        /**
         * 将小数度数转换成度分秒
         */
        @JvmStatic
        fun DDD2DMS(d: Double): String {
            val array = d.toString().split(".").toTypedArray()
            val degrees = array[0] //得到度
            val m = ("0." + array[1]).toDouble() * 60
            val array1 = m.toString().split(".").toTypedArray()
            val minutes = array1[0] //得到分
            val s = ("0." + array1[1]).toDouble() * 60
            val seconds = s.toString() //得到秒
            return "$degrees°$minutes'$seconds\""
        }

        /**
         * 将小数度数转换成度分秒
         * 秒取整
         */
        @JvmStatic
        fun DDD2DMSROUNDING(d: Double): String {
            val array = d.toString().split(".").toTypedArray()
            val degrees = array[0] //得到度
            val m = ("0." + array[1]).toDouble() * 60
            val array1 = m.toString().split(".").toTypedArray()
            val minutes = array1[0] //得到分
            val s = ("0." + array1[1]).toDouble() * 60
            val seconds = s.toInt().toString() //得到秒
            return "$degrees°$minutes'$seconds\""
        }

        /**
         * 将度分秒转换成小数度数
         */
        @JvmStatic
        fun DMS2DDD(lng: String): Double {
            val lntArr = lng
                .trim { it <= ' ' }
                .replace("°", ";")
                .replace("′", ";")
                .replace("'", ";")
                .replace("\"", "")
                .split(";").toTypedArray()
            var result = 0.0
            for (i in lntArr.size downTo 1) {
                val v = lntArr[i - 1].toDouble()
                result = if (i == 1) {
                    v + result
                } else {
                    (result + v) / 60
                }
            }
            return result
        }
    }
}