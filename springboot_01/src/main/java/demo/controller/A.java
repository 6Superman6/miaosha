package demo.controller;


public class A {
    static int number=0;
    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
        printArray("排序前：",a);
        MergeSort(a);
        printArray("排序后：",a);
    }

    private static void printArray(String pre,int[] a) {
        System.out.print(pre+"\n");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"\t");
        System.out.println();
    }

    private static void MergeSort(int[] a) {
        System.out.println("开始排序");
        Sort(a, 0, a.length - 1);
    }

    private static void Sort(int[] a, int left, int right) {
        if(left>=right)
            return;

        int mid = (left + right) / 2;
        Sort(a, left, mid);
        Sort(a, mid + 1, right);
        merge(a, left, mid, right);

    }

    private static void merge(int[] a, int left, int mid, int right) {

        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex=left;

        while(left <=mid && r1 <= right)
        {
            if (a[left] <= a[r1])
                tmp[tIndex++] = a[left++];
            else
                tmp[tIndex++] = a[r1++];
        }
        while (left <=mid)
        {
            tmp[tIndex++] = a[left++];
        }
        while ( r1 <= right )
        {
            tmp[tIndex++] = a[r1++];
        }
        System.out.println("第"+(++number)+"趟排序:\t");
        while(cIndex<=right)
        {
            a[cIndex]=tmp[cIndex];
            System.out.print(a[cIndex]+"\t");
            cIndex++;
        }
        System.out.println();
    }


}
