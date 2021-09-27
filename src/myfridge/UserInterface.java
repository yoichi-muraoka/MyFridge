package myfridge;

import java.util.Scanner;

/**
 * 各画面の生成(標準入出力)を担うクラス
 */
public class UserInterface {

	/**
	 * ユーザーの選択した番号に応じて、各画面を呼び出す
	 */
	public void run() {
		boolean loopFlag = true;
		while(loopFlag) {
			// ユーザーに操作を選択させる
			System.out.println("何をしますか？");
			System.out.println("1:冷蔵庫の中身を見る  2:賞味期限切れ一覧  3:追加  4:削除  5:終了");

			var scanner = new Scanner(System.in);
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
		}
	}


	/**
	 * アイテム一覧表示画面の生成を担うメソッド
	 */
	private void showItems() {
		System.out.println("アイテム一覧");
	}


	/**
	 * 賞味期限切れ一覧画面の生成を担うメソッド
	 */
	private void showExpiredItems() {
		System.out.println("賞味期限切れ一覧");
	}


	/**
	 * アイテム追加画面の生成を担うメソッド
	 * ユーザーから、アイテム名と賞味期限の入力を受け付ける
	 */
	private void addItem() {
		System.out.println("アイテム追加");
	}

	/**
	 * アイテム削除画面の生成を担うメソッド
	 * ユーザーから削除対象のアイテム番号(Listのインデックス番号)の入力を受け付ける
	 */
	private void deleteItem() {
		System.out.println("アイテム削除");
	}

}
