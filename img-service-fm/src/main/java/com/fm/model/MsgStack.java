package com.fm.model;

public class MsgStack {
	String imgAtoB;
	String imgAtoC;
	boolean success;
	public String getImgAtoB() {
		return imgAtoB;
	}
	public void setImgAtoB(String imgAtoB) {
		this.imgAtoB = imgAtoB;
	}
	public String getImgAtoC() {
		return imgAtoC;
	}
	public void setImgAtoC(String imgAtoC) {
		this.imgAtoC = imgAtoC;
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
	public MsgStack(String imgAtoB, String imgAtoC, boolean success) {
		super();
		this.imgAtoB = imgAtoB;
		this.imgAtoC = imgAtoC;
		this.success = success;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imgAtoB == null) ? 0 : imgAtoB.hashCode());
		result = prime * result + ((imgAtoC == null) ? 0 : imgAtoC.hashCode());
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
		if (imgAtoC == null) {
			if (other.imgAtoC != null)
				return false;
		} else if (!imgAtoC.equals(other.imgAtoC))
			return false;
		if (success != other.success)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MsgStack [imgAtoB=" + imgAtoB + ", imgAtoC=" + imgAtoC + ", success=" + success + "]";
	}
	

}
