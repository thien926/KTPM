package com.WorkWithExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import com.BasicClass.ClassDatHang;
import com.BasicClass.NewUser;
import com.BasicClass.ProductType;
import com.BasicClass.User;

public class XuatExcel {
	public HSSFCellStyle getStyleTieuDe(HSSFWorkbook workbook) {
        // Font
        HSSFFont font = workbook.createFont();
        font.setBold(true);
 
        // Font Height
        font.setFontHeightInPoints((short) 13);
        font.setFontName("Consolas");
 
        // Style
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
 
        return style;
    }
	
	public HSSFCellStyle getSampleStyle(HSSFWorkbook workbook) {
        // Font
        HSSFFont font = workbook.createFont();
 
        // Font Height
        font.setFontHeightInPoints((short) 13);
        font.setFontName("Consolas");
 
        // Style
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setFont(font);
 
        return style;
    }
	
	// Xuất file Excel resultDangNhap
    public void resultDangNhap(ArrayList<User> list){
        String url = "Result/resultDangNhap.xls";
        
        FileOutputStream outFile = null;
        HSSFCell cell;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("testDangNhap");
            HSSFCellStyle style = getSampleStyle(workbook);
            HSSFCellStyle styletieude = getStyleTieuDe(workbook);
            
            
            int rownum = 0, index = 0;
            
            Row row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Test Login");
            cell.setCellStyle(styletieude);
            
            ++rownum;
            row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Test Case");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(1, CellType.STRING);
            cell.setCellValue("User");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(2, CellType.STRING);
            cell.setCellValue("Password");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(3, CellType.STRING);
            cell.setCellValue("Error");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(4, CellType.STRING);
            cell.setCellValue("Result");
            cell.setCellStyle(style);
            
            for(User u: list){
                ++rownum;
                ++index;
                
                row = sheet.createRow(rownum);
                cell = (HSSFCell) row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(index);
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(1, CellType.STRING);
                cell.setCellValue(u.getUser());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(2, CellType.STRING);
                cell.setCellValue(u.getPass());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(3, CellType.STRING);
                cell.setCellValue(u.getError());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(4, CellType.BOOLEAN);
                cell.setCellValue(u.getResult());
                cell.setCellStyle(style);
            }
            
            for(int i = 0; i < 5; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
 // Xuất file Excel resultDangKy
    public void resultDangKy(ArrayList<NewUser> list){
        String url = "Result/resultDangKy.xls";
        
        FileOutputStream outFile = null;
        HSSFCell cell;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("testDangKy");
            HSSFCellStyle style = getSampleStyle(workbook);
            HSSFCellStyle styletieude = getStyleTieuDe(workbook);
            
            
            int rownum = 0, index = 0;
            
            Row row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Result Register");
            cell.setCellStyle(styletieude);
            
            ++rownum;
            row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Test Case");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(1, CellType.STRING);
            cell.setCellValue("Full Name");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(2, CellType.STRING);
            cell.setCellValue("User");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(3, CellType.STRING);
            cell.setCellValue("Password");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(4, CellType.STRING);
            cell.setCellValue("RePassword");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(5, CellType.STRING);
            cell.setCellValue("Email");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(6, CellType.STRING);
            cell.setCellValue("Phone");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(7, CellType.STRING);
            cell.setCellValue("Address");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(8, CellType.STRING);
            cell.setCellValue("Gender");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(9, CellType.STRING);
            cell.setCellValue("Born");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(10, CellType.STRING);
            cell.setCellValue("Error");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(11, CellType.STRING);
            cell.setCellValue("Result");
            cell.setCellStyle(style);
            
            for(NewUser u: list){
                ++rownum;
                ++index;
                
                row = sheet.createRow(rownum);
                cell = (HSSFCell) row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(index);
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(1, CellType.STRING);
                cell.setCellValue(u.getFullname());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(2, CellType.STRING);
                cell.setCellValue(u.getUser());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(3, CellType.STRING);
                cell.setCellValue(u.getPass());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(4, CellType.STRING);
                cell.setCellValue(u.getRepass());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(5, CellType.STRING);
                cell.setCellValue(u.getEmail());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(6, CellType.STRING);
                cell.setCellValue(u.getPhone());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(7, CellType.STRING);
                cell.setCellValue(u.getAddress());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(8, CellType.STRING);
                cell.setCellValue(u.getGender());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(9, CellType.STRING);
                cell.setCellValue(u.getBorn());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(10, CellType.STRING);
                cell.setCellValue(u.getError());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(11, CellType.BOOLEAN);
                cell.setCellValue(u.getResult());
                cell.setCellStyle(style);
            }
            
            for(int i = 0; i < 12; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    // Xuất file resultDatHang
    public void resultDatHang(ArrayList<ClassDatHang> list){
        String url = "Result/resultDatHang.xls";
        
        FileOutputStream outFile = null;
        HSSFCell cell;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("resultDatHang");
            HSSFCellStyle style = getSampleStyle(workbook);
            HSSFCellStyle styletieude = getStyleTieuDe(workbook);
            
            
            int rownum = 0, index = 0;
            
            Row row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Test Checkout");
            cell.setCellStyle(styletieude);
            
            ++rownum;
            row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Test Case");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(1, CellType.STRING);
            cell.setCellValue("User");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(2, CellType.STRING);
            cell.setCellValue("Password");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(3, CellType.STRING);
            cell.setCellValue("Type Product");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(4, CellType.STRING);
            cell.setCellValue("Product");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(5, CellType.STRING);
            cell.setCellValue("Type Address");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(6, CellType.STRING);
            cell.setCellValue("Address");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(7, CellType.STRING);
            cell.setCellValue("Remove");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(8, CellType.STRING);
            cell.setCellValue("Error");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(9, CellType.STRING);
            cell.setCellValue("Result");
            cell.setCellStyle(style);
            
            for(ClassDatHang u: list){
                ++rownum;
                ++index;
                
                row = sheet.createRow(rownum);
                cell = (HSSFCell) row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(index);
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(1, CellType.STRING);
                cell.setCellValue(u.getUser());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(2, CellType.STRING);
                cell.setCellValue(u.getPass());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(3, CellType.STRING);
                cell.setCellValue(u.getTypeProduct());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(4, CellType.STRING);
                cell.setCellValue(u.getProduct());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(5, CellType.STRING);
                cell.setCellValue(u.getTypeAddress());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(6, CellType.STRING);
                cell.setCellValue(u.getAddress());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(7, CellType.STRING);
                cell.setCellValue(u.getRemove());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(8, CellType.STRING);
                cell.setCellValue(u.getError());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(9, CellType.BOOLEAN);
                cell.setCellValue(u.getResult());
                cell.setCellStyle(style);
            }
            
            for(int i = 0; i < 10; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
 // Xuất file Excel resultDangNhapAdmin
    public void resultDangNhapAdmin(ArrayList<User> list){
        String url = "Result/resultDangNhapAdmin.xls";
        
        FileOutputStream outFile = null;
        HSSFCell cell;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("testDangNhapAdmin");
            HSSFCellStyle style = getSampleStyle(workbook);
            HSSFCellStyle styletieude = getStyleTieuDe(workbook);
            
            
            int rownum = 0, index = 0;
            
            Row row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Test Login Admin");
            cell.setCellStyle(styletieude);
            
            ++rownum;
            row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Test Case");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(1, CellType.STRING);
            cell.setCellValue("User");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(2, CellType.STRING);
            cell.setCellValue("Password");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(3, CellType.STRING);
            cell.setCellValue("Error");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(4, CellType.STRING);
            cell.setCellValue("Result");
            cell.setCellStyle(style);
            
            for(User u: list){
                ++rownum;
                ++index;
                
                row = sheet.createRow(rownum);
                cell = (HSSFCell) row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(index);
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(1, CellType.STRING);
                cell.setCellValue(u.getUser());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(2, CellType.STRING);
                cell.setCellValue(u.getPass());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(3, CellType.STRING);
                cell.setCellValue(u.getError());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(4, CellType.BOOLEAN);
                cell.setCellValue(u.getResult());
                cell.setCellStyle(style);
            }
            
            for(int i = 0; i < 5; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
 // Xuất file Excel resultThemLoaiSanPham
    public void resultThemLoaiSanPham(ArrayList<ProductType> list){
        String url = "Result/resultThemLoaiSanPham.xls";
        
        FileOutputStream outFile = null;
        HSSFCell cell;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("resultThemLoaiSanPham");
            HSSFCellStyle style = getSampleStyle(workbook);
            HSSFCellStyle styletieude = getStyleTieuDe(workbook);
            
            
            int rownum = 0, index = 0;
            
            Row row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Result Add Product Type");
            cell.setCellStyle(styletieude);
            
            ++rownum;
            row = sheet.createRow(rownum);
            cell = (HSSFCell)row.createCell(0, CellType.STRING);
            cell.setCellValue("Test Case");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(1, CellType.STRING);
            cell.setCellValue("Id");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(2, CellType.STRING);
            cell.setCellValue("Name");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(3, CellType.STRING);
            cell.setCellValue("Describe");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(4, CellType.STRING);
            cell.setCellValue("Error");
            cell.setCellStyle(style);
            
            cell = (HSSFCell)row.createCell(5, CellType.STRING);
            cell.setCellValue("Result");
            cell.setCellStyle(style);
            
            for(ProductType u: list){
                ++rownum;
                ++index;
                
                row = sheet.createRow(rownum);
                cell = (HSSFCell) row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(index);
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(1, CellType.NUMERIC);
                cell.setCellValue(u.getId());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(2, CellType.STRING);
                cell.setCellValue(u.getname());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(3, CellType.STRING);
                cell.setCellValue(u.getname());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(4, CellType.STRING);
                cell.setCellValue(u.getError());
                cell.setCellStyle(style);
                
                cell = (HSSFCell) row.createCell(5, CellType.BOOLEAN);
                cell.setCellValue(u.getResult());
                cell.setCellStyle(style);
            }
            
            for(int i = 0; i < 6; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
