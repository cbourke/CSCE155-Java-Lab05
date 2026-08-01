package unl.soc;

/**
 * This class is a test suite (a collection of unit tests) for methods in the
 * {@link ColorUtils} class. These tests are written in an informal manner (not
 * using any formal unit testing framework such as JUnit).
 * 
 */
public class ColorUtilsTester {

	/**
	 * Default tolerance for differences in floating point values.
	 */
	public static final double DELTA = 0.0001;

	/**
	 * Returns true if the two given values <code>a</code>, <code>b</code> are
	 * within {@link #DELTA} of each other.
	 */
	public static boolean isClose(double a, double b) {
		return (Math.abs(a - b) < DELTA);
	}

	public static void main(String args[]) {

		boolean reportPass = false;
		if (args.length == 1) {
			if (args[0].equals("--passed")) {
				reportPass = true;
			} else if (args[0].equals("--failed")) {
				reportPass = false;
			} else {
				System.err.println("Unrecognized CLA: " + args[0]);
			}
		}

		int c;
		int x = 10, y = 20, z = 30;
		int result;
		double expectedD, actualD;
		RGB input, expected, actual;
		int numPassed = 0;
		int numFailed = 0;

		c = 123;
		expectedD = 0.4823;
		System.out.printf("TESTING: rgbIntToFloat(%d): ", c);
		actualD = ColorUtils.rgbIntToFloat(c);
		if (!isClose(expectedD, actualD)) {
			System.out.printf("FAILED: returned %f, expected %f\n", actualD, expectedD);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		c = 53;
		expectedD = 0.2078;
		System.out.printf("TESTING: rgbIntToFloat(%d): ", c);
		actualD = ColorUtils.rgbIntToFloat(c);
		if (!isClose(expectedD, actualD)) {
			System.out.printf("FAILED: returned %f, expected %f\n", actualD, expectedD);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", x, y, z);
		result = ColorUtils.max(x, y, z);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", x, z, y);
		result = ColorUtils.max(x, z, y);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", y, x, z);
		result = ColorUtils.max(y, x, z);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", y, z, x);
		result = ColorUtils.max(y, z, x);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", z, x, y);
		result = ColorUtils.max(z, x, y);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", z, y, x);
		result = ColorUtils.max(z, y, x);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", x, x, z);
		result = ColorUtils.max(x, x, z);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", x, z, x);
		result = ColorUtils.max(x, z, x);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", z, x, x);
		result = ColorUtils.max(z, x, x);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		System.out.printf("TESTING: max(%d,%d,%d): ", z, z, z);
		result = ColorUtils.max(z, z, z);
		if (result != 30) {
			System.out.printf("FAILED: max returned %d, expected 30\n", result);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		input = new RGB(255, 0, 0);
		expected = new RGB(85, 85, 85);
		System.out.printf("TESTING: toGrayScaleAverage(%s): ", input);
		actual = ColorUtils.toGrayScaleAverage(input);
		if (!actual.equals(expected)) {
			System.out.printf("FAILED: toGrayScaleAverage returned %s, expected %s\n", actual, expected);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		// TODO: this test case fails, fix toGrayScaleAverage() so that it passes!
		input = new RGB(100, 39, 40);
		expected = new RGB(60, 60, 60);
		System.out.printf("TESTING: toGrayScaleAverage(%s): ", input);
		actual = ColorUtils.toGrayScaleAverage(input);
		if (!actual.equals(expected)) {
			System.out.printf("FAILED: toGrayScaleAverage returned %s, expected %s\n", actual, expected);
			numFailed++;
		} else {
			System.out.printf("PASSED\n");
			numPassed++;
		}

		// TODO: add your test cases here
		// - You should write at least 1 test case for each of the
		// methods: min(), toGrayScaleLightness(),
		// toGrayScaleLuminosity(), and toSepia()
		// - There should be a total of at least 18 passing
		// test cases

		System.out.printf("Number Test Cases Passed: %6d\n", numPassed);
		System.out.printf("Number Test Cases Failed: %6d\n", numFailed);
		System.out.printf("Percent Passed:           %6.2f\n", 100.0 * numPassed / (numPassed + numFailed));

		if (reportPass) {
			System.exit(numPassed);
		} else {
			System.exit(numFailed);
		}
	}

}
