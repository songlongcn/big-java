package com.blogspot.vmustafayev4en.ca;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by michael.song on 8/22/2016 for bigJava
 */


public class TestHttps {
	public static void main(String args[]) throws Exception {
		//Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{
				new X509TrustManager() {
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return null;
					}

					public void checkClientTrusted(
							java.security.cert.X509Certificate[] certs, String authType
					) {
					}

					public void checkServerTrusted(
							java.security.cert.X509Certificate[] certs, String authType
					) {
					}
				}
		};

		//install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null,trustAllCerts,new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}

		//you can access an https URL without having the certificate in the truststore
		try {
			HostnameVerifier hv = new HostnameVerifier() {
				@Override
				public boolean verify(String urlHostName, SSLSession sslSession) {
					System.out.println("Warning: URL Host: "+ urlHostName + " vs. " + sslSession.getPeerHost());
					return true;
				}
			};

			String datam="param=myparam";
			URL url = new URL("https://mylocal.efax.com:8080/myaccount/webAdmin/version");
			URLConnection conn = url.openConnection();
			HttpsURLConnection urlConn = (HttpsURLConnection) conn;
			urlConn.setHostnameVerifier(hv);
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(datam);
			wr.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb  = new StringBuilder();
			String inputLine;
			while((inputLine = in.readLine()) != null){
				sb.append(inputLine);
			}
			in.close();
			String res = sb.toString();
			System.out.println(res);

		} catch (MalformedURLException e) {
			System.out.println("Error in SSL Connetion " + e);
		}
	}
}
