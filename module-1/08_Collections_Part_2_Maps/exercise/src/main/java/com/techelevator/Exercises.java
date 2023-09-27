package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		// Create a map to store the animal names and their corresponding group names
		Map<String, String> animalGroups = new HashMap<>();

		// Populate the map with animal names and group names
		animalGroups.put("rhino", "Crash");
		animalGroups.put("giraffe", "Tower");
		animalGroups.put("elephant", "Herd");
		animalGroups.put("lion", "Pride");
		animalGroups.put("crow", "Murder");
		animalGroups.put("pigeon", "Kit");
		animalGroups.put("flamingo", "Pat");
		animalGroups.put("deer", "Herd");
		animalGroups.put("dog", "Pack");
		animalGroups.put("crocodile", "Float");

		// Convert the animalName to lowercase for case-insensitive matching
		animalName = animalName.toLowerCase();

		// Check if the animalName exists in the map, and return its group name
		if (animalGroups.containsKey(animalName)) {
			return animalGroups.get(animalName);
		} else {
			// If not found, return "unknown"
			return "unknown";
		}
	}

	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		// Create a map to store item numbers and their corresponding discount percentages
		Map<String, Double> itemDiscounts = new HashMap<>();

		// Populate the map with item numbers and discount percentages
		itemDiscounts.put("kitchen4001", 0.20);
		itemDiscounts.put("garage1070", 0.15);
		itemDiscounts.put("livingroom", 0.10);
		itemDiscounts.put("kitchen6073", 0.40);
		itemDiscounts.put("bedroom3434", 0.60);
		itemDiscounts.put("bath0073", 0.15);

		// Convert the itemNumber to lowercase for case-insensitive matching
		itemNumber = itemNumber.toLowerCase();

		// Check if the itemNumber exists in the map, and return its discount percentage
		if (itemDiscounts.containsKey(itemNumber)) {
			return itemDiscounts.get(itemNumber);
		} else {
			// If not found, return 0.00
			return 0.00;
		}
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
	 * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		// Check if "Peter" has more than 0 money and "Paul" has less than $10
		if (peterPaul.containsKey("Peter") && peterPaul.containsKey("Paul")
				&& peterPaul.get("Peter") > 0 && peterPaul.get("Paul") < 1000) {
			// Calculate the amount to transfer (half of Peter's money)
			int transferAmount = peterPaul.get("Peter") / 2;

			// Update Peter's and Paul's balances
			peterPaul.put("Peter", peterPaul.get("Peter") - transferAmount);
			peterPaul.put("Paul", peterPaul.get("Paul") + transferAmount);
		}

		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		// Check if "Peter" has $50 or more and "Paul" has $100 or more
		if (peterPaul.containsKey("Peter") && peterPaul.containsKey("Paul")
				&& peterPaul.get("Peter") >= 5000 && peterPaul.get("Paul") >= 10000) {
			// Calculate the combined contribution (a quarter of each partner's current worth)
			int contribution = (peterPaul.get("Peter") + peterPaul.get("Paul")) / 4;

			// Update Peter's balance
			peterPaul.put("Peter", peterPaul.get("Peter") - contribution);

			// Update Paul's balance
			peterPaul.put("Paul", peterPaul.get("Paul") - contribution);

			// Create the "PeterPaulPartnership" entry
			peterPaul.put("PeterPaulPartnership", contribution);
		}

		return peterPaul;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where, for every String in the array,
	 * there is an entry whose key is the first character of the string.
	 *
	 * The value of the entry is the last character of the String. If multiple Strings start with the same letter, then the
	 * value for that key should be the later String's last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["code", "bug", "cat"]) → {"b": "g", "c": "t"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		// Create a map to store the first and last characters of each word
		Map<String, String> result = new HashMap<>();

		// Iterate through the array of words
		for (String word : words) {
			if (!word.isEmpty()) {
				// Get the first character of the word
				char firstChar = word.charAt(0);

				// Get the last character of the word
				char lastChar = word.charAt(word.length() - 1);

				// Add the entry to the map
				result.put(String.valueOf(firstChar), String.valueOf(lastChar));
			}
		}

		return result;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		// Create a map to store word counts
		Map<String, Integer> wordCounts = new HashMap<>();

		// Iterate through the array of words
		for (String word : words) {
			// Update the count for the word in the map
			wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
		}

		return wordCounts;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		// Create a map to store integer counts
		Map<Integer, Integer> integerCounts = new HashMap<>();

		// Iterate through the array of integers
		for (int num : ints) {
			// Update the count for the integer in the map
			integerCounts.put(num, integerCounts.getOrDefault(num, 0) + 1);
		}

		return integerCounts;
	}
		/*
		 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
		 * is true only if that String appears 2 or more times in the array.
		 *
		 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
		 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
		 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
		 *
		 */
		public Map<String, Boolean> wordMultiple(String[] words) {
			// Create a map to store word multiples (true if a word appears 2 or more times)
			Map<String, Boolean> wordMultiples = new HashMap<>();

			// Iterate through the array of words
			for (String word : words) {
				// Check if the word exists in the map and has appeared before
				if (wordMultiples.containsKey(word)) {
					// If yes, set it to true
					wordMultiples.put(word, true);
				} else {
					// If not, add it to the map with false
					wordMultiples.put(word, false);
				}
			}

			return wordMultiples;
		}



	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
													 Map<String, Integer> remoteWarehouse) {
		// Iterate through the entries in the remoteWarehouse and update the mainWarehouse
		for (Map.Entry<String, Integer> entry : remoteWarehouse.entrySet()) {
			// Add the quantity from the remoteWarehouse to the mainWarehouse
			mainWarehouse.put(entry.getKey(), mainWarehouse.getOrDefault(entry.getKey(), 0) + entry.getValue());
		}

		return mainWarehouse;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, its last2 count is the number of times that a subString length 2
	 * appears in the String and also as the last 2 chars of the String.
	 *
	 * We don't count the end subString, so "hixxxhi" has a last2 count of 1, but the subString may overlap a prior
	 * position by one.  For instance, "xxxx" has a count of 2: one pair at position 0, and the second at position 1.
	 * The third pair at position 2 is the end subString, which we don't count.
	 *
	 * Return a Map<String, Integer> where the keys are the Strings from the array and the values are the last2 counts.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		// Create a map to store last2 counts for each word
		Map<String, Integer> last2Counts = new HashMap<>();

		// Iterate through the array of words
		for (String word : words) {
			// Initialize the count to 0
			int count = 0;

			// Iterate through the characters of the word
			for (int i = 0; i < word.length() - 2; i++) {
				// Check if the substring of length 2 matches the last 2 characters of the word
				if (word.substring(i, i + 2).equals(word.substring(word.length() - 2))) {
					count++;
				}
			}

			// Add the entry to the map
			last2Counts.put(word, count);
		}

		return last2Counts;
	}
}