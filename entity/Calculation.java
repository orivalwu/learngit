package entity;
/*
����ÿһ��ѡ��ÿһ�ֵĵ÷����
 */

public class Calculation {
	
	private int score;
	
	
	public int getScore() {
		return score;
	}


	public void calcScore() {
		//����һ��ScoreSimulation����,������ÿһλѡ��һ�ֱ�����ÿ�ֻ���ƿ�ĸ���
		ScoreSimulation score = new ScoreSimulation();
		//���ܷ��ȼ�Ϊ0
		int totalScore = 0;
		//����ÿһ�ֵĻ�����ƿ��������ÿһ�ֵķ���
		for(int i=0;i<10;i++) {
			if(i!=9) {
				if(score.list.get(i).getNumber1()==10) {
					score.list.get(i).setAmount(10+score.list.get(i+1).getNumber1()+score.list.get(i+1).getNumber2());
				}
				else if(score.list.get(i).getNumber1()+score.list.get(i).getNumber2()==10) {
					score.list.get(i).setAmount(10+score.list.get(i+1).getNumber1());
				}
				else
					score.list.get(i).setAmount(score.list.get(i).getNumber1()+score.list.get(i).getNumber2());
			}
			else {
				score.list.get(i).setAmount(score.list.get(i).getNumber1()+score.list.get(i).getNumber2()
						+score.list.get(i).getNumber3());
			}
		}
		
		for(int i=0; i<10;i++) {
			totalScore+=score.list.get(i).getAmount();
		}
		this.score = totalScore;
		
	}


	public Calculation() {
	}

}
