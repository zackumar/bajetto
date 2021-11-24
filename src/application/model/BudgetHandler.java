package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

import application.model.Income.BudgetFreq;

public class BudgetHandler {

	public static final BudgetHandler INSTANCE = new BudgetHandler();
	public static BudgetHandler getInstance() {
		return INSTANCE;
	}
	
	public String name;
	public ArrayList<BudgetItem> items = new ArrayList<BudgetItem>();
	public Income income;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<BudgetItem> getItems() {
		return items;
	}
	
	public void addItem(BudgetItem item) {
		items.add(item);
		save();
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public void save() {
		File dir = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + (System.getProperty("os.name").toLowerCase().contains("mac") ? "/Documents" : "") + "/Bajetto");
    	if(!dir.exists())dir.mkdir();
		
		String filename = dir.getPath() + "/" + this.name.replace(" ", "-") + ".bajetto";
		
		System.out.println("Saving to " + filename);
		
		PrintWriter writer = null;
		
		StringBuilder tsv = new StringBuilder();
		
		tsv.append(name).append("\t").append(income.income).append("\t").append(income.freq).append("\n");
		
		for(BudgetItem item: items) {
			tsv.append(item.toTsvRow()).append("\n");
		}
		
		
		try {
			writer = new PrintWriter(new File(filename));
			
			writer.write(tsv.toString());
			
		} catch (FileNotFoundException e) {
			System.err.println("Error writing save file: "+ filename);
			e.printStackTrace();
		} finally {
			writer.close();
		}
		
		System.out.println("Saved file.");
		
	}
	
	public BudgetHandler read(String fileDir) {
		
		Scanner tsv = null;
		
		try {
			tsv = new Scanner(new File(fileDir));
			String[] firstLine = tsv.nextLine().split("\t");
			this.name = firstLine[0];
			this.income = new Income(BudgetFreq.valueOf(firstLine[2]), Double.parseDouble(firstLine[1]));
			
			while(tsv.hasNextLine()) {
				String[] itemLine = tsv.nextLine().split("\t");
				BudgetItem item = new BudgetItem(itemLine[0], Double.parseDouble(itemLine[1]), BudgetFreq.valueOf(itemLine[2]));
				items.add(item);
			}
			
			
		} catch (FileNotFoundException e) {
			System.err.println("Error reading save file: " + fileDir);
			e.printStackTrace();
		}
		
		return this;
	}
	
	
	public String toString() {
		
		StringBuilder tsv = new StringBuilder();
		
		tsv.append(name).append("\t").append(income.income).append("\t").append(income.freq).append("\n");
		
		for(BudgetItem item: items) {
			tsv.append(item.toTsvRow()).append("\n");
		}
		
		
		return tsv.toString();
	}

}
