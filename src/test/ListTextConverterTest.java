package test;

import java.util.List;

import myfridge.Item;
import myfridge.ListTextConverter;

public class ListTextConverterTest {

	private static ListTextConverter converter = new ListTextConverter();

	public static void main(String[] args) {
		testRead();
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
