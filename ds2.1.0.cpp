#include <stdio.h>
#define M 5
#define N 10
int main()
{
	int k=N-M;
	int j;
	int array1[M]={4,6,8,1,3};
	int array2[N]={1,4,52,13,75};
	printf("����array1�е�Ԫ��Ϊ��\n");
	
	for (int i = 0; i <M; i++)
	{
		printf("%d,",array1[i]);//���array1�е�Ԫ�� 
	}
	printf("\n");
	printf("����array2�е�Ԫ��Ϊ��\n");
	for (int i = 0; i <N-M; i++)
	{
		printf("%d,",array2[i]);//���array2�е�Ԫ�� 
	}
	printf("\n");
	for (int i = 0; i < M; i++)
	{
		for ( j = 0; j <N-M; j++)
			if (array1[i] == array2[j])
			break;//��array1�и���Ԫ�غ�array2������Ԫ�ؽ��бȽ� ,����������ͬ��Ԫ�أ������ѭ�� 
		if(j==5)
		{
			array2[k]= array1[i];
			k++;//��array2��û��array1�е�Ԫ�أ���ô�����forѭ���Ľ��������ǵ�j=5,��������if�� 
		}        // �������Ὣarray1�е�Ԫ�ظ���array2���±�Ϊ5��֮���Ԫ��
	}
	printf("�������Ա�ϲ���Ľ��Ϊ��\n" );
	for (int i = 0; i < k; i++)
	{
		printf("%d,",array2[i] );//���array2�е�Ԫ�� 
	}
	return 0;
}
