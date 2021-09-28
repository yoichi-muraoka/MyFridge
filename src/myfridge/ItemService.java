package myfridge;

import java.util.List;

/**
 * アイテムを操作するためのインターフェース
 */
public interface ItemService {

	List<Item> getItemList();     //全アイテムの取得
	List<Item> getExpiredList();  //賞味期限切れアイテムの取得
	void addItem(Item item);      //アイテムを追加
	void deleteItem(int index);   //アイテムを削除

}
