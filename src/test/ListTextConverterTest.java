package test;

import myfridge.ListTextConverter;

public class ListTextConverterTest {

	private static ListTextConverter converter = new ListTextConverter();

	public static void main(String[] args) {
		testRead();
	}

	// テキストファイルの読み込みテスト
	private static void testRead() {
		converter.read();
	}

}
