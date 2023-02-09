package com.example.leecodetest

/**
 * author：null
 * date：2023/02/09
 * description：null
 */
class LeeCode {
    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。

    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    示例 2：
    输入：nums = [3,2,4], target = 6
    输出：[1,2]

    示例 3：
    输入：nums = [3,3], target = 6
    输出：[0,1]
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indexArray = IntArray(2)
        val hashMap = HashMap<Int,Int>()
        run let@{
            nums.forEachIndexed{index,num->
                val temp:Int = target - num
                if(hashMap.containsKey(temp)) {
                    indexArray[0] = hashMap.getValue(temp)
                    indexArray[1] = index
                    return@let
                }
                hashMap[num] = index
            }
        }
        return indexArray
    }
    
    /**
     *
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。

    示例1:
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    示例 2:
    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    示例 3:
    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     */
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val charSet = HashSet<Char>()
        var left = 0
        var right = 0
        while (right < s.length) {
            if (!charSet.contains(s[right])) {
                charSet.add(s[right])
                right++
            } else {
                charSet.remove(s[left])
                left++
            }
            maxLength = Math.max(maxLength, charSet.size)
        }
        return  maxLength
    }

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
    算法的时间复杂度应该为 O(log (m+n)) 。

    示例 1：
    输入：nums1 = [1,3], nums2 = [2]
    输出：2.00000
    解释：合并数组 = [1,2,3] ，中位数 2

    示例 2：
    输入：nums1 = [1,2], nums2 = [3,4]
    输出：2.50000
    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val numOne = if(nums1.isNotEmpty()) nums1[0] else 0
        val numTwo = if(nums2.isNotEmpty()) nums2[0] else 0
        if (nums1.isEmpty()) {
            //直接计算nums2的
            return if (nums2.size == 1) {
                nums2[0].toDouble()
            } else {
                if (nums2.size % 2 == 0) {
                    //证明是偶数个，则取中间两个相加/2
                    (nums2[nums2.size / 2 - 1] + nums2[nums2.size / 2]) / 2.00
                } else {
                    nums2[nums2.size / 2].toDouble()
                }
            }
        }else if (nums2.isEmpty()) {
            //直接计算nums1的
            return if (nums1.size == 1) {
                nums1[0].toDouble()
            } else {
                if (nums1.size % 2 == 0) {
                    //证明是偶数个，则取中间两个相加/2
                    (nums1[nums1.size / 2 - 1] + nums1[nums1.size / 2]) / 2.00
                } else {
                    nums1[nums1.size / 2].toDouble()
                }
            }
        } else {
            //两个都不为空
            // 把两个数组合成一个，排序
            val newArray = IntArray(nums1.size + nums2.size)
            for (index in 0 until nums1.size + nums2.size) {
                if (index >= nums1.size) {
                    newArray[index] = nums2[index - nums1.size]
                } else {
                    newArray[index] = nums1[index]
                }
            }
            //获取完整的新数组，进行排序
            
            return 0.0
        }
    }
}
