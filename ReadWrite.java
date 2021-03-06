package FileText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite {
    public  List<String> readfile(String path){
        List<String> list = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                list.add(line);
            }
        }catch (Exception e){
            System.out.println("Find not found or data type is not true");
        }
        return list;
    }
    public void writefile(List<String> list, String path){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String string: list){
                bufferedWriter.write(string);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println("Find not found");
        }
    }

    public static void main(String[] args) {
        ReadWrite demo = new ReadWrite();
        List<String> listDemo = demo.readfile("src/Bucthuctinhdautien");
        demo.writefile(listDemo,"src/FileNew.txt");
    }
}
