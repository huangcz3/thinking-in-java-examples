package com.thinking.chapter1;


/**
 * @author Huangcz
 * @date 2018-12-29 10:44
 * @desc 1.维护一个容量为k的小顶堆，堆中的k个节点代表着当前最大的k个元素，而堆顶显然是这k个元素中的最小值。
 * 2.遍历原数组，每遍历一个元素，就和堆顶比较，如果当前元素小于等于堆顶，则继续遍历；如果元素大于堆顶，则把当前元素放在堆顶位置，并调整二叉堆（下沉操作）。
 * 3.遍历结束后，堆顶就是数组的最大k个元素中的最小值，也就是第k大元素。
 */
public class Cal {

	/**
	 * 寻找第k大的元素
	 *
	 * @param array 待调整的堆
	 * @param k     第几大
	 */

	public static int findNumberK(int[] array, int k) {

		//1.用前k个元素构建小顶堆
		buildHeap(array, k);
		//2.继续遍历数组，和堆顶比较
		for (int i = k; i < array.length; i++) {
			if (array[i] > array[0]) {
				array[0] = array[i];
				downAdjust(array, 0, k);
			}
		}
		//3.返回堆顶元素
		return array[0];

	}


	/**
	 * 构建堆
	 *
	 * @param array  待调整的堆
	 * @param length 堆的有效大小
	 */

	private static void buildHeap(int[] array, int length) {

		// 从最后一个非叶子节点开始，依次下沉调整
		for (int i = (length - 2) / 2; i >= 0; i--) {
			downAdjust(array, i, length);
		}
	}


	/**
	 * 下沉调整
	 *
	 * @param array  待调整的堆
	 * @param index  要下沉的节点
	 * @param length 堆的有效大小
	 */

	private static void downAdjust(int[] array, int index, int length) {

		// temp保存父节点值，用于最后的赋值
		int temp = array[index];

		int childIndex = 2 * index + 1;
		while (childIndex < length) {
			// 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
			if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
				childIndex++;
			}
			// 如果父节点小于任何一个孩子的值，直接跳出
			if (temp <= array[childIndex])
				break;

			//无需真正交换，单向赋值即可
			array[index] = array[childIndex];
			index = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		array[index] = temp;
	}


	public static void main(String[] args) {
		int[] array = new int[]{7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};

		System.out.println(findNumberK(array, 5));
	}
}
