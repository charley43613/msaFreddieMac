package com.fm.model;

public class ImgCompObj {
	String img1;
	String img2;
	String img3;
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public ImgCompObj(String img1, String img2, String img3) {
		super();
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((img3 == null) ? 0 : img3.hashCode());
		result = prime * result + ((img1 == null) ? 0 : img1.hashCode());
		result = prime * result + ((img2 == null) ? 0 : img2.hashCode());
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
		ImgCompObj other = (ImgCompObj) obj;
		if (img3 == null) {
			if (other.img3 != null)
				return false;
		} else if (!img3.equals(other.img3))
			return false;
		if (img1 == null) {
			if (other.img1 != null)
				return false;
		} else if (!img1.equals(other.img1))
			return false;
		if (img2 == null) {
			if (other.img2 != null)
				return false;
		} else if (!img2.equals(other.img2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ImgCompObj [img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + "]";
	}
	public ImgCompObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	

}
