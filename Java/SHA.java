import java.security.*;
import java.util.*;
public class SHA {
public static void main(String args[]) throws Exception {
Scanner s=new Scanner(System.in);
String password = s.nextLine();

if ((args.length == 1) && (args[0].length() > 0))
{
password = args[0];
}

System.out.println("Password: " + password + " in SHA512 is:");
System.out.println(hashText(password));
}
public static String convertByteToHex(byte data[])
{
StringBuffer hexData = new StringBuffer();
for(int byteIndex = 0; byteIndex<data.length; byteIndex++)
hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));

return hexData.toString();
}
public static String hashText(String textToHash) throws Exception
{
final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
sha512.update(textToHash.getBytes());

return convertByteToHex(sha512.digest());
}
}