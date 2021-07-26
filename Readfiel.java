package FileText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Readfiel {
    public List<National> reedfile(String path){
        List<National> list = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String [] arrline;
            while ((line=bufferedReader.readLine())!=null){
                arrline = line.split(",");
                National national = new National(Integer.parseInt(arrline[0]),arrline[1],arrline[2]);
                list.add(national);
            }
        }catch (Exception e){
            System.out.println("File is not exits");
        }
        return list;
    }
    public static void main(String[] args) {
        Readfiel test = new Readfiel();
        List<National> list = test.reedfile("src/National");
        for(National national:list){
            System.out.println(national);
        }
    }
}
