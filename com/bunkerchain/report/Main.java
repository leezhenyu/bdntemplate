package com.bunkerchain.report;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Test {

	public static void main(String[] args) {
		
		JasperReport reporte = (JasperReport) JRLoader
				.loadObject(new File("../../BunkerRequisitionForm.jasper"));

		
		Map<String, Object> fieldsMap = new HashMap<String, Object>();

		fieldsMap.put("marineFuelOilTonnesPerHour", "1.5");
		fieldsMap.put("productName", "VLSFO RMG380");
		fieldsMap.put("isBlendedInAdvance", "NO");
		fieldsMap.put("viscosity", "380");
		fieldsMap.put("density", "0.8845");
		fieldsMap.put("waterContentPercentage", "0.3");
		fieldsMap.put("flashPointCelsius", "70");
		fieldsMap.put("sulphurContentPercentage", "0.05%");



		
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, fieldsMap, new JREmptyDataSource());

	    JasperExportManager.exportReportToPdfFile(jasperPrint, "BunkerRequisitionForm.pdf");
		
		
	}

}
