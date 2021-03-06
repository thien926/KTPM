package com.WorkWithExcel;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;

import com.BasicClass.ClassDatHang;
import com.BasicClass.NewUser;
import com.BasicClass.Product;
import com.BasicClass.ProductType;
import com.BasicClass.User;

public class DocExcel {
	public HSSFCellStyle getSampleStyle(HSSFWorkbook workbook) {
        // Font
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setItalic(true);
 
        // Font Height
        font.setFontHeightInPoints((short) 18);
 
        // Font Color
        font.setColor(IndexedColors.RED.index);
 
        // Style
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setFont(font);
 
        return style;
    }
	
	public ArrayList<User> DocExcelTaiKhoanDangNhap(){
        String url = "NhapData/testDangNhap.xls";
        ArrayList<User> list = new ArrayList<User>();
        
        FileInputStream inpFile = null;
        try{
            inpFile = new FileInputStream(new File(url));
            
            HSSFWorkbook workbook = new HSSFWorkbook(inpFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
            int index = -1;
            while(rowIterator.hasNext()){
            	++index;
            	Row row = rowIterator.next();
            	// N???u s??? d??ng <= 2 th?? skip
            	if(index >= 2) {
            		
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    
                    while(cellIterator.hasNext()){
                        int stt = (int) cellIterator.next().getNumericCellValue();
//                        String user = cellIterator.next().getStringCellValue();
                        
                        String user = convert_Num_Str(cellIterator.next());
                        String pass = convert_Num_Str(cellIterator.next());
                        
                        User U = new User(user, pass);
                        list.add(U);
                    }
            	}
            }
            
            
        }
        catch (Exception e){
        	e.printStackTrace();
        } finally {
            try{
                if (inpFile != null) {
                    inpFile.close();
                }
            } catch (Exception ex){
            	ex.printStackTrace();
            }
        }
        return list;
    }
	
	public ArrayList<NewUser> DocExcelTaiKhoanDangKy(){
        String url = "NhapData/testDangKy.xls";
        ArrayList<NewUser> list = new ArrayList<NewUser>();
        
        FileInputStream inpFile = null;
        try{
            inpFile = new FileInputStream(new File(url));
            HSSFWorkbook workbook = new HSSFWorkbook(inpFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
            String user = "", pass = "", repass = "", fullname = "", email = "", phone = "", address = "", gender = "", born = ""; 
            
            int index = -1, stt = 0;
            while(rowIterator.hasNext()){
            	++index;
            	Row row = rowIterator.next();
            	// N???u s??? d??ng <= 2 th?? skip
            	if(index >= 2) {
            		
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    
                    while(cellIterator.hasNext()){
                    	
                        stt = (int) cellIterator.next().getNumericCellValue();
//                        String user = cellIterator.next().getStringCellValue();
                        
                        fullname = convert_Num_Str(cellIterator.next());
                        user = convert_Num_Str(cellIterator.next());
                        pass = convert_Num_Str(cellIterator.next());
                        repass = convert_Num_Str(cellIterator.next());
                        email = convert_Num_Str(cellIterator.next());
                        phone = convert_Num_Str(cellIterator.next());
                        address = convert_Num_Str(cellIterator.next());
                        gender = convert_Num_Str(cellIterator.next());
                        born = cellIterator.next().getStringCellValue();
                        
                        NewUser U = new NewUser(user, pass, repass, fullname, email, phone, address, gender, born);
                        list.add(U);
                    }
            	}
            }
            
            
        }
        catch (Exception e){
        	e.printStackTrace();
        } finally {
            try{
                if (inpFile != null) {
                    inpFile.close();
                }
            } catch (Exception ex){
            	ex.printStackTrace();
            }
        }
        return list;
    }
	
	public ArrayList<ClassDatHang> DocExcelDatHang(){
        String url = "NhapData/testDatHang.xls";
        ArrayList<ClassDatHang> list = new ArrayList<ClassDatHang>();
        
        FileInputStream inpFile = null;
        try{
            inpFile = new FileInputStream(new File(url));
            HSSFWorkbook workbook = new HSSFWorkbook(inpFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
            String user = "", pass = "", typeProduct = "", product = "", address = "", remove = "";
            boolean typeAddress = false;
            int pageShop = 0;
            
            int index = -1, stt = 0;
            while(rowIterator.hasNext()){
            	++index;
            	Row row = rowIterator.next();
            	// N???u s??? d??ng <= 2 th?? skip
            	if(index >= 2) {
            		
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    
                    while(cellIterator.hasNext()){
                    	
                        stt = (int) cellIterator.next().getNumericCellValue();
//                        String user = cellIterator.next().getStringCellValue();
                        user = convert_Num_Str(cellIterator.next());
                        pass = convert_Num_Str(cellIterator.next());
                        typeProduct = cellIterator.next().getStringCellValue();
                        product = cellIterator.next().getStringCellValue();
                        typeAddress = cellIterator.next().getBooleanCellValue();
                        address = convert_Num_Str(cellIterator.next());
                        remove = convert_Num_Str(cellIterator.next());
                        
                        ClassDatHang U = new ClassDatHang(user, pass, typeProduct, product, typeAddress, address, remove);
                        list.add(U);
                    }
            	}
            }
            
            
        }
        catch (Exception e){
        	e.printStackTrace();
        } finally {
            try{
                if (inpFile != null) {
                    inpFile.close();
                }
            } catch (Exception ex){
            	ex.printStackTrace();
            }
        }
        return list;
    }
	
	public ArrayList<User> DocExcelTaiKhoanDangNhapAdmin(){
        String url = "NhapData/testDangNhapAdmin.xls";
        ArrayList<User> list = new ArrayList<User>();
        
        FileInputStream inpFile = null;
        try{
            inpFile = new FileInputStream(new File(url));
            
            HSSFWorkbook workbook = new HSSFWorkbook(inpFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
            int index = -1;
            while(rowIterator.hasNext()){
            	++index;
            	Row row = rowIterator.next();
            	// N???u s??? d??ng <= 2 th?? skip
            	if(index >= 2) {
            		
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    
                    while(cellIterator.hasNext()){
                        int stt = (int) cellIterator.next().getNumericCellValue();
                        String user = convert_Num_Str(cellIterator.next());
                        String pass = convert_Num_Str(cellIterator.next());
                        
                        User U = new User(user, pass);
                        list.add(U);
                    }
            	}
            }
            
            
        }
        catch (Exception e){
        	e.printStackTrace();
        } finally {
            try{
                if (inpFile != null) {
                    inpFile.close();
                }
            } catch (Exception ex){
            	ex.printStackTrace();
            }
        }
        return list;
    }
	
	// DOc file testThemLoaiSanPham
	public ArrayList<ProductType> DocExcelThemLoaiSanPham(){
        String url = "NhapData/testThemLoaiSanPham.xls";
        ArrayList<ProductType> list = new ArrayList<ProductType>();
        
        FileInputStream inpFile = null;
        try{
            inpFile = new FileInputStream(new File(url));
            
            HSSFWorkbook workbook = new HSSFWorkbook(inpFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
            int index = -1;
            while(rowIterator.hasNext()){
            	++index;
            	Row row = rowIterator.next();
            	// N???u s??? d??ng <= 2 th?? skip
            	if(index >= 2) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()){
                        int stt = (int) cellIterator.next().getNumericCellValue();
                        String name = convert_Num_Str(cellIterator.next());
                        String describe = convert_Num_Str(cellIterator.next());
                        
                        ProductType U = new ProductType(name, describe);
                        list.add(U);
                    }
            	}
            }
            
            
        }
        catch (Exception e){
        	e.printStackTrace();
        } finally {
            try{
                if (inpFile != null) {
                    inpFile.close();
                }
            } catch (Exception ex){
            	ex.printStackTrace();
            }
        }
        return list;
    }
	
	// DOc file testSuaLoaiSanPham
	public ArrayList<ProductType> DocExcelSuaLoaiSanPham(){
        String url = "NhapData/testSuaLoaiSanPham.xls";
        ArrayList<ProductType> list = new ArrayList<ProductType>();
        
        FileInputStream inpFile = null;
        try{
            inpFile = new FileInputStream(new File(url));
            
            HSSFWorkbook workbook = new HSSFWorkbook(inpFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
            int index = -1;
            while(rowIterator.hasNext()){
            	++index;
            	Row row = rowIterator.next();
            	// N???u s??? d??ng <= 2 th?? skip
            	if(index >= 2) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()){
                        int stt = (int) cellIterator.next().getNumericCellValue();
                        int id = (int) cellIterator.next().getNumericCellValue();
                        String name = convert_Num_Str(cellIterator.next());
                        String describe = convert_Num_Str(cellIterator.next());
                        
                        ProductType U = new ProductType(id, name, describe);
                        list.add(U);
                    }
            	}
            }
            
            
        }
        catch (Exception e){
        	e.printStackTrace();
        } finally {
            try{
                if (inpFile != null) {
                    inpFile.close();
                }
            } catch (Exception ex){
            	ex.printStackTrace();
            }
        }
        return list;
    }
	
	// DOc file testThemSanPham
	public ArrayList<Product> DocExcelThemSanPham(){
        String url = "NhapData/testThemSanPham.xls";
        ArrayList<Product> list = new ArrayList<Product>();
        
        FileInputStream inpFile = null;
        try{
            inpFile = new FileInputStream(new File(url));
            
            HSSFWorkbook workbook = new HSSFWorkbook(inpFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
            int index = -1;
            while(rowIterator.hasNext()){
            	++index;
            	Row row = rowIterator.next();
            	// N???u s??? d??ng <= 2 th?? skip
            	if(index >= 2) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()){
                        int stt = (int) cellIterator.next().getNumericCellValue();
                        String name = convert_Num_Str(cellIterator.next());
                        String type = convert_Num_Str(cellIterator.next());
                        String author = convert_Num_Str(cellIterator.next());
                        String nxb = convert_Num_Str(cellIterator.next());
                        String img = convert_Num_Str(cellIterator.next());
                        int amount = (int)cellIterator.next().getNumericCellValue();
                        long price = (long)cellIterator.next().getNumericCellValue();
                        String sail = convert_Num_Str(cellIterator.next());
                        String descript = convert_Num_Str(cellIterator.next());
                        String status = convert_Num_Str(cellIterator.next());
                        
                        Product U = new Product(name, type, author, nxb, img, amount, price, sail, descript, status);
                        list.add(U);
                    }
            	}
            }
            
            
        }
        catch (Exception e){
        	e.printStackTrace();
        } finally {
            try{
                if (inpFile != null) {
                    inpFile.close();
                }
            } catch (Exception ex){
            	ex.printStackTrace();
            }
        }
        return list;
    }
	
	// DOc file testSuaSanPham
	public ArrayList<Product> DocExcelSuaSanPham(){
        String url = "NhapData/testSuaSanPham.xls";
        ArrayList<Product> list = new ArrayList<Product>();
        
        FileInputStream inpFile = null;
        try{
            inpFile = new FileInputStream(new File(url));
            
            HSSFWorkbook workbook = new HSSFWorkbook(inpFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
            int index = -1;
            while(rowIterator.hasNext()){
            	++index;
            	Row row = rowIterator.next();
            	// N???u s??? d??ng <= 2 th?? skip
            	if(index >= 2) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()){
                        int stt = (int) cellIterator.next().getNumericCellValue();
                        int id = (int) cellIterator.next().getNumericCellValue();
                        String name = convert_Num_Str(cellIterator.next());
                        String type = convert_Num_Str(cellIterator.next());
                        String author = convert_Num_Str(cellIterator.next());
                        String nxb = convert_Num_Str(cellIterator.next());
                        String img = convert_Num_Str(cellIterator.next());
                        int amount = (int)cellIterator.next().getNumericCellValue();
                        long price = (long)cellIterator.next().getNumericCellValue();
                        String sail = convert_Num_Str(cellIterator.next());
                        String descript = convert_Num_Str(cellIterator.next());
                        String status = convert_Num_Str(cellIterator.next());
                        
                        Product U = new Product(id, name, type, author, nxb, img, amount, price, sail, descript, status);
                        list.add(U);
                    }
            	}
            }
            
            
        }
        catch (Exception e){
        	e.printStackTrace();
        } finally {
            try{
                if (inpFile != null) {
                    inpFile.close();
                }
            } catch (Exception ex){
            	ex.printStackTrace();
            }
        }
        return list;
    }
	
	public String convert_Num_Str(Cell cell) {
		String text = "";
		try {
			text = cell.getStringCellValue();;
        } catch(Exception e) {
        	text = Integer.toString((int)cell.getNumericCellValue());
        }
		return text;
	}
}
