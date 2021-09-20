
import entities.PortFolio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class geektrust {


    public static void main(String[] args) throws IOException {


        String filePath = args[0];
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> input = new ArrayList<>();
        String textdata;
        while ((textdata = br.readLine()) != null)
        {
            input.add(textdata);
        }

        PortFolio portFolio = new PortFolio(input);
        portFolio.run();

    }


}



