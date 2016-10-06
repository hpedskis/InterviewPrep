package chapter4;

import java.util.ArrayList;
import java.util.List;


//TODO was switching over from iterative dependencies to a list of each project it's dependent on
//TODO change the way add dependency works and change findOrder to delete that project form their list
public class MyGraph{
	public int size;
	public List<project> unBuiltProjects;
	public int projectMatrix[][];
	public ArrayList<Character> buildOrder;
	
	public MyGraph(List<project> proj){
		this.unBuiltProjects = proj;
		size = proj.size(); 
		System.out.println("size is now " + size);
		projectMatrix = new int[size][size];
		//restart matrix to zero
		for(int i=0; i< size; i++){
			for (int j= 0; j< size; j++){
				projectMatrix[i][j] = 0;
			}
		}
		buildOrder = new ArrayList<Character>();
	}
	
	public void addDependency(project dependent, project proj){
		
		int dependentIndex = unBuiltProjects.indexOf(dependent); //findIndex(dependent.name); //don't have to find index in lists :'(
		int projIndex = unBuiltProjects.indexOf(proj);
		
		projectMatrix[projIndex][dependentIndex] = 1;
		proj.dependencies += 1;
		//have a list of it's dependencies. If you compile C, go through and take C out.
	}
	
	
	public int findIndex(char a){
		return unBuiltProjects.indexOf(a);
	}
	
	public boolean findOrder(){
		//have a list of unbuilt projects, run until it's not empty
		//after iterating, if your size hasn't changed, throw exception, because you're stuck.
		while(!unBuiltProjects.isEmpty()){
			//findCompilableProejects()
			for (project p: unBuiltProjects){
				
				if (p.dependencies == 0){
					//if it's a list, list.remove(node with no dependencies)
					
					buildOrder.add(p.name);
					int justBuilt = findIndex(p.name);
					project deleted = unBuiltProjects.remove(unBuiltProjects.indexOf(p));
					
					for(int j=0; j< unBuiltProjects.size();j++){
						if(projectMatrix[j][justBuilt] == 1){
							projectMatrix[j][justBuilt] = 0;
							unBuiltProjects.get(j).dependencies -=1;
						}	
					}
			}
			
		}
			printOrder();
		
	}
	return true;
	}
	public void printOrder(){
		System.out.println("printing build order!!!");
		System.out.println("");
		for(char c: buildOrder){
			
			System.out.print(c);
		}
		System.out.println("");

	}
	
}
class project{
	public char name;
	//public int dependencies;
	public list<project> dependencies;
	//public list of projects it's dependent on
	
	public project(char name){
		this.name = name;
		dependencies = 0;
	}
}
