# 算法总结

## 排序算法

### 快速排序
```java
public class PuickSort {


    //arr 需要排序的数组

    //low 开始时最左边的索引 = 0

    //high 开始时最右边的索引 = arr.length - 1
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, z,y;
        if (low > high) {
            return;
        }
        i = low;//左边哨兵的索引
        j = high;//右边哨兵的索引
        //temp就是基准位
        temp = arr[low];//以最左边为 基准位

        while (i < j) {
            //先看右边，依次往左递减
            //先从右往左找一个小于 基准位的数
            //当右边的哨兵位置所在的数 > 基准位的数 时
            //继续从右往左找（同时 j 索引 - 1）
            //找到后会跳出 while循环
            while (temp <= arr[j] && i < j) {
                j--;
            }

            //再看左边，依次往右递增
            //步骤和上面类似
            while (temp >= arr[i] && i < j) {
                i++;
            }

            //如果满足条件则交换
            if (i < j) {

                //z、y 都是临时参数，用于存放 左右哨兵 所在位置的数据
                z = arr[i];
                y = arr[j];

                //左右哨兵 交换数据（互相持有对方的数据）
                arr[i] = y;
                arr[j] = z;

            }

        }

        //这时 跳出了 “while (i < j) {}”循环
        //说明 i = j 左右在同一位置
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];//或 arr[ low] =arr[j];
        arr[i] = temp;//或 arr[ j] =temp;


        //i = j
        //这时 左半数组<(i或j所在索引的数) < 右半数组
        //也就是说(i或j所在索引的数) 已经确定排序位置，所以就不用再排序了，
        //只要用相同的方法 分别处理 左右数组就可以了

        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```
 
## 查找算法 

### 递归二分查找
```java
//注意：使用二分查找的前提是 该数组是有序的.
public class BinarySearch {

	public static void main(String[] args) {
		//int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13,14,15,16,17,18,19,20 };
		

		//
//		int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
//		System.out.println("resIndex=" + resIndex);
		
		List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1);
		System.out.println("resIndexList=" + resIndexList);
	}

	// 二分查找算法
	/**
	 * 
	 * @param arr
	 *            数组
	 * @param left
	 *            左边的索引
	 * @param right
	 *            右边的索引
	 * @param findVal
	 *            要查找的值
	 * @return 如果找到就返回下标，如果没有找到，就返回 -1
	 */
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		

		// 当 left > right 时，说明递归整个数组，但是没有找到
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // 向 右递归
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 向左递归
			return binarySearch(arr, left, mid - 1, findVal);
		} else {
			
			return mid;
		}

	}
	
	/*
	 *{1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
	 * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
	 * 
	 * 思路分析
	 * 1. 在找到mid 索引值，不要马上返回
	 * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
	 * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
	 * 4. 将Arraylist返回
	 */

	public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

		System.out.println("hello~");
		// 当 left > right 时，说明递归整个数组，但是没有找到
		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // 向 右递归
			return binarySearch2(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 向左递归
			return binarySearch2(arr, left, mid - 1, findVal);
		} else {
//			 * 思路分析
//			 * 1. 在找到mid 索引值，不要马上返回
//			 * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 4. 将Arraylist返回
			
			List<Integer> resIndexlist = new ArrayList<Integer>();
			//向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
			int temp = mid - 1;
			while(true) {
				if (temp < 0 || arr[temp] != findVal) {//退出
					break;
				}
				//否则，就temp 放入到 resIndexlist
				resIndexlist.add(temp);
				temp -= 1; //temp左移
			}
			resIndexlist.add(mid);  //
			
			//向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
			temp = mid + 1;
			while(true) {
				if (temp > arr.length - 1 || arr[temp] != findVal) {//退出
					break;
				}
				//否则，就temp 放入到 resIndexlist
				resIndexlist.add(temp);
				temp += 1; //temp右移
			}
			
			return resIndexlist;
		}

	}
}


```

### 非递归二分查找

```java

public class BinarySearchNoRecur {

	public static void main(String[] args) {
		//测试
		int[] arr = {1,3, 8, 10, 11, 67, 100};
		int index = binarySearch(arr, 100);
		System.out.println("index=" + index);//
	}
	
	//二分查找的非递归实现
	/**
	 * 
	 * @param arr 待查找的数组, arr是升序排序
	 * @param target 需要查找的数
	 * @return 返回对应下标，-1表示没有找到
	 */
	public static int binarySearch(int[] arr, int target) {
		
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) { //说明继续查找
			int mid = (left + right) / 2;
			if(arr[mid] == target) {
				return mid;
			} else if ( arr[mid] > target) {
				right = mid - 1;//需要向左边查找
			} else {
				left = mid + 1; //需要向右边查找
			}
		}
		return -1;
	}

}

```



