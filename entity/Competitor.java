package entity;

import java.util.List;
/*
 * ������Ա��Ϣ
 */
public class Competitor {
    //ÿ��10��
    private static final int rounds = 10;

	//����
	private String name;
	//���
	private int number;
	//���
	private String group;
	//�ܵ÷�
    private int totalScore;
    //�ִ�
    private List<Integer> roundCount;
    //ÿ�ֵ÷�
    private List<Integer>roundScore;
    //����
    private int lever;

    public int getlever() {
        return lever;
    }

    public void setlever(int lever) {
        this.lever = lever;
    }

    public Competitor() {

    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Integer> getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(List<Integer> round) {
        this.roundScore = round;
    }

    public List<Integer> getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(List<Integer> roundCount) {
        this.roundCount = roundCount;
    }


    @Override
	public String toString() {
		return " ��ţ�" + number + ", ������" + name + ", �÷�:" + totalScore+", ���:" + group ;
	}
	
	

}
