/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashraf.course.machinelearning.id3decisiontree;

import com.ashraf.course.machinelearning.id3decisiontree.dataStructures.Entry;
import com.ashraf.course.machinelearning.id3decisiontree.modules.Id3Training;
import com.ashraf.course.machinelearning.id3decisiontree.modules.Id3Testing;
import com.ashraf.course.machinelearning.id3decisiontree.dataStructures.TreeNode;
import com.ashraf.course.machinelearning.id3decisiontree.utilities.CsvUtils;
import com.ashraf.course.machinelearning.id3decisiontree.utilities.Defs;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Ashraf
 */
public class ID3DecisionTree {

    final static Logger logger = Logger.getLogger(ID3DecisionTree.class);

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        logger.info("Running ID3 Decision Tree...");

        // Build decision tree
        Id3Training id3Training = new Id3Training();
        TreeNode decisionTreeRoot = id3Training.buildTree();

        // Run test on decision tree
        Id3Testing id3Testing = new Id3Testing();
        List<Entry> clusteredEntryList = id3Testing.getTestResults(decisionTreeRoot);

        if (Defs.currentRunningMode == Defs.RunningModes.DEBUG) {
            for (Entry e : clusteredEntryList) {
                logger.debug("ID: " + e.getId() + " SEQ: " + e.getSequence() + " Class: " + e.getCategory());
            }
        }
        try {
            CsvUtils.writeEntriesToCsvFile(clusteredEntryList, Defs.RESULT_FILE_NAME);
        } catch (FileNotFoundException fileEx) {
            logger.error(fileEx.getMessage());
            logger.info("Could not open results file");
        } catch (IOException ioEx) {
            logger.error(ioEx.getMessage());
            logger.info("Could not write to results file");
        }
        logger.info("Results are written in " + Defs.RESULT_FILE_NAME + " file.");
    }
}
