import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class DES
{
	private static Cipher encryptCipher;
	private static Cipher decryptCipher;
	public static void main(String[] args) throws Exception
	{
		KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		SecretKey secretKey = keygenerator.generateKey();
		encryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedData = encryptData("Vani123");
		decryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
		decryptData(encryptedData);
 	}
	private static byte[] encryptData(String data)  throws Exception
	{
		System.out.println("Data Before Encryption :" + data);
		byte[] dataToEncrypt = data.getBytes();
		byte[] encryptedData = encryptCipher.doFinal(dataToEncrypt);
		System.out.println("Encryted Data: " + new String(encryptedData));
		return encryptedData;
 	}
	private static void decryptData(byte[] data)  throws Exception
	{
		byte[] textDecrypted = decryptCipher.doFinal(data);
		System.out.println("Decryted Data: " + new String(textDecrypted));
 	}
}
