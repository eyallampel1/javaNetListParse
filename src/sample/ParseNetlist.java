package sample;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Lampel on 01/02/2019.
 */
public class ParseNetlist {

    private String pathToNetllist;


    public void setPathToNetllist(String pathToNetllist) {
        this.pathToNetllist = pathToNetllist;
        readTextFileLineByLine(pathToNetllist);

    }

    public void readTextFileLineByLine(String file){

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                // process the line.
            }
        }
catch (Exception e){

}

    }
}
