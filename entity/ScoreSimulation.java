package entity;
/*
���ڼ�¼ÿһ������ѡ����һ�֣�10�֣������л�����ƿ�ӵ���Ŀ
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScoreSimulation {
	
	List<ScoringInformation>list = new ArrayList<>();
	
	public ScoreSimulation() {
		play();
	}
	

	public void play() {
		
		for(int i= 1; i<11;i++) {
			int temp1=0;
			int temp2=0;
			Random random = new Random();
			ScoringInformation sf = new ScoringInformation();
			for(int j =0;j<2;j++) {
				temp1 = random.nextInt(10);
				sf.setNumber1(temp1);
				if(temp1 == 10) {
					break;
				}
				else {
					temp2 = random.nextInt(10-temp1);
					sf.setNumber2(temp2);
					sf.setNumber3(0);
				}
				
			}
			if(i==10) {
				if(temp1==10) {
					int temp3 = random.nextInt(10);
					sf.setNumber2(temp3);
					int temp4 = random.nextInt(10);
					sf.setNumber3(temp4);	
				}
				if(temp1+temp2==10) {
					int temp3 = random.nextInt(10);
					sf.setNumber3(temp3);
				}
			}
			list.add(sf);
		}
	}
	
	
	

}
