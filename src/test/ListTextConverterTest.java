package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import myfridge.Item;
import myfridge.ListTextConverter;

public class ListTextConverterTest {

	private static ListTextConverter converter = new ListTextConverter();

	public static void main(String[] args) {
		testWrite();
		testRead();
	}

	// テキストファイルへの書き込みテスト
	private static void testWrite() {
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(new Date(), "ほうれん草"));
		itemList.add(new Item(new Date(), "モロヘイヤ"));
		itemList.add(new Item(new Date(), "キャベツ"));
		converter.write(itemList);
	}

	// テキストファイルの読み込みテスト
	private static void testRead() {
		List<Item> list =  converter.read();

		for(Item item : list) {
			System.out.println(item.getExpDate());
			System.out.println(item.getName());
		}
	}

}
