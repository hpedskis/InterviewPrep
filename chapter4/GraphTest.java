package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphTest {

	//always use Lists 
	public static void main(String[] args) {
		project a = new project('a');
		project b = new project('b');
		project c = new project('c');
		project d = new project('d');
		project e = new project('e');
		project f = new project('f');
		
		List<project> unBuilt = new ArrayList<project>();
		unBuilt.add(a);
		unBuilt.add(b);
		unBuilt.add(c);
		unBuilt.add(d);
		unBuilt.add(e);
		unBuilt.add(f);
		
		MyGraph test = new MyGraph(unBuilt);
		
		test.addDependency(f, a);
		test.addDependency(a, d);
		test.addDependency(b, d);
		test.addDependency(d, c);
		test.addDependency(f, b);
		
		test.findOrder();
		test.printOrder();

	}

}
