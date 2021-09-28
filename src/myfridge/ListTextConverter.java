package myfridge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * List<Item> と items.txt の相互変換を担うクラス
 */
public class ListTextConverter {

	private SimpleDateFormat sdf; //日付の形式

	public ListTextConverter() {
		// 文字列 ⇔ Date型の相互変換用フォーマッター
		sdf = new SimpleDateFormat("y年MM月dd日");
	}


	/**
	 * items.txtを読み込み、List<Item>に変換する
	 * @return アイテムのリスト
	 */
	public List<Item> read() {
		List<Item> list = new ArrayList<>();

		// テキストファイルの読み込み
		try {
			InputStream is = new FileInputStream("items.txt");
			try(var br = new BufferedReader(new InputStreamReader(is))) {
				String line;
				while((line = br.readLine()) != null) {
					// 半角スペースを区切りとして配列に変換
					String[] item = line.split(" ");
					// 文字列の日付をDate型への変換しつつ、Listに追加
					list.add(new Item(sdf.parse(item[0]), item[1]));
				}
			}
			catch (ParseException e) {
				e.printStackTrace();
				System.out.println("データの読み込みに失敗しました");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("データの読み込みに失敗しました");
		}

		return list;
	}


	/**
	 * List<Item>の情報(賞味期限とアイテム名)をitems.txtに書き込む
	 * @param itemList アイテムのリスト
	 */
	public void write(List<Item> itemList) {
		itemList = new ArrayList<>();
		itemList.add(new Item(new Date(), "豚肉"));
		itemList.add(new Item(new Date(), "鶏肉"));
		itemList.add(new Item(new Date(), "牛肉"));

		try(var ps = new PrintStream("items.txt")) {
			for(Item item :  itemList) {
				ps.println(sdf.format(item.getExpDate()) + " " + item.getName());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("データの書き込みに失敗しました");
		}
	}

}
