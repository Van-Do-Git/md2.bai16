package FileText;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class findMax {
    public List<Integer> readFileText(String filePath) {
        List<Integer> list = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                list.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("File not found");
        }
        return list;
    }
    public int findMax(List<Integer> _list){
        int max = _list.get(0);
        for(Integer integers:_list){
            if (integers>max)
                max = integers;
        }
        return max;
    }
    public void writeFile(String pathfile,int max){
        try {
            File file = new File(pathfile);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Value max of file is: "+max);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Find not found or data type is not true");
        }
    }

    public static void main(String[] args) {
        findMax findMax = new findMax();
        List<Integer> list = findMax.readFileText("src/demo.txt");
        int max = findMax.findMax(list);
        findMax.writeFile("src/resulf",max);
    }
}
