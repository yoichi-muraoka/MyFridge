package myfridge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * アイテムを操作するためのクラス
 * (ItemServiceインターフェースの実装)
 */
public class ItemServiceImpl implements ItemService {

	private ListTextConverter converter;
	private Date today; // 今日の日付(賞味期限切れ確認用)

	public ItemServiceImpl() {
		converter = new ListTextConverter();

		// 現在日時から時間を切り捨てて「今日の日付」として設定
		// 参考：https://teratail.com/questions/1123
		var sdf = new SimpleDateFormat("yyyy/MM/dd");
		String strToday = sdf.format(new Date());
		try {
			today = sdf.parse(strToday);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
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
			if(isExpired(item.getExpDate())) {
				expiredList.add(item);
			}
		}

		return expiredList;
	}


	/**
	 * アイテムを追加
	 */
	@Override
	public void addItem(Item item) {
		// 全アイテムのリストを取得
		List<Item> list = converter.read();
		// リストの末尾に、引数として渡されたアイテムを追加
		list.add(item);
		// リストをテキストに書き込んで更新
		converter.write(list);
	}


	/**
	 * アイテムを削除
	 */
	@Override
	public void deleteItem(int index) {
		// 全アイテムのリストを取得
		List<Item> list = converter.read();
		// インデックス番号を元に、リストからアイテムを削除
		list.remove(index);
		// リストをテキストに書き込んで更新
		converter.write(list);
	}


	/**
	 * 参考：https://www.sejuku.net/blog/20714
	 *
	 * 賞味期限切れか否か判断する(賞味期限と現在の日付を比較)
	 * @param expDate 賞味期限
	 * @return 期限切れの場合、trueを返す
	 */
	private boolean isExpired(Date expDate) {
		return expDate.compareTo(today) == -1;
	}

}

	/**
	*追記
	 */