import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label	]
	/*
	String PATH_TO_ARRAY = args[0];
	
	System.out.println(PATH_TO_ARRAY);
	List<DataPoint> stuff = DataSet.readDataSet(PATH_TO_ARRAY);
	DataPoint hello = stuff.get(30);
	System.out.println(hello.getLabel());
	String outPut = Arrays.toString(hello.getX());
	System.out.println(outPut);


    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	
	List<DataPoint> testSet = DataSet.getTestSet(stuff, 0.2);
	List<DataPoint> trainingSet = DataSet.getTrainingSet(stuff, 0.8);


    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)

		double distanceT = DataSet.distanceEuclid(testSet.get(2), testSet.get(4));
	
		System.out.println(distanceT);
*/
    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	KNNClassifier classifierK = new KNNClassifier(3);



    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
 	double[] generations = new double[1000];
	double counter = 0;
	double accuracy = 0;
	  
	for (int h = 0; h < 1000; h++){
		
		List<DataPoint> dataList = DataSet.readDataSet(args[0]);
		List<DataPoint>	testList = DataSet.getTrainingSet(dataList, 0.3);
		List<DataPoint>	trainList = DataSet.getTrainingSet(dataList, 0.7);

		for (int i = 0; i < testList.size(); i++) {

			String predictionValue = classifier.predict(trainingList, Listset.get(i));
			String actualValue = (testList.get(i)).getLabel();

			if (predictionValue = actualValue){
					counter++;
			}
		} 
	 	accuracy = counter / testList.size()*100
		generations[h] = accuracy
		counter = 0;
	}
	  
	System.out.println("Mean is" + mean(generations));
	System.out.println("SD is " + standardDeviation(generations));

  }

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
