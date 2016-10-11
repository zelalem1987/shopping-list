package com.gcit.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {

	List<String> itemList = new ArrayList<String>(Arrays.asList("Milk", "Bread"));

	@RequestMapping(value = "/getList", method = RequestMethod.GET, produces = "application/json")
	public List<String> getItemList() {
		return itemList;
	}

	@RequestMapping(value = "/postList", method = RequestMethod.POST, 
			consumes = "application/json")
	public void addItem(@RequestBody String itemName) {
		try{
			itemList.add(itemName);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/deleteList", method = RequestMethod.POST, 
			consumes = "application/json")
	public void deleteItem(@RequestBody int itemIndex) {
		try{
			itemList.remove(itemIndex);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
