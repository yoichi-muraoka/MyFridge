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
