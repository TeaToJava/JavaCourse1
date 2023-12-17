package com.javacourse.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

	public static void main(String... args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к
		// большей).
		List<Transaction> transactions2011 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

		// 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
		List<String> distinctCities = transactions.stream().map(t -> t.getTrader().getCity()).distinct()
				.collect(Collectors.toList());

		// 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
		List<Trader> tradersFromCambridge = transactions.stream().map(t -> t.getTrader()).distinct()
				.filter(t -> t.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());

		// 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
		// порядке.
		String traderNames = transactions.stream().map(t -> t.getTrader()).distinct().map(t-> t.getName()).sorted()
				.collect(Collectors.joining(" "));

		// 5. Выяснить, существует ли хоть один трейдер из Милана.
		Optional<Trader> traderFromMilan = transactions.stream().map(t -> t.getTrader())
				.filter(t -> t.getCity().equals("Milan")).findAny();

		// 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
		List<Integer> valuesOfTransactionsFromCambridge = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue)
				.collect(Collectors.toList());

		// 7. Какова максимальная сумма среди всех транзакций?
		Optional<Integer> maxSum = transactions.stream().map(Transaction::getValue).max(Comparator.naturalOrder());

		// 8. Найти транзакцию с минимальной суммой.
		Optional<Transaction> transactionWithMinValue = transactions.stream()
				.min(Comparator.comparing(Transaction::getValue));

	}
}