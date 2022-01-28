package myfridge;

import java.util.Date;

/**
 * 賞味期限、アイテム名を保持するためのフィールドをもつクラス
 * ⇒ DTO (Data Transfer Object)としての役割を担う
 * 追記XXXX
 */
public class Item {

	private Date expDate; //賞味期限(Expiration Date)
	private String name;  //アイテム名

	//コンストラクタ
	public Item(Date expDate, String name) {
		this.expDate = expDate;
		this.name = name;
	}

	// アクセッサ
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
