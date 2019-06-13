package entity;

import java.util.List;
/*
 * 参赛人员信息
 */
public class Competitor {
    //每局10轮
    private static final int rounds = 10;

	//姓名
	private String name;
	//编号
	private int number;
	//组号
	private String group;
	//总得分
    private int totalScore;
    //轮次
    private List<Integer> roundCount;
    //每轮得分
    private List<Integer>roundScore;
    //排名
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
		return " 编号：" + number + ", 姓名：" + name + ", 得分:" + totalScore+", 组别:" + group ;
	}
	
	

}
