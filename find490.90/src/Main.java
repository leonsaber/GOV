import java.io.*;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        File inputFile = new File("/Users/leon/Desktop/Github/GOV/find490.90/5.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Double.parseDouble(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        Solution solution = new Solution();
        List<List<Double>> result = solution.worker(list);

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("/Users/leon/Desktop/Github/GOV/find490.90/result.txt"), "utf-8"));
            for (List<Double> listE: result) {
                StringBuffer lineCreater = new StringBuffer();
                for (Double d: listE) {
                    lineCreater.append(d);
                    lineCreater.append(" ");
                }
                lineCreater.append("\n");
                writer.write(lineCreater.toString());
            }
        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
        System.out.print(result);
    }
}
