package entity;
/*
分组策略，进行单人，双人，三人等分组
 */

import java.util.*;

public class GroupStrategy {
    private static GroupStrategy instance = null;
	private static final int number1 = 60;
	// 用于记录分组信息
    static List<Competitor> list = new ArrayList<>();

    //单例模式
    private GroupStrategy(){ }

    public static GroupStrategy getInstance(){
        if(instance == null){
            instance = new GroupStrategy();
        }
        return instance;
    }

    public static void clearInstance(){
		Iterator<Competitor> it = GroupStrategy.getList().iterator();
		while(it.hasNext()){
			Competitor a = it.next();
			it.remove();
		}
	}



	public static  List<Competitor> getList() {
		return list;
	}

	public void grouping(int number) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// 静态方法的运用
		PlayerSelect.getInstance();
		map.putAll(PlayerSelect.dictionary);

		Random random = new Random();
		int count = 1;

		switch (number) {
		// 单人随机分组
		case 1:
			while (!map.isEmpty()) {
				Competitor player = new Competitor();
				int temp = random.nextInt(number1) + 1;
				if (map.containsKey(temp)) {
					player.setGroup(String.valueOf(count));
					player.setNumber(temp);
					player.setName(map.get(temp));
					list.add(player);
					map.remove(temp);
					count++;
				}
			}
			break;
		// 双人随机分组

		case 2:
			while (!map.isEmpty()) {

				int []a = new int[2];
				for(int i=0;i<2;i++) {
					int temp1 = random.nextInt(number1) + 1;
					a[i]=temp1;
				}
				
				if (map.containsKey(a[0]) && map.containsKey(a[1]) && a[0] != a[1]) {
					for(int i=0;i<2;i++) {
						Competitor player = new Competitor();
						list.add(player);
					}
					for(int i=list.size()-1,j=0;i>=list.size()-2;i--,j++) {
						list.get(i).setGroup(count+"");
						list.get(i).setNumber(a[j]);
						list.get(i).setName(map.get(a[j]));
					}
					for(int i=0;i<a.length;i++) {
						map.remove(a[i]);
					}
					count++;
				}
			}
			break;

		// 三人随机分组
		case 3:
			while (!map.isEmpty()) {
				for (int i = map.size()-3;i>=0&&i<map.size(); ) {
					int temp = random.nextInt(number1) + 1;
					if (map.containsKey(temp)) {
						Competitor competitor = new Competitor();
						competitor.setNumber(temp);
						competitor.setName(map.get(temp));
						competitor.setGroup(String.valueOf(count));
						list.add(competitor);
						map.remove(temp);
					}
				}
				count++;
			}
			break;
			// 五人随机分组
		case 5:
			while (!map.isEmpty()) {
				for (int i = map.size()-5;i>=0&&i<map.size(); ) {
					int temp = random.nextInt(number1) + 1;
					if (map.containsKey(temp)) {
						Competitor competitor = new Competitor();
						competitor.setNumber(temp);
						competitor.setName(map.get(temp));
						competitor.setGroup(String.valueOf(count));
						list.add(competitor);
						map.remove(temp);
					}
				}
				count++;
			}
			break;
		default:
			System.out.println("不存在这样的分组");
		}

	}

}
