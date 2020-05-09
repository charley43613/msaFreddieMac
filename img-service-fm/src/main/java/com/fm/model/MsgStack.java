package com.fm.model;

public class MsgStack {
	String imgAtoB;
	String imgBtoC;
	boolean success;
	public String getImgAtoB() {
		return imgAtoB;
	}
	public void setImgAtoB(String imgAtoB) {
		this.imgAtoB = imgAtoB;
	}
	public String getImgBtoC() {
		return imgBtoC;
	}
	public void setImgBtoC(String imgBtoC) {
		this.imgBtoC = imgBtoC;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public MsgStack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MsgStack(String imgAtoB, String imgBtoC, boolean success) {
		super();
		this.imgAtoB = imgAtoB;
		this.imgBtoC = imgBtoC;
		this.success = success;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imgAtoB == null) ? 0 : imgAtoB.hashCode());
		result = prime * result + ((imgBtoC == null) ? 0 : imgBtoC.hashCode());
		result = prime * result + (success ? 1231 : 1237);
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
		MsgStack other = (MsgStack) obj;
		if (imgAtoB == null) {
			if (other.imgAtoB != null)
				return false;
		} else if (!imgAtoB.equals(other.imgAtoB))
			return false;
		if (imgBtoC == null) {
			if (other.imgBtoC != null)
				return false;
		} else if (!imgBtoC.equals(other.imgBtoC))
			return false;
		if (success != other.success)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MsgStack [imgAtoB=" + imgAtoB + ", imgBtoC=" + imgBtoC + ", success=" + success + "]";
	}
	

}
