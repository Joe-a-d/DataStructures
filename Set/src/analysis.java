/**
 * @author Domingues, Joao #2334590D
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import List.*;
import Tree.*;

public class analysis {
    public analysis() throws IOException {
    }

    public static void main(String[] args) {

        List<Integer> fileData = analysis.getFileData("src/int20k.txt");
        List<Integer> rand = analysis.popRandom();

        // Sets
        listSet<Integer> list = analysis.popList(fileData);
        bstSet tree = analysis.popTree(fileData);

        // Times


        long listTime = 0;
        long treeTime = 0;
        for (int i : rand){
            long start = System.nanoTime();
            list.isElement(i);
            long end = System.nanoTime();
            listTime += (end-start);
            long start2 = System.nanoTime();
            tree.isElement(i);
            long end2 = System.nanoTime();
            treeTime += (end-start);
        }

        System.out.println("IS-ELEMENT(S,x) : Running time average for list = " + listTime*0.00001 + "ms");
        System.out.println("IS-ELEMENT(S,x) : Running time average for tree = " + treeTime*0.00001 + "ms");

       // Size

        System.out.println();
        System.out.println("SET-SIZE(list) : " + list.size());
        System.out.println("SET-SIZE(tree) : " + tree.size());

        // Height

        System.out.println();
        System.out.println("HEIGHT(tree) : " + tree.getHeight());

    }

    public static List<Integer> getFileData(String filename) {

        List<Integer> outList = new ArrayList<Integer>(20000);


        Path filePath = Paths.get(filename);

        try (Scanner reader = new Scanner(Files.newBufferedReader(filePath));) {
            while (reader.hasNext())
                outList.add(reader.nextInt());

        } catch (IOException e) {
            System.out.println("problem reading file");
            e.printStackTrace();
        }


        return outList;


    }

    public static List<Integer> popRandom(){
        List<Integer> randList = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            int rand = (int) (Math.random() * 4999);
            randList.add(rand);
        }
        return randList;
    }

    public static listSet<Integer> popList(List<Integer> data) {
        listSet<Integer> list = new listSet();
        for (int el : data) {
            list.add(el);
        }
        return list;
    }

    public static bstSet popTree(List<Integer> data) {
        bstSet tree = new bstSet();
        for (int el : data) {
            tree.add(el);
        }
        return tree;
    }

}