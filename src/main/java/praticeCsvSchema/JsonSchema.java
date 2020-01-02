package praticeCsvSchema;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class JsonSchema {
	
	public void printJsonSchema() 
	{
		Logger.getLogger("org").setLevel(Level.ERROR);
		SparkSession spark = new SparkSession.Builder()
				.appName("Json Schema")
				.master("local[*]")
				.getOrCreate();
		Dataset<Row> df = spark.read().format("Json")
				.load("src/main/resources/simple.json");
		
		Dataset<Row> df2 = spark.read().format("json")
				.option("multiline",true)
				.load("src/main/resources/multiline.json");
		System.out.println("simple json output");
		df.show();
		System.out.println("Multiline Json format");
		df2.show();
		
		df.printSchema();
		df2.printSchema();
				
	}

}
