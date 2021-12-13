package test;

import java.util.Arrays;

public class FlatMap {
	public static void main(String[] args) {
		String[][] namesArray = new String[][] { { "kim", "taeng" }, { "mad", "play" } };

		// flatMap
		Arrays.stream(namesArray).flatMap(inner -> Arrays.stream(inner)).filter(name -> name.equals("taeng"))
				.forEach(System.out::println);

		// map
		Arrays.stream(namesArray).map(inner -> Arrays.stream(inner))
				.forEach(names -> names.filter(name -> name.equals("taeng")).forEach(System.out::println));
	}
}
