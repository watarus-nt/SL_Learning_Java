package utils;

import model.People;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Created by WataruS on 10/1/2016.
 */
public class FileHandlers {
    private Path filePath;

    public FileHandlers(String filePath) {
        this.setFilePath(filePath);

    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    public Boolean isFileExist() {
        return Files.exists(this.filePath);
    }

    public void createFile() {
        if (!this.isFileExist()) {
            try {
                Files.createFile(this.filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> readFile() {
        List<String> content = new ArrayList<String>();
        try {
            content = Files.readAllLines(this.filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }


    public List<People> getPeopleListFromFile(){
        List<String> content = readFile();
        List<People> result = new ArrayList<People>();
        int index = 0;
        for(String line:content){
            String[] info = line.split("-");
            String name = info[1];
            String phoneNumber = info[0];
            result.add(new People(index, name, phoneNumber));
            index++;
        }
        return result;
    }



    public int countLineInFile() {
        return readFile().size();
    }

    public void writeToFile(List<String> content, Boolean isAppend) {
        try {
            if (!isAppend) {
                Files.write(this.filePath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                Files.write(this.filePath, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(HashMap hm, Boolean isAppend) {
        try {
            if (!isAppend) {
                Files.write(this.filePath, hm.entrySet(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                Files.write(this.filePath, hm.entrySet(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String content, Boolean isAppend) {
        try {
            if (!isAppend) {
                Files.write(this.filePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                Files.write(this.filePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        try {
            Files.delete(this.filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String search(List<String> content, String searchText) throws FileNotFoundException {
        String result = "";
        Boolean found = false;
        for (String line:content){
            if (line.split("-")[0].trim().equals(searchText)){
                result = line;
                found = true;
                break;
            }
        }
        if (found){
            return  result;
        } else {
            return "Not Found";
        }


    }


    public void init() {
        //Initial default data
        List<String> secureLogixMembers = new ArrayList<String>(Arrays.asList(
                "Hung Tran Manh - SecureLogix - SENIOR_ENGINEER - 06/02/1990 - 0123456789 - Nha Trang",
                "Tu Pham Tran Vuong - SecureLogix - SENIOR_ENGINEER - 01/01/1987 - 9874563210 - Tien Giang",
                "Chien Nguyen Huu - SecureLogix - SENIOR_ENGINEER - 01/01/1989 - 8523697410 - Dak Lak",
                "Phu Nguyen Thai - SecureLogix - CONSULTANT - 16/12/1988 - 1478520369 - Da Lat",
                "Danh Ho Cong- SecureLogix - SENIOR_ENGINEER - 04/02/1990 - 8452107963 - Binh Thuan",
                "Tuyen Nguyen Thi Thanh - SecureLogix - SENIOR_ENGINEER - 15/03/1988 - 9874102563 - Tuy Hoa",
                "Hoang Le Huy - SecureLogix - CONSULTANT - 06/10/1984 - 8741025639 - Da Lat",
                "Tuyen Vu Xuan - SecureLogix - ENGINEER - 22/04/1991 - 0123456789 - Nha Trang",
                "Trung Doan Bao - SecureLogix - CONSULTANT - 06/02/1989 - 9632587412 - Tien Giang"));

        //Write team data to filePath SecureLogix.txt

        FileHandlers fp = new FileHandlers("SecureLogix.txt");
        if (fp.readFile().size() <= 0) {
            fp.writeToFile(secureLogixMembers, false);
        }
    }
}
