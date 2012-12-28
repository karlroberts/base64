package au.com.allianz.common;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import au.com.allianz.common.UrlSigner;


public class UrlSignerTest {

	UrlSigner s =null;
	
	@Before
	public void setUp() throws Exception {
		s = new UrlSigner(new String("gViycVTY0NHmn7akQbCUXWh_Vg4="));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUrlSigner() {
		assertNotNull(s);
	}

	@Test
	public void testSignRequest() throws Exception {

		String myURL = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=15+Banksia+St,Dee+Why,NSW&client=gme-allianz";
		URL url = new URL(myURL);
		String signed = s.signURL(url);
		assertNotNull(signed);
		assertTrue(signed.length() >= 0);
		
		 String expect = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=15+Banksia+St,Dee+Why,NSW&client=gme-allianz&signature=T3NFLwbAn69MJiI7Kh2xPocronE=";
		 assertEquals(expect, signed);
	}

}
