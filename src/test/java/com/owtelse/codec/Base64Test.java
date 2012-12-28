package com.owtelse.codec;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jvm.util.ByteArrayOutputStream;



import static org.junit.Assert.*;
import static com.owtelse.codec.Base64.*;


/**
 * @author jkyr
 *
 */
public class Base64Test {
	public static final String D1_expected = "Dummy[10,26.8889,1.7976931348623157E308,5698765.999876500107347965240478515625,Hello Karl :-)]";
	public static final String D3_expected = "Dummy[15,55.0,4567.0,5698765.999876500107347965240478515625,Hello Karl Again :-)]";
	
	Dummy d1;
	Dummy d2;
	Dummy d3;
	Dummy d4;
	Dummy d5;
	Dummy d6;
	Dummy d7;
	

	@Before
	public void setUp() throws Exception {
		d1= new Dummy();
		d1.setI(10);
		d1.setF(26.8889f);
		d1.setD(Double.MAX_VALUE);
		d1.setB(new BigDecimal(5698765.9998765d));
		d1.setS("Hello Karl :-)");
		assertNotNull(d1);
		
		d2= new Dummy();
		d2.setI(10);
		d2.setF(26.8889f);
		d2.setD(Double.MAX_VALUE);
		d2.setB(new BigDecimal(5698765.9998765d));
		d2.setS("Hello Karl :-)");
		assertNotNull(d2);
		
		d3= new Dummy();
		d3.setI(15);		
		d3.setF(55f);
		d3.setD(4567d);
		d3.setB(new BigDecimal(5698765.9998765d));
		d3.setS("Hello Karl Again :-)");
		assertNotNull(d3);
		
		d4= new Dummy();
		d4.setI(15);		
		d4.setF(55f);
		d4.setD(4567d);
		d4.setB(new BigDecimal(5698765.9998765d));
		d4.setS("Hello Karl Again :-)a");
		assertNotNull(d4);
		
		d5= new Dummy();
		d5.setI(15);		
		d5.setF(55f);
		d5.setD(4567d);
		d5.setB(new BigDecimal(5698765.9998765d));
		d5.setS("Hello Karl Again :-)ab");
		assertNotNull(d5);
		
		d6= new Dummy();
		d6.setI(15);		
		d6.setF(55f);
		d6.setD(4567d);
		d6.setB(new BigDecimal(5698765.9998765d));
		d6.setS("Hello Karl Again :-)abc");
		assertNotNull(d6);
		
		d7= new Dummy();
		d7.setI(15);		
		d7.setF(55f);
		d7.setD(4567d);
		d7.setB(new BigDecimal(5698765.9998765d));
		d7.setS("Hello Karl Again :-)abcd");
		assertNotNull(d7);

		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testDummyEquals() {
		assertEquals(d1,d2);
	}
	@Test
	public void testDummyHascode() {
		assertEquals(d1.hashCode(),d2.hashCode());
		assertFalse(d1.hashCode() == d3.hashCode());
	}
	
	@Test 
	public void testBase64_null1() throws UnsupportedEncodingException {
		String x = base64Encode(null, "UTF-8");
		assertNull(x);
	}
	@Test 
	public void testBase64_1a_badEncoding()  {
		String x;
		try {
			x = base64Encode("hello", "WIbbleWobble");
			fail("shouldn't get here");
		} catch (UnsupportedEncodingException e) {
			assertNotNull(e);
		}
	}
	
	@Test 
	public void testBase64_null2() {
		byte[] x = base64Encode(null);
		assertNull(x);
	}
	
	@Test 
	public void testBase64_null3() throws UnsupportedEncodingException {
		String x = base64Decode(null, "UTF-8");
		assertNull(x);
	}
	@Test 
	public void testBase64_badEncoding()  {
		String x;
		try {
			x = base64Decode("hello", "WIbbleWobble");
			fail("shouldn't get here");
		} catch (UnsupportedEncodingException e) {
			assertNotNull(e);
		}
	}
	
	@Test 
	public void testBase64_null4() {
		byte[] x = base64Decode(null);
		assertNull(x);
	}
	
	@Test 
	public void testBase64_handlesNotEncoded() {
		byte[] x;
		try {
			x = base64Decode("ab===dfds========".getBytes());
			fail("should not get here");
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}		
	}
	
	@Test 
	public void testBase64_handlesAllPadding() {
		
			byte[] x = base64Decode("===========".getBytes());
			assertNull(x);
				
	}
	
	@Test 
	public void testBase64_Encode_1morebyte() throws IOException, ClassNotFoundException {
		Dummy testDummy = d4;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		assertTrue((testDummy instanceof java.io.Serializable));
		
		testDummy.save(os);
		String strSerializedDummy = os.toString("UTF-8");
		String strSerializedDummyEncoded = base64Encode(strSerializedDummy , "UTF-8");
		assertNotNull(strSerializedDummyEncoded);
		assertFalse(strSerializedDummyEncoded.length() == 0);
	}
	
	@Test 
	public void testBase64_Encode_2morebyte() throws IOException, ClassNotFoundException {
		Dummy testDummy = d5;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		assertTrue((testDummy instanceof java.io.Serializable));
		
		testDummy.save(os);
		String strSerializedDummy = os.toString("UTF-8");
		String strSerializedDummyEncoded = base64Encode(strSerializedDummy , "UTF-8");
		assertNotNull(strSerializedDummyEncoded);
		assertFalse(strSerializedDummyEncoded.length() == 0);
	}
	
	@Test 
	public void testBase64_Encode_3morebyte() throws IOException, ClassNotFoundException {
		Dummy testDummy = d6;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		assertTrue((testDummy instanceof java.io.Serializable));
		
		testDummy.save(os);
		String strSerializedDummy = os.toString("UTF-8");
		String strSerializedDummyEncoded = base64Encode(strSerializedDummy , "UTF-8");
		assertNotNull(strSerializedDummyEncoded);
		assertFalse(strSerializedDummyEncoded.length() == 0);
	}
	
	@Test 
	public void testBase64_Encode_4morebyte() throws IOException, ClassNotFoundException {
		Dummy testDummy = d7;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		assertTrue((testDummy instanceof java.io.Serializable));
		
		testDummy.save(os);
		String strSerializedDummy = os.toString("UTF-8");
		String strSerializedDummyEncoded = base64Encode(strSerializedDummy , "UTF-8");
		assertNotNull(strSerializedDummyEncoded);
		assertFalse(strSerializedDummyEncoded.length() == 0);
	}
	
	
	
	@Test 
	public void testBase64_DummySerialized() throws IOException, ClassNotFoundException {
		Dummy testDummy = d1;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		assertTrue((testDummy instanceof java.io.Serializable));
		
		testDummy.save(os);
		String strSerializedDummy = os.toString("UTF-8");
		String strSerializedDummyEncoded = base64Encode(strSerializedDummy , "UTF-8");
		
		assertNotNull(strSerializedDummyEncoded);
		assertFalse(strSerializedDummyEncoded.length() == 0);
		
		String deSerialized = base64Decode(strSerializedDummyEncoded, "UTF-8");
		assertEquals(strSerializedDummy, deSerialized);

	}
	
	@Test 
	public void testBase64_DummySerialized2() throws IOException, ClassNotFoundException {
		Dummy testDummy = d1;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		assertTrue((testDummy instanceof java.io.Serializable));
		
		testDummy.save(os);
		byte[] strSerializedDummy = os.toByteArray();
		byte[] strSerializedDummyEncoded = base64Encode(strSerializedDummy);
		
		assertNotNull(strSerializedDummyEncoded);
		assertFalse(strSerializedDummyEncoded.length == 0);
		
		byte[] deSerialized = base64Decode(strSerializedDummyEncoded);
		
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(deSerialized));
		Dummy temp = (Dummy)ois.readObject();
		ois.close();
		assertNotNull(temp);
		assertEquals(d1, temp);
		System.out.println(temp);
	}
	
	
	@Test 
	public void testBase64_DummySerialized3() throws IOException, ClassNotFoundException {
		Dummy testDummy = d3;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		assertTrue((testDummy instanceof java.io.Serializable));
		
		testDummy.save(os);
		String strSerializedDummy = os.toString("UTF-8");
		String strSerializedDummyEncoded = base64Encode(strSerializedDummy , "UTF-8");
		
		assertNotNull(strSerializedDummyEncoded);
		assertFalse(strSerializedDummyEncoded.length() == 0);
		
		String deSerialized = base64Decode(strSerializedDummyEncoded, "UTF-8");
		assertEquals(strSerializedDummy, deSerialized);

	}
	
	@Test 
	public void testBase64_DummySerialized4() throws IOException, ClassNotFoundException {
		Dummy testDummy = d3;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		assertTrue((testDummy instanceof java.io.Serializable));
		
		testDummy.save(os);
		byte[] strSerializedDummy = os.toByteArray();
		byte[] strSerializedDummyEncoded = base64Encode(strSerializedDummy);
		
		assertNotNull(strSerializedDummyEncoded);
		assertFalse(strSerializedDummyEncoded.length == 0);
		
		byte[] deSerialized = base64Decode(strSerializedDummyEncoded);
		
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(deSerialized));
		Dummy temp = (Dummy)ois.readObject();
		ois.close();
		assertNotNull(temp);
		assertEquals(d3, temp);
		System.out.println(temp);
	}
	


}

