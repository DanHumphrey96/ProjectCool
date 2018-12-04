package com.ProjectCool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PageTable {
	List<Page> onMemory;
	List<Page> onDisk;
	int numberOfPagesFit = 4;
	int pageFaults =0;
	int fifoCounter =0;
	private String algorithm = "RANDO";
	
	PageTable(){
		onMemory = new ArrayList<Page>();
		onDisk = new ArrayList<Page>();
		for (int i =0;i<20;i++) {
			onDisk.add(new Page());
		}
	}
	public int getInMemoryAddress(int virtualAddress){
		int inMemory = 0;
		Page neededPage = getPageFromVirtualAddress(virtualAddress);
		if(isAddressInMemory(virtualAddress)) {
			inMemory = calculatePhysicalMemoryAddress(virtualAddress);
		} else {
			loadPageIntoPageTable(neededPage);
			inMemory = calculatePhysicalMemoryAddress(virtualAddress);
		}
		return inMemory;
	}
	private void loadPageIntoPageTable(Page neededPage) {
		pageFaults++;
		if(onMemory.size()<numberOfPagesFit) {
			onMemory.add(neededPage);
			onDisk.remove(neededPage);
		} else {
			replacePage(algorithm,neededPage);
		}	
	}

	private void replacePage(String string, Page neededPage) {
		
		if(string.equals("FIFO")) {
			onDisk.add(onMemory.remove(fifoCounter));
			onMemory.add(neededPage);
			onDisk.remove(neededPage);
			fifoCounter++;
		}
		if(string.equals("RANDO")) {
			Page pageToReplace;
			Random rand = new Random(System.currentTimeMillis());
			pageToReplace = onMemory.get(rand.nextInt(onMemory.size()));
			onDisk.add(pageToReplace);
			onMemory.remove(pageToReplace);
			onMemory.add(neededPage);
			onDisk.remove(neededPage);
			fifoCounter++;
		}
		
	}
	private Page getPageFromVirtualAddress(int virtualAddress) {
		// TODO Auto-generated method stub
		for (Page page:onDisk) {
			if(page.isAddressInPage(virtualAddress)) {
				return page;
			};
		}
		for (Page page:onMemory) {
			if(page.isAddressInPage(virtualAddress)) {
				return page;
			};
		}
		return null;
	}
	private int calculatePhysicalMemoryAddress(int virtualAddress) {
		// TODO Auto-generated method stub
		
		int addressInMemory =0;
		for (Page page:onMemory) {
			if(page.isAddressInPage(virtualAddress)) {
				int memoryOffset = virtualAddress-page.lowerBound;
				addressInMemory+=memoryOffset;
				break;
			}
			addressInMemory+=page.upperBound-page.lowerBound;
		}
		return addressInMemory;
	}
	public boolean isAddressInMemory(int virtualAddress) {
		for (Page page:onMemory) {
			if(page.isAddressInPage(virtualAddress)) {
				return true;
			};
		}
		return false;		
	}
}
