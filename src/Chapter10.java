import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Chapter10 {
    public static void main(String[] args) throws Exception {
        List<Task> list = new ArrayList<>();
        list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
        list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
        list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
        list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
        list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

        // 未完了のタスクの個数を数える
        long falseCount = list.stream()							// ストリーム生成
                         .filter(task -> task.isDone()==false) 	// 中間操作：未完了タスクを抽出
                         .count(); 								// 終端処理：未完了のタスクの個数を数える
        System.out.println("未完了のタスクの個数は" + falseCount);

        System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
        
        // 未完了のタスクを日時の昇順に並べて表示
        list.stream()										// ストリーム生成
            .filter(task -> task.isDone()==false)			// 中間操作：未完了タスクを抽出
            .sorted(Comparator.comparing(Task::getDate)) 	// 中間操作：日時の昇順に並べ替え（メソッド参照）
            .forEach(System.out::println); 					// 終端操作：各タスクをコンソールに表示（メソッド参照）
    }
}