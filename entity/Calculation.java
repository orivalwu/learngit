package entity;
/*
计算每一名选手每一局的得分情况
 */

public class Calculation {
	
	private int score;
	
	
	public int getScore() {
		return score;
	}


	public void calcScore() {
		//创建一个ScoreSimulation对象,用来得每一位选手一局比赛中每轮击中瓶的个数
		ScoreSimulation score = new ScoreSimulation();
		//将总分先计为0
		int totalScore = 0;
		//根据每一轮的击倒的瓶数来计算每一轮的分数
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
