package entity;
/*
������ԣ����е��ˣ�˫�ˣ����˵ȷ���
 */

import java.util.*;

public class GroupStrategy {
    private static GroupStrategy instance = null;
	private static final int number1 = 60;
	// ���ڼ�¼������Ϣ
    static List<Competitor> list = new ArrayList<>();

    //����ģʽ
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
		// ��̬����������
		PlayerSelect.getInstance();
		map.putAll(PlayerSelect.dictionary);

		Random random = new Random();
		int count = 1;

		switch (number) {
		// �����������
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
		// ˫���������

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

		// �����������
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
			// �����������
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
			System.out.println("�����������ķ���");
		}

	}

}
