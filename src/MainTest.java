import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public class MainTest {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
 
       
		Class c1=Class.forName("designMode.watcherPattern.Police");
		
		
		Class c=Thread.currentThread().getContextClassLoader().loadClass("designMode.watcherPattern.Police");
		Object o=c.newInstance();
		Method m=c.getMethod("action", null);
		o=m.invoke(o, null);
//		Class clazz = Class.forName("entity.User");
//		Object obj = clazz.newInstance();// 获得类的实例
//		// 获得 User 类中的指定属性对应的Field对象（每个属性对应一个Field对象）
//		Field field = clazz.getDeclaredField("name");
//
//		// 取消属性的访问权限控制，即使private 属性也可以进行访问
//		field.setAccessible(true);
//		// 调用 getter 方法获取属性值
//		System.out.println(field.get(obj));
//		// 调用setter 方法给属性赋值
//		field.set(obj, "scott");
//		// 调用 getter 方法获取对应属性修改后的值
//		System.out.println(field.get(obj));
	}

	static void changeRef(MainTest t) {
		System.out.println(t);
		t = new MainTest();
		System.out.println(t);
	}

	private int i;

	void set(MainTest m) {
		i = m.i;
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int middle = (start + end) / 2;
		mergeSort(arr, start, middle);
		mergeSort(arr, middle + 1, end);
		merge(arr, start, end, middle);

	}

	public static void merge(int[] arr, int start, int end, int middle) {
		int[] temp = new int[end - start + 1];
		int i = start, j = middle + 1, index = 0;
		while (i <= middle && j <= end) {
			if (arr[i] > arr[j]) {
				temp[index++] = arr[j++];
			} else {
				temp[index++] = arr[i++];
			}
		}
		while (i <= middle) {
			temp[index++] = arr[i++];
		}
		while (j <= end) {
			temp[index++] = arr[j++];
		}
		System.arraycopy(temp, 0, arr, start, temp.length);
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (arr == null || start > end)
			return;
		int left = start, right = end, k = start;
		while (left < right) {
			while (left < right && arr[right] > arr[left])
				right--;
			if (left < right) {
				arr[left] = arr[left] + arr[right];
				arr[right] = arr[left] - arr[right];
				arr[left] = arr[left] - arr[right];
				left++;
				k = right;
			}
			while (left < right && arr[left] <= arr[right])
				left++;
			if (left < right) {
				arr[left] = arr[left] + arr[right];
				arr[right] = arr[left] - arr[right];
				arr[left] = arr[left] - arr[right];
				right--;
				k = left;
			}
		}
		if (start < k)
			quickSort(arr, start, k - 1);
		if (k < end)
			quickSort(arr, k + 1, end);

	}

}
