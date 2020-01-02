package praticeCsvSchema;

public class Application {


	public static void main(String[] args) {
		
		InferCsvSchema parser = new InferCsvSchema();
		parser.printschema();
		
		JsonSchema parserJson = new JsonSchema();
		parserJson.printJsonSchema();

	}

}
