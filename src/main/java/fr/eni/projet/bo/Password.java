package fr.eni.projet.bo;

import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class Password {


	private static final int iterations = 20 * 1000;
	private static final int saltLen = 32;
	private static final int desiredKeyLen = 256;

	public static String getSaltedHash(String password) throws Exception {
		byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);

		return Base64.encodeBase64String(salt) + "$" + hash(password, salt);

	} 
	
	public static boolean check(String password, String stored) throws Exception{
		String[] saltAndHash = stored.split("\\$");
		if (saltAndHash.length != 2) {
			throw new IllegalStateException(
			"le password stock� est mainetenat sous format 'salt$hash'");
		}
		String hashOfInput = hash(password, Base64.decodeBase64(saltAndHash[0]));
		
		return hashOfInput.equals(saltAndHash[1]);
		
	}

	public static String hash (String password, byte[] salt) throws Exception {
		if (password == null || password.length() == 0)
			throw new IllegalArgumentException("Password vide not supported.");
		SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey key = f.generateSecret(new PBEKeySpec(password.toCharArray(),salt,iterations,desiredKeyLen));
		
		return Base64.encodeBase64String(key.getEncoded());
	}
}
