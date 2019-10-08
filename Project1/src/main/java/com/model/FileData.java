package com.model;

public class FileData {

	private Integer field;
	private byte[] fileContent;
	private String tempFlag;
	public Integer getField() {
		return field;
	}
	public void setField(Integer field) {
		this.field = field;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	public String getTempFlag() {
		return tempFlag;
	}
	public void setTempFlag(String tempFlag) {
		this.tempFlag = tempFlag;
	}
	
}
