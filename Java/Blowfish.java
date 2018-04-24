import javax.crypto.*;
import java.util.*;
public class Blowfish
{
	private static Cipher encryptCipher;
	private static Cipher decryptCipher;
	public static void main(String[] args) throws Exception
	{
		KeyGenerator k = KeyGenerator.getInstance("Blowfish");
		SecretKey sk = k.generateKey();
		encryptCipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		encryptCipher.init(Cipher.ENCRYPT_MODE, sk);
		Scanner s=new Scanner(System.in);
		byte[] encryptedData = encryptData(s.nextLine());
		decryptCipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		decryptCipher.init(Cipher.DECRYPT_MODE, sk);
		decryptData(encryptedData);
	}
	private static byte[] encryptData(String data)
	throws Exception 
	{
		System.out.println("Data Before Encryption :" + data);
		byte[] encryptedData = encryptCipher.doFinal(data.getBytes());
		System.out.println(";Encrypted Data: " + new String(encryptedData));
		return encryptedData;
	}
	private static void decryptData(byte[] data)
	throws Exception 
	{
		byte[] textDecrypted = decryptCipher.doFinal(data);
		System.out.println("Decrypted Data: " + new String(textDecrypted));
	}
}