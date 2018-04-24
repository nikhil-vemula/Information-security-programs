import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
public class RSA
{
	public static void main(String args[])throws Exception
	{
		Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		byte[] textByte="RSA execution 1234".getBytes();
		System.out.println("Plain text="+new String(textByte));
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(512);
		KeyPair pair = kpg.genKeyPair();
		byte[] cipher=encrypt(textByte, pair, rsaCipher);
		System.out.println("The Encryption using RSA Algorithm : "+new String(cipher));
		String plain=decrypt(cipher,pair, rsaCipher);
		System.out.println("The Decryption using RSA Algorithm : "+plain);
	}
	public static byte[] encrypt(byte[] textBytes, KeyPair pair, Cipher rsaCipher) throws Exception
	{
		PublicKey pk=pair.getPublic();
		rsaCipher.init(Cipher.ENCRYPT_MODE, pk);
		byte[] encByte = rsaCipher.doFinal(textBytes);
		return encByte;
	}
	public static String decrypt(byte[] cipherBytes, KeyPair pair, Cipher rsaCipher) throws Exception
	{
		PrivateKey pvk=pair.getPrivate();
		rsaCipher.init(Cipher.DECRYPT_MODE, pvk);
		byte[] decByte = rsaCipher.doFinal(cipherBytes);
		return new String(decByte);
	}
}
