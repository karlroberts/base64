package com.owtelse.codec;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

public class Dummy implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Dummy () {}
	
	private int i;

	private  float f;
	private  Double d;
	
	private BigDecimal b;
	private String s;
		
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	public float getF() {
		return f;
	}
	public void setF(float f) {
		this.f = f;
	}
	public Double getD() {
		return d;
	}
	public void setD(Double d) {
		this.d = d;
	}
	public BigDecimal getB() {
		return b;
	}
	public void setB(BigDecimal b) {
		this.b = b;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
		
	

	
	@Override
	public String toString(){
		return "Dummy["+ i +","+ f +","+ d +","+ b +","+ s +"]";
	}
	
	
	
	
	
	
	
	
	public void save(OutputStream os) throws IOException {
		ObjectOutputStream o =null;
		try {
			o = new ObjectOutputStream(os);
			o.writeObject(this);
			o.flush();
		} catch (IOException e) {
			throw e;
		}
		finally {
			if(o != null) {o.close();}
		}
	}
	
	
	public Dummy restore(InputStream is) throws IOException,
			ClassNotFoundException {
		Dummy restoredDummy = null;
		ObjectInputStream o = null;
		try {
			o = new ObjectInputStream(is);
			restoredDummy = (Dummy) o.readObject();
		} catch (IOException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		}
		finally{
			if(o != null) {o.close();}
		}
		return restoredDummy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + Float.floatToIntBits(f);
		result = prime * result + i;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dummy other = (Dummy) obj;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (Float.floatToIntBits(f) != Float.floatToIntBits(other.f))
			return false;
		if (i != other.i)
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	
	
	
}