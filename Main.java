package com.ProjectCool;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			PageTable ourTable = new PageTable();

			System.out.println( " Load page a :" +ourTable.getInMemoryAddress(55)+ ", faults :" +ourTable.pageFaults);
			System.out.println( " Load page a :" +ourTable.getInMemoryAddress(55)+ ", faults :" +ourTable.pageFaults);
			System.out.println( " Load page c :" +ourTable.getInMemoryAddress(250)+ ", faults :" +ourTable.pageFaults);
			System.out.println( " Load page b :" +ourTable.getInMemoryAddress(105)+ ", faults :" +ourTable.pageFaults);
			System.out.println( " Load page d :" +ourTable.getInMemoryAddress(352)+ ", faults :" +ourTable.pageFaults);
			System.out.println( " Load page b :" +ourTable.getInMemoryAddress(105)+ ", faults :" +ourTable.pageFaults);
			System.out.println( " Load page e :" +ourTable.getInMemoryAddress(457)+ ", faults :" +ourTable.pageFaults);
			System.out.println( " Load page a :" +ourTable.getInMemoryAddress(55)+ ", faults :" +ourTable.pageFaults);
	}

}
