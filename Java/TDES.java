import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class TDES
{
	private static Cipher encryptCipher;
	private static Cipher decryptCipher;
	public static void main(String[] args) throws Exception
	{
		KeyGenerator keygenerator = KeyGenerator.getInstance("DESede");
		SecretKey secretKey = keygenerator.generateKey();
		encryptCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedData = encryptData("Triple DES execution123");
		decryptCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
		decryptData(encryptedData);
	}
	private static byte[] encryptData(String data) throws Exception
	{
		System.out.println("Data Before Encryption :" + data);
		byte[] dataToEncrypt = data.getBytes();
		byte[] encryptedData = encryptCipher.doFinal(dataToEncrypt);
		System.out.println("Encrypted Data: " + new String(encryptedData));
		return encryptedData;
	}
	private static void decryptData(byte[] data) throws Exception
	{
		byte[] textDecrypted = decryptCipher.doFinal(data);
		System.out.println("Decrypted Data: " + new String(textDecrypted));
	}
}
