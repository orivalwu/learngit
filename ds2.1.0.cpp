#include <stdio.h>
#define M 5
#define N 10
int main()
{
	int k=N-M;
	int j;
	int array1[M]={4,6,8,1,3};
	int array2[N]={1,4,52,13,75};
	printf("数组array1中的元素为：\n");
	
	for (int i = 0; i <M; i++)
	{
		printf("%d,",array1[i]);//输出array1中的元素 
	}
	printf("\n");
	printf("数组array2中的元素为：\n");
	for (int i = 0; i <N-M; i++)
	{
		printf("%d,",array2[i]);//输出array2中的元素 
	}
	printf("\n");
	for (int i = 0; i < M; i++)
	{
		for ( j = 0; j <N-M; j++)
			if (array1[i] == array2[j])
			break;//将array1中各个元素和array2中所有元素进行比较 ,若出现有相同的元素，则结束循化 
		if(j==5)
		{
			array2[k]= array1[i];
			k++;//若array2中没有array1中的元素，那么上面的for循环的结束条件是到j=5,这是满足if的 
		}        // 条件，会将array1中的元素赋给array2中下标为5及之后的元素
	}
	printf("两个线性表合并后的结果为：\n" );
	for (int i = 0; i < k; i++)
	{
		printf("%d,",array2[i] );//输出array2中的元素 
	}
	return 0;
}
