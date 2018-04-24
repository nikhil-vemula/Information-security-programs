import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.util.*;
public class Mac{
public static void main(String[] argv) throws Exception {
KeyGenerator kg = KeyGenerator.getInstance("HmacMD5");
SecretKey k = kg.generateKey();
Mac mac = Mac.getInstance(k.getAlgorithm());
mac.init(k);
Scanner s=new Scanner(System.in);
String str = s.nextLine();
byte[] utf8 = str.getBytes("UTF8");
byte[] digest = mac.doFinal(utf8);
String digestB64 = new sun.misc.BASE64Encoder().encode(digest);
System.out.println(digestB64);
}
}
