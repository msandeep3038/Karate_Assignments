package support;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class Reusable {

    public static String read_Properties_File(String key)
    {
        String value=null;
        try
        {
            FileReader read=new FileReader(System.getProperty("user.dir")+"\\testData.properties");
            Properties prop=new Properties();
            prop.load(read);
            value=prop.getProperty(key);

        }

        catch (Exception e)        {e.printStackTrace();        }
        return value;

    }
    public static String read_Excel1(String testcasename,String param)
    {
        String excel_data=null;
        try{
            String excel_path="C:\\Users\\sandeepkm\\IdeaProjects\\karte_framework\\src\\test\\dataProvider\\Pet_Test_Data.xlsx";
            //String excel_path=read_Properties_File("excel_path");
            //String excel_sheet_name=read_Properties_File("sheet_name");
            //String excel_path="C:\\Users\\sandeepkm\\IdeaProjects\\Edyoda_Testing\\TestData\\Automatio_test_Data.xlsx";
            //Read the Excel path
            FileInputStream fls=new FileInputStream(excel_path);
            // Get the Workbook access
            Workbook workbook=new XSSFWorkbook(fls);
            // Read data from specific sheet
            Sheet sheet=workbook.getSheet("Test_Data");
            int RC_count=sheet.getLastRowNum();
            //System.out.println("Get the row number  " +RC_count);
            for (int i=0;i<=RC_count;i++)
            {
                Row row=sheet.getRow(i);
                int Col_count=row.getLastCellNum();
                // System.out.println("Total column count of row number:" +Col_count);
                Cell cell=row.getCell(0);
                String value=cell.getStringCellValue();
                //System.out.println("the columan value is --->" +value);
                //System.out.println("******************");
                if(value.equals(testcasename))
                {
                    //System.out.println("The row number is :"+i);
                    Row newrow=sheet.getRow(0);

                    for(int j=0;j<Col_count;j++)
                    {
                        Cell cellnum=newrow.getCell(j);
                        String valueofcell=cellnum.getStringCellValue();
                        if(valueofcell.equals(param))
                        {
                            //System.out.println("The URL is"+sheet.getRow(i).getCell(j));
                            excel_data=sheet.getRow(i).getCell(j).toString();
                        }


                    }
                }
            }
        }
        catch (Exception e)
        {

        }
        return excel_data;
    }

    public static String creatPait_Req_Body(String pet_id,String pet_name)
    {
        String body="{\n" +
                "    \"id\": "+pet_id+",\n" +
                "    \"category\": {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    },\n" +
                "    \"name\": \""+pet_name+"\",\n" +
                "    \"photoUrls\": [\n" +
                "      \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "      {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"string\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"status\": \"Active\"\n" +
                "  }";
        return body;

    }

    public static int flottoint(String petID)
    {
        float f=Float.parseFloat(petID);
        return (int)f;
    }

}
