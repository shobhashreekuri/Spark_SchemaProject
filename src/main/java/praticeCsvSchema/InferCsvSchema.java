package praticeCsvSchema;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class InferCsvSchema {

	public void printschema() {
		Logger.getLogger("org").setLevel(Level.ERROR);
		SparkSession spark = new SparkSession.Builder()
				.appName("CSV to DataFrame")
				.master("local")
				.getOrCreate();
	Dataset<Row> df = spark.read().format("CSV")
				.option("header", true)
				.load("src/main/resources/100 Sales Records.csv");
		System.out.println("DataFrame content :");
			df.show(5);
		System.out.println("Dataframe Schema :");
			df.printSchema();
	
	}

}
