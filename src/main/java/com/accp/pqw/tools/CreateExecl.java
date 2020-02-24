package com.accp.pqw.tools;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import com.accp.pqw.pojo.Dates;
import com.accp.pqw.pojo.Token;

public class CreateExecl {

	public static void main(String[] args) {
		List<Dates> list = new ArrayList<Dates>();
		Dates d = new Dates(2018, 3, 2050f);
		List<Token> tList = new ArrayList<Token>();
		tList.add(new Token(1, "研发部", 1000));
		tList.add(new Token(2, "人事部", 1050));
		d.setList(tList);
		list.add(d);
		createExecl(list, "总经理");
	}

	public static boolean createExecl(List<Dates> list, String dName) {
		// 获取电脑桌面地址
		String computerDesktopPath = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
		// 创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 表标题列
		String[] columns = { "编号", "", "时间", "报销金额" };
		list.forEach(i -> {
			// 表标题名
			String title = i.getMonth() == null ? String.format("%s年%s年度报销统计", i.getYear(), dName)
					: String.format("%s年%s月%s月度报销统计", i.getYear(), i.getMonth(), dName);
			// 在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet(title);
			// 在sheet中添加表标题行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow titleRow = sheet.createRow(0);
			// 创建表标题单元格样式对象并设置值
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			titleStyle.setWrapText(true);// 设置自动换行
			// 设置表标题行行高
			titleRow.setHeightInPoints(25);
			// 创建表标题字体对象，并设置样式
			HSSFFont titleFont = wb.createFont();
			titleFont.setFontName("等线 Light");
			titleFont.setFontHeightInPoints((short) 18);// 字体大小
			titleFont.setColor(IndexedColors.BLUE_GREY.getIndex());// 字体颜色 蓝灰
			// 表标题单元格
			HSSFCell titleCell = titleRow.createCell(0, 1);
			titleCell.setCellValue(title);
			titleStyle.setFont(titleFont);// 设置表标题字体样式
			titleCell.setCellStyle(titleStyle);// 设置表标题单元格样式
			// 表头单元格合并，对象四个参数分别是开始行、最后行、开始列和最后列。(从0开始)
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
			// 创建表头行
			HSSFRow headRow = sheet.createRow(1);
			// 创建表头单元格样式对象并设置值
			HSSFCellStyle headStyle = wb.createCellStyle();
			headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			headStyle.setWrapText(true);// 设置自动换行
			headStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 重要，不设置这个前景色、背景色无效
			headStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());// 背景色 蓝色
			// 创建表头字体对象，并设置样式
			HSSFFont headFont = wb.createFont();
			headFont.setFontName("等线");
			headFont.setFontHeightInPoints((short) 11);// 字体大小
			headFont.setColor(IndexedColors.WHITE.getIndex());// 字体颜色 白色
			headStyle.setFont(headFont);
			if ("总经理".equals(dName)) {
				columns[1] = "报销部门";
			} else {
				columns[1] = "报销人";
			}
			for (int j = 0; j < columns.length; j++) {
				HSSFCell headCell = headRow.createCell(j);
				headCell.setCellValue(columns[j]);
				headCell.setCellStyle(headStyle);
				// 设置列宽
				sheet.setColumnWidth(j, 20 * 256);
			}
			// 数据样式1
			HSSFCellStyle bodyStyle1 = wb.createCellStyle();
			bodyStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			bodyStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 重要，不设置这个前景色和背景色无效
			bodyStyle1.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());// 背景色 浅绿色
			// 数据字体样式1
			HSSFFont bodyFont1 = wb.createFont();
			bodyFont1.setFontName("等线");
			bodyFont1.setFontHeightInPoints((short) 11);// 字体大小
			bodyFont1.setColor(IndexedColors.DARK_GREEN.getIndex());// 字体颜色 绿色
			bodyStyle1.setFont(bodyFont1);
			// 数据样式2
			HSSFCellStyle bodyStyle2 = wb.createCellStyle();
			bodyStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			bodyStyle2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 重要，不设置这个前景色和背景色无效
			bodyStyle2.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());// 背景色 绿色
			// 数据字体样式2
			HSSFFont bodyFont2 = wb.createFont();
			bodyFont2.setFontName("等线");
			bodyFont2.setFontHeightInPoints((short) 11);// 字体大小
			bodyFont2.setColor(IndexedColors.BRIGHT_GREEN.getIndex());// 字体颜色 浅绿色
			bodyStyle2.setFont(bodyFont2);
			// 填充数据
			for (int k = 0; k < i.getList().size(); k++) {
				HSSFRow bodyRow = sheet.createRow(2 + k);
				HSSFCell firstCell = bodyRow.createCell(0);
				firstCell.setCellValue(i.getList().get(k).getId());
				HSSFCell secondCell = bodyRow.createCell(1);
				secondCell.setCellValue(i.getList().get(k).getName());
				HSSFCell thirdCell = bodyRow.createCell(2);
				if (i.getMonth() != null) {
					thirdCell.setCellValue(i.getYear() + "年" + i.getMonth() + "月");
				} else {
					thirdCell.setCellValue(i.getYear() + "年");
				}
				HSSFCell fourthCell = bodyRow.createCell(3);
				fourthCell.setCellValue(i.getList().get(k).getMoney());
				if ((2 + k) % 2 == 0) {
					firstCell.setCellStyle(bodyStyle1);
					secondCell.setCellStyle(bodyStyle1);
					thirdCell.setCellStyle(bodyStyle1);
					fourthCell.setCellStyle(bodyStyle1);
				} else {
					firstCell.setCellStyle(bodyStyle2);
					secondCell.setCellStyle(bodyStyle2);
					thirdCell.setCellStyle(bodyStyle2);
					fourthCell.setCellStyle(bodyStyle2);
				}
			}
			// 共计样式
			HSSFCellStyle footStyle = wb.createCellStyle();
			footStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			footStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 重要，不设置这个前景色、背景色无效
			footStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());// 背景色 亮橙色
			// 共计字体样式
			HSSFFont footFont = wb.createFont();
			footFont.setFontName("等线");
			footFont.setFontHeightInPoints((short) 11);// 字体大小
			footFont.setColor(IndexedColors.LEMON_CHIFFON.getIndex());// 字体颜色 浅黄色
			footFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
			footStyle.setFont(footFont);
			HSSFRow footRow = sheet.createRow(2 + i.getList().size());
			HSSFCell sumCell = footRow.createCell(2);
			sumCell.setCellValue("共计：￥" + i.getMoney());
			sumCell.setCellStyle(footStyle);
			sheet.addMergedRegion(new CellRangeAddress(2 + i.getList().size(), 2 + i.getList().size(), 2, 3));
		});
		// 将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream(computerDesktopPath + "/"
					+ new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒").format(new Date()) + "创建统计表.xls");
			wb.write(fout);
			fout.close();
			System.out.println("报销表创建成功！");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
