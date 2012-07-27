/**
 * 
 */
package com.darkenedsky.d20charviewer.common;

import java.text.DecimalFormat;

/**
 * Tools for working with numbers and the primitive Number object
 * 
 * @author Jaeden
 *
 */
public abstract class NumberTools {


	/** Hide constructor */ private NumberTools() { }
	

	/** Declared here for reuse in TrimFloat() */
	private static DecimalFormat nf = new DecimalFormat();
	
	/**
	 * Trim a floating-point number into a more attractive string for printing.
	 * 
	 * @param fVal Float
	 * @return String representation with the specified parameters
	 */
	public static String trimFloat(float fVal) {
		return trimFloat(fVal, 0, 3, false);
	}

	/**
	 * Trim a floating-point number into a more attractive string for printing.
	 * 
	 * @param fVal Float
	 * @param iMin Minimum digits after decimal
	 * @param iMax maximum digits after decimal
	 * @param bShowDecimal if 'true', always show decimal point
	 * @return String representation with the specified parameters
	 */
	public static String trimFloat(float fVal, int iMin, int iMax, boolean bShowDecimal) {
		nf.setMaximumFractionDigits(iMax);
		nf.setMinimumFractionDigits(iMin);
		nf.setDecimalSeparatorAlwaysShown(bShowDecimal);
		return nf.format(fVal);
	}


	/** Pads an integer to a number of digits with leading zeroes
	 * 
	 * @param number Number to pad
	 * @param digits Digits to guarantee are shown
	 * @return the padded number
	 */
	public static String padDigits(long number, int digits) { 
		
		String pad = Long.toString(number).trim();
		if (pad.length() >= digits)
			return pad;
		
		while (pad.length() < digits)
			pad = "0" + pad;
		
		return pad;
		
	}
	
	/**
	 * Determine if the Number is an integer type
	 * 
	 * @param I a Number that might be an integer type
	 * @return 'true' if it's an integer type
	 */
	public static boolean isIntegerType(Number I) {
		return (I instanceof Byte || I instanceof Short || I instanceof Integer || I instanceof Long);
	}

	/**
	 * Check if an integer is a power of 2. We do this by seeing if exactly one
	 * bit in the integer is turned on.
	 * 
	 * @param i integer to check
	 * @return true if the image is a power of 2, false otherwise
	 */
	public static boolean isPowerOf2(int i) {
		boolean bPower = false;
		for (int x = 0; x < 32 /* size of int */; x++) {
			if (((i >> x) & 1) == 1) {
				// if it's true we've already found a bit on, so there's more
				// than one
				if (bPower == true) {
					return false;
				}

				// if it's false, we've not found a bit on yet, so turn it on
				if (bPower == false) {
					bPower = true;
				}
			}
		}

		return bPower;
	}
}
