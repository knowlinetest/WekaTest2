/**
 * "Tree visualization (Intermediate)"
 *
 * Visualize a decision tree.
 *
 * @author http://bostjankaluza.net
 */
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;


public class VisualizeTree {
	public static void main(String args[]) throws Exception {
		visualize("dataset/titanic.arff");
	}

	public static void visualize(String dataset) throws Exception {

		// Alternate way to get Instances loaded
		
		// specify data source
		// DataSource source = new DataSource(dataset);
		
		// load the data 
		// Instances data = source.getDataSet();
		
		
		Instances data = new Instances(new BufferedReader(new FileReader(dataset)));
		data.setClassIndex(data.numAttributes() - 1);
		
		J48 classifier = new J48();
		classifier.buildClassifier(data);
		
		
		TreeVisualizer tv = new TreeVisualizer(null, classifier.graph(), new PlaceNode2());
		
		JFrame frame = new javax.swing.JFrame("Tree Visualizer");
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(tv);
		frame.setVisible(true);
		
		tv.fitToScreen();
	}
}
