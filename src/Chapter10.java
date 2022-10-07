import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chapter10 {

	public static void main(String[] args) {
	
		List<Task> list = new ArrayList<Task>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "〇〇社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));
		
		// 未完了のタスクを抽出
		int result = (int) list.stream()
							.filter(l -> l.isDone() == false)
							.count();
		System.out.println("未完了のタスクの個数は" + result);
		
		System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
		
		list.stream()
			.filter(l -> l.isDone() == false)
			.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
			.forEach(System.out::println);
	}
	
}
