package certificateEx;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class C2keystoreLookup {
	public static void main(String args[]) {
		try {
			String alias = "paul";
			char[] password = "kkkk".toCharArray();
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			String fname = "keystore";
			FileInputStream fis = new FileInputStream(fname);
			ks.load(fis, null);
			
			if (ks.isKeyEntry(alias)) {
				System.out.println(alias + " is a key entry in the keystore");

				//doesn't work
				System.out.println("The private key for" + alias + " is "
						+ ks.getKey(alias, password));
				
				Certificate certs[] = ks.getCertificateChain(alias);
				if (certs[0] instanceof X509Certificate) {
					X509Certificate x509 = (X509Certificate) certs[0];
					System.out.println(alias + " is really "
							+ x509.getSubjectDN());
				}
				if (certs[certs.length - 1] instanceof X509Certificate) {
					X509Certificate x509 = (X509Certificate) certs[certs.length - 1];
					System.out.println(alias + " was verified by "
							+ x509.getIssuerDN());
				}
			} else if (ks.isCertificateEntry(alias)) {
				System.out.println(alias
						+ " is a certificate entry in the keystore");
				Certificate c = ks.getCertificate(alias);
				if (c instanceof X509Certificate) {
					X509Certificate x509 = (X509Certificate) c;
					System.out.println(alias + " is really "
							+ x509.getSubjectDN());
					System.out.println(alias + " was verified by "
							+ x509.getIssuerDN());
				}
			} else {
				System.out.println(alias + " is unknown to this keystore");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}