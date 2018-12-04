package com.ProjectCool;

public class Page {

	static int globalNextLower = 1;
	int blockSize = 99;
	int lowerBound;
	int upperBound;
	public boolean isAddressInPage(int virtualAddress) {
		return virtualAddress<=upperBound && virtualAddress>=lowerBound;
	}
	Page(){
		setBounds();
		
	}
	synchronized void setBounds() {
		lowerBound= globalNextLower;
		upperBound = lowerBound+blockSize;
		globalNextLower= upperBound+1;
	}
}
