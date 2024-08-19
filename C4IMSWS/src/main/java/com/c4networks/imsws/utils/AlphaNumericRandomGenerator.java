package com.c4networks.imsws.utils;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

public class AlphaNumericRandomGenerator {

	private final static int COMPANY_OID_SEQUENCE = 16;
	private final static int COMPANY_ID_SEQUENCE = 7;
	private final static int ROLE_SEQUENCE = 6;
	private final static int USER_SEQUENCE = 16;

//	private final static int CUSTOMER_SEQUENCE = 8; // 12
//	private final static int MOVIE_SEQUENCE = 7; // 10
//	private final static int CATEGORY_SEQUENCE = 7; // 10
//	private final static int RENTAL_SEQUENCE = 5; // 8
//	private final static int BONUS_SEQUENCE = 5; // 8

	public static String generateCompanyObjectIdentifier() {
		String randomSequence;
		randomSequence = RandomStringUtils.randomAlphanumeric(COMPANY_OID_SEQUENCE).toUpperCase();
		return randomSequence;
	}

	public static String generateCompanyIdentifier() {
		String randomSequence;
		randomSequence = "COM" + RandomStringUtils.randomAlphanumeric(COMPANY_ID_SEQUENCE).toUpperCase();
		return randomSequence;
	}

	public static String generateRoleIdentifier() {
		String randomSequence;
		randomSequence = "RL" + RandomStringUtils.randomAlphanumeric(ROLE_SEQUENCE).toUpperCase();
		return randomSequence;
	}

	public static String generateUserIdentifier() {
		String randomSequence;
		randomSequence = RandomStringUtils.randomAlphanumeric(USER_SEQUENCE).toUpperCase();
		return randomSequence;
	}
	
//	public static String generateAgentCustomerIdentifier() {
//		String randomSequence;
//		randomSequence = RandomStringUtils.random(USER_SEQUENCE, "AGC").toUpperCase();
//		return randomSequence;
//	}
//
//	public static String generateAlphaNumericSeqForCustomerID() {
//		String randomSequence;
//		randomSequence = RandomStringUtils.random(CUSTOMER_SEQUENCE, "CUST").toUpperCase();
//		return randomSequence;
//	}
//
//	public static String generateAlphaNumericSeqForMovieID() {
//		String randomSequence;
//		randomSequence = "MOV" + RandomStringUtils.randomAlphanumeric(MOVIE_SEQUENCE).toUpperCase();
//		return randomSequence;
//	}
//
//	public static String generateAlphaNumericSeqForCategoryID() {
//		String randomSequence;
//		randomSequence = "CAT" + RandomStringUtils.randomAlphanumeric(CATEGORY_SEQUENCE).toUpperCase();
//		return randomSequence;
//	}
//
//	public static String generateAlphaNumericSeqForRentalID() {
//		String randomSequence;
//		randomSequence = "RNT" + RandomStringUtils.randomAlphanumeric(RENTAL_SEQUENCE).toUpperCase();
//		return randomSequence;
//	}
//
//	public static String generateAlphaNumericSeqForBonusID() {
//		String randomSequence;
//		randomSequence = "BNS" + RandomStringUtils.randomAlphanumeric(BONUS_SEQUENCE).toUpperCase();
//		return randomSequence;
//	}
//
//	public static String getRandomString(int length) {
//		String randomStr = UUID.randomUUID().toString();
//		System.out.println(">>" + randomStr);
//		while (randomStr.length() < length) {
//			randomStr += UUID.randomUUID().toString();
//		}
//		return randomStr.substring(0, length);
//	}

}
