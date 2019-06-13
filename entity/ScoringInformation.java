package entity;
/*
 * 计分系统，记录每一名选手一局比赛中的每一轮击倒的瓶数
 */
public class ScoringInformation {
	//该轮总得分数
	private int amount;
	//每一轮第一次击倒的瓶数
	private int number1;
	//每一轮第二次击倒的瓶数
	private int number2;
	//第十轮第三次击倒的瓶数
	private int number3;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	
	public int getNumber3() {
		return number3;
	}
	public void setNumber3(int number3) {
		this.number3 = number3;
	}
	
	
	

}
