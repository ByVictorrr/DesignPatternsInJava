package com.company;// SRP - Single responsiblity principle
// It states:
//			 that a class should have a single reason to change ( should have one responsible)
// God object: a class takes on a lot of responsiblity.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
class Journal{

		private final List<String> entries = new ArrayList<>();
		private static int count = 0;
		
		public void addEntry(String text)
		{
			entries.add("" + ++count + ": " + text);
		}

		public void removeEntry(int index)
		{
			entries.remove(index);
		}
		@Override
		public String toString(){
			return String.join(System.lineSeparator(), entries);
		}



		/* Violation of SRP
		public void save(String filename) throws FileNotFoundException {
			try(PrintStream out = new PrintStream(filename)) {
				out.print(toString());
			}
		}

		public void load(String filename){}
		public void load(URL url){}
		 */

}
class Persistence {

	public void saveToFIle(Journal journal,
						   String filename,
						   boolean overwrite)throws FileNotFoundException{
		if(overwrite || new File(filename).exists()){
			try(PrintStream out = new PrintStream(filename)) {
				out.print(journal.toString());
			}
		}
	}
}
/*
class Demo{

	public static void main(String[] args)throws Exception{
		Journal j = new Journal();

		j.addEntry("I cried today");
		j.addEntry("I ate a bug");
		System.out.println(j);

		// Persistance
		Persistence p = new Persistence();
		String filename = "/home/victor/todo.txt";
		p.saveToFIle(j, filename, true);

		//Runtime.getRuntime().exec("vim" + filename);
	}


}

 */
