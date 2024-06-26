package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface IBaseString {

	public String pathSeparator = java.nio.file.FileSystems.getDefault().getSeparator();



	default public String stringEnsamble(List<String> stringPaths) {
		StringBuilder newString = new StringBuilder();
		stringPaths.stream().forEach(path -> newString.append(path));
		return newString.toString();
	}


	public static List<String> createList(String multiLineText){
		List<String> lineList = new ArrayList<>();
		Scanner scanner = new Scanner(multiLineText);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			lineList.add(line);
		}
		scanner.close();
		return lineList;
	}

	default public String path(List<String> paths) {

		StringBuilder newPathBuilder = new StringBuilder();

		for (int i = 0; paths.size() > i; i++) {
			if(i != 0 && i+1 != paths.size() && paths.get(i) != " ") {
				newPathBuilder.append(stringEnsamble(List.of(pathSeparator, paths.get(i))));
			}else if (paths.get(i) != " " && i+1 == paths.size()) {
				newPathBuilder.append(stringEnsamble(List.of(pathSeparator, paths.get(i))));
			}else if (paths.get(i) != " ") {
				newPathBuilder.append(paths.get(i));
			}
			if (paths.get(i) == " ") {
				newPathBuilder.append(pathSeparator);
			}
		}
		return newPathBuilder.toString();
	}





}
