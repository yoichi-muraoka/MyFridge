package myfridge;

import java.util.Scanner;

/**
 * 各画面の生成(標準入出力)を担うクラス
 */
public class UserInterface {

	private Scanner scanner;

	public UserInterface() {
		scanner = new Scanner(System.in);
	}

	/**
	 * ユーザーの選択した番号に応じて、各画面を呼び出す
	 */
	public void run() {
		boolean loopFlag = true;
		while(loopFlag) {
			// ユーザーに操作を選択させる
			System.out.println("何をしますか？");
			System.out.println("1:冷蔵庫の中身を見る  2:賞味期限切れ一覧  3:追加  4:削除  5:終了");

			String strChoice = scanner.nextLine();

			// 入力された番号を整数に変換
			int choice;
			try {
				choice = Integer.parseInt(strChoice);
			}
			catch(NumberFormatException e) {
				// 変換できなかった場合、「5:終了」とする
				choice = 5;
			}

			// 番号に応じて画面を呼び出す
			switch(choice) {
			case 1:
				showItems();
				break;
			case 2:
				showExpiredItems();
				break;
			case 3:
				addItem();
				break;
			case 4:
				deleteItem();
				break;
			default:
				System.out.println("システムを終了しました");
				scanner.close();
				loopFlag = false;
			}
			System.out.println("======================\n");
		}
	}


	/**
	 * アイテム一覧表示画面の生成を担うメソッド
	 */
	private void showItems() {
		System.out.println("冷蔵庫の中身 [賞味期限]");
		System.out.println("-----------------------");

		// 仮データの出力
		System.out.println("0：牛乳 [9/23]");
		System.out.println("1：納豆 [9/25]");
		System.out.println("2：もずく [9/27]");
		System.out.println("3：たまご [9/28]");
		System.out.println("4：チーズ [9/28]");
	}


	/**
	 * 賞味期限切れ一覧画面の生成を担うメソッド
	 */
	private void showExpiredItems() {
		System.out.println("賞味期限切れ一覧");
		System.out.println("-----------------------");

		// 仮データの出力
		System.out.println("牛乳 [9/23]");
		System.out.println("納豆 [9/25]");
	}


	/**
	 * アイテム追加画面の生成を担うメソッド
	 * ユーザーから、アイテム名と賞味期限の入力を受け付ける
	 */
	private void addItem() {
		System.out.println("何を冷蔵庫に入れますか？");
		String name = scanner.nextLine();

		System.out.println("賞味期限は何日後ですか？");
		String strDays = scanner.nextLine();

		// 賞味期限の日数を整数に変換
		int days;
		try {
			days = Integer.parseInt(strDays);
		}
		catch(NumberFormatException e) {
			// 例外が発生した場合、賞味期限は7日に設定
			days = 7;
		}

		// 保存処理(テキストファイルへの書き込み)

		System.out.println(name + "を冷蔵庫に入れました");
		System.out.println("賞味期限を" + days + "日後に設定しました");
	}


	/**
	 * アイテム削除画面の生成を担うメソッド
	 * ユーザーから削除対象のアイテム番号(Listのインデックス番号)の入力を受け付ける
	 */
	private void deleteItem() {
		System.out.println("何番のアイテムを削除しますか？");
		System.out.println("キャンセルの場合、適当なアルファベットを入力してください");
		String strIndex = scanner.nextLine();

		try {
			int index = Integer.parseInt(strIndex);
			System.out.println(index + "番のアイテムを削除しました");
		}
		catch(NumberFormatException e) {
			System.out.println("削除をキャンセルしました");
		}
	}

}
