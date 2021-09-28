package myfridge;

import java.util.List;

/**
 * アイテムを操作するためのクラス
 * (ItemServiceインターフェースの実装)
 */
public class ItemServiceImpl implements ItemService {

	/**
	 * 全アイテムを取得
	 */
	@Override
	public List<Item> getItemList() {
		var converter = new ListTextConverter();
		return converter.read();
	}

	@Override
	public List<Item> getExpiredList() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void addItem(Item item) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteItem(int index) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
