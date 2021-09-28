package myfridge;

import java.util.ArrayList;
import java.util.List;

/**
 * アイテムを操作するためのクラス
 * (ItemServiceインターフェースの実装)
 */
public class ItemServiceImpl implements ItemService {

	private ListTextConverter converter;

	public ItemServiceImpl() {
		converter = new ListTextConverter();
	}


	/**
	 * 全アイテムを取得
	 */
	@Override
	public List<Item> getItemList() {
		return converter.read();
	}


	/**
	 * 賞味期限切れアイテムの一覧を取得
	 */
	@Override
	public List<Item> getExpiredList() {
		// 賞味期限切れアイテムを格納するためのList
		List<Item> expiredList = new ArrayList<>();

		// 全アイテムのList
		List<Item> itemList = converter.read();

		// ①各アイテムを拡張for文で取り出し
		for(Item item : itemList) {
			// ②賞味期限切れの場合、expiredListに追加
		}

		return expiredList;
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
