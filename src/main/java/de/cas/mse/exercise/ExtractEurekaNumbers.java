package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class ExtractEurekaNumbers {

	public List<Long> extractEurekaNumbers(long intervalBegin, long intervalEnd) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long i = intervalBegin; i < intervalEnd; i++) {

			List<Long> digits = this.splitNumberIntoDigits(i);
			
			long sum = this.calcPotentialEurekaNumber(digits);

			this.checkEurekaNumber(eurekaNumbers, sum, i);
		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;

	}

	private List<Long> splitNumberIntoDigits(long number) {
		String temp = Long.toString(number);
		List<Long> digits = new ArrayList<Long>();

		for (int i = 0; i < temp.length(); i++) {
			digits.add(Long.valueOf(temp.substring(i, i + 1)));
		}
		return digits;
	}

	private long calcPotentialEurekaNumber(List<Long> digits) {
		long sum = 0;
		for (int i = 1; i <= digits.size(); i++) {
			sum += Math.pow(digits.get(i - 1), i);
		}
		return sum;
	}

	private void checkEurekaNumber(List<Long> result, long sum, long initialNumber) {
		if (sum == initialNumber) {
			result.add(sum);
		}
	}

}