package sample;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Lampel on 01/02/2019.
 */
public class ParseNetlist {

    private String pathToNetllist;
    private String netName;
    private String pinName;

    public void setPathToNetllist(String pathToNetllist) {
        this.pathToNetllist = pathToNetllist;


    }

    public void convertNetlist(String Designator) {
        readTextFileLineByLine(pathToNetllist, Designator);
    }

    public void readTextFileLineByLine(String filePath, String Designator) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
             String line;
            while (((line = br.readLine()) != null) && (!line.equals("# begin one pin nets list"))) {

               // System.out.println(line);
                // process the line.


                int first = line.indexOf("'");
                int secondOccurence = line.indexOf("'", first + 1);

                int first2 = line.indexOf("/");
                int secondOccurence2 = line.indexOf("/", first2 + 1);


                int designatorIndex = line.indexOf(Designator+"-");
                if (designatorIndex != -1 && (line.length()-designatorIndex>2)) {//FOR SPECIAL CASE WHERE PIN_NAME = DESIGNATOR NAME
                    netName = line.substring(secondOccurence2 + 1, secondOccurence + 1);
                    netName=netName.substring(0, netName.length() - 1); ///remove last char (the ' sign)
                    pinName = line.substring(designatorIndex).split("-")[1];
                  //set_location_assignment PIN_F17 -to LEDG[8]
                    System.out.println("set_location_assignment PIN_"+pinName+" -to "+netName);


                }

            }
        } catch (Exception e) {

        }

    }
}
