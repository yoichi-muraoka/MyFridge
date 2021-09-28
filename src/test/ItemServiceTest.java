package test;

import myfridge.Item;
import myfridge.ItemService;
import myfridge.ItemServiceImpl;

public class ItemServiceTest {

	private static ItemService service = new ItemServiceImpl();

	public static void main(String[] args) {
		testGetExpiredList();
	}

	private static void testGetExpiredList() {
		for(Item item : service.getExpiredList()) {
			System.out.println(item.getExpDate());
			System.out.println(item.getName());
		}
	}

}
