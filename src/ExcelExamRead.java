import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class ExcelExamRead {
    static List<Menu> menuList=new ArrayList<>();

    public List<Menu> getMenuList() {
        return menuList;
    }

    /** 读Excel文件内容 */
    public void showExcel(String excelName) {
        File file = new File(excelName);
        FileInputStream in = null;
        try {
// 创建对Excel工作簿文件的引用
            in = new FileInputStream(file);
            HSSFWorkbook hwb = new HSSFWorkbook(in);
            HSSFSheet sheet = hwb.getSheet("myFirstExcel");// 根据指定的名字来引用此Excel中的有效工作表
// 读取Excel 工作表的数据
           // System.out.println("下面是Excel文件" + file.getAbsolutePath() + "的内容：");
            HSSFRow row = null;
            HSSFCell cell = null;
            int rowNum = 1;
// 行标
            int colNum = 0;
// 列标
            for (; rowNum < 12; rowNum++) {
// 获取第rowNum行
                row = sheet.getRow((short) rowNum);
                Menu menu=new Menu();
                for (colNum = 0; colNum < 13; colNum++) {
                    cell = row.getCell((short) colNum);// 根据当前行的位置来创建一个单元格对象
                   if(colNum==2){
                       menu.setNianlingduan(cell.getStringCellValue());
                   }
                    if(colNum==5){
                       if(cell==null){
                           menu.setKM_1("null");
                        }else {
                           menu.setKM_1(cell.getNumericCellValue()+"");
                       }
                    }
                    if(colNum==6){
                        if(cell==null){
                            menu.setCJ_1("null");
                        }else {
                            menu.setCJ_1(cell.getNumericCellValue()+"");
                        }
                    }
                    if(colNum==7){
                        if(cell==null){
                            menu.setKM_2("null");
                        }else {
                            menu.setKM_2(cell.getNumericCellValue()+"");
                        }
                    }
                    if(colNum==8){
                        if(cell==null){
                            menu.setCJ_2("null");
                        }else {
                            menu.setCJ_2(cell.getNumericCellValue()+"");
                        }
                    }
                    if(colNum==9){
                        if(cell==null){
                            menu.setKM_3("null");
                        }else {
                            menu.setKM_3(cell.getNumericCellValue()+"");
                        }
                    }
                    if(colNum==10){
                        if(cell==null){
                            menu.setCJ_3("null");
                        }else {
                            menu.setCJ_3(cell.getNumericCellValue()+"");
                        }
                    }
                    if(colNum==11){
                        if(cell==null){
                            menu.setKM_4("null");
                        }else {
                            menu.setKM_4(cell.getNumericCellValue()+"");
                        }
                    }
                    if(colNum==12){
                        if(cell==null){
                            menu.setCJ_4("null");
                        }else {
                            menu.setCJ_4(cell.getNumericCellValue()+"");
                        }
                    }
                    if(cell==null){
                       //System.out.print("null" + "\t");
                   }
                   else if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING) {
                      // System.out.print(cell.getStringCellValue() + "\t");// 获取当前单元格中的内容
                   }else {
                      // System.out.print(cell.getNumericCellValue() + "\t");
                   }
                }
                //System.out.println(); // 换行
                menuList.add(menu);
            }
            in.close();
        } catch (Exception e) {
            System.out
                    .println("读取Excel文件" + file.getAbsolutePath() + "失败：" + e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    public static void main(String[] args) {
        ExcelExamRead excel = new ExcelExamRead();
        String excelName = "D:/ExcelExamRead.xls";
        excel.showExcel(excelName);
        List<Menu> menuList=excel.getMenuList();
        List<Menu> menuList1=new ArrayList<>();
        List<Menu> menuList2=new ArrayList<>();
        List<Menu> menuList3=new ArrayList<>();
        List<Menu> menuList4=new ArrayList<>();
        List<Menu> menuList5=new ArrayList<>();
        //System.out.println(menuList.size()+"*********");
        for(int i=0;i<menuList.size();i++){
           switch (menuList.get(i).getNianlingduan()){
               case "[20-29]":
                   menuList1.add(menuList.get(i));
                   break;
               case "[30-39]":
                   menuList2.add(menuList.get(i));
                   break;
               case "[40-49]":
                   menuList3.add(menuList.get(i));
                   break;
               case "[50-59]":
                   menuList4.add(menuList.get(i));
                   break;
                   default:
                    menuList5.add(menuList.get(i));
                    break;
           }
        }
        put_String(menuList1,"[20-29]");
        put_String(menuList2,"[30-39]");
        put_String(menuList3,"[40-49]");
        put_String(menuList4,"[50-59]");
        put_String(menuList5,"60岁以上");
        put_CJ1(menuList);
        put_CJ2(menuList);
        put_CJ3(menuList);
        put_CJ4(menuList);
    }
   static void put_String(List<Menu> list,String string){
        int c1=0,c2=0,c3=0,c4=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKM_1().equals("1.0")&&!list.get(i).getCJ_1().equals("-1.0")){
                double v=Double.parseDouble(list.get(i).getCJ_1());
                if(v>72){
                    c1++;
                }
            }
            if(list.get(i).getKM_2().equals("1.0")&&!list.get(i).getCJ_2().equals("-1.0")){
                double v=Double.parseDouble(list.get(i).getCJ_2());
                if(v>60){
                    c2++;
                }
            }
            if(list.get(i).getKM_3().equals("1.0")&&!list.get(i).getCJ_3().equals("-1.0")){
                double v=Double.parseDouble(list.get(i).getCJ_3());
                if(v>84){
                    c3++;
                }
            }
            if(list.get(i).getKM_4().equals("1.0")&&!list.get(i).getCJ_4().equals("-1.0")){
                double v=Double.parseDouble(list.get(i).getCJ_4());
                if(v>60){
                    c4++;
                }
            }
            //System.out.println(list.get(i));
        }
        int z=0;
        for(int i=0;i<menuList.size();i++){
            if(menuList.get(i).getKM_1().equals("1.0")&&!menuList.get(i).getCJ_1().equals("-1.0")){
                z++;
            }
        }
        int z2=0;
        for(int i=0;i<menuList.size();i++){
            if(menuList.get(i).getKM_2().equals("1.0")&&!menuList.get(i).getCJ_2().equals("-1.0")){
                z2++;
            }
        }
        int z3=0;
        for(int i=0;i<menuList.size();i++){
            if(menuList.get(i).getKM_3().equals("1.0")&&!menuList.get(i).getCJ_3().equals("-1.0")){
                z3++;
            }
        }
        int z4=0;
        for(int i=0;i<menuList.size();i++){
            if(menuList.get(i).getKM_4().equals("1.0")&&!menuList.get(i).getCJ_4().equals("-1.0")){
                z4++;
            }
        }
        BigDecimal bigDecimal = new BigDecimal((double)c1/z);
//这里的 2 就是你要保留几位小数。
        double f1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(string+"*********"+vv((double)c1/z*100)
                +"%****"+vv((double)c2/z2*100)+"%****"
                +vv((double)c3/z3*100)+"%****"
                +vv((double)c4/z4*100)+"%");
    }

   static void put_CJ1(List<Menu> list){
        int c1=0,c2=0,c3=0,c4=0,c5=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKM_1().equals("1.0")&&!list.get(i).getCJ_1().equals("-1.0")){
                double v=Double.parseDouble(list.get(i).getCJ_1());
                if(v<=72){
                    c1++;
                }else if(v>72&&v<=84){
                    c2++;
                }else if(v>84&&v<=96){
                    c3++;
                }else if(v>96&&v<=108){
                    c4++;
                }else if(v>108&&v<=120){
                    c5++;
                }
            }
        }
       System.out.println("CJ1");
       System.out.println("不 "+" 差 "+" 中 "+" 良 "+" 优 ");
       System.out.println(c1+"   "+c2+"   "+c3+"   "+c4+"   "+c5);

    }
   static void put_CJ2(List<Menu> list){
        int c1=0,c2=0,c3=0,c4=0,c5=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKM_2().equals("1.0")&&!list.get(i).getCJ_2().equals("-1.0")){
                double v=Double.parseDouble(list.get(i).getCJ_2());
                if(v<=84){
                    c1++;
                }else if(v>84&&v<=98){
                    c2++;
                }else if(v>112&&v<=126){
                    c3++;
                }else if(v>96&&v<=108){
                    c4++;
                }else if(v>126&&v<=140){
                    c5++;
                }
            }
        }
        System.out.println("CJ2");
        System.out.println("不 "+" 差 "+" 中 "+" 良 "+" 优 ");
        System.out.println(c1+"   "+c2+"   "+c3+"   "+c4+"   "+c5);

    }
   static void put_CJ3(List<Menu> list){
        int c1=0,c2=0,c3=0,c4=0,c5=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKM_3().equals("1.0")&&!list.get(i).getCJ_3().equals("-1.0")){
                double v=Double.parseDouble(list.get(i).getCJ_3());
                if(v<=60){
                    c1++;
                }else if(v>60&&v<=70){
                    c2++;
                }else if(v>70&&v<=80){
                    c3++;
                }else if(v>80&&v<=90){
                    c4++;
                }else if(v>90&&v<=100){
                    c5++;
                }
            }
        }
        System.out.println("CJ3");
        System.out.println("不 "+" 差 "+" 中 "+" 良 "+" 优 ");
        System.out.println(c1+"   "+c2+"   "+c3+"   "+c4+"   "+c5);

    }
   static void put_CJ4(List<Menu> list){
        int c1=0,c2=0,c3=0,c4=0,c5=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKM_4().equals("1.0")&&!list.get(i).getCJ_4().equals("-1.0")){
                double v=Double.parseDouble(list.get(i).getCJ_4());
                if(v<=60){
                    c1++;
                }else if(v>60&&v<=70){
                    c2++;
                }else if(v>70&&v<=80){
                    c3++;
                }else if(v>80&&v<=90){
                    c4++;
                }else if(v>90&&v<=100){
                    c5++;
                }
            }
        }
        System.out.println("CJ4");
        System.out.println("不 "+" 差 "+" 中 "+" 良 "+" 优 ");
        System.out.println(c1+"   "+c2+"   "+c3+"   "+c4+"   "+c5);

    }
   static double vv(double d){
        BigDecimal bigDecimal = new BigDecimal(d);
//这里的 2 就是你要保留几位小数。
        double f1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//       DecimalFormat df = new DecimalFormat("#.00");
//       return df.format(d);
        return f1;
    }
}